package com.ivannikov;

import com.ivannikov.controller.GameController;
import com.ivannikov.model.Colour;
import com.ivannikov.model.Direction;
import com.ivannikov.model.Entity;
import com.ivannikov.util.LevelLoader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GameController session = new GameController();
        session.createSession(1);
        Entity[][] field = session.makeMove(Colour.RED, Direction.RIGHT);
        field = session.makeMove(Colour.RED, Direction.UP);
        System.out.println();
    }
}
