package com.ivannikov.model;

import lombok.Getter;

public class Coordinate {

    @Getter
    int line;
    @Getter
    int column;

    public Coordinate(int line, int column) {
        this.line = line;
        this.column = column;
    }
}
