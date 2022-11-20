import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Box extends JPanel implements MouseListener {

   int x, y;
   Popup p;

   public Box(int x, int y) {
      this.addMouseListener(new MouseInputAdapter() {
      });

      this.x = x;
      this.y = y;
      this.setLocation(x, y);
      JTextArea ta = new JTextArea();

      this.setSize(100, 60);
      ta.setSize(100, 30);
      ta.setBackground(Color.YELLOW);
      // this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
      this.setBorder(BorderFactory.createLineBorder(Color.CYAN, 30));
      String className = JOptionPane.showInputDialog("Class Name");
      ta.setText(className);
      this.add(ta);
      this.setBackground(Color.RED);
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.println("clicked on a box");
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
      // TODO Auto-generated method stub

   }

   // @Override
   // public void paintComponent(Graphics g) {
   // super.paintComponent(g);
   // setForeground(Color.black);
   // setForeground(Color.yellow);
   // g.fillRect(x, y, 200, 100);
   // }

}