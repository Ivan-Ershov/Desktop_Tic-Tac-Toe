package tictactoe.controller;

import tictactoe.model.Coordinate;
import tictactoe.model.Field;
import tictactoe.model.GameStatus;
import tictactoe.model.GameSymbol;
import tictactoe.model.Players.Player;
import tictactoe.view.Drawable;

import java.util.function.Consumer;

public class Game {
    private final Field field;
    private final Drawable drawable;
    private final Consumer<Boolean> setEnabledField;
    private Player player1;
    private Player player2;
    private boolean nextSecond = true;

    public Game(int size, Drawable drawable, Consumer<Boolean> setEnabledField) {
        this.drawable = drawable;
        this.field = new Field(size);
        this.setEnabledField = setEnabledField;
    }

    public void start(Player player1, Player player2) {
        field.reset();
        setEnabledField.accept(false);
        this.player1 = player1;
        this.player2 = player2;
        nextSecond = true;
        drawGameStatus();
        player1.nextStep();
    }

    public void moveNext(Coordinate coordinate) {
        GameStatus status = field.getStatus();

        if ((status != GameStatus.GAME_NOT_FINISHED)
                && (status != GameStatus.GAME_NOT_STARTED)) {
            return;
        }

        if (field.getCell(coordinate) != GameSymbol.WHITESPACE) {
            return;
        }

        setEnabledField.accept(false);

        if (nextSecond) {
            field.moveX(coordinate);
            drawable.drawCell(coordinate, field.getCell(coordinate));
            nextSecond = false;
            drawGameStatus();

            status = field.getStatus();
            if ((status != GameStatus.GAME_NOT_FINISHED)
                    && (status != GameStatus.GAME_NOT_STARTED)) {
                return;
            }

            player2.nextStep();
        } else {
            field.moveO(coordinate);
            drawable.drawCell(coordinate, field.getCell(coordinate));
            nextSecond = true;
            drawGameStatus();

            status = field.getStatus();
            if ((status != GameStatus.GAME_NOT_FINISHED)
                    && (status != GameStatus.GAME_NOT_STARTED)) {
                return;
            }

            player1.nextStep();
        }

    }

    private void drawGameStatus() {
        GameStatus status = field.getStatus();

        if (status == GameStatus.X_WINS) {
            drawable.drawGameStatus(
                    String.format("The %s Player (X) wins",
                            player1.getGamePlayer().getText()));
            return;
        }

        if (status == GameStatus.O_WINS) {
            drawable.drawGameStatus(
                    String.format("The %s Player (O) wins",
                            player2.getGamePlayer().getText()));
            return;
        }

        if (status == GameStatus.GAME_NOT_FINISHED) {

            Player cur;
            GameSymbol symbol;

            if (nextSecond) {
                cur = player1;
                symbol = GameSymbol.CROSS;
            } else {
                cur = player2;
                symbol = GameSymbol.ZERO;
            }


            drawable.drawGameStatus(
                    String.format("The turn of %s Player (%s)",
                            cur.getGamePlayer().getText(), symbol.getSymbol()));
            return;
        }

        drawable.drawGameStatus(status.getText());
    }

    public Field getField() {
        return field;
    }
}
