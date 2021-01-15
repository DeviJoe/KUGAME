package com.ivannikov.controller;

import com.ivannikov.model.*;
import com.ivannikov.model.Point;
import com.ivannikov.service.GameService;
import com.ivannikov.util.LevelLoader;
import lombok.Getter;

import java.io.IOException;
import java.util.Arrays;

/**
 * API для клиента!!!
 */
public class GameController {

    public static final String LEVEL_PATH = "src/main/resources/levels/stage_";
    public static final String EXPANSION = ".lvl";

    @Getter
    GameService session;

    /**
     * Создает новую игровую сессию - инициализирует поле
     * @param level - порядковый номер уровня
     * @throws IOException если путь до файла с уровнем не существует - уровень в базе отсутствует
     */
    public void createSession(int level) throws IOException {
        String path = LEVEL_PATH + level + EXPANSION;
        Entity[][] levelField = LevelLoader.loadLevel(path);
        GameField field = new GameField(levelField);
        session = new GameService(field);
    }

    /**
     * Возвращает игровое поле
     */
    private Entity[][] getOriginalField() {
        return session.getGameField().getField();
    }

    /**
     * Возвращает игровое поле (КОПИЯ)
     */
    public Entity[][] getField() {
        return Arrays.copyOfRange(session.getGameField().getField(), 0, session.getGameField().getField().length);
    }

    /**
     * Получение текущего игрового счета
     */
    public int getScore() {
        return session.getScore();
    }

    /**
     * Получение объекта по цвету
     * @param colour цвет
     * @return объект
     */
    private Entity getBall(Colour colour) {
        return session.getGameField().getBall(colour);
    }

    /**
     * Передвигает шарик по полю по направлению
     * @param colour цвет
     * @param direction направление
     * @return текущее состояние поля
     */
    public Entity[][] makeMove(Colour colour, Direction direction) {
        Entity ball = getBall(colour);
        Point newCoordinateOfBall = session.move(ball, direction);
        Entity[][] field;
        if (newCoordinateOfBall != null) {
            Coordinate newCoordinate = GameField.getCoordinateFromPoint(newCoordinateOfBall);
            field = getOriginalField();
            Coordinate old = GameField.getCoordinateFromEntity(ball);

            if (!old.equals(newCoordinate)) {
                field[newCoordinate.line][newCoordinate.column] = ball;
                field[old.line][old.column] = null;
                ball.setPoint(GameField.getPointFromCoordinate(newCoordinate));
            }
        } else {
            session.getGameField().deleteEntity(ball);
            session.setScore(session.getScore() + 1);
        }
        return getField();
    }

    public boolean isWin() {
        Entity[][] field = getField();

        for (Entity[] entities : field) {
            for (Entity entity : entities) {
                if (entity instanceof Ball) return false;
            }
        }
        return true;
    }
}
