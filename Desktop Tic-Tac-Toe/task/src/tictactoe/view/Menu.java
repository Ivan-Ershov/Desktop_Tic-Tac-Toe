package tictactoe.view;

import tictactoe.controller.MenuItemListener;
import tictactoe.model.GamePlayers;

import javax.swing.*;

public class Menu extends JMenu {

    public Menu(Panel panel) {
        super("Game");
        setName("MenuGame");
        addComponents(panel);
    }

    private void addComponents(Panel panel) {
        JMenuItem menuHumanHuman = new JMenuItem("Human vs Human");
        menuHumanHuman.setName("MenuHumanHuman");
        JMenuItem menuHumanRobot = new JMenuItem("Human vs Robot");
        menuHumanRobot.setName("MenuHumanRobot");
        JMenuItem menuRobotHuman = new JMenuItem("Robot vs Human");
        menuRobotHuman.setName("MenuRobotHuman");
        JMenuItem menuRobotRobot = new JMenuItem("Robot vs Robot");
        menuRobotRobot.setName("MenuRobotRobot");
        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.setName("MenuExit");

        add(menuHumanHuman);
        add(menuHumanRobot);
        add(menuRobotHuman);
        add(menuRobotRobot);
        addSeparator();
        add(menuExit);

        menuHumanHuman.addActionListener
                (new MenuItemListener(panel, GamePlayers.USER, GamePlayers.USER));
        menuHumanRobot.addActionListener
                (new MenuItemListener(panel, GamePlayers.USER, GamePlayers.ROBOT));
        menuRobotHuman.addActionListener
                (new MenuItemListener(panel, GamePlayers.ROBOT, GamePlayers.USER));
        menuRobotRobot.addActionListener
                (new MenuItemListener(panel, GamePlayers.ROBOT, GamePlayers.ROBOT));
        menuExit.addActionListener(e -> System.exit(0));

    }

}
