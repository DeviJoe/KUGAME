package com.ivannikov.controller;


import com.ivannikov.model.Colour;
import com.ivannikov.model.Direction;
import com.ivannikov.util.SwingUtils;
import com.ivannikov.view.Board;
import com.ivannikov.view.LevelForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Класс реализовывает управление для JPanel на "стрелках"
 */
public class ArrowController implements KeyListener {

    Board board;
    GameController controller;

    private boolean isLeft;
    private boolean isRight;
    private boolean isUp;
    private boolean isDown;
    private boolean isR;
    private boolean isO;
    private boolean isG;
    private boolean isB;

    public ArrowController(Board board) {
        this.isLeft = false;
        this.isRight = false;
        this.isUp = false;
        this.isDown = false;
        isB = false;
        isG = false;
        isO = false;
        isR = false;
        this.board = board;
        this.controller = GameController.getInstance();
    }

    public void move() {
        Colour state;
        Direction dir;

        if (isB()) state = Colour.BLUE;
        else if (isG()) state = Colour.GREEN;
        else if (isO()) state = Colour.ORANGE;
        else if (isR()) state = Colour.RED;
        else state = null;

        if (isDownPressed()) dir = Direction.DOWN;
        else if (isUpPressed()) dir = Direction.UP;
        else if (isLeftPressed()) dir = Direction.LEFT;
        else if (isRightPressed()) dir = Direction.RIGHT;
        else dir = null;

        if (dir != null && state != null)
            controller.makeMove(state, dir);

        isLeft = false;
        isRight = false;
        isUp = false;
        isDown = false;
    }

    public boolean isUpPressed() {
        return this.isUp;
    }

    public boolean isDownPressed() {
        return this.isDown;
    }

    public boolean isLeftPressed() {
        return this.isLeft;
    }

    public boolean isRightPressed() {
        return this.isRight;
    }

    public boolean isB() {
        return isB;
    }

    public boolean isG() {
        return isG;
    }

    public boolean isO() {
        return isO;
    }

    public boolean isR() {
        return isR;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.isLeft = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.isRight = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.isUp = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.isDown = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_R) {
            this.isR = true;
            this.isO = false;
            this.isG = false;
            this.isB = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_O) {
            this.isO = true;
            this.isG = false;
            this.isB = false;
            this.isR = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_G) {
            this.isG = true;
            this.isB = false;
            this.isR = false;
            this.isO = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_B) {
            this.isB = true;
            this.isG = false;
            this.isR = false;
            this.isO = false;
        }

        if (isRightPressed() || isLeftPressed() || isDownPressed() || isUpPressed()) {
            move();
            board.repaint();
            if (controller.isWin()) {
                SwingUtils.showInfoMessageBox("Вы выиграли!");
            }
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.isLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.isRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.isUp = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.isDown = false;
        }
    }


}
