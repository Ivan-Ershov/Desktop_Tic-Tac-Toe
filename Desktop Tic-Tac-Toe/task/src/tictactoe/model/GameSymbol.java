package tictactoe.model;

public enum GameSymbol {
    CROSS('X'),
    ZERO('O'),
    WHITESPACE(' ');

    private final char symbol;

    GameSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
