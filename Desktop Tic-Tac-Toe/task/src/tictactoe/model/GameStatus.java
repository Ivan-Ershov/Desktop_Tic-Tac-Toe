package tictactoe.model;

public enum GameStatus {
    GAME_NOT_STARTED("Game is not started"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    GAME_NOT_FINISHED("Game in progress"),
    DRAW("Draw");

    private final String text;

    GameStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
