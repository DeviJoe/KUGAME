package com.ivannikov.util;

import com.ivannikov.model.*;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LevelLoader {

    public static Entity[][] loadLevel(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(lines::add);

        List<String[]> separate = new ArrayList<>();
        for (String line : lines) {
            separate.add(line.split(" "));
        }

        Entity[][] res = new Entity[separate.size()][separate.get(0).length];
        int i = 0, j = 0;
        for (String[] strings : separate) {
            for (String code : strings) {
                switch (code) {
                    case "00" -> res[i][j] = null;
                    case "99" -> res[i][j] = new Wall(ResourceLoader.loadImage("src/main/resources/sprites/wall.png"), GameField.getPointFromCoordinate(new Coordinate(i, j)));
                    case "11" -> res[i][j] = new Ball(ResourceLoader.loadImage("src/main/resources/sprites/red_ball.png"), GameField.getPointFromCoordinate(new Coordinate(i, j)), Colour.RED);
                    case "12" -> res[i][j] = new Ball(ResourceLoader.loadImage("src/main/resources/sprites/blue_ball.png"), GameField.getPointFromCoordinate(new Coordinate(i, j)), Colour.BLUE);
                    case "13" -> res[i][j] = new Ball(ResourceLoader.loadImage("src/main/resources/sprites/orange_ball.png"), GameField.getPointFromCoordinate(new Coordinate(i, j)), Colour.ORANGE);
                    case "14" -> res[i][j] = new Ball(ResourceLoader.loadImage("src/main/resources/sprites/green_ball.png"), GameField.getPointFromCoordinate(new Coordinate(i, j)), Colour.GREEN);
                    case "21" -> res[i][j] = new Base(ResourceLoader.loadImage("src/main/resources/sprites/red_base.png"), GameField.getPointFromCoordinate(new Coordinate(i, j)), Colour.RED);
                    case "22" -> res[i][j] = new Base(ResourceLoader.loadImage("src/main/resources/sprites/blue_base.png"), GameField.getPointFromCoordinate(new Coordinate(i, j)), Colour.BLUE);
                    case "23" -> res[i][j] = new Base(ResourceLoader.loadImage("src/main/resources/sprites/orange_base.png"), GameField.getPointFromCoordinate(new Coordinate(i, j)), Colour.ORANGE);
                    case "24" -> res[i][j] = new Base(ResourceLoader.loadImage("src/main/resources/sprites/green_base.png"), GameField.getPointFromCoordinate(new Coordinate(i, j)), Colour.GREEN);
                }
                j++;
            }
            i++;
            j = 0;
        }
        return res;
    }
}
