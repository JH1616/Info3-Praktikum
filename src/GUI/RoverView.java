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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rover.CommandList;
import rover.CommandType;
import rover.ControlModel;


/**
 * 
 *
 */
public class RoverView extends JFrame{
	private ControlModel cm;
	
	private CommandTypesTable commandTypes;
	private CommandListTable commandList;

	
	public RoverView(ControlModel cm){
		this.cm = cm;
		
		this.setSize(600,400);
		this.setMinimumSize(new Dimension(500, 300));
		this.setTitle("Control Devloper");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JPanel pane = new JPanel(new GridBagLayout());
		this.add(pane);
		GridBagConstraints c = new GridBagConstraints();
		
		Menue menu = new Menue(cm, this);
	    
	    
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
	    commandTypes = new CommandTypesTable(cm);
	    pane.add(commandTypes, c);

	    
	    c.weightx = 1;
	    c.weighty = 0.5;
	    c.gridx = 1;
	    c.gridy = 1;  
	    commandList = new CommandListTable(cm);
	    pane.add(commandList, c);
	    

	    c.gridwidth = 2;
	    c.weightx = 0.0;
	    c.gridx = 0;
	    c.gridy = 3;
	    //JButton button = new JButton("Long-Named Button 6");
	    //JTextField button = new JTextField();
	    Konsole konsole = new Konsole(cm);
	    pane.add(konsole, c);
	    
	    
	    //Buttons als eigenes Panel? -> Klasse Buttons
	    Buttons buttonList = new Buttons(cm);
	    c.gridwidth = 2;
	    c.weighty = 0.0;
	    c.ipady = 10;
	    c.gridx = 0;
	    c.gridy = 2;
	    pane.add(buttonList, c);

		
	}


	
}
