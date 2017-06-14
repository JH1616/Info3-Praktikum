/**
 * 
 */
package GUI;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rover.ControlModel;
import rover.command.Command;

/**
 * Selection position erkennen
 *
 */
public class SharedListSelectionHandler implements ListSelectionListener {
	private ControlModel cm;
	private boolean inliste;
	
    public SharedListSelectionHandler(ControlModel cm, boolean inliste) {
		this.cm = cm;
		this.inliste = inliste;
	}

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
                	Command cmd;
                	if(inliste){
                		cmd = cm.getControlProcess().get(i);
                	}
                	else{
                		cmd = cm.getCommandTypes()[i].createInstance();
                	}
                	
                	DialogBox a = new DialogBox(cmd, this.cm, this.inliste);
                }
            }
        }
    }
}