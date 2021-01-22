package com.ivannikov;

import com.ivannikov.controller.GameController;
import com.ivannikov.model.Colour;
import com.ivannikov.model.Direction;
import com.ivannikov.model.Entity;
import com.ivannikov.service.ArrowController;
import com.ivannikov.util.LevelLoader;
import com.ivannikov.view.GameFrame;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        GameController session = new GameController();
//        session.createSession(1);
//        Entity[][] field = session.makeMove(Colour.RED, Direction.RIGHT);
//        field = session.makeMove(Colour.RED, Direction.UP);
//        System.out.println();

        GameFrame frame = new GameFrame();
        frame.setVisible(true);
        frame.setSize(332, 600);
        frame.addKeyListener(new ArrowController());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
