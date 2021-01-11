package com.ivannikov.view;

import com.ivannikov.service.GameService;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    GameService service;

    public Board() {
        // подсунуть поле
        init();
    }

    private void init() {
        setFocusable(true);
        setBackground(Color.BLACK);

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // отрисовать поле

        Toolkit.getDefaultToolkit().sync();
    }
}
