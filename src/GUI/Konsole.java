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

	
	public Konsole (){
		super(new BorderLayout());
		this.cm = ControlModel.getInstance();
		this.cm.setKonsole(this);
		
		JTextArea text = new JTextArea();
		text.setEditable(false);
		
		this.add(new JScrollPane(text), BorderLayout.CENTER);
		}

	public void addText(String ausgabe){
		text.append(ausgabe);
	}

		
	}