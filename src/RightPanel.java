import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

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
                        // Can generate a random class name as well
                        className = "noClassName";
                    }
                    Box newBox = new Box(x, y, className);
                    boxes.add(newBox);
                    rightPanel.add(newBox);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                    rightPanel.sendUpdate();
                }
            }
        });
        return rightPanel;
    }

    public void listRenderedBoxes() {
        for (Box x : boxes)
            System.out.print(x + ",");
        System.out.println();
    }

    public void boxClickTracker(Box box) {
        mouseTracker.add(box);
        if (mouseTracker.size() == 2) {
            System.out.println("Invoke an arrow function");
            mouseTracker.clear();
        }

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