import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* The FirstScreen class asks the user to select team size in the form of a dropdown.
The dropdown has values ranging from 2 to 7. Any other entry is not possible.
It also asks the user if scores were entered previously by using a radio button preference
Based on the user preferences, he is navigated to the second screen accordingly.
* */

public class FirstScreen extends JFrame implements ActionListener {

	private final JComboBox<Integer> groupList;
	private JButton submitButton;
	JRadioButton yesButton ;
	JRadioButton noButton ;

	// Constructor where all the values are initialized
	public FirstScreen() {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		//Create a sub-panel and add them to the main panel.
		JPanel subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(350,300));

		// Create the label for entering group count.
		JLabel groupCountLabel = new JLabel("Enter the group count");

		//Value range is restricted between 2 to 7.
		Integer[] groupValues = new Integer[]{2, 3, 4, 5, 6, 7};
		groupList = new JComboBox<>(groupValues);

		//Create another label for asking question for previously entered scores.
		JLabel previousScoreQuestion = new JLabel("Did you enter previous scores or not?");

		// Initialize Radio buttons
		yesButton = new JRadioButton("Yes");
		yesButton.setSelected(false);
		noButton = new JRadioButton("No");
		noButton.setSelected(true);

		//Group the radio buttons.
		ButtonGroup radioBtnGroup = new ButtonGroup();
		radioBtnGroup.add(yesButton);
		radioBtnGroup.add(noButton);

		// Create submit button and add listener
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);

		//Putting every component in a sub-panel with proper formatting
		//and adding it to the final panel.
		subPanel.add(Box.createRigidArea(new Dimension(10,100)));
		subPanel.add(groupCountLabel);
		subPanel.add(groupList);
		subPanel.add(previousScoreQuestion);
		subPanel.add(Box.createRigidArea(new Dimension(110,0)));
		subPanel.add(yesButton);
		subPanel.add(noButton);
		subPanel.add(Box.createRigidArea(new Dimension(100,50)));
		subPanel.add(submitButton, BorderLayout.CENTER);

		panel.add(subPanel);
		add(panel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {

		// Initializing first screen
		FirstScreen firstScreen = new FirstScreen();
		firstScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstScreen.setTitle("Self and peer evaluation");
		firstScreen.pack();
		firstScreen.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Click action on submit
		if (e.getSource() == submitButton) {
			int preference = 0;
			if(yesButton.isSelected()) {
				preference = 1;
			}
			int size = Integer.parseInt(groupList.getSelectedItem().toString());
			//Invoking second screen and passing values to its object.
			SecondScreen secondScreen = new SecondScreen(size,preference);
			secondScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			secondScreen.setTitle("Self and peer evaluation");
			secondScreen.pack();
			setVisible(false);
			secondScreen.setVisible(true);
		}
	}


}

