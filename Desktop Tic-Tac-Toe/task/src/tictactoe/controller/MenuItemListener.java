package tictactoe.controller;

import tictactoe.model.ActionStatus;
import tictactoe.model.GamePlayers;
import tictactoe.view.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemListener implements ActionListener {

    private final Panel panel;
    private final GamePlayers player1;
    private final GamePlayers player2;

    public MenuItemListener(Panel panel, GamePlayers player1, GamePlayers player2) {
        this.panel = panel;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (panel.getActionStatus() == ActionStatus.RESET) {
            panel.clickStartReset();
        }

        if (panel.getGamePlayer1() != player1) {
            panel.clickPlayer1();
        }

        if (panel.getGamePlayer2() != player2) {
            panel.clickPlayer2();
        }

        panel.clickStartReset();
    }
}
