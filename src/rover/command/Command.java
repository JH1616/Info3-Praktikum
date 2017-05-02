/**
* Aufgabenblatt 1
* Aufgabe 2
* Bearbeitungsdauer: 60 min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Jörn Hoffarth
* @version 1.0
*/

package rover.command;

/**
 * super Klasse für aller Kommandos
 */
public abstract class Command implements ICommand{
	private String name;

	/**
	 * getter...
	 */
	public String getName() {
		return name;
	}
	

}
