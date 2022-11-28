import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RightPanel extends JPanel implements Observable {

    public static RightPanel rightPanel;
    private static ArrayList<Box> boxes;
    private static ArrayList<Box> mouseTracker;
    private static ArrayList<RelationShip> relationShips;

    private RightPanel() {
    }

    JPanel jPanel;

    public static void getRightPanel() {

        if (rightPanel == null) {
            rightPanel = new RightPanel();
            boxes = new ArrayList<>();
            mouseTracker = new ArrayList<>();
            relationShips = new ArrayList<>();
        }

        rightPanel.setLayout(null);
        rightPanel.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                rightPanel.addNewBox(x, y);

            }
        });
    }

    public void addNewBox(int x, int y) {
        Box newBox = new Box(x, y);
        if (newBox.getBoxCreated()) {
            boxes.add(newBox);
            sendUpdate();
            updateRightPanel();
        }
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
        int response = 0;
        if (response == 0) {
            System.out.println("Inheritance");
            Arrow arrow = new InheritanceDecoration(new JustLine());
            relationShips.add(new RelationShip(b1, b2, "Inheritance", arrow));
            updateRightPanel();
        } else if (response == 1) {
            System.out.println("Composition");
        } else
            System.out.println("Association");
    }

    public void updateRightPanel() {
        // removeAll();
        System.out.println("rePainting started");
        for (int i = 0; i < boxes.size(); ++i) {
            rightPanel.add(boxes.get(i));
            // rightPanel.revalidate();
            // rightPanel.repaint();
        }

        for (int i = 0; i < relationShips.size(); ++i) {
            Box b1 = relationShips.get(i).b1;
            Box b2 = relationShips.get(i).b2;
            Arrow arrow = relationShips.get(i).arrow;
            // move it inside later.
            arrow.drawLine(b1.x, b1.y, b2.x, b2.y);
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