package uet.oop.bomberman.entities.StillEntity.item;

import javafx.scene.image.Image;

/**
 * Khi sử dụng Item này, Bomber sẽ được tăng vận tốc di chuyển thêm một giá trị thích hợp.
 */

public class SpeedItem extends Item{
    public SpeedItem(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

    }
}
