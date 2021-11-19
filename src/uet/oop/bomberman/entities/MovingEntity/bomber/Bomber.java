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
            Entity e1 = getAt(this.getX() - 4, this.getY());
            Entity e2 = getAt(this.getX() - 4, this.getY() + 28);
            if (e1 != null && e2 != null) {
                return false;
            } else if (e1 != null) {
                return (e1.getImg().equals(Sprite.brick.getFxImage()) || e1.getImg().equals(Sprite.wall.getFxImage()) ||
                        e1.getImg().equals(Sprite.bomb.getFxImage()));
            } else if (e2 != null) {
                return (e2.getImg().equals(Sprite.brick.getFxImage()) ||
                        e2.getImg().equals(Sprite.wall.getFxImage()) || e2.getImg().equals(Sprite.bomb.getFxImage()));
            } else {
                return true;
            }
        }
        if (_direction == 1) {
            Entity e1 = getAt(this.getX(), this.getY() - 4);
            Entity e2 = getAt(this.getX() + 20, this.getY() - 4);
            if (e1 != null && e2 != null) {
                return false;
            } else if (e1 != null) {
                return (e1.getImg().equals(Sprite.brick.getFxImage()) || e1.getImg().equals(Sprite.wall.getFxImage()) ||
                        e1.getImg().equals(Sprite.bomb.getFxImage()));
            } else if (e2 != null) {
                return (e2.getImg().equals(Sprite.brick.getFxImage()) ||
                        e2.getImg().equals(Sprite.wall.getFxImage()) || e2.getImg().equals(Sprite.bomb.getFxImage()));
            } else {
                return true;
            }
        }
        if (_direction == 2) {
            Entity e1 = getAt(this.getX() + 20, this.getY());
            Entity e2 = getAt(this.getX() + 20, this.getY() + 28);
            if (e1 != null && e2 != null) {
                return false;
            } else if (e1 != null) {
                return (e1.getImg().equals(Sprite.brick.getFxImage()) || e1.getImg().equals(Sprite.wall.getFxImage()) ||
                        e1.getImg().equals(Sprite.bomb.getFxImage()));
            } else if (e2 != null) {
                return (e2.getImg().equals(Sprite.brick.getFxImage()) ||
                        e2.getImg().equals(Sprite.wall.getFxImage()) || e2.getImg().equals(Sprite.bomb.getFxImage()));
            } else {
                return true;
            }
        }
        if (_direction == 3) {
            Entity e1 = getAt(this.getX(), this.getY() + 32);
            Entity e2 = getAt(this.getX() + 20, this.getY() + 32);
            if (e1 != null && e2 != null) {
                return false;
            } else if (e1 != null) {
                return (e1.getImg().equals(Sprite.brick.getFxImage()) || e1.getImg().equals(Sprite.wall.getFxImage()) ||
                        e1.getImg().equals(Sprite.bomb.getFxImage()));
            } else if (e2 != null) {
                return (e2.getImg().equals(Sprite.brick.getFxImage()) ||
                        e2.getImg().equals(Sprite.wall.getFxImage()) || e2.getImg().equals(Sprite.bomb.getFxImage()));
            } else {
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
        if (_alive)
            chooseSprite();
        else
            _sprite = Sprite.player_dead1;
        gc.drawImage(_sprite.getFxImage(), x, y);
    }

    @Override
    public void update() {
        animate();
    }
}
