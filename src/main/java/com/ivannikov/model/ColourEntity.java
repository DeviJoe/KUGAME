package com.ivannikov.model;

import java.awt.image.BufferedImage;

public abstract class ColourEntity extends Entity {

    Colour colour;


    public ColourEntity(BufferedImage texture, Point coordinate, Colour colour) {
        super(texture, coordinate);
        this.colour = colour;
    }
}
