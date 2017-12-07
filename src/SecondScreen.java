import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SecondScreen extends JFrame implements ActionListener{

	private JButton submitButton;
	Object[][] data ;
	public SecondScreen(int groupSize, int preference) {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel subPanel1 = new JPanel();
		subPanel1.setPreferredSize(new Dimension(550,550));

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
			for(int i = 0 ;i<groupSize;i++) {
				for(int j=0;j<4;j++) {
					data[i][j] = scores[i][j];
				}
			}
		} else {
			for(int i = 0 ;i<groupSize;i++) {
				data[i][0] = scores[i][0];
				for(int j=1;j<4;j++) {
					data[i][j] = 0;
				}
			}
		}

		MyTableModel myData = new MyTableModel();
		myData.setData(data);
		JTable table = new JTable(myData);
		JScrollPane jscr = new JScrollPane(table);
		
		JLabel headerLabel = new JLabel("Kindly enter scores in the below table and click on SUBMIT. ");
		JLabel headerLabel2 = new JLabel("If you have previously entered scores - ");
		JLabel headerLabel3 = new JLabel("Double click on the score to update and click on SUBMIT");

		subPanel1.add(headerLabel);
		subPanel1.add(headerLabel2);
		subPanel1.add(headerLabel3);

		subPanel1.add(jscr);

		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		subPanel1.add(submitButton);

		panel.add(subPanel1);

		add(panel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			ThirdScreen thirdScreen = new ThirdScreen(data);
			thirdScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			thirdScreen.setTitle("Normalized Scores");
			thirdScreen.pack();
			setVisible(false);
			thirdScreen.setVisible(true);
		}
	}

}

