package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* The Third and final screen collects the table data from second screen and displays normalised output to the user
This screen has a Table of normalised scores plotted against each student name and an Ok button
Clicking ok will dismiss the screen
The table values are uneditable
* */

public class ThirdScreen extends JFrame implements ActionListener {

	JButton okButton;

	// Constructor to initialize values
	public ThirdScreen(Object[][] data) {

		if (data == null) {
			return;
		}

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(550, 350)); // setting the window size

		// Button to close the screen
		okButton = new JButton("OK");
		okButton.addActionListener(this);

		String[] columnNames = {"Student", "Scores"}; //Final columns to be displayed.

		Object[][] normalisedData = normalise(data); // Normalised scores of all students


		JTable table = new JTable(normalisedData, columnNames);
		table.setEnabled(false); // Disabling the edit feature
		JScrollPane jscr = new JScrollPane(table);

		jscr.setPreferredSize(new Dimension(500, 300));
		subPanel.add(jscr);
		subPanel.add(okButton);
		panel.add(subPanel);
		add(panel, BorderLayout.CENTER);
	}

	// Normalization method - Takes table data from second screen and returns normalised data
	public Object[][] normalise(Object[][] data) {

		// Check if input array is either null or if the array is empty - return empty array
		if (data == null || data.length == 0) {
			return new Object[0][0];
		}
		//Check for input with incomplete names or scores - return empty array
		for (int i = 0; i < data.length; i++) {
			if (data[i].length != 4) {
				return new Object[0][0];
			}
		}

		//check for group count < 2 and group count > 7 - return empty array
		if (data.length < 2 || data.length > 7) {
			return new Object[0][0];
		}

		Object[][] normalisedData = new Object[data.length][2];
		double[] studentTotal = new double[data.length]; // Total of student scores across different categories
		double allTotal = 0; // Total of each student totals
		try {
			for(int i = 0; i<data.length; i++) {
				double a = (int)data[i][1];
				double b = (int)data[i][2];
				double c = (int)data[i][3];

				//in case of negative values, return an empty array
				if (a < 0 || b < 0 || c < 0) {
					return new Object[0][0];
				}

				double total = a+b+c;
				allTotal = allTotal + total;
				studentTotal[i] = total;


				if (allTotal == 0) { //when all scores are zero, handle NaN values.
					for (int j = 0; j < data.length; j++) {
						normalisedData[j][0] = data[j][0];
						normalisedData[j][1] = 0.0;
					}
				} else { //when all scores are proper, calculates normalised scores
					for (int j = 0; j < data.length; j++) {
						normalisedData[j][0] = data[j][0];
						double x = studentTotal[j] / allTotal;
						String s = String.format("%.2f", x); // Truncates the decimal to 2 places
						Double y = Double.parseDouble(s);
						normalisedData[j][1] = y;
					}
				}

			}
			//in case of class cast, return an empty array.
		} catch (ClassCastException e) {
			return new Object[0][0];
		}

		return normalisedData;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Ok button click - dismiss the screen
		if (e.getSource() == okButton) {
			setVisible(false);

		}
	}


}
