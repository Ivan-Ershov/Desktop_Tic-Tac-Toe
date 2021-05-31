package tictactoe.controller;

import tictactoe.model.GamePlayers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ChangePlayerListener implements ActionListener {

    private final Consumer<GamePlayers> setPlayer;
    private final Supplier<GamePlayers> getPlayer;
    private final Consumer<String> setText;

    public ChangePlayerListener(Consumer<String> setText,
            Consumer<GamePlayers> setPlayer, Supplier<GamePlayers> getPlayer) {
        this.setPlayer = setPlayer;
        this.getPlayer = getPlayer;
        this.setText = setText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getPlayer.get() == GamePlayers.USER) {
            setPlayer.accept(GamePlayers.ROBOT);
        } else {
            setPlayer.accept(GamePlayers.USER);
        }

        setText.accept(getPlayer.get().getText());
    }
}
