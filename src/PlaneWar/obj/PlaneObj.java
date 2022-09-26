package PlaneWar.obj;

import PlaneWar.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj {
    public PlaneObj() {
        super();
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                setX(e.getX() - 17);
                setY(e.getY() - 17);
            }
        });
    }

    @Override
    public void paintSelf(Graphics graphics) {
        super.paintSelf(graphics);
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }
}
