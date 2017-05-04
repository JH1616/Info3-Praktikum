package rover.command;

/**
 * beschreibt ein Kommando-Objekt welches spaeter den Rover warten laesst speichert
 */
public class Pause extends Command implements IPause{
	private double duration;

	/**
	 * Bis jetzt Sinnlos...
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * Bis jetzt Sinnlos...
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
