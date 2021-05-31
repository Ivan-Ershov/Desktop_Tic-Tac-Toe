package tictactoe.model;

public enum GamePlayers {
    USER("Human"),
    ROBOT("Robot");

    private final String text;

    GamePlayers(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
