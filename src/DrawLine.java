import java.awt.Graphics;
import java.util.Arrays;
import java.util.Collections;
import java.awt.Color;
import javax.swing.*;

public class DrawLine extends JPanel {
	
	static int[] x  = new int[2];
	static int[] y  = new int[2];
	static int[] lx = new int[2];
	static int[] ly = new int[2];
	static int[] ax = new int[4];
	static int[] ay = new int[4];
	static int[] ix = new int[4];
	static int[] iy = new int[4];
	
	@Override
	public void paintComponent (Graphics g)
	{ 
	     super.paintComponent(g);
	     setForeground(Color.black);
	     setForeground(Color.blue);
	 
	     //Association
	     g.drawLine(lx[0], ly[0], lx[1], ly[1]);
	     g.drawLine(x[1], y[0], lx[1], ly[1]);
	     g.drawLine(x[0], y[1], lx[1], ly[1]);   
	     
	     //Aggregation
	     g.drawLine(lx[0], 80, lx[1], 80);
	     g.drawPolygon(ax,ay,4);
	     
	     //Inheritance
	     g.drawLine(lx[0], 60, lx[1], 60);
	     g.drawPolygon(ix,iy,4);
	}
	
    public static void main(String[ ] args)
    {
    	lx[0]= 100;
    	lx[1]= 500;
    	ly[0]= 100;
    	ly[1]= 100;
    	
    	//Association
    	x[1] = x[0] = lx[1] - 10;
    	y[0] = ly[0] + 10;
    	y[1]= ly[1] - 10;
    	
    	//Aggregation
    	ax[0] = lx[0] - 20;
    	ax[1] = lx[0] - 10;
    	ax[2]= lx[0];
    	ax[3]= ax[1];
    	
    	ay[0] = ly[0]-20;
    	ay[1] = ly[0] -10;
    	ay[2]= ay[0];
    	ay[3]= ly[0]-30;
    	
    	//inheritance
    	
    	ix[0] = ix[1]= ix[3]= lx[1];
    	ix[2] = lx[1]+10;
   
    	iy[2]= iy[0] = ly[1] - 40;
    	iy[1]= ly[1] -30;
    	iy[3]= ly[1] -50;
    	
    	DrawLine d = new DrawLine( ); 
        JFrame f = new JFrame("Title of the frame");
        f.add(d); //adds DisplayGraphics to the frame for viewing
        f.setSize(500,500); //sets the coordinate size of frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes frame
        f.setLocationRelativeTo(null); //centers the frame on screen          
        f.setVisible(true); //makes frame appear on screen
   }

}
