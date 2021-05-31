package tictactoe.model;

public enum ActionStatus {
    START("Start"),
    RESET("Reset");

    private final String text;

    ActionStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
