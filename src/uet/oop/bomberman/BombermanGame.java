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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class BombermanGame extends Application {

    public static KeyBoard keyBoard = new KeyBoard();
    private GraphicsContext gc;
    public static ImageView authorView = new ImageView();
    private Canvas canvas;
    private Board _board = new Board(3);
    public static Stage mainStage = null;
    public static boolean running = true;

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
        root.getChildren().add(authorView);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setTitle("Bomberman Game by Quang Anh and Tien Manh");
        stage.setScene(scene);
        mainStage = stage;
        mainStage.show();
        keyBoard.addListener(scene);

        _board.player = new Bomber(1, 1, Sprite.player_right.getFxImage());
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (running) {
                    render();
                    update();
                }
            }

        };
        _board.createMap();
        timer.start();
    }

    public void update() {
        _board.updateBrick();
        _board.updateEnemys();
        _board.items.forEach(Item::update);
        _board.updateItems();
        _board.gach.forEach(Entity::update);
        _board.enemys.forEach(Entity::update);
        _board.player.update();
        _board.bombs.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        _board.stillEntity.forEach(g -> g.render(gc));
        _board.items.forEach(g -> g.render(gc));
        _board.bombs.forEach(g -> g.render(gc));
        _board.enemys.forEach(g -> g.render(gc));
        _board.gach.forEach(g -> g.render(gc));
        if (_board.player!= null) {
            _board.player.render(gc);
        }
    }
}
