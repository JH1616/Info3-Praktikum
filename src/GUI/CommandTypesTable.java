/**
 * 
 */
package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import rover.ControlModel;

/**
 * Liste mit CommandTypes
 */
public class CommandTypesTable extends JPanel{
	private ControlModel cm;
	
	private JTable table;
	private CommandTypesTableModel model;
	private TableUpdater tUpdate;

	
	public CommandTypesTable (){
		super(new BorderLayout());
		this.cm = ControlModel.getInstance();
		this.tUpdate = cm.gettUpdate();
		
		this.model = new CommandTypesTableModel();
		this.table = new JTable(this.model);
		
		this.tUpdate.add(model);
        
        this.table.addMouseListener(new SharedListSelectionHandler(this.tUpdate, this.table, false));
		
        this.add(new JScrollPane(table), BorderLayout.CENTER);
		}


		
	}