package com.ivannikov.model;

import com.ivannikov.Settings;
import lombok.Getter;

public class GameField {

    @Getter
    Entity[][] field;

    public GameField(Entity[][] field) {
        this.field = field;
    }

    public static Coordinate getCoordinateFromEntity(Entity entity) {
        Point point = entity.coordinate;
        int str = (int) (point.getX() / Settings.TEXTURE_SIZE);
        int col = (int) (point.getY() / Settings.TEXTURE_SIZE);
        return new Coordinate(str, col);
    }

    public Entity getEntityFromCoordinate(Coordinate coordinate) {
        return field[coordinate.line][coordinate.column];
    }

    public static Point getPointFromCoordinate(Coordinate coordinate) {
        return new Point(coordinate.line * Settings.TEXTURE_SIZE, coordinate.column * Settings.TEXTURE_SIZE);
    }

    public Point scanFieldForMove(Entity entity, Direction direction) {
        Coordinate coordinate = getCoordinateFromEntity(entity);
        for (int i = coordinate.line; i >= 0 && i < field.length; i += direction.getOffsetLine()) {
            for (int j = coordinate.column; j>=0 && j < field[0].length; j += direction.getOffsetColumn()) {
                if (field[i][j] != null) return getPointFromCoordinate(new Coordinate(i - direction.getOffsetLine(), j - direction.getOffsetColumn()));
            }
        }
        return null;
    }
}
