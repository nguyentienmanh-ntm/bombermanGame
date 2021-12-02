package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.MovingEntity.bomber.Bomber;
import uet.oop.bomberman.entities.StillEntity.item.Item;
import uet.oop.bomberman.graphics.Sprite;

import uet.oop.bomberman.input.KeyBoard;
import uet.oop.bomberman.sound.Sound;

public class BombermanGame extends Application {

    public static KeyBoard keyBoard = new KeyBoard();
    private GraphicsContext gc;
    public static ImageView authorView = new ImageView();
    private Canvas canvas;
    public static Stage mainStage = null;
    public static boolean running = true;
    private Sound sounds = new Sound();
    public static boolean upLevel = false;
    private int level = 0;
    private Board _board;

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
        stage.setTitle("Bomberman Game by Quang Anh & Tien Manh & Minh Hieu");
        stage.setScene(scene);
        mainStage = stage;
        mainStage.show();
        keyBoard.addListener(scene);

        running = true;
        sounds.play("soundtrack");
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (running) {
                    if (upLevel) {
                        long now = 999999999;
                        while (now > -999999998) {
                            now --;
                        }
                        now = 999999999;
                        while (now > -999999998) {
                            now --;
                        }
                        now = 999999999;
                        while (now > -999999998) {
                            now --;
                        }
                        upLevel = false;
                        authorView.setX(-1000);
                        authorView.setY(-2000);
                        authorView.setScaleX(0.5);
                        authorView.setScaleY(0.5);
                    }
                    if (level != 0) {
                        render();
                        update();
                    }
                }
                if (level == 0) {
                    upLevel = true;
                }
                if (upLevel) {
                    level ++;
                    Image img = new Image("level " + level + ".png");
                    authorView.setImage(img);
                    authorView.setX(-496);
                    authorView.setY(-208);
                    authorView.setScaleX(0.5);
                    authorView.setScaleY(0.5);
                    _board = new Board(level);
                    _board.createMap();
                    _board.player = new Bomber(1, 1, Sprite.player_right.getFxImage());
                }
                if (!running) {
                    running = true;
                    upLevel = true;
                    level = 0;
                }
            }
        };
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
        _board.portal.update();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        _board.stillEntity.forEach(g -> g.render(gc));
        _board.portal.render(gc);
        _board.items.forEach(g -> g.render(gc));
        _board.bombs.forEach(g -> g.render(gc));
        _board.enemys.forEach(g -> g.render(gc));
        _board.gach.forEach(g -> g.render(gc));
        if (_board.player!= null) {
            _board.player.render(gc);
        }
    }
}
