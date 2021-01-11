package com.ivannikov.model;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;


public abstract class Entity {

    @Getter
    private final BufferedImage texture;
    @Getter @Setter
    private Point coordinate;
    @Getter @Setter
    private boolean isVisible = true;

    public Entity(BufferedImage texture, Point coordinate) {
        this.texture = texture;
        this.coordinate = coordinate;
    }


}
