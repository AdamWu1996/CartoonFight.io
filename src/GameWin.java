import Utils.GameUtils;

import javax.swing.*;
import java.awt.*;

public class GameWin extends JFrame {
    public void launch() {
        //設定視窗是否可見
        setVisible(true);
        //設置窗口大小
        setSize(800, 600);
        //設定窗口位置
        setLocationRelativeTo(null);
        //標題
        setTitle("打飛機");
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(GameUtils.bgImg, 0, 0, null);
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
