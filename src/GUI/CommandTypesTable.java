/**
 * 
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author jorn
 *
 */
public class CommandTypesTable extends JPanel{

	public CommandTypesTable(){
		super(new BorderLayout());
	
		
		String[][] rowData = {{"zeile1"},{"zeile2"},{"zeile3"}, {"zeile4"}};
		String[] header = {"Typs"};
		JTable table = new JTable(rowData, header);
		
	    this.add(new JScrollPane(table), BorderLayout.CENTER);
	    
	    //)
	}
}
