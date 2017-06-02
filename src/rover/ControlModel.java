/**
* Aufgabenblatt 2
* Aufgabe 2
* Bearbeitungsdauer:  min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/
package rover;

import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;
import rover.command.Command;
import rover.command.Direction;
import rover.command.Gear;
import rover.command.Pause;
import rover.command.Repetition;

/**
 * 
 * Zentralverwaltung der Commands
 */
public class ControlModel {
	
	private static ControlModel instance=null;
	private CommandType[] commandTypes;
	private CommandList controlProcess;
	private IOType io_obj;
	
	/**
	 * 
	 */
	private ControlModel(){
		
		commandTypes = new CommandType[4];
		controlProcess = new CommandList();
		
	}
	
	/**
	 * 
	 * @return the instance
	 */
	public static ControlModel getInstance(){
		if (instance==null)
			instance = new ControlModel();
		return instance;
	}
	
	/**
	 * befuellt das Array CommandTypes
	 */
	public void createCommandTypes(){
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}
	
	/**
	 * auslesen der Commads aus dem File f und speichern in der verketteten Liste
	 * @param f
	 * @return true wenn erfolgreich, 
	 */
	public boolean load(File f){
	    
	    this.io_obj = new TextFile(f, false);
	    
	    Vector<String> data = new Vector<String>();
	    this.io_obj.read(data);
	    this.io_obj.close();
	
	    String[] zeile1;
	    
		for(String zeile : data){
			zeile1 = zeile.split(" ");
			String name = zeile1[0];
			
			for(int i = 1; i < zeile1.length; i+=1){
				zeile1[i] = (zeile1[i].split("="))[1];
				zeile1[i] = zeile1[i].replaceAll(",", "");
				zeile1[i] = zeile1[i].replaceAll("]", "");
			}
			
			if(name.equals("Gear")){
				controlProcess.add(new Gear(Integer.parseInt(zeile1[1]), Double.parseDouble(zeile1[2])));
			}
			else if(name.equals("Repetition")) {
				controlProcess.add(new Repetition(Integer.parseInt(zeile1[1]), Integer.parseInt(zeile1[2])));
			}
			else if(name.equals("Pause")){
				controlProcess.add(new Pause(Double.parseDouble(zeile1[1])));
			}
			else if(name.equals("Direction")){
				controlProcess.add(new Direction(Integer.parseInt(zeile1[1])));
			}
		}

		return true;
	}
	
	/**
	 * speichern der Commands in der verketteten Liste im File f
	 * @param f
	 * @return
	 */
	public boolean save (File f){
		
	    this.io_obj = new TextFile(f, false);		// false -> ueberschreiben
		
		Vector<String> data = new Vector<String>();
		
		for(int i = 0;  null != controlProcess.get(i); i+=1)
			data.add(controlProcess.get(i).toString());	
		
		this.io_obj.write(data);
		this.io_obj.close();
		return true;
	}
	
	/**
	 * 
	 * @param c
	 */
	public void commandPerformed(Command c){
		System.out.println(c.toString());
		//damit die Methode irgendwas macht
	}
	
	/**
	 * Zugriff auf verkettete Liste
	 * @return the controlProcess
	 */
	public CommandList getControlProcess(){
		return controlProcess;
	}
	
}
