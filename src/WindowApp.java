import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.event.*;

public class WindowApp extends JFrame implements KeyListener {

    private WindowPanel panel;
    private int worldsSize;

    WindowApp(ArrayList<int[][]> worlds) {
        worldsSize = worlds.size();
        panel = new WindowPanel(worlds);
        addKeyListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(panel);
        pack();
        setTitle("Flood world, USE ARROW KEYS ;) - Case : 0");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39 && panel.page < worldsSize - 1) {
            panel.page += 1;
            panel.repaint();
            setTitle("Flood world, USE ARROW KEYS ;) - Case : " + panel.page);
        }

        if (e.getKeyCode() == 37 && panel.page > 0) {
            panel.page -= 1;
            panel.repaint();
            setTitle("Flood world, USE ARROW KEYS ;) - Case : " + panel.page);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // document why this method is empty
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // document why this method is empty
    }
}
