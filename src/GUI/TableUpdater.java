package GUI;

import java.util.Vector;

import javax.swing.JTable;

public class TableUpdater {
	private Vector<tableUpdate> v = new Vector<tableUpdate>();
	private JTable table;
	
	public void add(tableUpdate table){
		v.addElement(table);
	}
	
	public void update(){
		for(tableUpdate i : this.v){
			i.update();
		}
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

}
