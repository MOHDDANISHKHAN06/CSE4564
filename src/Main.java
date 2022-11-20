import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        JMenu file, help;
        JMenuItem New, save, load;
        JFrame frame = new JFrame("SplitPaneFrame");
        JMenuBar mb = new JMenuBar();
        file = new JMenu("File");
        help = new JMenu("help");
        New = new JMenuItem("New");
        save = new JMenuItem("Save");
        load = new JMenuItem("Load");
        file.add(New);
        file.add(save);
        file.add(load);
        mb.add(file);
        mb.add(help);
        LeftPanel lp = new LeftPanel();
        RightPanel rp = new RightPanel();
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lp, rp);
        split.setDividerLocation(500);
        frame.getContentPane().add(split);
        frame.setJMenuBar(mb);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000, 1000);
        frame.setVisible(true);
    }
}
