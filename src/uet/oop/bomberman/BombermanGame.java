package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;
import uet.oop.bomberman.entities.MovingEntity.bomber.Bomber;
import uet.oop.bomberman.entities.MovingEntity.enemy.Balloom;
import uet.oop.bomberman.entities.MovingEntity.enemy.Doll;
import uet.oop.bomberman.entities.MovingEntity.enemy.Enemy;
import uet.oop.bomberman.entities.MovingEntity.enemy.Oneal;
import uet.oop.bomberman.entities.StillEntity.*;
import uet.oop.bomberman.entities.StillEntity.item.Item;
import uet.oop.bomberman.graphics.Sprite;

import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.input.KeyBoard;

import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static uet.oop.bomberman.Board.*;

public class BombermanGame extends Application {

    public static KeyBoard keyBoard = new KeyBoard();
    private GraphicsContext gc;
    private Canvas canvas;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * Board._width, Sprite.SCALED_SIZE * Board._height);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setTitle("Bomberman Game by Quang Anh and Tien Manh");
        stage.setScene(scene);
        stage.show();
        keyBoard.addListener(scene);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        createMap();
        timer.start();

        player = new Bomber(1, 1, Sprite.player_right.getFxImage());
        //bomb = new Bomb(-1, -1, Sprite.bomb.getFxImage());

    }

    public void update() {
        updateBrick();
        updateEnemys();
        items.forEach(Item::update);
        updateItems();
        gach.forEach(Entity::update);
        enemys.forEach(Entity::update);
        player.update();
        bombs.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillEntity.forEach(g -> g.render(gc));
        items.forEach(g -> g.render(gc));
        enemys.forEach(g -> g.render(gc));
        bombs.forEach(g -> g.render(gc));
        gach.forEach(g -> g.render(gc));
        if (player!= null) {
            player.render(gc);
        }
    }
}
