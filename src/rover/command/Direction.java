package rover.command;

/**
 * beschreibt ein Kommando-Objekt welches spaeter die Richtungsaenderung speichert
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
	 * damit die Funktion toString sinnvolles Zeug enthaelt
	 */
	public String toString() {
		return "Direction [degree=" + this.degree + "]";
	}

}
