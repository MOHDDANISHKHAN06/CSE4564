import javax.swing.*;
import java.util.ArrayList;

public class LeftPanel extends JPanel implements Observer {
    String text_output = "";
    JTextArea jt;
    int len = 0;
    private static ArrayList<Box> boxobjectarray = new ArrayList<>();
    
    LeftPanel() {
        jt = new JTextArea(100, 45);
        this.add(jt);
    }

    @Override
    public void update(ArrayList<Box> boxes) {
        System.out.println("in update");
        boxobjectarray = boxes;
        jt.selectAll();
        jt.replaceSelection(" ");
        write_string();
        // this.revalidate();
        // this.repaint();
    }

    public void write_string() {
        for (Box each_box : boxobjectarray) {
            // text_output += each_box.className;
            // jt.insert("\nclass ",0);
            // jt.insert(each_box.className,7);
            // System.out.println(each_box.className.length());
            // len = 8 + (int) each_box.className.length() + 1 ;
            // System.out.println(len);
            // jt.insert("{}", len);
            jt.append("\n Class ");
            jt.append(each_box.className);
            jt.append(" {}");

        }
        System.out.println(text_output);

    }
}
