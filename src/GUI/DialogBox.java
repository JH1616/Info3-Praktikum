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

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rover.command.Command;
import rover.command.Direction;
import rover.command.Gear;
import rover.command.Pause;
import rover.command.Repetition;

/**
 * 
 *
 */
public class DialogBox extends JOptionPane{
	
	private JTextField textField1;
	private JTextField textField2;
	JPanel pane;
	Command command;
	
	
	public DialogBox(Command command){
		
		this.command = command;
		textField1 = new JTextField(7);
		textField2 = new JTextField(7);
		
		pane = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();

		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		
		if (command.getName().equals("Gear")){
			label1.setText("Speed: ");
			label2.setText("Duration: ");
			textField1.setText("0");
			textField2.setText("0.0");
		}
		
		else if (command.getName().equals("Pause")){
			label1.setText("Duration: ");
			textField1.setText("0.0");
		}
		
		else if (command.getName().equals("Repetition")){
			label1.setText("nrSteps: ");
			label2.setText("nrRepetitions: ");
			textField1.setText("0");
			textField2.setText("0");
		}
		
		else if (command.getName().equals("Direction")){
			label1.setText("degree: ");
			textField1.setText("0");
		}
		
		pane.add(label1, c);
		c.gridx = 1;
		c.gridy = 0;
		pane.add(textField1, c);
		
		if (command.getName().equals("Gear") | command.getName().equals("Repetition")){
			c.gridx = 0;
			c.gridy = 1;
			pane.add(label2, c);
			c.gridx = 1;
			c.gridy = 1;
			pane.add(textField2, c);
		}
		
		show();
	}
	
	public void show(){
		int result = showConfirmDialog(null, pane, "Configuration", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			if (textField1.getText() == "");
				textField1.setText("0");
			if (textField2.getText() == "");
				textField2.setText("0");
			if (command.getName().equals("Gear")){
				((Gear) command).setSpeed(Integer.parseInt(textField1.getText()));
				((Gear) command).setDuration(Double.parseDouble(textField2.getText()));
			}
			
			else if (command.getName().equals("Pause")){
				((Pause) command).setDuration(Double.parseDouble(textField1.getText()));
			}
			
			else if (command.getName().equals("Repetition")){
				((Repetition) command).setNrSteps(Integer.parseInt(textField1.getText()));
				((Repetition) command).setNrRepetitions(Integer.parseInt(textField2.getText()));
			}
			
			else if (command.getName().equals("Direction")){
				((Direction) command).setDegree(Integer.parseInt(textField1.getText()));
			}
		}
		
		System.out.println(command.toString());
	}


	//Testen
	public static void main(String[] args) {

		DialogBox a = new DialogBox (new Gear());
	  }
}




