package uet.oop.bomberman.entities.MovingEntity.bomber;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.KeyBoard;
import static uet.oop.bomberman.BombermanGame.keyBoard;

import static uet.oop.bomberman.Board.getAt;

/**
 * Bomber là nhân vật chính của trò chơi.
 * Bomber có thể di chuyển theo 4 hướng trái/phải/lên/xuống theo sự điều khiển của người chơi.
 */

public class Bomber extends MovingEntity {

    //public KeyBoard _input;

    public Bomber(double x, double y, Image img) {
        super(x, y, img);
    }

    public Bomber() {
        super();
    }

    @Override
    protected void calculateMove() {
        // TODO: xử lý nhận tín hiệu điều khiển hướng đi từ _input và gọi move() để thực hiện di chuyển
        // TODO: nhớ cập nhật lại giá trị cờ _moving khi thay đổi trạng thái di chuyển
        double xa = 0, ya = 0;
        if(keyBoard.up) ya--;
        if(keyBoard.down) ya++;
        if(keyBoard.left) xa--;
        if(keyBoard.right) xa++;

        if(xa != 0 || ya != 0)  {
            move(xa * 2.5, ya * 2.5);
            _moving = true;
        } else {
            _moving = false;
        }
    }

    @Override
    public void move(double xa, double ya) {
        // TODO: sử dụng canMove() để kiểm tra xem có thể di chuyển tới điểm đã tính toán hay không và thực hiện thay đổi tọa độ _x, _y
        // TODO: nhớ cập nhật giá trị _direction sau khi di chuyển
        if(xa > 0) _direction = 1;
        if(xa < 0) _direction = 3;
        if(ya > 0) _direction = 2;
        if(ya < 0) _direction = 0;

        if(canMove(0, ya)) { //separate the moves for the player can slide when is colliding
            setY(getY() + ya);
        }

        if(canMove(xa, 0)) {
            setX(getX() + xa);
        }
    }

    @Override
    public void kill() {

    }

    @Override
    protected void afterKill() {

    }

    @Override
    public boolean canMove(double x, double y) {
        // TODO: kiểm tra có đối tượng tại vị trí chuẩn bị di chuyển đến và có thể di chuyển tới đó hay không
        for (int c = 0; c < 4; c++) { //colision detection for each corner of the player
            double xt = ((getX() + x) + c % 2 * 9) / 32; //divide with tiles size to pass to tile coordinate
            double yt = ((getY() + 32 + y) + c / 2 * 10 - 13) / 32; //these values are the best from multiple tests

            Entity a1 = getAt(xt * 32 + 12, yt * 32 - 16);
            Entity a2 = getAt(xt * 32 + 12, yt * 32);
            Entity a3 = getAt(xt * 32, yt * 32 - 16);
            Entity a4 = getAt(xt * 32, yt * 32);

            System.out.println("(" + xt * 32 + ", " + yt * 32 + ") - (" + getX() + ", " + getY() + ")" + ") - (" + x + ", " + y + ")");
            if(a1 != null || a2 != null || a3 != null || a4 != null) {
                return false;
            }
        }
        return true;
        //return false;
    }

    //sprite
    private void chooseSprite() {
        switch (_direction) {
            case 0:
                _sprite = Sprite.player_up;
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
                }
                break;
            case 2:
                _sprite = Sprite.player_down;
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, _animate, 20);
                }
                break;
            case 3:
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
        calculateMove();
    }
}
