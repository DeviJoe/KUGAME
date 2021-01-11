package com.ivannikov.model;

import com.ivannikov.Settings;
import lombok.Getter;

public class GameField {

    @Getter
    private final Entity[][] field;

    public GameField(Entity[][] field) {
        this.field = field;
    }

    /**
     * Получение координаты сущности
     * @param entity сущность
     * @return координата
     */
    public static Coordinate getCoordinateFromEntity(Entity entity) {
        Point point = entity.getCoordinate();
        int str = (int) (point.getX() / Settings.TEXTURE_SIZE);
        int col = (int) (point.getY() / Settings.TEXTURE_SIZE);
        return new Coordinate(str, col);
    }

    /**
     * Возвращает сущность по координате в таблице
     * @param coordinate координата в таблице
     * @return игровая сущность
     */
    public Entity getEntityFromCoordinate(Coordinate coordinate) {
        return field[coordinate.line][coordinate.column];
    }

    /**
     * Преобразует координату таблицы в точку на плоскости
     * @param coordinate координата колонки и ячейки
     * @return точку на плоскости, пригодную для отрисовки
     */
    public static Point getPointFromCoordinate(Coordinate coordinate) {
        return new Point(coordinate.line * Settings.TEXTURE_SIZE, coordinate.column * Settings.TEXTURE_SIZE);
    }

    /**
     * Проверяет для сущности направление движения и возвращает точку для графического интерфейса, где надо будет отрисовать объект
     * @param entity шарик
     * @param direction направление
     * @return координату на плоскости, если объект столкнется с базой, то вернуть null
     */
    public Point scanFieldForMove(Entity entity, Direction direction) {
        Coordinate coordinate = getCoordinateFromEntity(entity);
        for (int i = coordinate.line; i >= 0 && i < field.length; i += direction.getOffsetLine()) {
            for (int j = coordinate.column; j>=0 && j < field[0].length; j += direction.getOffsetColumn()) {
                if (field[i][j] != null && !(field[i][j] instanceof Base)) return getPointFromCoordinate(new Coordinate(i - direction.getOffsetLine(), j - direction.getOffsetColumn()));
                if (field[i][j] instanceof Base) {
                    if (((Base) field[i][j]).getColour() == ((Ball)entity).getColour()) return null;
                }
            }
        }
        return null;
    }

    public void deleteEntity(Entity entity) {
        Coordinate coordinate = getCoordinateFromEntity(entity);
        field[coordinate.line][coordinate.column] = null;
    }
}
