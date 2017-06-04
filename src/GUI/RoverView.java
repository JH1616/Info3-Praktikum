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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rover.CommandList;
import rover.CommandType;


/**
 * 
 *
 */
public class RoverView extends JFrame{
	
	public RoverView(CommandType[] liste1, CommandList liste2){
		this.setSize(600,400);
		this.setTitle("Control Devloper");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pane = new JPanel(new GridBagLayout());
		this.add(pane);
		GridBagConstraints c = new GridBagConstraints();
		
		Menue menu = new Menue();
	    
	    
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

	   // JButton button2 = new JButton("Long-Named Button 4");
	    c.gridwidth = 1;
	    c.ipadx = 120;//make this component tall
	    c.ipady = 60000;
	    c.weightx = 0.0;
	    c.weighty = 0.5;
	    c.gridx = 0;
	    c.gridy = 1;
	    
	    
	    CommandTypesTable table = new CommandTypesTable(liste1);
	    pane.add(table, c);

	    
	    
	    
	    JButton button = new JButton("Long-Named Button 5");
	    c.weightx = 1;
	    c.weighty = 0.5;
	    c.gridx = 1;
	    c.gridy = 1;
	    
	    CommandListTable table2 = new CommandListTable(liste2);
	    pane.add(table2, c);
	    
	    
	    button = new JButton("Long-Named Button 6");
	    c.gridwidth = 2;
	    c.weightx = 0.0;
	    c.gridx = 0;
	    c.gridy = 2;
	    pane.add(button, c);

	    
	    //this.pack();
		
		
	}

	
}
