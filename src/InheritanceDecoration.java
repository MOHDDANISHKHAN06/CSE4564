import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Color;

public class InheritanceDecoration extends JustLineDecorator {

    int[] ix = new int[3];
    int[] iy = new int[3];
    int boundX;
    int boundY;
    int boundW;
    int boundH;

    public InheritanceDecoration(Arrow arrow) {
        super(arrow);
        setLayout(null);
        setBounds(arrow.getBoundX(), arrow.getBoundY(), arrow.getBoundW()+20, arrow.getBoundH()+20);
    }

    @Override
    public JPanel drawLine(int x1, int y1, int x2, int y2) {
        this.add(super.drawLine(x1, y1, x2, y2));
        ix[0] = x2 + 10;
        iy[0] = y2;
        ix[1] = x2;
        iy[1] = y2 + 10;
        ix[2] = x2;
        iy[2] = y2 - 10;
        return this;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // setBackground(Color.CYAN);
        setForeground(Color.BLACK);
        g.drawPolygon(ix, iy, 3);
    }

}
