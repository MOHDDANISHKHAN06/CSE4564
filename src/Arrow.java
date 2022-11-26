
import javax.swing.*;

public interface Arrow {
    public JPanel drawLine(int x1, int y1, int x2, int y2);
    public int getBoundH();
    public int getBoundX();
    public int getBoundW();
    public int getBoundY();
}
