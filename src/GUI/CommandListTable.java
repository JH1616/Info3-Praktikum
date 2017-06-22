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
public class CommandListTable extends JPanel{
	private ControlModel cm;
	
	private JTable table;
	private CommandListTableModel model;
	private TableUpdater tUpdate;

	
	public CommandListTable (ControlModel cm){
		super(new BorderLayout());
		this.cm = cm;
		this.tUpdate = cm.gettUpdate();
		
		this.model = new CommandListTableModel(cm);
		this.table = new JTable(this.model);
		
		this.tUpdate.add(model);
		this.tUpdate.setTable(this.table);

		this.table.addMouseListener(new SharedListSelectionHandler(this.tUpdate, this.table, this.cm, true));
		
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		}


		
	}