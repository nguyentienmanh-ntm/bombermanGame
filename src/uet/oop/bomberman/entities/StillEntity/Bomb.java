package uet.oop.bomberman.entities.StillEntity;

import javafx.scene.image.Image;

/**
 * Bomb là đối tượng mà Bomber sẽ đặt và kích hoạt tại các ô Grass. Khi đã được kích hoạt, Bomber và Enemy không thể di chuyển vào vị trí Bomb.
 * Tuy nhiên ngay khi Bomber vừa đặt và kích hoạt Bomb tại ví trí của mình, Bomber có một lần được đi từ vị trí đặt Bomb ra vị trí bên cạnh.
 * Sau khi kích hoạt 2s, Bomb sẽ tự nổ, các đối tượng Flame được tạo ra.
 */

public class Bomb extends StillEntity {
    public Bomb(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setImg(Image img) {
        super.setImg(img);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void update() {

    }
}
