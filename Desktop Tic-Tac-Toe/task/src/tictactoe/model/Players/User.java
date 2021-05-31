package tictactoe.model.Players;

import tictactoe.controller.Action;
import tictactoe.model.GamePlayers;

public class User implements Player{

    private final Action action;
    private final GamePlayers who;

    public User(Action action, GamePlayers who) {
        this.action = action;
        this.who = who;
    }

    @Override
    public void nextStep() {
        action.action();
    }

    @Override
    public GamePlayers getGamePlayer() {
        return who;
    }
}
