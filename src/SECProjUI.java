import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SECProjUI extends JFrame implements ActionListener{

	private JButton submitButton;

	public SECProjUI() {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		//Create a sub-panel and add them to the main panel.
		JPanel subPanel = new JPanel();
		panel.add(subPanel);
		subPanel.setPreferredSize(new Dimension(350,300));


		// Create the label for entering group count.
		JLabel groupCountLabel = new JLabel("Enter the group count");

		JTextField groupCountBox = new JTextField();
		groupCountBox.setPreferredSize(new Dimension(60,20));
		groupCountBox.setHorizontalAlignment(JTextField.CENTER);;

		//Create another label for asking question for previously entered scores.        
		JLabel previousScoreQuestion = new JLabel("Did you enter previous scores or not?");

		JRadioButton yesButton = new JRadioButton("Yes");
		yesButton.setSelected(false);
		JRadioButton noButton = new JRadioButton("No");
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
		subPanel.add(groupCountBox);
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

		SECProjUI projUI = new SECProjUI();
		projUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		projUI.setTitle("Self and peer evaluation");
		projUI.pack();
		projUI.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submitButton) {

			//groupCountLabel.setText("You clicked submit!!");
			SecondScreen secondScreen = new SecondScreen();
			setVisible(false);
			secondScreen.setVisible(true);
		}
	}
}

