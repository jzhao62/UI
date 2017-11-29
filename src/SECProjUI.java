import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

/**
 * We now see how to make an area in which we can edit text.
 *
 * @author Matthew Hertz
 */
public class SECProjUI extends JFrame implements ActionListener{
    /**
     * Create a new window in which to write the great American novel.
     */

    private JButton submitButton;
    private JLabel groupCountLabel;


    public SECProjUI() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        // Create two sub-panels and add them to the main panel
        JPanel subPanel1 = new JPanel();
        subPanel1.setLayout(new FlowLayout());
        panel.add(subPanel1);
        //add(subPanel1, BorderLayout.NORTH);
        // Question: what if we add the subpanel directly to the JFrame?

        JPanel subPanel2 = new JPanel();
        subPanel2.setLayout(new FlowLayout());
        //add(subPanel2, BorderLayout.SOUTH);
        // Question: what if we add the subpanel directly to the JFrame?

        // Create the label and add it to the panel.
        groupCountLabel = new JLabel("I hold text");

        // Create & add the buttons
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Add things to the various panels
        subPanel1.add(groupCountLabel);
        subPanel1.add(submitButton);
     ;
        panel.add(subPanel1);
        panel.add(subPanel2);
        //panel.add(label);
        add(panel, BorderLayout.CENTER);

    }

    /**
     * Run the example program that starts the day
     *
     * @param args Command-line arguments which we will ignore.
     */
    public static void main(String[] args) {


        SECProjUI projUI = new SECProjUI();
        projUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projUI.setTitle("Self and peer evaluation");
        projUI.pack();
        projUI.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            groupCountLabel.setText("You clicked submit!!");
        }
    }
}

