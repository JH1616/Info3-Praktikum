package GUI;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import rover.CommandList;
import rover.CommandType;
import rover.ControlModel;

public class CommandTypesTableModel extends AbstractTableModel implements tableUpdate{
	private ControlModel cm;
	private CommandType [] row; 
	
	private String[] culumnHeader = {"CommandTypes"};
	
	public CommandTypesTableModel(ControlModel cm){
		super();
		this.cm = cm;
		this.row = cm.getCommandTypes();
		
	}

	@Override
	public int getRowCount() {
		return this.row.length;
	}

	@Override
	public int getColumnCount() {
		return culumnHeader.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return row[rowIndex].getName();
	}

	public boolean isCellEditable(int rowIndex, int columnIndex){
		return false;
	}

	public String getColumnName(int column){
		return culumnHeader[column];
	}

	@Override
	public void update() {
		fireTableDataChanged();
	}


}
