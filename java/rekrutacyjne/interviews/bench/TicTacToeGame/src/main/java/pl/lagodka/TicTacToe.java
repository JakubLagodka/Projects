package pl.lagodka;

import java.util.HashSet;
import java.util.Set;

import static pl.lagodka.GameState.*;
import static pl.lagodka.Position.*;

public class TicTacToe {
    private Player currentPlayer;
    private Set<Position> positionPlayed = new HashSet<>();
    private Set<Position> xPositions = new HashSet<>();

    private Set<Position> oPositions = new HashSet<>();

    public void play(Player player, Position position) {
        if (player == currentPlayer) {
            return;
        }
        if (positionPlayed.contains(position)) {
            return;
        }
        currentPlayer = player;

        if (player == Player.X) {
            xPositions.add(position);
        } else{
            oPositions.add(position);
        }
        positionPlayed.add(position);
    }

    public GameState state() {
        boolean xWins = WINNING_COMBINATIONS.stream()
                .anyMatch(cobination -> xPositions.containsAll(cobination));
        if (xWins){
            return X_WINS;
        }

        boolean oWins = WINNING_COMBINATIONS.stream()
                .anyMatch(cobination -> oPositions.containsAll(cobination));
        if (oWins){
            return O_WINS;
        }
        if (currentPlayer == null || currentPlayer == Player.O) {
            return X_PLAYS;
        }
        return O_PLAYS;
    }

    public int validMoves() {
        return positionPlayed.size();
    }

    private static final Set<Set<Position>> WINNING_COMBINATIONS = Set.of(
            Set.of(UP_LEFT, UP,UP_RIGHT),
            Set.of(LEFT,CENTER,RIGHT),
            Set.of(DOWN_LEFT,DOWN,DOWN_RIGHT),

            Set.of(UP_LEFT,LEFT,DOWN_LEFT),
            Set.of(UP,CENTER,DOWN),
            Set.of(UP_RIGHT,RIGHT,DOWN_RIGHT),

            Set.of(UP_LEFT,CENTER,DOWN_RIGHT),
            Set.of(UP_RIGHT,CENTER,DOWN_LEFT)
    );
}
