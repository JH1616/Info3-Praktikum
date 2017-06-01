/**
* Aufgabenblatt 1
* Aufgabe 2
* Bearbeitungsdauer:  min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/
package rover.command;
import hsrt.mec.controldeveloper.core.com.command.IDirection;

/**
 * beschreibt ein Kommando-Objekt welches spaeter die Richtungsaenderung speichert
 */
public class Direction extends Command implements IDirection{
	private int degree; //gradmaß
	
	
	
	public Direction() {
		super("Direction");
	}


	

	/**
	 * @param degree
	 */
	public Direction(int degree) {
		super("Direction");
		this.degree = degree;
	}




	/**
	 * @return the degree
	 */
	public int getDegree() {
		return degree;
	}



	/**
	 * @param degree the degree to set
	 */
	public void setDegree(int degree) {
		this.degree = degree;
	}


	@Override
	/**
	 * damit die Funktion toString sinnvolles Zeug enthaelt
	 */
	public String toString() {
		return "Direction [degree=" + this.degree + "]";
	}

}
