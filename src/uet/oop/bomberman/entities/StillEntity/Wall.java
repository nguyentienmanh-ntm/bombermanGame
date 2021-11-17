package uet.oop.bomberman.entities.StillEntity;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

/**
 * Wall là đối tượng cố định, không thể phá hủy bằng Bomb cũng như không thể đặt Bomb lên được,
   Bomber và Enemy không thể di chuyển vào đối tượng này.
 */

public class Wall extends StillEntity {

    public Wall(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {

    }
}