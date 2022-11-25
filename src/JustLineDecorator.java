import javax.swing.JPanel;

public abstract class JustLineDecorator extends JPanel implements Arrow {
    protected Arrow arrow;

    public JustLineDecorator(Arrow arrow) {
        this.arrow = arrow;
        setLayout(null);
    }

    @Override
    public JPanel drawLine(int x1, int y1, int x2, int y2) {
        this.arrow.drawLine(x1, y1, x2, y2);
        return this;
    }

}
