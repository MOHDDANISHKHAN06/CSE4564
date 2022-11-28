import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Box extends JPanel implements MouseInputListener {

   public int x, y;
   boolean boxCreated = false;
   String className = "noClassName";

   public Box(int x, int y) {
      className = JOptionPane.showInputDialog("Class Name");
      if ((className != null)) {
         if (className.length() == 0) {
            className = "noClassName";
         }
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
         boxCreated = true;
         this.setBackground(Color.RED);
         this.revalidate();
         this.repaint();
      }
   }

   public boolean getBoxCreated() {
      return boxCreated;
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      RightPanel.rightPanel.boxClickTracker(this);
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