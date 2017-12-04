import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		private JTextField groupCountBox;


		public SecondScreen(int groupSize) {

		/*	JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

			//Create a sub-panel and add them to the main panel.
			JPanel subPanel = new JPanel();
			panel.add(subPanel);
			subPanel.setPreferredSize(new Dimension(350,300));


			// Create the label for entering group count.
			groupCountLabel = new JLabel("Enter the group count");

			groupCountBox = new JTextField();
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

			add(panel, BorderLayout.CENTER);*/
			createAndShowUI();

		}

		public static void createAndShowUI() {
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

			JPanel subPanel1 = new JPanel();
			subPanel1.setLayout(new FlowLayout());
			panel.add(subPanel1);

			JButton submitButton = new JButton("Submit");

			subPanel1.add(submitButton);
			panel.add(subPanel1);

			String[] columnNames = {"Item", "F1", "F2", "F1"};
			Object[][] data =
					{
							{"S1", "Feature 1", "Feature 2", "Feature 3"},
							{"S2", "Feature 1", "Feature 2", "Feature 3"},
							{"S3", "Feature 1", "Feature 2", "Feature 3"},
							{"S4", "Feature 1", "Feature 2", "Feature 3"},
							{"S5", "Feature 1", "Feature 2", "Feature 3"},

					};


			JTable table = new JTable(data, columnNames);
//    table.getColumnModel().getColumn(1).setPreferredWidth(300);
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			JScrollPane scrollPane = new JScrollPane(table);

			// Use the popup editor on the second column

			TablePopupEditor popupEditor = new TablePopupEditor();
			table.getColumnModel().getColumn(1).setCellEditor(popupEditor);
			table.getColumnModel().getColumn(2).setCellEditor(popupEditor);
			table.getColumnModel().getColumn(3).setCellEditor(popupEditor);


			JFrame frame = new JFrame("Popup Editor Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(new JTextField(), BorderLayout.NORTH);
			frame.add(scrollPane);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);


		}
	  
	    @Override
	    public void actionPerformed(ActionEvent e) {

	        if (e.getSource() == submitButton) {

	            groupCountLabel.setText("You clicked submit!!");
	        }
	    }

		/*public void setVisible(boolean b) {
			this.setVisible(b);			
		}*/
	}

