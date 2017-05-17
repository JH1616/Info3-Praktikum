/**
* Aufgabenblatt 1
* Aufgabe 2
* Bearbeitungsdauer: min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/

package rover.command;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * super Klasse fuer aller Kommandos
 */
public abstract class Command implements ICommand{
	private String name;

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


	

}
