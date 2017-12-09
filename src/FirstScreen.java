import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstScreen extends JFrame implements ActionListener {

	private final JComboBox<Integer> groupList;
	private JButton submitButton;
	JRadioButton yesButton ;
	JRadioButton noButton ;

	public FirstScreen() {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		//Create a sub-panel and add them to the main panel.
		JPanel subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(350,300));

		// Create the label for entering group count.
		JLabel groupCountLabel = new JLabel("Enter the group count");

		Integer[] groupValues = new Integer[]{2, 3, 4, 5, 6, 7};
		groupList = new JComboBox<>(groupValues);

		//Create another label for asking question for previously entered scores.
		JLabel previousScoreQuestion = new JLabel("Did you enter previous scores or not?");

		yesButton = new JRadioButton("Yes");
		yesButton.setSelected(false);
		noButton = new JRadioButton("No");
		noButton.setSelected(false);

		//Group the radio buttons.
		ButtonGroup radioBtnGroup = new ButtonGroup();
		radioBtnGroup.add(yesButton);
		radioBtnGroup.add(noButton);

		// Create & add the buttons
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);

		// Add things to the various panels
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

		FirstScreen firstScreen = new FirstScreen();
		firstScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstScreen.setTitle("Self and peer evaluation");
		firstScreen.pack();
		firstScreen.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submitButton) {
			int preference = 0;
			if(yesButton.isSelected()) {
				preference = 1;
			}
			int size = Integer.parseInt(groupList.getSelectedItem().toString());
			SecondScreen secondScreen = new SecondScreen(size,preference);
			secondScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			secondScreen.setTitle("Self and peer evaluation");
			secondScreen.pack();
			setVisible(false);
			secondScreen.setVisible(true);
		}
	}


}

