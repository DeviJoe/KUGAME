package com.ivannikov.service;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Класс реализовывает управление для JPanel на "стрелках"
 */
public class ArrowController implements KeyListener {

    private boolean isLeft;
    private boolean isRight;
    private boolean isUp;
    private boolean isDown;

    public ArrowController() {
        this.isLeft = false;
        this.isRight = false;
        this.isUp = false;
        this.isDown = false;
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


    public void keyTyped(final KeyEvent e) {
    }

    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.isLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.isRight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.isUp = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.isDown = true;
        }
    }

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
