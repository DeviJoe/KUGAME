package com.ivannikov.view;

import com.ivannikov.Settings;
import com.ivannikov.controller.GameController;
import com.ivannikov.model.Colour;
import com.ivannikov.model.Direction;
import com.ivannikov.model.Entity;
import com.ivannikov.controller.ArrowController;
import com.ivannikov.util.ResourceLoader;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel {

    @Getter @Setter
    GameController session;



    public Board(GameController session) {
        this.session = session;
    }

    // отрисовка поля
    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceLoader.loadImage("src/main/resources/sprites/bg.png"), 0, 0, null);
        Entity[][] field = session.getField();
        // отрисовка поля
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] != null)
                    g.drawImage(field[i][j].getTexture(), j * Settings.TEXTURE_SIZE + 64, i * Settings.TEXTURE_SIZE + Settings.TEXTURE_SIZE + 32, null);
                else
                   g.drawImage(ResourceLoader.loadImage("src/main/resources/sprites/space.png"), i * Settings.TEXTURE_SIZE + 64, j * Settings.TEXTURE_SIZE + 32, null);
            }
        }
    }
}
