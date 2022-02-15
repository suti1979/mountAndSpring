import javax.swing.JPanel;
import java.awt.*; //for Graphics class
import java.util.ArrayList;


public class WindowPanel extends JPanel {

    private int size; 
    private int X;
    private int Y;
    private int elevation;
    private Font font;
    private int fontsize;
    private ArrayList<StoreWorlds> worlds;
    
    public int w = 0;
    
    WindowPanel(ArrayList<StoreWorlds> worlds) {
        this.size = worlds.get(0).array[0].length;
        this.worlds = worlds;
        setPreferredSize(new Dimension(size * 100, size * 100));       
    }

    public void paint(Graphics g) {

        X = getWidth() / size;
        Y = getHeight() / size;

        fontsize = X / size;
        font = new Font("Serif", Font.BOLD, fontsize);
        g.setFont(font);

        
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    elevation = worlds.get(w).array[i][j];
                    if (elevation > 0) {
                        g.setColor(new Color(0, 100 + (10 * elevation), 0));
                        g.fillRect(X * i, Y * j, X, Y);
                        g.setColor(Color.WHITE);
                        g.drawString(String.valueOf(elevation), (X * i + X * (i + 1)) / 2 - fontsize / 3,
                                (Y * j + Y * (j + 1)) / 2 + fontsize / 3);
                    } else {
                        g.setColor(new Color(0, 100 + (10 * elevation), 255));
                        g.fillRect(X * i, Y * j, X, Y);
                        g.setColor(Color.WHITE);
                        g.drawString(String.valueOf(elevation), (X * i + X * (i + 1)) / 2
                                - fontsize / 2, (Y * j + Y * (j + 1)) / 2 + fontsize / 2);
                    }
                } // j
            } // i
    } // paint 
}
