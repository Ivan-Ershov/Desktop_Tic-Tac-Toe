package tictactoe.view;

import tictactoe.model.Coordinate;
import tictactoe.model.GameSymbol;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{
    private static final String BUTTON = "Button";

    private Cell[][] field;

    public Board(int size) {
        setLayout(new GridLayout(size, size));
        addField(size);
    }

    /*
        Draw game field.
     */

    private void addField(int size) {
        field = new Cell[size][size];

        for (int vertical = 0; vertical < size; vertical++) {
            for (int horizontal = 0; horizontal < size; horizontal++) {
                Coordinate coordinate = new Coordinate(vertical, horizontal);
                String name = BUTTON + getName(coordinate, size);
                Cell cell = createCell(name);
                add(cell);
                field[vertical][horizontal] = cell;
            }
        }
    }

    private String getName(Coordinate coordinate, int size) {
        return (char)('A' + coordinate.getHorizontal())
                + Integer.toString(size - coordinate.getVertical());
    }

    private Cell createCell(String name) {
        Cell cell = new Cell(GameSymbol.WHITESPACE);
        cell.setName(name);
        cell.setEnabled(false);
        return cell;
    }

    /*
        Draw cell.
     */

    public void drawCell(Coordinate coordinate, GameSymbol gameSymbol) {
        getCell(coordinate).setText(String.valueOf(gameSymbol.getSymbol()));
    }

    private Cell getCell(Coordinate coordinate) {
        return  field[coordinate.getVertical()][coordinate.getHorizontal()];
    }

    /*
        Clean field.
     */

    public void clean() {
        for (Cell[] cells : field) {
            for (int horizontal = 0; horizontal < field.length; horizontal++) {
                cells[horizontal]
                        .setText(String.valueOf(GameSymbol.WHITESPACE.getSymbol()));
            }
        }
    }

    /*
        Get field.
     */

    public Cell[][] getField() {
        return field;
    }

    /*
        Set enabled.
     */

    public void setEnabled(boolean b) {
        for (Cell[] cells : field) {
            for (int horizontal = 0; horizontal < field.length; horizontal++) {
                cells[horizontal].setEnabled(b);
            }
        }
    }
}
