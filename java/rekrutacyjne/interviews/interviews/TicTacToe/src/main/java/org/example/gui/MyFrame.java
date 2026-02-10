package org.example.gui;

import org.example.Coordinate;
import org.example.Symbol;
import org.example.logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MyFrame extends JFrame  {
    private JLabel label;

    private Game game;
    public MyFrame() {
        super("Tic Tac Toe");
        setSize(600,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        label = new JLabel();
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial",Font.BOLD,50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic-Tac-Toe");
        label.setOpaque(true);

        add(label,BorderLayout.NORTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.DARK_GRAY);

        game = new Game( true);
        JButton[][] board = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton tile = new JButton();
                board[i][j] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.DARK_GRAY);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Arial",Font.BOLD,50));
                tile.setFocusable(false);
                int finalI = i;
                int finalJ = j;
                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tile = (JButton) e.getSource();
                        if(tile.getText() == "" && !game.isGameOver()){
                            tile.setText(String.valueOf(game.isXTurn() ? Symbol.X : Symbol.O));
                            label.setText((!game.isXTurn() ? Symbol.X : Symbol.O) + "'s turn");
                            List<Coordinate> winningCombination = game.placeSymbol(game.isXTurn() ? Symbol.X : Symbol.O, finalI*3+finalJ);
                            if(game.isGameOver()){
                                if(!game.isTie()){
                                    label.setText((!game.isXTurn() ? Symbol.X : Symbol.O) + " is the winner!");
                                    for (Coordinate coordinate : winningCombination) {
                                        markWinner(board[coordinate.ordinal() < 3 ? 0 : coordinate.ordinal() < 6 ? 1 : 2][coordinate.ordinal() % 3]);
                                    }
                                }
                                else {
                                    label.setText("Game ended with tie!");
                                }
                            }
                        }
                    }
                });
            }
        }
        add(boardPanel);
    }
    void markWinner(JButton tile){
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.GRAY);
    }
}