package uet.oop.bomberman.entities.MovingEntity.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;
import uet.oop.bomberman.entities.MovingEntity.enemy.ai.AILow;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Balloom là Enemy đơn giản nhất, di chuyển ngẫu nhiên với vận tốc cố định.
 */

public class Balloom extends Enemy {

    public Balloom(double x, double y, Image img) {
        super(x, y, img);
    }

    public Balloom() {
        super();
    }

    @Override
    protected void calculateMove() {
        // TODO: Tính toán hướng đi và di chuyển Enemy theo _ai và cập nhật giá trị cho _direction
        // TODO: sử dụng canMove() để kiểm tra xem có thể di chuyển tới điểm đã tính toán hay không
        // TODO: sử dụng move() để di chuyển
        // TODO: nhớ cập nhật lại giá trị cờ _moving khi thay đổi trạng thái di chuyển
        int xa = 0, ya = 0;
        if(_steps <= 0){
            _direction = _ai.calculateDirection();
            _steps = MAX_STEPS;
        }

        if(_direction == 0) ya--;
        if(_direction == 2) ya++;
        if(_direction == 3) xa--;
        if(_direction == 1) xa++;

        if(canMove(xa, ya)) {
            _steps -= 1 + rest;
            move(xa * _speed, ya * _speed);
            _moving = true;
        } else {
            _steps = 0;
            _moving = false;
        }
    }

    public Balloom(int x, int y) {
        super(x, y, Sprite.balloom_dead, 0.8, 100);

        _sprite = Sprite.balloom_left1;

        _ai = new AILow();
        _direction = _ai.calculateDirection();
    }

    @Override
    protected void chooseSprite() {
        switch(_direction) {
            case 0:
            case 1:
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60);
                } else {
                    _sprite = Sprite.balloom_left1;
                }
                break;
            case 2:
            case 3:
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, _animate, 60);
                } else {
                    _sprite = Sprite.balloom_left1;
                }
                break;
        }
    }
}
