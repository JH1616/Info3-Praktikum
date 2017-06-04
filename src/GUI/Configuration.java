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


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rover.command.Command;


/**
 * Fenster für die Konfiguration der Kommandos
 *
 */
public class Configuration extends JFrame{
	
	private JTextField textField1;
	private JTextField textField2;
	private JButton button1;
	
	public Configuration(Command command){
	//Allgemeine Konfiguration Fenster
		this.setSize(300, 150);
		this.setTitle("Configuration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel(new GridBagLayout());
		this.add(pane);
		GridBagConstraints c = new GridBagConstraints();
		
		//CommandType.getName()
		
	//Save-Button
		button1 = new JButton ("Save");
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.CENTER;
		
		pane.add(button1, c);
		
	//Labels und TextFields
		textField1 = new JTextField(10);
		textField2 = new JTextField(10);
		
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		pane.add(textField1, c);
		
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		
		if (command.getName().equals("Gear")){
			label1.setText("Speed: ");
			label2.setText("Duration: ");
		}
		
		else if (command.getName().equals("Pause")){
			label1.setText("Duration: ");
		}
		
		else if (command.getName().equals("Repetition")){
			label1.setText("nrSteps: ");
			label2.setText("nrRepetitions: ");
		}
		
		else if (command.getName().equals("Direction")){
			label1.setText("degree: ");
		}
		
		if (command.getName().equals("Gear") | command.getName().equals("Repetition")){
			c.gridx = 1;
			c.gridy = 2;
			pane.add(textField2, c);
			c.gridx = 0;
			c.gridy = 2;
			pane.add(label2, c);
		}
		
		c.gridx = 0;
		c.gridy = 1;
		pane.add(label1, c);
		
	}

}
