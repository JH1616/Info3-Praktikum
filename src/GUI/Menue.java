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

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import rover.ControlModel;

/**
 * 
 *
 */
public class Menue extends JMenuBar{
	private ControlModel cm;
	private JFrame frame;
	
	public Menue(ControlModel cm, JFrame frame){
		super();
		this.cm = cm;
		this.frame = frame;
		
		JMenu file = new JMenu("File");
		this.add(file);
		
		JMenu info = new JMenu("Info");
		this.add(info);
		
		
		JMenuItem save = new JMenuItem("save");
		file.add(save);
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			            "Textfiles", "txt");
			        chooser.setFileFilter(filter);
			    int returnVal = chooser.showSaveDialog(frame);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to Save this file: " +
			            chooser.getSelectedFile().getName());
			    }
				
			}
		});
		
		JMenuItem load = new JMenuItem("load");
		file.add(load);
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			            "Textfiles", "txt");
			        chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(frame);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			    }
			    }
		});		
		
		JMenuItem help = new JMenuItem("help");
		info.add(help);
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				URL url = null;
		        try {
		            url = new URL("http://www.gidf.de");
		        } catch (MalformedURLException c) {
		            c.printStackTrace();
		        }
		        if(Desktop.isDesktopSupported()){
		            try {
		                Desktop.getDesktop().browse(url.toURI());
		            } catch (IOException g) {
		                g.printStackTrace();
		            } catch (URISyntaxException f) {
		                f.printStackTrace();
		            }
		        }
				
			}
		});
		
	}

}
