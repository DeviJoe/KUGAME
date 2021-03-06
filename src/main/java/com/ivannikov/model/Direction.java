package com.ivannikov.model;

import lombok.Getter;

public enum Direction {

    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    @Getter
    private final int offsetLine;
    @Getter
    private final int offsetColumn;

    Direction(int offsetLine, int offsetColumn) {
        this.offsetLine = offsetLine;
        this.offsetColumn = offsetColumn;
    }
}
