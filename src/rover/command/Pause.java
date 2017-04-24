package rover.command;

/**
 * beschreibt ein Kommando-Objekt welches später den Rover warten läst speichert
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
	 * damit die funktion toString sinnvolles Zeug enthält
	 */
	public String toString() {
		return "Pause [duration=" + duration + "]";
	}
	

}
