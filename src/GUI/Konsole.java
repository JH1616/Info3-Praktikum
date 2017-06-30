/**
 * 
 */
package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import rover.ControlModel;

/**
 *
 */
public class Konsole extends JPanel{
	private ControlModel cm;
	
	private JTextArea text;
	private JScrollPane scroll;

	
	public Konsole (){
		super(new BorderLayout());
		this.cm = ControlModel.getInstance();
		this.cm.setKonsole(this);
		
		this.text = new JTextArea();
		this.text.setEditable(false);
		this.scroll = new JScrollPane(text);
		//this.scroll.setAutoscrolls(true);
		
		//this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.add(this.scroll, BorderLayout.CENTER);
		}

	public void addText(String ausgabe){
		this.text.append(ausgabe+"\n");
		this.scroll.getVerticalScrollBar().setValue(this.scroll.getVerticalScrollBar().getMaximum()+1);
	}

		
	}