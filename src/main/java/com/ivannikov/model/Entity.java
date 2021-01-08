package com.ivannikov.model;

import java.awt.image.BufferedImage;


public abstract class Entity {

    BufferedImage texture;
    Point coordinate;

    public Entity(BufferedImage texture, Point coordinate) {
        this.texture = texture;
        this.coordinate = coordinate;
    }
}
