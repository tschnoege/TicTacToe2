public class Player {
    String token;
    final static Player FIRST = new Player("X");
    final static Player SECOND = new Player("O");

    public Player(String token) {
        this.token = token;
    }

    public static Player first() {
        return FIRST;
    }

    public static Player second() {
        return SECOND;
    }
}
