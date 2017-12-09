import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* This class represents the final screen on which the  
 * normalized scores for students will be displayed.
 * It has a constructor which takes scores entered on the 
 * second screen in an Object[][] and normalizes them.*/

public class ThirdScreen extends JFrame implements ActionListener {

	JButton okButton;
	
	public ThirdScreen(Object[][] data) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(500, 500));

		okButton = new JButton("OK");
		okButton.addActionListener(this);
		
		String[] columnNames = {"Student", "Scores"}; //Final columns to be displayed.
		
		Object[][] normalisedData = normalise(data); //Normalization of data.
		
		JTable table = new JTable(normalisedData, columnNames);
		table.setEnabled(false);
		JScrollPane jscr = new JScrollPane(table);
		
		subPanel.add(jscr);
		subPanel.add(okButton);
		panel.add(subPanel);
		add(panel, BorderLayout.CENTER);
	}
	public Object[][] normalise(Object[][] data) {

		Object[][] ddata = new Object[data.length][2];
		double[] studentTotal = new double[data.length];
		double allTotal = 0;
		try {
			for(int i =0 ; i<data.length;i++) {
				double a = (int)data[i][1];
				double b = (int)data[i][2];
				double c = (int)data[i][3];
				//in case of negative values, it returns an all negative array.
				if(a<0 || b<0 || c<0) { 
					for(int j =0;j<data.length;j++) {
						ddata[j][0] = -1;
						ddata[j][1] = -1;	
					}
					return ddata;
				}
				double total = a+b+c;
				allTotal = allTotal + total;
				studentTotal[i] = total;		
			}
		//in case of class cast, return an empty array.
		}catch(ClassCastException e) {
			return ddata; 						
		}		
		//when all scores are zero, handle NaN values.
		if(allTotal == 0) {
			for(int j =0;j<data.length;j++) {
				ddata[j][0] = data[j][0];
				ddata[j][1] = 0.0;
			}
		} else {
		for(int j =0;j<data.length;j++) {
			ddata[j][0] = data[j][0];
			double x = studentTotal[j]/allTotal;
			ddata[j][1] = x;
		}
		}		
		return ddata;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			setVisible(false);
			
		}
	}

}
