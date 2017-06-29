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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 * Zentralverwaltung der Grafik
 *
 */
public class RoverView extends JFrame{
	
	private CommandTypesTable commandTypes;
	private CommandListTable commandList;

	
	/**
	 * Fenster mit Paneln wird erstellt und dimensioniert
	 * @param cm
	 */
	public RoverView(){
		
		this.setSize(600,400);
		this.setMinimumSize(new Dimension(500, 300));
		this.setTitle("Control Devloper");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JPanel pane = new JPanel(new GridBagLayout());
		this.add(pane);
		GridBagConstraints c = new GridBagConstraints();
		
		Menue menu = new Menue(this);
	    
	    
	    //natural height, maximum width
		c.anchor = GridBagConstraints.PAGE_START;
	    c.gridwidth = 2;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 1;
	    c.weighty = 0;
	    c.ipady = 30;
	    c.gridx = 0;
	    c.gridy = 0;
	    pane.add(menu, c);
	    
	    
	    c.gridwidth = 1;
	    c.ipadx = 120;//make this component tall
	    c.ipady = 60000;
	    c.weightx = 0.0;
	    c.weighty = 0.5;
	    c.gridx = 0;
	    c.gridy = 1;
	    commandTypes = new CommandTypesTable();
	    pane.add(commandTypes, c);

	    
	    c.weightx = 1;
	    c.weighty = 0.5;
	    c.gridx = 1;
	    c.gridy = 1;  
	    commandList = new CommandListTable();
	    pane.add(commandList, c);
	    

	    c.gridwidth = 2;
	    c.weightx = 0.0;
	    c.gridx = 0;
	    c.gridy = 3;
	    Konsole konsole = new Konsole();
	    pane.add(konsole, c);
	    
	    
	    //Buttons als eigenes Panel? -> Klasse Buttons
	    Buttons buttonList = new Buttons();
	    c.gridwidth = 2;
	    c.weighty = 0.0;
	    c.ipady = 10;
	    c.gridx = 0;
	    c.gridy = 2;
	    pane.add(buttonList, c);

		
	}


	
}
