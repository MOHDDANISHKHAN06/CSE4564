import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class JustLine implements Arrow {

  int x1;
  int y1;
  int x2;
  int y2;

  public JustLine() {
  }

  @Override
  public void drawLine(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    Graphics g = RightPanel.rightPanel.getGraphics();
    g.drawLine(x1, y1, x2, y2);
  }

  // @Override
  // public void paint(Graphics g) {
  // super.paint(g);
  // setBackground(Color.GRAY);
  // g.setColor(Color.BLACK);
  // System.out.println("BOIDU");
  // g.drawLine(x1, y1, x2, y2);
  // }

}
