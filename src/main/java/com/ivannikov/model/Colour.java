package com.ivannikov.model;

public enum Colour {

    RED(1),
    BLUE(2),
    ORANGE(3),
    GREEN(4);

    private final int index;

    Colour(int index) {
        this.index = index;
    }
}
