package uet.oop.bomberman;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;
import uet.oop.bomberman.entities.MovingEntity.enemy.Balloom;
import uet.oop.bomberman.entities.MovingEntity.enemy.Doll;
import uet.oop.bomberman.entities.MovingEntity.enemy.Enemy;
import uet.oop.bomberman.entities.MovingEntity.enemy.Oneal;
import uet.oop.bomberman.entities.StillEntity.*;
import uet.oop.bomberman.entities.StillEntity.bomb.Bomb;
import uet.oop.bomberman.entities.StillEntity.item.BombItem;
import uet.oop.bomberman.entities.StillEntity.item.FlameItem;
import uet.oop.bomberman.entities.StillEntity.item.Item;
import uet.oop.bomberman.entities.StillEntity.item.SpeedItem;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Board {
    //public static boolean running;
    //protected static int speed = 4;
    //public static final int WIDTH = 20;
    //public static final int HEIGHT = 15;
    protected static int _width = 31, _height = 13; // default values just for testing
    private static char[][] _map;
    protected static int _level;

    //public Entity[] _entities;
    public static List<Enemy> enemys = new ArrayList<>();
    public static List<StillEntity> stillEntity = new ArrayList<>();
    public static List<StillEntity> gach = new ArrayList<>();
    public static List<Bomb> bombs = new ArrayList<>();
    public static List<Item> items = new ArrayList<>();
    public static MovingEntity player;

    private static final int BOMBRATE = 1;
    private static final int BOMBRADIUS = 1;
    protected static int bombRate = BOMBRATE;
    protected static int bombRadius = BOMBRADIUS;

    public static int getBombRate() {
        return bombRate;
    }

    public static int getBombRadius() {
        return bombRadius;
    }

    public static void addBombRadius(int i) {
        bombRadius += i;
    }

    public static void addBombRate(int i) {
        bombRate += i;
    }

    public static void setBombRate(int bombRate) {
        Board.bombRate = bombRate;
    }

    public static void setBombRadius(int bombRadius) {
        Board.bombRadius = bombRadius;
    }

    public static void update() {

    }

    public static void createMap() {
        List<String> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("res/levels/Level3update.txt");
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
                //int pos = x + y * _width;
                char c = _map[y][x];
                switch (c) {
                    // Thêm grass
                    case ' ':
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        //_board.addEntity(pos, new Grass(x, y, Sprite.grass));
                        break;
                    // Thêm Wall
                    case '#':
                        gach.add(new Wall(x, y, Sprite.wall.getFxImage()));
                        //_board.addEntity(pos, new Wall(x, y, Sprite.wall));
                        break;
                    // Thêm Portal
                    case 'x':
                        /**_board.addEntity(pos, new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new Portal(x, y, _board, Sprite.portal),
                         new Brick(x, y, Sprite.brick)));*/
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        gach.add(new Brick(x, y));
                        break;
                    // Thêm brick
                    case '*':
                        /**_board.addEntity(x + y * _width,
                         new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new Brick(x, y, Sprite.brick)
                         )
                         );*/
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        gach.add(new Brick(x, y));
                        break;
                    // Thêm Bomber
                    case 'p':
                        /**_board.addCharacter(new Bomber(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                         Screen.setOffset(0, 0);
                         _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));*/
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        //enemys.add(new Brick(x, y, Sprite.player_right.getFxImage()));
                        break;

                    // Thêm balloon
                    case '1':
                        /**_board.addCharacter(new Balloon(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                         _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));*/
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        enemys.add(new Balloom(x, y));
                        break;
                    // Thêm oneal
                    case '2':
                        /**_board.addCharacter(new Oneal(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                         _board.addEntity(pos, new Grass(x, y, Sprite.grass));*/
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        enemys.add(new Oneal(x, y));
                        break;
                    // Thêm doll
                    case '3':
                        /**_board.addCharacter(new Doll(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                         _board.addEntity(x + y * _width, new Grass(x, y, Sprite.grass));*/
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        enemys.add(new Doll(x, y, Sprite.doll_right1.getFxImage()));
                        break;
                    // Thêm oneal
                    // Thêm BomItem
                    case 'b':
                        /**LayeredEntity layer = new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new BombItem(x, y, Sprite.powerup_bombs),
                         new Brick(x, y, Sprite.brick));
                         _board.addEntity(pos, layer);*/
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        gach.add(new Brick(x, y));
                        items.add(new BombItem(x, y, Sprite.powerup_bombs.getFxImage()));
                        break;
                    // Thêm SpeedItem
                    case 's':
                        /** layer = new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new SpeedItem(x, y, Sprite.powerup_speed),
                         new Brick(x, y, Sprite.brick));
                         _board.addEntity(pos, layer);
                         */
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        gach.add(new Brick(x, y));
                        items.add(new SpeedItem(x, y, Sprite.powerup_speed.getFxImage()));
                        break;
                    // Thêm FlameItem
                    case 'f':
                        /** layer = new LayeredEntity(x, y,
                         new Grass(x, y, Sprite.grass),
                         new FlameItem(x, y, Sprite.powerup_flames),
                         new Brick(x, y, Sprite.brick));
                         _board.addEntity(pos, layer);
                         */
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        gach.add(new Brick(x, y));
                        items.add(new FlameItem(x, y, Sprite.powerup_flames.getFxImage()));
                        break;
                    default:
                        stillEntity.add(new Grass(x, y, Sprite.grass.getFxImage()));
                        //_board.addEntity(pos, new Grass(x, y, Sprite.grass));
                        break;
                }
            }
        }
    }

    public static void render() {

    }

    public static Entity getGachAt(double x, double y) {
        for (Entity element : gach) {
            int X = (int) element.getX();
            int Y = (int) element.getY();
            int _X = (int) x;
            int _Y = (int) y;
            if (X / 32 == _X / 32) {
                if (Y / 32 == _Y / 32) {
                    return element;
                }
            }
        }
        return null;
    }

    public static Entity getBombAt(double x, double y) {
        for (Entity element : bombs) {
            int X = (int) element.getX();
            int Y = (int) element.getY();
            int _X = (int) x;
            int _Y = (int) y;
            if (X / 32 == _X / 32) {
                if (Y / 32 == _Y / 32) {
                    return element;
                }
            }
        }
        return null;
    }

    public static Entity getEnemyAt(double x, double y) {
        for (Entity element : enemys) {
            int X = (int) element.getX();
            int Y = (int) element.getY();
            int _X = (int) x;
            int _Y = (int) y;
            if (X / 32 == _X / 32) {
                if (Y / 32 == _Y / 32) {
                    return element;
                }
            }
        }
        return null;
    }

    public static void updateBrick() {
        Iterator<StillEntity> br = gach.iterator();
        StillEntity b;
        while (br.hasNext()) {
            b = br.next();
            for (Bomb ele : bombs) {
                Entity e1 = ele.flameAt(b.getX() / 32, b.getY() / 32);
                if (b instanceof Brick) {
                    b.collide(e1);
                }
            }
            if (b.isRemoved()) {
                br.remove();
            }
        }

    }

    public static void updateEnemys() {
        enemys.removeIf(MovingEntity::isRemoved);
    }

    public static void updateItems() {
        items.removeIf(StillEntity::isRemoved);
    }
}
