package tictactoe;

import tictactoe.controller.CellListener;
import tictactoe.controller.EnabledActions;
import tictactoe.controller.Game;
import tictactoe.model.ActionStatus;
import tictactoe.model.Coordinate;
import tictactoe.model.GameStatus;
import tictactoe.model.GameSymbol;
import tictactoe.view.Board;
import tictactoe.view.Drawable;
import tictactoe.view.Menu;
import tictactoe.view.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class TicTacToe extends JFrame implements Drawable, EnabledActions {
    private static final int SIZE = 3;

    private Board board;
    private Panel panel;
    private JLabel status;
    private final Game game;

    public TicTacToe() {
        setting();
        game = new Game(SIZE, this, this::field);
        createComponents();
        addMenu();
        addComponents();
        setVisible(true);
    }

    private void setting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setSize(450, 450);
        setLocationRelativeTo(null);
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu game = new Menu(panel);
        game.setMnemonic(KeyEvent.VK_G);
        menuBar.add(game);
    }

    private void createComponents() {
        createBoard();
        createStatus();
        createPanel();
    }

    private void addComponents() {
        add(panel, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
    }

    private void createBoard() {
        board = new Board(SIZE);
        field(false);
        addListeners();
    }

    private void createStatus() {
        status = new JLabel();
        status.setText(GameStatus.GAME_NOT_STARTED.getText());
        status.setName("LabelStatus");
    }

    private void createPanel() {
        panel = new Panel(this, this, game);
    }

    private void addListeners() {
        for (int vertical = 0; vertical < game.getField().getSize(); vertical++) {
            for (int horizontal = 0; horizontal < game.getField().getSize(); horizontal++) {
                Coordinate coordinate = new Coordinate(vertical, horizontal);
                ActionListener listener = new CellListener(game, coordinate);
                board.getField()[vertical][horizontal].addActionListener(listener);
            }
        }
    }

    /*
        Drawable interface.
     */

    @Override
    public void drawCell(Coordinate coordinate, GameSymbol gameSymbol) {
        board.drawCell(coordinate, gameSymbol);
    }

    @Override
    public void drawGameStatus(String text) {
        this.status.setText(text);
    }

    @Override
    public void drawActionStatus(ActionStatus status) {
        panel.drawStatus(status);
    }

    @Override
    public void cleanField() {
        drawGameStatus(GameStatus.GAME_NOT_STARTED.getText());
        board.clean();
    }

    /*
        EnabledActions interface.
     */

    @Override
    public void player1(boolean b) {
        panel.setEnabledPlayer1(b);
    }

    @Override
    public void player2(boolean b) {
        panel.setEnabledPlayer2(b);
    }

    @Override
    public void field(boolean b) {
        board.setEnabled(b);
    }
}