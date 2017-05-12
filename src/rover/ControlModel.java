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
import rover.command.Command;
import rover.command.Direction;
import rover.command.Gear;
import rover.command.Pause;
import rover.command.Repetition;

/**
 * 
 *
 */
public class ControlModel {
	
	private static ControlModel instance=null;
	private CommandType[] commandTypes;
	private CommandList controlProcess;
	
	/**
	 * 
	 */
	private ControlModel(){
		commandTypes = new CommandType[4];
	}
	
	/**
	 * 
	 * @return
	 */
	public static ControlModel getInstance(){
		if (instance==null)
			instance = new ControlModel();
		return instance;
	}
	
	/**
	 * 
	 */
	public void createCommandTypes(){
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public boolean load(File f){
		
		return false;
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public boolean save (File f){
		
		return false;
	}
	
	/**
	 * 
	 * @param c
	 */
	public void commandPerformed(Command c){
		//bisher leer
	}
	
	/**
	 * 
	 * @return
	 */
	public CommandList getControlProcess(){
		return controlProcess;
	}
	

}
