import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ThirdScreen extends JFrame implements ActionListener {

	JButton okButton;
	
	public ThirdScreen(Object[][] data) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(500, 500));

		okButton = new JButton("OK");
		okButton.addActionListener(this);
		
		String[] columnNames = {"Student", "Scores"};
		
		double[] studentTotal = new double[data.length];

		int allTotal = 0;
		
		for(int i =0 ; i<data.length;i++) {

			int a = (int) data[i][1];
			int b = (int) data[i][2];
			int c = (int) data[i][3];

			int total = a + b + c;
				allTotal = allTotal + total;
				studentTotal[i] = total;		
			
		}


		Object[][] normalisedData = new Object[data.length][2];
		
		for(int j =0;j<data.length;j++) {
			normalisedData[j][0] = data[j][0];
			double x = studentTotal[j]/allTotal;
			normalisedData[j][1] = x;
		}

		JTable table = new JTable(normalisedData, columnNames);
		table.setEnabled(false);
		JScrollPane jscr = new JScrollPane(table);

		subPanel.add(jscr);
		subPanel.add(okButton);

		panel.add(subPanel);
		add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			setVisible(false);
			
		}
	}

}
