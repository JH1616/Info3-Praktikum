package GUI;

import javax.swing.table.AbstractTableModel;

import rover.CommandList;
import rover.ControlModel;


/**
 * Verwaltung der CommandList Tabelle
 *
 */
public class CommandListTableModel extends AbstractTableModel implements tableUpdate{
	private ControlModel cm;
	private CommandList liste; 
	
	private String[] culumnHeader = {"No.", "Command", "Configuration"};
	
	public CommandListTableModel(){
		super();
		this.cm = ControlModel.getInstance();
		this.liste = cm.getControlProcess();
		
	}

	@Override
	public int getRowCount() {
		return liste.getLength();
	}

	@Override
	public int getColumnCount() {
		return culumnHeader.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex==0){
			return rowIndex+1;
		}
		else if(columnIndex==1){
			return liste.get(rowIndex).getName();
		}
		else{
			String [] zeile = liste.get(rowIndex).toString().split(" ");
			for(int j = 1; j < zeile.length; j+=1){
				zeile[j] = (zeile[j].split("="))[1];
				zeile[j] = zeile[j].replaceAll(",", "");
				zeile[j] = zeile[j].replaceAll("]", "");
			}
			if (zeile[0].equals("Gear"))
				return zeile[1]+ " cm/sec, "+zeile[2] + " sec";
			else if (zeile[0].equals("Repetition"))
				//Einheiten??
				return zeile[1]+ " Steps, "+ zeile[2]+ " repetitions";
			else if (zeile[0].equals("Pause"))
				return zeile[1]+" sec";
			else if (zeile[0].equals("Direction"))
				return zeile[1]+" Degree";
			
			return "fehler";
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex){
		return false;
	}

	public String getColumnName(int column){
		return culumnHeader[column];
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		fireTableDataChanged();
	}


}
