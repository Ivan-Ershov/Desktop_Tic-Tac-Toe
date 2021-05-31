package tictactoe.view;

import tictactoe.model.GameSymbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Cell extends JButton {
    private static final Font TEXT_FONT = new Font("Courier", Font.BOLD, 40);

    public Cell(GameSymbol gameSymbol) {
        setText("" + gameSymbol.getSymbol());
        setFocusPainted(false);
        setFont(TEXT_FONT);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public void addActionListener(ActionListener l) {
        super.addActionListener(l);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
