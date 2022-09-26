package PlaneWar;

import PlaneWar.Utils.GameUtils;
import PlaneWar.obj.BackgroundObj;
import PlaneWar.obj.PlaneObj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    //0未開始 1遊戲中 2暫停 3通關失敗 4通關成功
    static int state = 0;
    private int width = 600;
    private int height = 600;

    //背景
    BackgroundObj bgObj = new BackgroundObj(GameUtils.bgImg, 0, -2000, 2);
    //玩家飛機
    PlaneObj planeObj = new PlaneObj(GameUtils.planeImg, 290, 550, 20, 30, 0, this);
    //避免起始畫面閃爍
    Image offScreenImage = null;

    public void launch() {
        //設定視窗是否可見
        setVisible(true);
        //設置窗口大小
        setSize(width, height);
        //設定窗口位置
        setLocationRelativeTo(null);
        //標題
        setTitle("plane war");

        //Component(Object) 的 synchronized method
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1 && state == 0) {
                    state = 1;
                    repaint();
                }
            }
        });

        while (true) {
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            //建立未開始時的背景圖片 (off-screen)
            offScreenImage = createImage(width, height);
        }
        //(off-screen)
        //取得 Image 的工具箱 graphics (https://stackoverflow.com/questions/31892451/java-graphics2d-for-offscreen-rendering)
        Graphics offScreenGraphic = offScreenImage.getGraphics();
        //在 offScreenImage 畫出一個矩形
        offScreenGraphic.fillRect(0, 0, width, height);

        if (state == 0) {
            offScreenGraphic.drawImage(GameUtils.bgImg, 0, 0, null);
            offScreenGraphic.drawImage(GameUtils.bossImg, 220, 120, null);
            offScreenGraphic.drawImage(GameUtils.explodeImg, 270, 350, null);
            offScreenGraphic.setColor(Color.yellow);
            offScreenGraphic.setFont(new Font("TimesRoman", Font.BOLD, 40));
            offScreenGraphic.drawString("Click to start", 180, 300);
        }

        if (state == 1) {
            bgObj.paintSelf(offScreenGraphic);
            planeObj.paintSelf(offScreenGraphic);
        }

        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
