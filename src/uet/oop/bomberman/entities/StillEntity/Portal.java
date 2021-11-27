package uet.oop.bomberman.entities.StillEntity;

import javafx.scene.image.Image;

/**
 * Portal là đối tượng được giấu phía sau một đối tượng Brick.
 * Khi Brick đó bị phá hủy, Portal sẽ hiện ra và nếu tất cả Enemy đã bị tiêu diệt thì
   người chơi có thể qua Level khác bằng cách di chuyển vào vị trí của Portal.
 */

public class Portal extends StillEntity{
    public Portal(int x, int y, Image img) {
        super(x, y, img);
    }

    public Portal() {
        super();
    }

    @Override
    public void update() {

    }
}
