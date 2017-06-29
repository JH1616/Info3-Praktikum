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
 *	Tabelle mit allen Commands in der Liste
 */
public class CommandListTable extends JPanel{
	private ControlModel cm;
	
	private JTable table;
	private CommandListTableModel model;
	private TableUpdater tUpdate;

	/**
	 * 
	 */
	public CommandListTable (){
		super(new BorderLayout());
		this.cm = ControlModel.getInstance();
		this.tUpdate = cm.gettUpdate();
		
		this.model = new CommandListTableModel();
		this.table = new JTable(this.model);
		
		this.tUpdate.add(model);
		this.tUpdate.setTable(this.table);

		this.table.addMouseListener(new SharedListSelectionHandler(this.tUpdate, this.table, true));
		
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		}


		
	}