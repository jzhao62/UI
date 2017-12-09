import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* The Second screen takes user preferences from the previous screen and populates table data accordingly
Group size and previous score preference are passed on from the first class
If user entered previous scores, populating hardcoded names and scores to the table.
If user didn't enter scores before, initializing zero scores for all student entries.
Number of rows in the table depend on the team size entered in the previous screen.
User can evaluate himself and his peers on a scale of 0 to 5. No other entry is possible.
Selection is given in the form of a drop down. So Invalid scores cannot be entered
The scores entered here will be normalised in the next(third) screen by clicking the submit button
* */

public class SecondScreen extends JFrame implements ActionListener{

	private JButton submitButton;
	private Object[][] data;

	// Class constructor to initialize values
	public SecondScreen(int groupSize, int preference) {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(550, 450)); // Setting panel size

		//Dummy data for previously entered scores.
		Object[][] scores = {
				{"Dave",new Integer(5),new Integer(5),new Integer(4)},
				{"Casey",new Integer(3),new Integer(4),new Integer(4)},
				{"Jim",new Integer(5),new Integer(5),new Integer(3)},
				{"Matt",new Integer(5),new Integer(5),new Integer(3)},
				{"Sara",new Integer(4),new Integer(4),new Integer(3)},
				{"Jake",new Integer(4),new Integer(5),new Integer(3)},
				{"Sam",new Integer(5),new Integer(3),new Integer(4)}};

		//Configuring the table data as per inputs from the first screen.
		data = new Object[groupSize][4];
		if(preference == 1) {
			for(int i = 0; i<groupSize; i++) {
				for(int j = 0; j<4; j++) {
					data[i][j] = scores[i][j];
				}
			}
		} else {
			for(int i = 0; i<groupSize; i++) {
				data[i][0] = scores[i][0];
				for(int j = 1; j<4; j++) {
					data[i][j] = 0;
				}
			}
		}

		MyTableModel model = new MyTableModel();
		model.setData(data); // Setting hardcoded data to the table model
		JTable table = new JTable(model);
		JScrollPane jscr = new JScrollPane(table);
		jscr.setPreferredSize(new Dimension(500, 300));
		// Labels for directions
		JLabel headerLabel = new JLabel("Kindly select scores in the below table and click on SUBMIT. ");
		JLabel headerLabel2 = new JLabel("If you have previously entered scores - ");
		JLabel headerLabel3 = new JLabel("select new value from dropdown to update and click on SUBMIT");

		// Adding this to subpanel
		subPanel.add(headerLabel);
		subPanel.add(headerLabel2);
		subPanel.add(headerLabel3);

		subPanel.add(jscr);

		// setting up the dropdown values

		setUpProfColumn(table.getColumnModel().getColumn(1));
		setUpWorkEvalColumn(table.getColumnModel().getColumn(2));
		setUpMeetingParColumn(table.getColumnModel().getColumn(3));

		// Submit button and listener
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		subPanel.add(submitButton);

		panel.add(subPanel);
		add(panel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// If submit button is clicked
		if (e.getSource() == submitButton) {

			// Passing table data to next screen
			ThirdScreen thirdScreen = new ThirdScreen(data);
			thirdScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			thirdScreen.setTitle("Normalized Scores");
			thirdScreen.pack();
			setVisible(false);
			thirdScreen.setVisible(true);

		}
	}

	// Set dropdown values - Professionalism
	public void setUpProfColumn(TableColumn profColumn) {
		//Set up the editor for the professionalism cells.
		JComboBox pBox = new JComboBox();
		pBox.addItem(0);
		pBox.addItem(1);
		pBox.addItem(2);
		pBox.addItem(3);
		pBox.addItem(4);
		pBox.addItem(5);
		profColumn.setCellEditor(new DefaultCellEditor(pBox));

		//Set up tool tips for the professionalism cells.
		DefaultTableCellRenderer renderer =
				new DefaultTableCellRenderer();
		renderer.setToolTipText("Click to enter Professionalism score");
		profColumn.setCellRenderer(renderer);
	}

	// Set dropdown values - Professionalism
	public void setUpWorkEvalColumn(TableColumn workEvalColumn) {
		//Set up the editor for the work eval cells.
		JComboBox wBox = new JComboBox();
		wBox.addItem(0);
		wBox.addItem(1);
		wBox.addItem(2);
		wBox.addItem(3);
		wBox.addItem(4);
		wBox.addItem(5);
		wBox.addActionListener(this);
		workEvalColumn.setCellEditor(new DefaultCellEditor(wBox));

		//Set up tool tips for the work eval cells.
		DefaultTableCellRenderer renderer =
				new DefaultTableCellRenderer();
		renderer.setToolTipText("Click to enter Work Evaluation score");
		workEvalColumn.setCellRenderer(renderer);
	}

	// Set dropdown values - Professionalism
	public void setUpMeetingParColumn(TableColumn meetingParColumn) {
		//Set up the editor for the meeting par cells.
		JComboBox mBox = new JComboBox();
		mBox.addItem(0);
		mBox.addItem(1);
		mBox.addItem(2);
		mBox.addItem(3);
		mBox.addItem(4);
		mBox.addItem(5);
		mBox.addActionListener(this);
		meetingParColumn.setCellEditor(new DefaultCellEditor(mBox));

		//Set up tool tips for the meeting par cells.
		DefaultTableCellRenderer renderer =
				new DefaultTableCellRenderer();
		renderer.setToolTipText("Click to enter Meeting Participation score");
		meetingParColumn.setCellRenderer(renderer);
	}

}

