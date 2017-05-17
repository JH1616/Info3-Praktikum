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
import hsrt.mec.controldeveloper.core.com.command.IGear;

/**
 * beschreibt ein Kommando-Objekt welches spaeter die Strecke und Geschwindigkeit speichert
 */
public class Gear extends Command implements IGear{
	private int speed;
	private double duration;
	



	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}




	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
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
		return "Gear [speed=" + this.speed + ", duration=" + this.duration + "]";
	}

}
