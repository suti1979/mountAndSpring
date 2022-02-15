import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.event.*;

public class WindowApp extends JFrame implements KeyListener {

    private WindowPanel panel;
    private int worldsSize;

    WindowApp(ArrayList<StoreWorlds> worlds) {
        worldsSize = worlds.size();
        panel = new WindowPanel(worlds);
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        pack();
        setTitle("Flood world, USE ARROW KEYS ;) - Case : 0");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39 && panel.w < worldsSize - 1) {
            panel.w += 1;
            panel.repaint();
            setTitle("Flood world, USE ARROW KEYS ;) - Case : " + panel.w);
        }

        if (e.getKeyCode() == 37 && panel.w > 0) {
            panel.w -= 1;
            panel.repaint();
            setTitle("Flood world, USE ARROW KEYS ;) - Case : " + panel.w);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
