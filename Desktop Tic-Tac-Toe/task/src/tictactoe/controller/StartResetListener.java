package tictactoe.controller;

import tictactoe.model.ActionStatus;
import tictactoe.model.GamePlayers;
import tictactoe.model.Players.Player;
import tictactoe.model.Players.Robots.Easy;
import tictactoe.model.Players.User;
import tictactoe.view.Drawable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class StartResetListener implements ActionListener {
    private final Drawable drawable;
    private final Supplier<GamePlayers> player1;
    private final Supplier<GamePlayers> player2;
    private final Game game;
    private final EnabledActions enabledActions;
    private ActionStatus status;

    public StartResetListener(Drawable drawable, EnabledActions enabledActions,
                              Supplier<GamePlayers> player1, Supplier<GamePlayers> player2,
                              Game game) {
        this.drawable = drawable;
        this.player1 = player1;
        this.player2 = player2;
        this.game = game;
        this.enabledActions = enabledActions;
        status = ActionStatus.START;
    }

    private void setEnabled(boolean b) {
        enabledActions.player1(b);
        enabledActions.player2(b);
        enabledActions.field(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (status == ActionStatus.START) {
            setEnabled(false);
            game.start(getPlayer(player1.get()), getPlayer(player2.get()));
            status = ActionStatus.RESET;
        } else {
            drawable.cleanField();
            setEnabled(true);
            enabledActions.field(false);
            status = ActionStatus.START;
        }

        drawable.drawActionStatus(status);
    }

    private Player getPlayer(GamePlayers gamePlayers) {
        if (gamePlayers == GamePlayers.USER) {
            return new User(this::enabledField, GamePlayers.USER);
        }

        if (gamePlayers == GamePlayers.ROBOT) {
            return new Easy(game, GamePlayers.ROBOT);
        }

        throw new IllegalArgumentException();
    }

    private void enabledField() {
        enabledActions.field(true);
    }

    public ActionStatus getStatus() {
        return status;
    }
}