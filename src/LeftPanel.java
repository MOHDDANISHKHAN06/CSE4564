import javax.security.sasl.RealmCallback;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class LeftPanel extends JPanel implements Observer {
    String text_output = "";
    int len = 0;
    private ArrayList<SubLeftPanel> subLeftPanels;
    ArrayList<Box> boxes;
    ArrayList<RelationShip> relationShips;

    LeftPanel() {
        boxes = new ArrayList<>();
        subLeftPanels = new ArrayList<>();
        setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
    }

    @Override
    public void update(ArrayList<Box> boxes, ArrayList<RelationShip> relationShips) {
        System.out.println("in update");
        this.boxes = boxes;
        this.relationShips = relationShips;
        write_string();
        // this.revalidate();
        // this.repaint();
    }

    public void write_string() {

        removeAll();
        subLeftPanels.clear();

        for (Box each_box : boxes) {
            SubLeftPanel codePanel = new SubLeftPanel(6, 45);
            // use builder pattern
            codePanel.setClassNameText(each_box.className);
            codePanel.setBox(each_box);
            codePanel.setCodeText();
            subLeftPanels.add(codePanel);
        }

        for (RelationShip relationShip : relationShips) {

            SubLeftPanel foundPanel = findSubLeftPanel(relationShip.b1);
            if (foundPanel != null) {
                foundPanel.setRelationsText(relationShip.b2.getClassName());
                foundPanel.setCodeText();
            }
        }

        System.out.println("LEnthll " + subLeftPanels.size());
        for (SubLeftPanel subLeftPanel : subLeftPanels) {
            add(subLeftPanel);
        }

        revalidate();
        repaint();
    }

    public SubLeftPanel findSubLeftPanel(Box box) {
        for (SubLeftPanel subLeftPanel : subLeftPanels) {

            if (box == subLeftPanel.box) {
                return subLeftPanel;
            }
        }
        return null;
    }
}
