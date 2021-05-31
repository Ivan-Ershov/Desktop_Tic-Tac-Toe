package tictactoe.model.Players.Robots;

import tictactoe.controller.Game;
import tictactoe.model.Coordinate;
import tictactoe.model.Field;
import tictactoe.model.GamePlayers;
import tictactoe.model.GameSymbol;
import tictactoe.model.Players.Player;

import java.util.Random;

public class Easy implements Player {
    private final Field field;
    private final int bound;
    private final Game game;
    private final GamePlayers who;

    public Easy(Game game, GamePlayers who) {
        this.field = game.getField();
        this.who = who;
        this.game = game;
        bound = field.getSize() * field.getSize();
    }

    @Override
    public void nextStep() {
        int x;
        int y;
        Coordinate coordinate;

        do {
            Random random = new Random();
            x = random.nextInt(bound);
            y = random.nextInt(bound);
            coordinate = new Coordinate(y, x);

        } while (!(((0 <= coordinate.getVertical()) &&
                        (coordinate.getVertical() < field.getSize())) &&
                ((0 <= coordinate.getHorizontal()) &&
                        (coordinate.getHorizontal() < field.getSize())) &&
                (field.getCell(coordinate) == GameSymbol.WHITESPACE)));

        game.moveNext(coordinate);
    }

    @Override
    public GamePlayers getGamePlayer() {
        return who;
    }
}
