package tictactoe;

import tictactoe.model.Coordinate;

@FunctionalInterface
public interface Action {
    void action(Coordinate coordinate);
}
