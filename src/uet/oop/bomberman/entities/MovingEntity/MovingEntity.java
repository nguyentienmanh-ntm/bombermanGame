package uet.oop.bomberman.entities.MovingEntity;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public abstract class MovingEntity extends Entity {
    public MovingEntity(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void setImg(Image img) {
        super.setImg(img);
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void update() {

    }
}
