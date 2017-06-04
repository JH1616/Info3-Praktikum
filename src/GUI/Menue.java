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

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 *
 */
public class Menue extends JMenuBar{
	
	public Menue(){
		JMenu file = new JMenu("File");
		this.add(file);
		JMenuItem save = new JMenuItem("save");
		JMenuItem load = new JMenuItem("load");
		file.add(save);
		file.add(load);
		
		JMenu info = new JMenu("Info");
		this.add(info);
	}

}
