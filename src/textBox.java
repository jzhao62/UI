import java.util.*;

import javax.swing.*;

/**
 * We now see how to make an area in which we can edit text.
 *
 * @author Matthew Hertz
 */
public class textBox extends JFrame {
    /**
     * Create a new window in which to write the great American novel.
     */
    public textBox() {
        JLabel myLabel = new JLabel("Team 1");
        JTextArea textBox = new JTextArea(2, 2);
        textBox.setLineWrap(true);
        textBox.setWrapStyleWord(true);
        textBox.setText(" ");
        add(textBox);
    }

    /**
     * Run the example program that starts the day
     *
     * @param args Command-line arguments which we will ignore.
     */
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        textBox window = new textBox();

        // Finish setting up this window.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("this is the textbox");
        window.pack();
        window.setVisible(true);
    }
}

