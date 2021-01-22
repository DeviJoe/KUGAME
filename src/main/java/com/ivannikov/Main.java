package com.ivannikov;

import com.ivannikov.controller.GameController;
import com.ivannikov.controller.ArrowController;
import com.ivannikov.view.Board;
import com.ivannikov.view.GameForm;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        GameController session = new GameController();
//        session.createSession(1);
//        Entity[][] field = session.makeMove(Colour.RED, Direction.RIGHT);
//        field = session.makeMove(Colour.RED, Direction.UP);
//        System.out.println();

        GameController session = new GameController();
        session.createSession(1);


        GameForm form = new GameForm();
        Board board = new Board(session);
        board.setLayout(new BorderLayout());
        form.addKeyListener(new ArrowController(board, session));
        form.setVisible(true);
        form.setFocusable(true);
        form.setContentPane(board);


    }
}
