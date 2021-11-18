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
import uet.oop.bomberman.graphics.Sprite;

import javafx.scene.input.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static uet.oop.bomberman.Board.*;

public class BombermanGame extends Application {

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

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                player._moving = false;
                update();
            }
        };
        createMap();
        timer.start();

        player = new Bomber(1, 1, Sprite.player_right.getFxImage());
        bomb = new Bomb(-1, -1, Sprite.bomb.getFxImage());

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.UP) {
                    player._moving = true;
                    if (player.canMove(1)) {
                        player.setY(player.getY() - speed);
                    }
                }
                if(event.getCode() == KeyCode.RIGHT) {
                    player._moving = true;
                    if (player.canMove(2)) {
                        player.setX(player.getX() + speed);
                    }
                }
                if(event.getCode() == KeyCode.LEFT) {
                    player._moving = true;
                    if (player.canMove(0)) {
                        player.setX(player.getX() - speed);
                    }
                }
                if(event.getCode() == KeyCode.DOWN) {
                    player._moving = true;
                    if (player.canMove(3)) {
                        player.setY(player.getY() + speed);
                    }
                }
                if(event.getCode() == KeyCode.SPACE) {
                    player._moving = true;
                    bomb.setY(player.getY());
                    bomb.setX(player.getX());
                }
            }
        });
    }

    public void update() {
        enemys.forEach(Entity::update);
        player.update();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillEntity.forEach(g -> g.render(gc));
        gach.forEach(g -> g.render(gc));
        enemys.forEach(g -> g.render(gc));
        if (bomb!= null) {
            bomb.render(gc);
        }
        if (player!= null) {
            player.render(gc);
        }
    }

}
