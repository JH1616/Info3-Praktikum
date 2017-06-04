/**
* Aufgabenblatt 3
* Aufgabe 1
* Bearbeitungsdauer:  min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import rover.CommandType;

/**
 * 
 *
 */
public class CommandTypesTable extends JPanel{

	public CommandTypesTable(CommandType [] row){
		super(new BorderLayout());
	
		
		String[][] rowData = new String [row.length][1];
		
		for (int i = 0; i < row.length; i++){
			if (row[i]!=null)
				rowData [i][0] = row[i].getName();
		}
		
		String[] header = {"Typs"};
		JTable table = new JTable(rowData, header);
		
	    this.add(new JScrollPane(table), BorderLayout.CENTER);
	    
	    //)
	}
}
