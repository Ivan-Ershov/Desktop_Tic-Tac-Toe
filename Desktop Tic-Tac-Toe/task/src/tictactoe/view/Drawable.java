package tictactoe.view;

import tictactoe.model.ActionStatus;
import tictactoe.model.Coordinate;
import tictactoe.model.GameSymbol;

public interface Drawable {
    void drawCell(Coordinate coordinate, GameSymbol gameSymbol);
    void drawGameStatus(String text);
    void drawActionStatus(ActionStatus status);
    void cleanField();
}
