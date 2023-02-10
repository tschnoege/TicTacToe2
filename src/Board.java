import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Board {
    Map<Position, Player> positionPlayerMap = new HashMap<>();
    public Move applyMove(Player player, Position position) {
        if (positionPlayerMap.containsKey(position))
            return Move.POSITION_IS_OCCUPIED;

        positionPlayerMap.put(position, player);

        if (check3InARow(position, player)) {
            return Move.PLAYER_WINS;
        }

        if (boardIsOccupied()) {
            return Move.GAME_IS_A_DRAW;
        }

        return Move.VALID_MOVE;
    }

    private boolean boardIsOccupied() {
        return positionPlayerMap.size() == 9;
    }

    public boolean check3InARow(Position position, Player player) {
        return checkRow(position, player) ||
                checkColumn(position, player) ||
                checkDiagonal(position, player);
    }

    private boolean checkRow(Position position, Player player) {

        final Stream<Map.Entry<Position, Player>> entryStream = positionPlayerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == player &&
                        entry.getKey().isOnSameRow(position));

        return entryStream.count() == 3;
    }

    private boolean checkColumn(Position position, Player player) {

        final Stream<Map.Entry<Position, Player>> entryStream = positionPlayerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == player &&
                        entry.getKey().isOnSameColumn(position));

        return entryStream.count() == 3;
    }

    private boolean checkDiagonal(Position position, Player player) {
        Stream<Map.Entry<Position, Player>> entryStream = positionPlayerMap.entrySet().stream()
                .filter(entry -> entry.getValue() == player &&
                        entry.getKey().isOnSameDiagonalfromLeftTop(position));
        long size = entryStream.count();

        if (size != 3) {
            entryStream = positionPlayerMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == player &&
                            entry.getKey().isOnSameDiagonalfromRightTop(position));
            size = entryStream.count();
        }

        return size == 3;
    }
}
