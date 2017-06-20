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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rover.ControlModel;
import rover.command.Command;
import rover.command.Direction;
import rover.command.Gear;
import rover.command.Pause;
import rover.command.Repetition;

/**
 * 
 * Konfiguration der Commands
 */
public class DialogBox extends JOptionPane {

	/**
	 * 
	 * @param command
	 * @param cm
	 * @param inList
	 */
	public DialogBox(Command command, ControlModel cm, boolean inList) {

		JTextField textField1 = new JTextField(7);
		JTextField textField2 = new JTextField(7);

		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;

		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();

		if (command.getName().equals("Gear")) {
			label1.setText("Speed: ");
			label2.setText("Duration: ");
			textField1.setText(Integer.toString(((Gear) command).getSpeed()));
			textField2.setText(Double.toString(((Gear) command).getDuration()));
		}

		else if (command.getName().equals("Pause")) {
			label1.setText("Duration: ");
			textField1.setText(Double.toString(((Pause) command).getDuration()));
		}

		else if (command.getName().equals("Repetition")) {
			label1.setText("nrSteps: ");
			label2.setText("nrRepetitions: ");
			textField1.setText(Integer.toString(((Repetition) command).getNrSteps()));
			textField2.setText(Integer.toString(((Repetition) command).getNrRepetitions()));
		}

		else if (command.getName().equals("Direction")) {
			label1.setText("degree: ");
			textField1.setText(Integer.toString(((Direction) command).getDegree()));
		}

		pane.add(label1, c);
		c.gridx = 1;
		c.gridy = 0;
		pane.add(textField1, c);

		if (command.getName().equals("Gear") | command.getName().equals("Repetition")) {
			c.gridx = 0;
			c.gridy = 1;
			pane.add(label2, c);
			c.gridx = 1;
			c.gridy = 1;
			pane.add(textField2, c);
		}

		int result = showConfirmDialog(null, pane, ("Configuration " + command.getName()),
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {

			/*
			 * if (textField1.getText().equals("")) textField1.setText("0"); if
			 * (textField2.getText().equals("")); textField2.setText("0");
			 */

			try {

				if (command.getName().equals("Gear")) {

					((Gear) command).setSpeed(Integer.parseInt(textField1.getText()));
					((Gear) command).setDuration(Double.parseDouble(textField2.getText()));
				}

				else if (command.getName().equals("Pause")) {
					((Pause) command).setDuration(Double.parseDouble(textField1.getText()));
				}

				else if (command.getName().equals("Repetition")) {
					((Repetition) command).setNrSteps(Integer.parseInt(textField1.getText()));
					((Repetition) command).setNrRepetitions(Integer.parseInt(textField2.getText()));
				}

				else if (command.getName().equals("Direction")) {
					((Direction) command).setDegree(Integer.parseInt(textField1.getText()));
				}
				
				if (!inList)
					cm.getControlProcess().add(command);
			} 
			catch (NumberFormatException e) {
				System.out.println("Falsch");
				DialogBox n = new DialogBox(command, cm, inList);
			}
		}

		System.out.println("\nListe: ");
		cm.getControlProcess().toString();
	}

}
