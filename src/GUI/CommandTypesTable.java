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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rover.CommandType;
import rover.ControlModel;


/**
 * der Versuch ein Doppel klick zu erkennen.
 *
 */
class NewMouseListener extends MouseAdapter{
    
    public void mouseClicked(MouseEvent e){
        if (e.getClickCount() == 2) { 
        	System.out.println("doppelKlick");
        }
    }
}

/**
 * Selection position erkennen
 *
 */
class SharedListSelectionHandler implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) { 
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();

        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean isAdjusting = e.getValueIsAdjusting(); 

        if (!lsm.isSelectionEmpty() && isAdjusting) {
            // Find out which indexes are selected.
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                	System.out.println("CommandTypesTable: " + i);
                }
            }
        }
    }
}

/**
 * Tabelle fuer die Comandotyps
 *
 */
public class CommandTypesTable extends JPanel{
	CommandType [] row;
	
	JTable table;
	ListSelectionModel listSelectionModel;

	public CommandTypesTable(ControlModel cm){
		super(new BorderLayout());
	
		this.row = cm.getCommandTypes();
		
		String[][] rowData = new String [row.length][1];
		
		for (int i = 0; i < row.length; i++){
			if (row[i]!=null)
				rowData [i][0] = row[i].getName();
		}
		
		String[] header = {"Typs"};
		table = new JTable(rowData, header);
		//table.addMouseListener(new NewMouseListener());
		
        listSelectionModel = table.getSelectionModel();
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
        table.setSelectionModel(listSelectionModel);

	    this.add(new JScrollPane(table), BorderLayout.CENTER);
	    
	    //)
	}
}
