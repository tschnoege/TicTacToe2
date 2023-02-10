import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void xAlwaysStarts()
    {
        final Game game = new Game();
        assertEquals(Player.first(), game.getPlayerToMove());
    }

    @Test
    public void playersAlternateEachMove()
    {
        final Game game = new Game();

        assertEquals(Player.first(), game.getPlayerToMove());
        game.applyMove(new Position(0,0));
        assertEquals(Player.second(), game.getPlayerToMove());
        game.applyMove(new Position(0,1));
        assertEquals(Player.first(), game.getPlayerToMove());
    }

    @Test
    public void playersCannotPlayOnAPlayedPosition()
    {
        final Game game = new Game();
        Position position = new Position(1,1);

        assertEquals(Move.VALID_MOVE, game.applyMove(position));
        assertEquals(Move.POSITION_IS_OCCUPIED, game.applyMove(position));
    }

    @Test
    public void rowWins() {
        final Game game = new Game();

        game.applyMove(new Position(0,0));
        game.applyMove(new Position(0,1));
        game.applyMove(new Position(1,0));
        game.applyMove(new Position(0,2));
        assertEquals(Move.PLAYER_WINS, game.applyMove(new Position(2,0)));
    }

    @Test
    public void columnWins() {
        final Game game = new Game();

        game.applyMove(new Position(0,0));
        game.applyMove(new Position(1,0));
        game.applyMove(new Position(0,1));
        game.applyMove(new Position(2,0));
        assertEquals(Move.PLAYER_WINS, game.applyMove(new Position(0,2)));
    }

    @Test
    public void diagonalWins() {
        final Game game = new Game();

        game.applyMove(new Position(1,0));
        game.applyMove(new Position(0,0));
        game.applyMove(new Position(2,0));
        game.applyMove(new Position(1,1));
        game.applyMove(new Position(0,1));
        assertEquals(Move.PLAYER_WINS, game.applyMove(new Position(2,2)));

        game.reset();

        game.applyMove(new Position(1,0));
        game.applyMove(new Position(0,2));
        game.applyMove(new Position(0,0));
        game.applyMove(new Position(1,1));
        game.applyMove(new Position(0,1));
        assertEquals(Move.PLAYER_WINS, game.applyMove(new Position(2,0)));
    }

    @Test void gameIsADraw() {
        final Game game = new Game();

        game.applyMove(new Position(0,0));
        game.applyMove(new Position(0,1));
        game.applyMove(new Position(0,2));
        game.applyMove(new Position(1,0));
        game.applyMove(new Position(1,1));
        game.applyMove(new Position(1,2));
        game.applyMove(new Position(2,0));
        game.applyMove(new Position(2,1));
        assertEquals(Move.GAME_IS_A_DRAW, game.applyMove(new Position(2,2)));
    }
}
