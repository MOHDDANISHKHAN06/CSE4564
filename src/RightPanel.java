import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RightPanel extends JPanel implements Observable {

    private static RightPanel rightPanel;
    private static ArrayList<Box> boxes;
    private static ArrayList<Box> mouseTracker;

    private RightPanel() {
    }

    JPanel jPanel;

    public static RightPanel getRightPanel() {

        if (rightPanel == null) {
            rightPanel = new RightPanel();
            boxes = new ArrayList<>();
            mouseTracker = new ArrayList<>();
        }

        rightPanel.setLayout(null);
        rightPanel.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                String className = JOptionPane.showInputDialog("Class Name");
                if ((className != null)) {
                    if (className.length() == 0) {
                        className = "noClassName";
                    }
                    rightPanel.addNewBox(x, y, className);
                }
            }
        });
        return rightPanel;
    }

    public void addNewBox(int x, int y, String className) {
        Box newBox = new Box(x, y, className);
        boxes.add(newBox);
        rightPanel.add(newBox);
        rightPanel.sendUpdate();
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    public void listRenderedBoxes() {
        for (Box x : boxes)
            System.out.print(x + ",");
        System.out.println();
    }

    public void boxClickTracker(Box box) {
        mouseTracker.add(box);
        if (mouseTracker.size() == 2) {
            handleRelations();
            mouseTracker.clear();
        }

    }

    public void handleRelations() {
        Box b1 = mouseTracker.get(0);
        Box b2 = mouseTracker.get(1);
        int boundX = Math.min(b1.x, b2.x) + 50;
        int boundY = Math.min(b1.y, b2.y) + 20;
        int boundW = Math.abs(b2.x - b1.x);
        int boundH = Math.abs(b2.y - b1.y);
        int response = 0;
        if (response == 0) {
            System.out.println("Inheritance");
            Arrow arrow = new InheritanceDecoration(new JustLine(boundX, boundY, boundW, boundH));
            rightPanel.add(arrow.drawLine(10, 10, 50, 20));
        } else if (response == 1) {
            System.out.println("Composition");
        } else
            System.out.println("Association");
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    @Override
    public void addSubscriber(Observer o) {
        observerArrayList.add(o);
    }

    @Override
    public void removeSubscriber(Observer o) {
        int observerIndex = observerArrayList.indexOf(o);
        observerArrayList.remove(observerIndex);
    }

    @Override
    public void sendUpdate() {
        for (Observer observer : observerArrayList) {
            observer.update(boxes);
        }
    }
}