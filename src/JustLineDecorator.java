import javax.swing.JPanel;

public abstract class JustLineDecorator extends JPanel implements Arrow {
    protected Arrow arrow;

    public JustLineDecorator(Arrow arrow) {
        this.arrow = arrow;
    }
   @Override 
    public int getBoundX() {
        return this.arrow.getBoundX();
    }

   @Override 
    public int getBoundY() {
        return this.arrow.getBoundY();
    }

   @Override 
    public int getBoundW() {
        return this.arrow.getBoundW();
    }

   @Override 
    public int getBoundH() {
        return this.arrow.getBoundH();
    }

    @Override
    public JPanel drawLine(int x1, int y1, int x2, int y2) {
        return this.arrow.drawLine(x1, y1, x2, y2);
    }

}
