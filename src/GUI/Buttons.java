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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import rover.CommandList;
import rover.ControlModel;

/**
 * 
 *
 */
public class Buttons extends JPanel{
	private ControlModel cm;
	private CommandList liste;
	private JTable table;

	//nur mal bisschen was hingeschrieben
	//mir ist nur noch nichts besseres eingefallen
	public Buttons(ControlModel cm){
		super(new GridBagLayout());
		this.cm = cm;
		this.liste = cm.getControlProcess();
		this.table = this.cm.gettUpdate().getTable();
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,5,0,10);
				
		JButton remove = new JButton("Remove");
		this.add(remove, c);
		remove.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				liste.remove(cm.getSelectedRow());
				cm.gettUpdate().update();
				cm.setSelectedRow(-1);
			}
		});
		
		JButton up = new JButton("Up");
		c.gridx = 1;
		c.insets = new Insets(0,10,0,5);
		this.add(up, c);
		up.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = cm.getSelectedRow();
				if((row - 1) > -1 && (row - 1) < liste.getLength()){
					liste.moveUp(row);
					cm.gettUpdate().update();
					cm.setSelectedRow(row-1);
					table.setRowSelectionInterval(cm.getSelectedRow(), cm.getSelectedRow());
				}
			}
		});
		
		JButton down = new JButton("Down");
		c.gridx = 2;
		c.insets = new Insets(0,5,0,10);
		this.add(down, c);
		down.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = cm.getSelectedRow();
				if((row + 1) > -1 && (row + 1) < liste.getLength()){
					liste.moveDown(row);
					cm.gettUpdate().update();
					cm.setSelectedRow(row+1);
					table.setRowSelectionInterval(cm.getSelectedRow(), cm.getSelectedRow());
				}
			}
		});
		
		JButton start = new JButton("Start");
		c.gridx = 3;
		c.insets = new Insets(0,10,0,5);
		this.add(start, c);
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				cm.start();
			}
		});
		
		JButton stop = new JButton("Stop");
		c.gridx = 4;
		c.insets = new Insets(0,5,0,5);
		this.add(stop, c);
		stop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				cm.stop();
			}
		});
	}
}
