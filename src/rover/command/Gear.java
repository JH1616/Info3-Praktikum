package rover.command;

/**
 * beschreibt ein Kommando-Objekt welches später die Strecke und Geschwindigkeit speichert
 */
public class Gear extends Command implements IGear{
	private int speed;
	private double duration;
	
	/**
	 * Bis jetzt Sinnlos...
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * Bis jetzt Sinnlos...
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Bis jetzt Sinnlos...
	 */
	public double getDuration() {
		return this.duration;
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
		return "Gear [speed=" + this.speed + ", duration=" + this.duration + "]";
	}

}
