package com.ivannikov.model;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;


public abstract class Entity {

    @Getter
    private final BufferedImage texture;
    @Getter @Setter
    private Point point;
    @Getter @Setter
    private boolean isVisible = true;

    public Entity(BufferedImage texture, Point point) {
        this.texture = texture;
        this.point = point;
    }


}
