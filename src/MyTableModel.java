import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel {
	
	 private final String[] columnNames = {"Student Name", "Professionalism","Work Evaluation","Meeting Participation"};
	 Object[][] data ;
	 
	   

		public int getColumnCount() {
	        return columnNames.length;
	    }

	    public int getRowCount() {
	        return data.length;
	    }

	    public String getColumnName(int col) {
	        return columnNames[col];
	    }

	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }

	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }
    public boolean isCellEditable(int row, int col) {
	       return true;
	    }

	    /*
	     * Don't need to implement this method unless your table's
	     * data can change.
	     */
	    public void setValueAt(Object value, int row, int col) {
	        data[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }
	    public Object[][] getData() {
			return data;
		}

		public void setData(Object[][] data) {
			this.data = data;
		}
}
