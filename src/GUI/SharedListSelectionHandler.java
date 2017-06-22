/**
 * 
 */
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rover.ControlModel;
import rover.command.Command;

/**
 * Selection position erkennen
 *
 */
public class SharedListSelectionHandler extends MouseAdapter {
	private ControlModel cm;
	private boolean inliste;
	private TableUpdater update;
	private JTable table;
	
    public SharedListSelectionHandler(TableUpdater update, JTable table, ControlModel cm, boolean inliste) {
		this.cm = cm;
		this.inliste = inliste;
		this.update = update;
		this.table = table;
	}
    
    public void mouseClicked(MouseEvent e) {
    	if (e.getClickCount()==1){
    		if(inliste){
    		int row = table.getSelectedRow();
    		cm.setSelectedRow(row);
    		System.out.println("Table: " + row);
    		}
    	}
    		
        if (e.getClickCount()==2)
        {
            int row = table.getSelectedRow();
            
            System.out.println("doubleTable: " + row);
        	Command cmd;
        	if(inliste){
        		cmd = cm.getControlProcess().get(row);
        	}
        	else{
        		cmd = cm.getCommandTypes()[row].createInstance();
        	}
        	
        	DialogBox a = new DialogBox(cmd, this.cm, this.inliste);
        	this.update.update();
        	cm.setSelectedRow(-1);
        	

        }
    }  
}