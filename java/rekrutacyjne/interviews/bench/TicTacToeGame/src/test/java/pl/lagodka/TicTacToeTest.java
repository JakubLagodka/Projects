package pl.lagodka;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static pl.lagodka.GameState.*;
import static pl.lagodka.Position.*;
import static pl.lagodka.Player.*;

public class TicTacToeTest {
    private TicTacToe game = new TicTacToe();

    @Test
    public void players_alternate() {
        game.play(X, UP_LEFT);
        game.play(O, LEFT);

        assertEquals(X_PLAYS,game.state());
    }
    @Test
    public void cannot_play_occupied_position() {
        game.play(X, UP_LEFT);
        game.play(O, LEFT);
        game.play(X, UP_LEFT);

        assertEquals(X_PLAYS,game.state());
    }
    @Test
    public void same_player_cannot_play_2_times_in_a_row() {
        game.play(X, UP_LEFT);
        game.play(O, LEFT);
        game.play(X, UP);
        game.play(X, UP_LEFT);
        game.play(X, UP);

        assertEquals(O_PLAYS,game.state());
    }
    @Test
    public void O_plays_after_X() {
        game.play(X, UP_LEFT);

        assertEquals(O_PLAYS,game.state());
    }
    @Test
    public void X_plays_first() {

        assertEquals(X_PLAYS,game.state());
    }
    @Test
    public void X_wins() {
        game.play(X, UP_LEFT);
        game.play(O, LEFT);
        game.play(X, UP);
        game.play(O, CENTER);
        game.play(X, UP_RIGHT);
        assertEquals(X_WINS,game.state());
    }
    @Test
    public void O_wins() {
        game.play(X, UP_LEFT);
        game.play(O, LEFT);
        game.play(X, UP);
        game.play(O, CENTER);
        game.play(X, DOWN_RIGHT);
        game.play(O, RIGHT);
        assertEquals(O_WINS,game.state());
    }
    @Test
    public void should_not_win() {
        game.play(X, UP_LEFT);
        game.play(O, UP);
        game.play(X, UP_RIGHT);

        assertEquals(O_PLAYS,game.state());
    }

    @Test
    public void X_wins_different_combination() {
        game.play(X, DOWN_LEFT);
        game.play(O, LEFT);
        game.play(X, DOWN);
        game.play(O, CENTER);
        game.play(X, DOWN_RIGHT);
        assertEquals(X_WINS,game.state());
    }
}