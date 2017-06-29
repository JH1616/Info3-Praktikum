/**
* Aufgabenblatt 2
* Aufgabe 1
* Bearbeitungsdauer:  min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/
package rover;

import hsrt.mec.controldeveloper.core.com.command.ICommand;
import rover.command.Command;
import rover.command.Direction;
import rover.command.Gear;
import rover.command.Pause;
import rover.command.Repetition;

/**
 * 
 *
 */
public class CommandType implements ICommand{
	
	private String name;
	
	/**
	 * 
	 * @param name
	 */
	public CommandType(String name){
		this.name=name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * erstellt Command (je nach Name)
	 * @return the command
	 */
	public Command createInstance(){
		if (name == "Direction")
			return new Direction();
		if (name == "Gear")
			return new Gear();
		if (name == "Repetition")
			return new Repetition();
		if (name == "Pause")
			return new Pause();
		return null;
	}


}
