package uet.oop.bomberman.entities.MovingEntity.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public class Doll extends Enemy {

    public Doll(int x, int y, Image img) {
        super( x, y, img);
    }

    public Doll() {
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
