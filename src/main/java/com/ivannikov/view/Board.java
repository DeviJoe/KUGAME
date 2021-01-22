package com.ivannikov.view;

import com.ivannikov.Settings;
import com.ivannikov.controller.GameController;
import com.ivannikov.model.Entity;
import com.ivannikov.service.GameService;
import com.ivannikov.util.ResourceLoader;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    @Getter
    GameController session = new GameController();


    public void paintComponent(Graphics g) {
        super.paint(g);
        Entity[][] field = session.getField();


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] != null)
                    g.drawImage(field[i][j].getTexture(), j * Settings.TEXTURE_SIZE + 64, i * Settings.TEXTURE_SIZE + Settings.TEXTURE_SIZE + 32, null);
                else
                    g.drawImage(ResourceLoader.loadImage("src/main/resources/sprites/space.png"), i * Settings.TEXTURE_SIZE, j * Settings.TEXTURE_SIZE, null);
            }
        }
    }
}
