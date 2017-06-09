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

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 *
 */
public class Buttons extends JPanel{

	//nur mal bisschen was hingeschrieben
	//mir ist nur noch nichts besseres eingefallen
	public Buttons(){
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,5,0,10);
				
		JButton remove = new JButton("Remove");
		this.add(remove, c);
		
		JButton up = new JButton("Up");
		c.gridx = 1;
		c.insets = new Insets(0,10,0,5);
		this.add(up, c);
		
		JButton down = new JButton("Down");
		c.gridx = 2;
		c.insets = new Insets(0,5,0,10);
		this.add(down, c);
		
		JButton start = new JButton("Start");
		c.gridx = 3;
		c.insets = new Insets(0,10,0,5);
		this.add(start, c);
		
		JButton stop = new JButton("Stop");
		c.gridx = 4;
		c.insets = new Insets(0,5,0,5);
		this.add(stop, c);
	}
}
