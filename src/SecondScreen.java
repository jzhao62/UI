

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
	public class SecondScreen extends JFrame implements ActionListener{
	    /**
	     * Create a new window in which to write the great American novel.
	     */

	    private JButton submitButton;
	    private JLabel groupCountLabel;


	    public SecondScreen() {

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
	        groupCountLabel = new JLabel("Enter the group count");
	        
	        JTextArea groupCountBox = new JTextArea(2, 10);
	        groupCountBox.setLineWrap(true);
	        groupCountBox.setWrapStyleWord(true);
	        //groupCountBox.setText("");
	        JLabel previousScoreQuestion = new JLabel("Did you enter previous scores or not?");
	        
	        JRadioButton yesButton = new JRadioButton("Yes");
	        //yesButton.setMnemonic(KeyEvent.VK_B);
	        //yesButton.setActionCommand(birdString);
	        yesButton.setSelected(false);

	        JRadioButton noButton = new JRadioButton("No");
	        //noButton.setMnemonic(KeyEvent.VK_C);
	        //noButton.setActionCommand(catString);
	        noButton.setSelected(false);
	  

	        //Group the radio buttons.
	        ButtonGroup radioBtnGroup = new ButtonGroup();
	        radioBtnGroup.add(yesButton);
	        radioBtnGroup.add(noButton);
	       

	        // Create & add the buttons
	        submitButton = new JButton("Submit");
	        submitButton.addActionListener(this);
	        
	        

	        // Add things to the various panels
	        subPanel1.add(groupCountLabel);
	        subPanel1.add(groupCountBox);
	        subPanel1.add(previousScoreQuestion);
	        subPanel1.add(yesButton);
	        subPanel1.add(noButton);
	        subPanel1.add(submitButton);
	        
	        panel.add(subPanel1);
	        panel.add(subPanel2);
	        //panel.add(label);
	        add(panel, BorderLayout.CENTER);

	    }
	  
	    @Override
	    public void actionPerformed(ActionEvent e) {

	        if (e.getSource() == submitButton) {

	            groupCountLabel.setText("You clicked submit!!");
	        }
	    }

		public void setVisible(boolean b) {
			this.setVisible(b);			
		}
	}
