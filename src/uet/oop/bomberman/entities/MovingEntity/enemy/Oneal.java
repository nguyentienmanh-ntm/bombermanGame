package uet.oop.bomberman.entities.MovingEntity.enemy;

import javafx.scene.image.Image;

/**
 * Oneal có tốc độ di chuyển thay đổi, lúc nhanh, lúc chậm và di chuyển "thông minh" hơn so với Balloom (biết đuổi theo Bomber).
 */

public class Oneal extends Enemy {

    public Oneal(double x, double y, Image img) {
        super( x, y, img);
    }

    public Oneal() {
        super();
    }

    @Override
    protected void calculateMove() {

    }

    @Override
    public void move(double xa, double ya) {

    }

    @Override
    public void kill() {

    }

    @Override
    protected void afterKill() {

    }

    @Override
    public boolean canMove(double x, double y) {
        return false;
    }

    @Override
    public void update() {

    }
}
