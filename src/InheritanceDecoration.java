import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Color;

public class InheritanceDecoration extends JustLineDecorator {

    int[] ix = new int[4];
    int[] iy = new int[4];

    public InheritanceDecoration(Arrow arrow) {
        super(arrow);
        setLayout(null);
        setSize(600, 500);
    }

    @Override
    public JPanel drawLine(int x1, int y1, int x2, int y2) {
        this.add(super.drawLine(x1, y1, x2, y2));
        System.out.println("NMSNS");
        ix[0] = ix[1] = ix[3] = x1;
        ix[2] = x1 + 10;
        iy[2] = iy[0] = y1 - 40;
        iy[1] = y1 - 30;
        iy[3] = y1 - 50;
        return this;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < 4; ++i) {
            System.out.println(ix[i] + " " + iy[i]);
        }
        setBackground(Color.CYAN);
        setForeground(Color.BLACK);
        g.drawPolygon(ix, iy, 4);
    }

}
