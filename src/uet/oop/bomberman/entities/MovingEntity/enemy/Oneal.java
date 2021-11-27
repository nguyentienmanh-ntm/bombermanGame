package uet.oop.bomberman.entities.MovingEntity.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.MovingEntity.enemy.ai.AILow;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Oneal có tốc độ di chuyển thay đổi, lúc nhanh, lúc chậm và di chuyển "thông minh" hơn so với Balloom (biết đuổi theo Bomber).
 */

public class Oneal extends Enemy {

    public Oneal(double x, double y, Image img) {
        super(x, y, img);
    }

    public Oneal() {
        super();
    }

    public Oneal(int x, int y) {
        super(x, y, Sprite.oneal_dead, 1, 100);

        _sprite = Sprite.oneal_left1;

        _ai = new AILow();
        _direction = _ai.calculateDirection();

    }

    @Override
    protected void chooseSprite() {
        switch(_direction) {
            case 0:
            case 1:
                _sprite = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, _animate, 60);
                break;
            case 2:
            case 3:
                _sprite = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, _animate, 60);
                break;
        }
    }
}
