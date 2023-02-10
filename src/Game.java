public class Game {
    private Player playerToMove = Player.FIRST;

    private Board board = new Board();

    public Move applyMove(Position position) {
        final Move move = board.applyMove(playerToMove, position);

        if (move.equals(Move.VALID_MOVE)) {
            togglePlayer();
        }

        return move;
    }

    private void togglePlayer() {
        if (playerToMove == Player.FIRST) {
            playerToMove = Player.second();
            return;
        }

        playerToMove = Player.FIRST;
    }

    public Player getPlayerToMove() {
        return playerToMove;
    }

    public void reset() {
        playerToMove = Player.FIRST;
        board = new Board();
    }
}
