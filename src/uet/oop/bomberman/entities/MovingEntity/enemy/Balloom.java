package uet.oop.bomberman.entities.MovingEntity.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;

/**
 * Balloom là Enemy đơn giản nhất, di chuyển ngẫu nhiên với vận tốc cố định.
 */

public class Balloom extends Enemy {

    public Balloom(int x, int y, Image img) {
        super( x, y, img);
    }

    public Balloom() {
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

    @Override
    public boolean canMove(int _direction) {
        return false;
    }

    @Override
    public void update() {

    }
}
