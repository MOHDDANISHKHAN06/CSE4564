import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class JustLine extends JPanel implements Arrow {

  int x1;
  int y1;
  int x2;
  int y2;
  int boundX;
  int boundY;
  int boundW;
  int boundH;

  public int getBoundX() {
    return boundX;
  }

  public int getBoundY() {
    return boundY;
  }

  public int getBoundW() {
    return boundW;
  }

  public int getBoundH() {
    return boundH;
  }

  public JustLine(int boundX, int boundY, int boundW, int boundH) {
    setLayout(null);
    System.out.println("ME HRER");
    this.boundX = boundX;
    this.boundY = boundY;
    this.boundW = boundW;
    this.boundH = boundH;
    setBounds(boundX, boundY, boundW-20, boundH-20);
  }

  @Override
  public JPanel drawLine(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.x1 = 0;
    this.x2 = 20;
    this.y1 = 0;
    this.y2 = 20;
    return this;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    setBackground(Color.GRAY);
    g.setColor(Color.BLACK);
    System.out.println("BOIDU");
    g.drawLine(x1, y1, x2, y2);
  }

}
