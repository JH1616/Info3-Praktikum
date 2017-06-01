/**
* Aufgabenblatt 1
* Aufgabe 3
* Bearbeitungsdauer:  min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/
package rover.command;
import hsrt.mec.controldeveloper.core.com.command.IPause;
/**
 * beschreibt ein Kommando-Objekt welches spaeter den Rover warten laesst
 */
public class Pause extends Command implements IPause{
	private double duration;

	

	/**
	 * Konstruktor
	 */
	public Pause() {
		super();
		setName("Pause");
	}


	

	/**
	 * @param duration
	 */
	public Pause(double duration) {
		super();
		setName("Pause");
		this.duration = duration;
	}



	

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}



	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}



	@Override
	/**
	 * damit die funktion toString sinnvolles Zeug enthaelt
	 */
	public String toString() {
		return "Pause [duration=" + duration + "]";
	}
	

}
