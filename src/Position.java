public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        assert x >= 0 && x < 3;
        assert y >= 0 && y < 3;

        this.x = x;
        this.y = y;
    }

    public boolean isOnSameRow(Position position) {
        return y == position.y;
    }

    public boolean isOnSameColumn(Position position) {
        return x == position.x;
    }

    public boolean isOnSameDiagonalfromLeftTop(Position position) {
        return position.x - this.x == position.y - this.y;
    }

    public boolean isOnSameDiagonalfromRightTop(Position position) {
        return position.x - this.x == this.y - position.y;
    }
}
