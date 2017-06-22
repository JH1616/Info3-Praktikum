/**
 * 
 */
package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import rover.CommandList;
import rover.ControlModel;

/**
 *
 */
public class CommandTypesTable extends JPanel{
	private ControlModel cm;
	
	private JTable table;
	private CommandTypesTableModel model;
	private TableUpdater tUpdate;

	
	public CommandTypesTable (ControlModel cm){
		super(new BorderLayout());
		this.cm = cm;
		this.tUpdate = cm.gettUpdate();
		
		this.model = new CommandTypesTableModel(cm);
		this.table = new JTable(this.model);
		
		this.tUpdate.add(model);
        
        this.table.addMouseListener(new SharedListSelectionHandler(this.tUpdate, this.table, this.cm, false));
		
        this.add(new JScrollPane(table), BorderLayout.CENTER);
		}


		
	}