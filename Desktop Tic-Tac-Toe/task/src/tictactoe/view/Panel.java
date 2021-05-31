package tictactoe.view;

import tictactoe.controller.ChangePlayerListener;
import tictactoe.controller.EnabledActions;
import tictactoe.controller.Game;
import tictactoe.controller.StartResetListener;
import tictactoe.model.ActionStatus;
import tictactoe.model.GamePlayers;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private JButton player1;
    private JButton startReset;
    private JButton player2;
    private StartResetListener startResetListener;

    private GamePlayers gamePlayer1;
    private GamePlayers gamePlayer2;

    public Panel(Drawable drawable, EnabledActions enabledActions, Game game) {
        gamePlayer1 = GamePlayers.USER;
        gamePlayer2 = GamePlayers.USER;
        createComponents(drawable, enabledActions, game);
        drawComponents();
    }

    private void drawComponents() {
        setLayout(new GridLayout(1, 3));
        add(player1);
        add(startReset);
        add(player2);
    }

    private void createComponents(Drawable drawable, EnabledActions enabledActions,
                                  Game game) {
        createStartReset(drawable, enabledActions, game);
        createPlayer1();
        createPlayer2();
    }

    private void createStartReset(Drawable drawable, EnabledActions enabledActions,
                                  Game game) {
        startReset = new JButton();
        startReset.setText(ActionStatus.START.getText());
        startResetListener = new StartResetListener(drawable, enabledActions,
                this::getGamePlayer1, this::getGamePlayer2,
                game);
        startReset.addActionListener(startResetListener);
        startReset.setName("ButtonStartReset");
        startReset.setFocusPainted(false);
    }

    private void createPlayer1() {
        player1 = new JButton();
        player1.setText(gamePlayer1.getText());
        player1.setName("ButtonPlayer1");
        player1.setFocusPainted(false);
        player1.addActionListener(
                new ChangePlayerListener(player1::setText,
                        this::setGamePlayer1, this::getGamePlayer1));
    }

    private void createPlayer2() {
        player2 = new JButton();
        player2.setText(gamePlayer2.getText());
        player2.setName("ButtonPlayer2");
        player2.setFocusPainted(false);
        player2.addActionListener(
                new ChangePlayerListener(player2::setText,
                        this::setGamePlayer2, this::getGamePlayer2));
    }

    public void clickPlayer1() {
        player1.doClick();
    }

    public void clickPlayer2() {
        player2.doClick();
    }

    public void clickStartReset() {
        startReset.doClick();
    }

    public GamePlayers getGamePlayer1() {
        return gamePlayer1;
    }

    public GamePlayers getGamePlayer2() {
        return gamePlayer2;
    }

    public ActionStatus getActionStatus() {
        return startResetListener.getStatus();
    }

    private void setGamePlayer1(GamePlayers gamePlayer1) {
        this.gamePlayer1 = gamePlayer1;
    }

    private void setGamePlayer2(GamePlayers gamePlayer2) {
        this.gamePlayer2 = gamePlayer2;
    }

    public void drawStatus(ActionStatus status) {
        startReset.setText(status.getText());
    }

    public void setEnabledPlayer1(boolean b) {
        player1.setEnabled(b);
    }

    public void setEnabledPlayer2(boolean b) {
        player2.setEnabled(b);
    }
}
