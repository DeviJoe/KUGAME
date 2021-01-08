package com.ivannikov.model;

import lombok.Getter;
import lombok.Setter;

public class Point {

    @Getter @Setter
    private double x;
    @Getter @Setter
    private double y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
