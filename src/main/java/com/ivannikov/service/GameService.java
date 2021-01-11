package com.ivannikov.service;

import com.ivannikov.model.*;

public class GameService {

    private int score;
    private final GameField field;

    public GameService(GameField field) {
        this.field = field;
    }

    /**
     * Сдвигает шарик определенного цвета по направлению до ближайшей сущности
     * @param ball шарик
     * @param direction направление
     * @return точка, в которую нужно будет сдвинуть шарик
     */
    public Point move(Entity ball, Direction direction) {
        /*
        1) найти шарик на поле
        2) Просмотреть направление и найти координаты ближайшей сущности, найти индексы соседней клетки
        3) Определить координаты точки
         */

        if (!(ball instanceof Ball)) throw new RuntimeException("Шарик не найден");
        Point state = field.scanFieldForMove(ball, direction);
        if (state != null) return state;
        else {
            ball.setVisible(false);
            score ++;
            field.deleteEntity(ball);
            return null;
        }
    }


}
