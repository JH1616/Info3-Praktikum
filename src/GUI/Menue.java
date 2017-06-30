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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
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

import hsrt.mec.controldeveloper.core.com.ComPort;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.SerialUSB;
import hsrt.mec.controldeveloper.io.TextFile;
import rover.ControlModel;

/**
 * MenueBar
 *
 */
public class Menue extends JMenuBar{
	private ControlModel cm;
	private JFrame frame;
	private JMenu portmenue;
	
	/**
	 * MenueBar mit Auswahlmoeglichkeiten und ActionListenern wird erstellt
	 * @param frame
	 */
	public Menue(JFrame frame){
		super();
		this.cm = ControlModel.getInstance();
		this.frame = frame;
		
		JMenu file = new JMenu("File");
		this.add(file);
		
		portmenue = new JMenu("Port");
		this.add(portmenue);
		portmenue.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {				
				// TODO Auto-generated method stub
				ComPort[] ports = cm.getComPortHandler().getPorts();
				portmenue.removeAll();
				JMenuItem toFile = new JMenuItem("toFile");
				portmenue.add(toFile);
				toFile.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						File f = new File("test.txt");
						cm.setSerial(new TextFile (f, false));
					}});
				portmenue.addSeparator();
				for(ComPort port : ports){
					JMenuItem item = new JMenuItem(port.getName());
					portmenue.add(item);
					item.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							cm.setSerial(new SerialUSB(port));
						}
					});
				}
			    System.out.println("hi");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
				
			}
		);
		
		JMenu info = new JMenu("Info");
		//this.add(info, GridBagConstraints.EAST);
		this.add(info);
		
		JMenuItem blanew = new JMenuItem("new");
		file.add(blanew);
		blanew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				cm.blanew();
			    cm.gettUpdate().update();
			    }
				
			}
		);
		
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
			       
			       String path = chooser.getCurrentDirectory().getAbsolutePath()+
			    		   "/"+chooser.getSelectedFile().getName() + ".txt";
			       System.out.println("You chose to Save this file: " + path);
			       File f = new File(path);
			       cm.save(f);
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
			    	String path = chooser.getCurrentDirectory().getAbsolutePath()+
				    		   "/"+chooser.getSelectedFile().getName();
				       System.out.println("You chose to load this file: " + path);
				       File f = new File(path);
				       cm.load(f);
				       cm.gettUpdate().update();
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
