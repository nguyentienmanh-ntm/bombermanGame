package uet.oop.bomberman.entities.StillEntity.item;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static uet.oop.bomberman.Board.bombs;
import static uet.oop.bomberman.Board.player;
import uet.oop.bomberman.entities.StillEntity.StillEntity;

/**
 * Các Item cũng được giấu phía sau Brick và chỉ hiện ra khi Brick bị phá hủy.
 * Bomber có thể sử dụng Item bằng cách di chuyển vào vị trí của Item.
 */

public abstract class Item extends StillEntity {
    public Item(double x, double y, Image img) {
        super(x, y, img);
    }

    public Item() {
        super();
    }

    @Override
    public void update() {
        if (getX() - 22 < player.getX() && player.getX() < getX() + 32) {
            if (getY() - 32 < player.getY() && player.getY() < getY() + 32) {
                upLevel();
                remove();
            }
        }
    }

    public void upLevel() {

    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
}
