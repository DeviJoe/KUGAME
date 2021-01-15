package com.ivannikov.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Coordinate {

    public int line;
    public int column;

    public Coordinate(int line, int column) {
        this.line = line;
        this.column = column;
    }
}
