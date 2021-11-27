package uet.oop.bomberman.entities.StillEntity.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.MovingEntity.bomber.Bomber;

import static uet.oop.bomberman.Board.addBombRadius;

/**
 * Item này giúp tăng phạm vi ảnh hưởng của Bomb khi nổ (độ dài các Flame lớn hơn)
 */

public class FlameItem extends Item{
    public FlameItem(double x, double y, Image img) {
        super( x, y, img);
    }

    public FlameItem() {
        super();
    }

    @Override
    public boolean collide(Entity e) {
        // TODO: xử lý Bomber ăn
        if (e instanceof Bomber) {

            //Sound.play("Item");
            addBombRadius(1);
            remove();
        }
        return false;
    }

    @Override
    public void upLevel() {
        addBombRadius(1);
    }

}
