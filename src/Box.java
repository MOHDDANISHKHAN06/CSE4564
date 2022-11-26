import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Box extends JPanel implements MouseInputListener {

   public int x, y;

   String className = "noClassName";

   public Box(int x, int y, String className) {
      // System.out.println("Im in box");
      this.className = className;
      addMouseListener(this);
      this.setLayout(new GridBagLayout());
      this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      this.x = x;
      this.y = y;
      this.setLocation(x, y);
      JTextArea ta = new JTextArea();
      this.setSize(200, 40);
      ta.setSize(100, 30);
      ta.setBackground(Color.YELLOW);
      ta.setText(className);
      this.add(ta);
      this.setBackground(Color.RED);
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      RightPanel.getRightPanel().boxClickTracker(this);
   }

   @Override
   public void mousePressed(MouseEvent e) {

   }

   @Override
   public void mouseReleased(MouseEvent e) {

   }

   @Override
   public void mouseEntered(MouseEvent e) {

   }

   @Override
   public void mouseExited(MouseEvent e) {

   }

   @Override
   public void mouseDragged(MouseEvent e) {

   }

   @Override
   public void mouseMoved(MouseEvent e) {

   }

}