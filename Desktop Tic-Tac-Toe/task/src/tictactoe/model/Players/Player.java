package tictactoe.model.Players;

import tictactoe.model.GamePlayers;

public interface Player {
    void nextStep();
    GamePlayers getGamePlayer();
}
