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
    public void kill() {

    }

    @Override
    protected void afterKill() {

    }

    public Balloom(int x, int y) {
        super(x, y, Sprite.balloom_dead, 0.5, 100);

        _sprite = Sprite.balloom_left1;

        _ai = new AILow();
        _direction = _ai.calculateDirection();

    }

    @Override
    protected void chooseSprite() {
        switch(_direction) {
            case 0:
            case 1:
                _sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60);
                break;
            case 2:
            case 3:
                _sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, _animate, 60);
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
}
