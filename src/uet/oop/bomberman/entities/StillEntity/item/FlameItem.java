package uet.oop.bomberman.entities.StillEntity.item;

import javafx.scene.image.Image;

/**
 * Item này giúp tăng phạm vi ảnh hưởng của Bomb khi nổ (độ dài các Flame lớn hơn)
 */

public class FlameItem extends Item{
    public FlameItem(int x, int y, Image img) {
        super( x, y, img);
    }

    public FlameItem() {
        super();
    }

    @Override
    public void update() {

    }
}
