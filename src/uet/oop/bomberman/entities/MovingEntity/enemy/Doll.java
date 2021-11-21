package uet.oop.bomberman.entities.MovingEntity.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public class Doll extends Enemy {

    public Doll(double x, double y, Image img) {
        super( x, y, img);
    }

    public Doll() {
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
    protected void chooseSprite() {

    }

    @Override
    public void update() {

    }
}
