import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class JustLine extends JPanel implements Arrow {

  int x1;
  int y1;
  int x2;
  int y2;

  public JustLine() {
    setLayout(null);
    setSize(600,100);
  }

  @Override
  public JPanel drawLine(int x1, int y1, int x2, int y2) {
    System.out.println("HEYYY");
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    return this;
  }

  @Override
  public void paintComponent(Graphics g) {
    System.out.println("BOY");
    super.paintComponent(g);
    setBackground(Color.RED);
    g.setColor(Color.BLACK);
    g.drawLine(x1, y1, x2, y2);
  }

}
