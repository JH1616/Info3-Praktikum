/**
 * 
 */
package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import rover.ControlModel;

/**
 *
 */
public class Konsole extends JPanel{
	private ControlModel cm;
	
	private JTextArea text;

	
	public Konsole (ControlModel cm){
		super(new BorderLayout());
		this.cm = cm;
		
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setText("test");
		
		this.add(new JScrollPane(text), BorderLayout.CENTER);
		}


		
	}