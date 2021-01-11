package com.ivannikov.model;

import lombok.Getter;

import java.awt.image.BufferedImage;

public abstract class ColourEntity extends Entity {

    @Getter
    private final Colour colour;

    public ColourEntity(BufferedImage texture, Point coordinate, Colour colour) {
        super(texture, coordinate);
        this.colour = colour;
    }
}
