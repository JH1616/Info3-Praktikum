package rover.command;

/**
 * beschreibt ein Kommando-Objekt welches später die Richtungsänderung speichert
 */
public class Direction extends Command implements IDirection{
	private int degree; //gradmaß

	/**
	 * getter in gradmaß
	 */
	public int getDegree() {
		return this.degree;
	}

	/**
	 * setter in gradmaß
	 */
	public void setDegree(int degree) {
		this.degree = degree;
	}	
	
	@Override
	/**
	 * damit die funktion toString sinnvolles Zeug enthält
	 */
	public String toString() {
		return "Direction [degree=" + this.degree + "]";
	}

}
