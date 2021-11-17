package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;
    protected int _width = 31, _height = 13; // default values just for testing
    private static char[][] _map;
    protected int _level;
    
    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * _width, Sprite.SCALED_SIZE * _height);
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
                update();
            }
        };
        timer.start();

        createMap();

        //Entity bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        //entities.add(bomberman);
    }

    public void createMap() {
        List<String> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/bombermanGame/res/levels/Level1update.txt");
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] arrays = list.get(0).trim().split(" ");
        _level = Integer.parseInt(arrays[0]);
        _height = Integer.parseInt(arrays[1]);
        _width = Integer.parseInt(arrays[2]);
        _map = new char[_height][_width];
        for (int i = 0; i < _height; i++) {
            for (int j = 0; j < _width; j++) {
                _map[i][j] = list.get(i + 1).charAt(j);
            }
        }

        for (int y = 0; y < _height; y++) {
            for (int x = 0; x < _width; x++) {
                int pos = x + y * _width;
                char c = _map[y][x];
                Entity object;
                switch (c) {
                    // Thêm grass
                    case ' ':
                        object = new Grass(x, y, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        //_board.addEntity(pos, new Grass(x, y, Sprite.grass));
                        break;
                    // Thêm Wall
                    case '#':
                        object = new Wall(x, y, Sprite.wall.getFxImage());
                        stillObjects.add(object);
                        //_board.addEntity(pos, new Wall(x, y, Sprite.wall));
                        break;
                    // Thêm Portal
                    case 'x':
                        /**_board.addEntity(pos, new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new Portal(x, y, _board, Sprite.portal),
                         new Brick(x, y, Sprite.brick)));*/
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        object = new Brick(x, y, Sprite.brick.getFxImage());
                        entities.add(object);
                        break;
                    // Thêm brick
                    case '*':
                        /**_board.addEntity(x + y * _width,
                         new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new Brick(x, y, Sprite.brick)
                         )
                         );*/
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        entities.add(new Brick(x, y, Sprite.brick.getFxImage()));
                        break;
                    // Thêm Bomber
                    case 'p':
                        /**_board.addCharacter(new Bomber(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                         Screen.setOffset(0, 0);
                         _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));*/
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        entities.add(new Bomber(x, y, Sprite.bomb.getFxImage()));
                        break;

                    // Thêm balloon
                    case '1':
                        /**_board.addCharacter(new Balloon(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                         _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));*/
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        entities.add(new Balloon(x, y, Sprite.balloom_right1.getFxImage()));
                        break;
                    // Thêm oneal
                    case '2':
                        /**_board.addCharacter(new Oneal(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                         _board.addEntity(pos, new Grass(x, y, Sprite.grass));*/
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        entities.add(new Oneal(x, y, Sprite.oneal_right1.getFxImage()));
                        break;
                    // Thêm doll
                    case '3':
                        /**_board.addCharacter(new Doll(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                         _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));*/
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        entities.add(new Doll(x, y, Sprite.doll_right1.getFxImage()));
                        break;
                    // Thêm oneal
                    // Thêm BomItem
                    case 'b':
                        /**LayeredEntity layer = new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new BombItem(x, y, Sprite.powerup_bombs),
                         new Brick(x, y, Sprite.brick));
                         _board.addEntity(pos, layer);*/
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        entities.add(new Brick(x, y, Sprite.brick.getFxImage()));
                        break;
                    // Thêm SpeedItem
                    case 's':
                        /**layer = new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new SpeedItem(x, y, Sprite.powerup_speed),
                         new Brick(x, y, Sprite.brick));
                         _board.addEntity(pos, layer);*/
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        entities.add(new Brick(x, y, Sprite.brick.getFxImage()));
                        break;
                    // Thêm FlameItem
                    case 'f':
                        /** layer = new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new FlameItem(x, y, Sprite.powerup_flames),
                         new Brick(x, y, Sprite.brick));
                         _board.addEntity(pos, layer);*/
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        entities.add(new Brick(x, y, Sprite.brick.getFxImage()));
                        break;

                    default:
                        stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        //_board.addEntity(pos, new Grass(x, y, Sprite.grass));
                        break;

                }
            }

            /** for (int i = 0; i < WIDTH; i++) {
             for (int j = 0; j < HEIGHT; j++) {
             Entity object;
             if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
             object = new Wall(i, j, Sprite.wall.getFxImage());
             }
             else {
             object = new Grass(i, j, Sprite.grass.getFxImage());
             }
             stillObjects.add(object);
             }
             }*/
        }
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
<<<<<<< HEAD
=======
    //manhdep trai 12345
>>>>>>> origin
}
