package uet.oop.bomberman.entities.MovingEntity.bomber;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.Board.getAt;

/**
 * Bomber là nhân vật chính của trò chơi.
 * Bomber có thể di chuyển theo 4 hướng trái/phải/lên/xuống theo sự điều khiển của người chơi.
 */

public class Bomber extends MovingEntity {

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public Bomber() {
        super();
    }

    @Override
    protected void calculateMove() {

    }

    @Override
    protected void move(int _direction) {

    }

    @Override
    public void kill() {

    }

    @Override
    protected void afterKill() {

    }

    // _direction = 0: left;
    // _direction = 1: up;
    // _direction = 2: right;
    // _direction = 3: down;
    @Override
    public boolean canMove(int _direction) {
        _moving = true;
        this._direction = _direction;
        if (_direction == 0) {
            Entity e = getAt(this.getX() - 4, this.getY());
            if (e != null) {
                return (e.getImg().equals(Sprite.brick.getFxImage()) || e.getImg().equals(Sprite.wall.getFxImage()) ||
                        e.getImg().equals(Sprite.bomb.getFxImage()));
            } else {
                System.out.println(this.getX() - 4);
                System.out.println(this.getY());
                return true;
            }
        }
        if (_direction == 1) {
            Entity e = getAt(this.getX(), this.getY() - 4);
            if (e != null) {
                return (e.getImg().equals(Sprite.brick.getFxImage()) || e.getImg().equals(Sprite.wall.getFxImage()) ||
                        e.getImg().equals(Sprite.bomb.getFxImage()));
            } else {
                System.out.println(this.getX());
                System.out.println(this.getY() - 4);
                return true;
            }
        }
        if (_direction == 2) {
            Entity e = getAt(this.getX() + 20, this.getY());
            if (e != null) {
                return (e.getImg().equals(Sprite.brick.getFxImage()) || e.getImg().equals(Sprite.wall.getFxImage()) ||
                        e.getImg().equals(Sprite.bomb.getFxImage()));
            } else {
                System.out.println(this.getX() + 4);
                System.out.println(this.getY());
                return true;
            }
        }
        if (_direction == 3) {
            Entity e = getAt(this.getX(), this.getY() + 32);
            if (e != null) {
                return (e.getImg().equals(Sprite.brick.getFxImage()) || e.getImg().equals(Sprite.wall.getFxImage()) ||
                        e.getImg().equals(Sprite.bomb.getFxImage()));
            } else {
                System.out.println(this.getX());
                System.out.println(this.getY() + 4);
                return true;
            }
        }
        return false;
    }

    //sprite
    private void chooseSprite() {
        switch (_direction) {
            case 1:
                _sprite = Sprite.player_up;
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
                }
                break;
            case 2:
                _sprite = Sprite.player_right;
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, _animate, 20);
                }
                break;
            case 3:
                _sprite = Sprite.player_down;
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, _animate, 20);
                }
                break;
            case 0:
                _sprite = Sprite.player_left;
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, _animate, 20);
                }
                break;
            default:
                _sprite = Sprite.player_right;
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, _animate, 20);
                }
                break;
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        //if (_alive)
            chooseSprite();
        //else
          //  _sprite = Sprite.player_dead1;
        gc.drawImage(_sprite.getFxImage(), getX(), getY());
    }

    @Override
    public void update() {
        animate();
    }
}
