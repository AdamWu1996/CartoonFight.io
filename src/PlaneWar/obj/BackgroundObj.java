package PlaneWar.obj;

import PlaneWar.GameWin;

import java.awt.*;

public class BackgroundObj extends GameObj {
    public BackgroundObj() {
        super();
    }

    public BackgroundObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public BackgroundObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics graphics) {
        super.paintSelf(graphics);
        //不斷移動
        y += speed;

        if (y >= -1200) {
            y = -2000;
        }
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }
}
