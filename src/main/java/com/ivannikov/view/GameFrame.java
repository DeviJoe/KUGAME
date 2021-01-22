package com.ivannikov.view;


import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
    private JPanel gamePanel;
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        gamePanel = new Board();
        try {
            ((Board) gamePanel).getSession().createSession(1);
        } catch (Exception e) {
            System.out.println("JIS<RF");
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 332, 332);
        ((Board)gamePanel).paintComponent(g);
    }

}

