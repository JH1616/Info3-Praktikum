/**
 * 
 */
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

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

	/**
	 * 
	 * @param update
	 * @param table
	 * @param inliste
	 */
	public SharedListSelectionHandler(TableUpdater update, JTable table, boolean inliste) {
		this.cm = ControlModel.getInstance();
		this.inliste = inliste;
		this.update = update;
		this.table = table;
	}

	/**
	 * einfacher Klick: falls Command in der Liste ist wird das ausgewaehlteCommand and ControlModel gegeben
	 *  
	 * Doppelklick: Command erstellen und Konfigurieren bzw konfigurieren falls Command schon in der Liste ist,Listen updaten
	 */
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 1) {
			if (inliste) {
				int row = table.getSelectedRow();
				cm.setSelectedRow(row);
				System.out.println("Table: " + row);
			}
		}

		if (e.getClickCount() == 2) {
			int row = table.getSelectedRow();

			System.out.println("doubleTable: " + row);
			Command cmd;
			if (inliste) {
				cmd = cm.getControlProcess().get(row);
			} else {
				cmd = cm.getCommandTypes()[row].createInstance();
			}

			DialogBox a = new DialogBox(cmd, this.inliste);
			this.update.update();
			cm.setSelectedRow(-1);

		}
	}
}