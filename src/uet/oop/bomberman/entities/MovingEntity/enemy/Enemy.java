package uet.oop.bomberman.entities.MovingEntity.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;

/**
 * Enemy là các đối tượng mà Bomber phải tiêu diệt hết để có thể qua Level.
 * Enemy có thể di chuyển ngẫu nhiên hoặc tự đuổi theo Bomber tùy theo loại Enemy.
 */

public abstract class Enemy extends MovingEntity {
    public Enemy(int x, int y, Image img) {
        super( x, y, img);
    }

    public Enemy() {
        super();
    }

    @Override
    public void update() {

    }


}
