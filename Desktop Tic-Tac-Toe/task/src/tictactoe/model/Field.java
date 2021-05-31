package tictactoe.model;

public class Field {
    private final int size;
    private final GameSymbol[][] field;
    private final String xWinLine;
    private final String oWinLine;

    public Field (int size) {
        this.size = size;
        this.xWinLine = GameSymbol.CROSS.name().repeat(size);
        this.oWinLine = GameSymbol.ZERO.name().repeat(size);
        this.field = new GameSymbol[size][size];

        for (int vertical = 0; vertical < size; vertical++) {
            for (int horizontal = 0; horizontal < size; horizontal++) {
                field[vertical][horizontal] = GameSymbol.WHITESPACE;
            }
        }

    }

    public int getSize() {
        return size;
    }

    public void moveX(Coordinate coordinate) {
        move(GameSymbol.CROSS, coordinate);
    }

    public void moveO(Coordinate coordinate) {
        move(GameSymbol.ZERO, coordinate);
    }

    private void move(GameSymbol symbol, Coordinate coordinate) {

        if ((coordinate.getHorizontal() < 0) || (size <= coordinate.getHorizontal())) {
            throw new IllegalArgumentException("Coordinates should be from 0 to 2!");
        }

        if ((coordinate.getVertical() < 0) || (size <= coordinate.getVertical())) {
            throw new IllegalArgumentException("Coordinates should be from 0 to 2!");
        }

        replace(symbol,coordinate);
    }

    private void replace(GameSymbol symbol, Coordinate coordinate) {
        if (getCell(coordinate) != GameSymbol.WHITESPACE) {
            throw new IllegalArgumentException(
                    "This cell is occupied! Choose another one!");
        }

        field[coordinate.getVertical()][coordinate.getHorizontal()] = symbol;
    }

    public GameSymbol getCell(Coordinate coordinate) {
        return field[coordinate.getVertical()][coordinate.getHorizontal()];
    }

    public GameStatus getStatus() {

        if (isWin(xWinLine)) {
            return GameStatus.X_WINS;
        }

        if (isWin(oWinLine)) {
            return GameStatus.O_WINS;
        }

        if (isNoFinish()) {
            return GameStatus.GAME_NOT_FINISHED;
        }

        return GameStatus.DRAW;
    }

    private boolean isWin(String winLine) {

        if (isHorizontalWin(winLine)) {
            return true;
        }

        if (isVerticalWin(winLine)) {
            return true;
        }

        return isDiagonalWine(winLine);
    }

    private boolean isHorizontalWin(String winLine) {
        for (int vertical = 0; vertical < size; vertical++) {
            if (toString(field[vertical]).equals(winLine)) {
                return true;
            }
        }

        return false;
    }

    private String toString(GameSymbol[] line) {
        StringBuilder output = new StringBuilder();

        for (GameSymbol gameSymbol : line) {
            output.append(gameSymbol);
        }

        return output.toString();
    }

    private boolean isVerticalWin(String winLine) {
        for (int horizontal = 0; horizontal < size; horizontal++) {
            if (getHorizontalLine(horizontal).equals(winLine)) {
                return true;
            }
        }

        return false;
    }

    private String getHorizontalLine(int number) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < size; i++) {
            output.append(field[i][number]);
        }

        return output.toString();
    }

    private boolean isDiagonalWine(String winLine) {

        if (getRightDiagonal().equals(winLine)) {
            return true;
        }

        return getLeftDiagonal().equals(winLine);
    }

    private String getRightDiagonal() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < size; i++) {
            output.append(field[i][i]);
        }

        return output.toString();
    }

    private String getLeftDiagonal() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < size; i++) {
            output.append(field[i][size - i - 1]);
        }

        return output.toString();
    }

    private boolean isNoFinish() {
        for (int vertical = 0; vertical < size; vertical++) {
            for (int horizontal = 0; horizontal < size; horizontal++) {
                if (field[vertical][horizontal] == GameSymbol.WHITESPACE) {
                    return true;
                }
            }
        }

        return false;
    }

    public void reset() {
        for (int vertical = 0; vertical < size; vertical++) {
            for (int horizontal = 0; horizontal < size; horizontal++) {
                field[vertical][horizontal] = GameSymbol.WHITESPACE;
            }
        }
    }

}
