/**
 * 
 */
package GUI;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * @author jorn
 *
 */
public class Menue extends JMenuBar{
	
	public Menue(){
		JMenu file = new JMenu("File");
		this.add(file);
		JMenu info = new JMenu("Info");
		this.add(info);
	}

}
