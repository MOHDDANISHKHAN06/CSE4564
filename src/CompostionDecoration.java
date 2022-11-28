
import java.awt.Graphics;
public class CompostionDecoration extends JustLineDecorator {

    public CompostionDecoration(Arrow arrow) {
        super(arrow);
    }

    int[] ix = new int[3];
    int[] iy = new int[3];


    
    public void drawLine(int x1, int y1, int x2, int y2) {
        // RightPanel rp = RightPanel.getRightPanel();
        Graphics g = RightPanel.rightPanel.getGraphics();
        // this.add(super.drawLine(x1, y1, x2, y2));
        super.drawLine(x1, y1, x2, y2);
        ix[0] = x2 + 10;
        iy[0] = y2;
        ix[1] = x2;
        iy[1] = y2 + 10;
        ix[2] = x2;
        iy[2] = y2 - 10;
        g.drawPolygon(ix, iy, 3);
    }
}
