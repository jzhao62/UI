import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ThirdScreen  extends JFrame implements ActionListener{

	JButton okButton;
	
	public ThirdScreen(Object[][] data) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel subPanel1 = new JPanel();
		subPanel1.setPreferredSize(new Dimension(500,500));

		okButton = new JButton("OK");
		okButton.addActionListener(this);
		
		String[] columnNames = {"Student", "Scores"};
		
		double[] studentTotal = new double[data.length];
		
		double allTotal = 0;
		
		for(int i =0 ; i<data.length;i++) {
			
				double a = (int)data[i][1];
				double b = (int)data[i][2];
				double c = (int)data[i][3];
				
				double total = a+b+c;
				allTotal = allTotal + total;
				studentTotal[i] = total;		
			
		}
		
		
		Object[][] ddata = new Object[data.length][2];
		
		for(int j =0;j<data.length;j++) {
			ddata[j][0] = data[j][0];
			double x = studentTotal[j]/allTotal;
			ddata[j][1] = x;
		}
				
		JTable table = new JTable(ddata,columnNames);

		JScrollPane jscr = new JScrollPane(table);
		
		subPanel1.add(jscr);
		subPanel1.add(okButton);

		panel.add(subPanel1);

		add(panel, BorderLayout.CENTER);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			setVisible(false);
			
		}
	}

}
