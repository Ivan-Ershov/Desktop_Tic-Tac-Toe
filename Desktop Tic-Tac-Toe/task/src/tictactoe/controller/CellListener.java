package tictactoe.controller;

import tictactoe.model.Coordinate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellListener implements ActionListener {

    private final Game game;
    private final Coordinate coordinate;

    public CellListener(Game game, Coordinate coordinate) {
        this.game = game;
        this.coordinate = coordinate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            game.moveNext(coordinate);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }
}
