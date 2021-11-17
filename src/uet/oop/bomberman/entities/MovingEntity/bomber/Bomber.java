package uet.oop.bomberman.entities.MovingEntity.bomber;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;

/**
 * Bomber là nhân vật chính của trò chơi.
 * Bomber có thể di chuyển theo 4 hướng trái/phải/lên/xuống theo sự điều khiển của người chơi.
 */

public class Bomber extends MovingEntity {
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setImg(Image img) {
        super.setImg(img);
    }

    @Override
    public void update() {

    }
}
