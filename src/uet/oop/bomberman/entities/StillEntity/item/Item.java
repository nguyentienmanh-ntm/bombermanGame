package uet.oop.bomberman.entities.StillEntity.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.StillEntity.StillEntity;

/**
 * Các Item cũng được giấu phía sau Brick và chỉ hiện ra khi Brick bị phá hủy.
 * Bomber có thể sử dụng Item bằng cách di chuyển vào vị trí của Item.
 */

public abstract class Item extends StillEntity {
    public Item(int x, int y, Image img) {
        super( x, y, img);
    }

    public Item() {
        super();
    }

    @Override
    public void update() {

    }
}
