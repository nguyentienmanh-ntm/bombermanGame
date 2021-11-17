package uet.oop.bomberman.entities.StillEntity;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.entities.Entity;

/**
 * Brick là đối tượng được đặt lên các ô Grass, không cho phép đặt Bomb lên nhưng có thể bị phá hủy bởi Bomb được đặt gần đó.
 * Bomber và Enemy thông thường không thể di chuyển vào vị trí Brick khi nó chưa bị phá hủy.
 */
public class Brick extends StillEntity {

    public Brick(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

    }
}
