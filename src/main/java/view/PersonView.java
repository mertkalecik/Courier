package view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class PersonView extends JFrame {
    protected JFrame personFrame;

    public PersonView(String label, int h, int v) {
        this.personFrame = new JFrame(label);
        personFrame.addWindowListener(new CloseListener());
        personFrame.setSize(250, 500);
        personFrame.setLocation(h, v);
    }

    public static class CloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

}
