package uet.oop.bomberman.entities.StillEntity;

import javafx.scene.image.Image;

/**
 * Các đối tượng Flame được tạo ra ngay sau khi Bomb nổ.
 */

public class Flame extends StillEntity{
    public Flame (int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

    }
}
