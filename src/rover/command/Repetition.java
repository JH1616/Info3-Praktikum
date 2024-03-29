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
import hsrt.mec.controldeveloper.core.com.command.IRepetition;

/**
 * noch nicht ganz klar wofuer die Klasse gut ist
 */
public class Repetition extends Command implements IRepetition{
	private int nrSteps;
	private int nrRepetitions;
	
	
	
	/**
	 * Konstruktor
	 */
	public Repetition() {
		super("Repetition");
	}
	
	

	/**
	 * @param nrSteps
	 * @param nrRepetitions
	 */
	public Repetition(int nrSteps, int nrRepetitions) {
		super("Repetition");
		this.nrSteps = nrSteps;
		this.nrRepetitions = nrRepetitions;
	}



	/**
	 * @return the nrSteps
	 */
	public int getNrSteps() {
		return nrSteps;
	}

	/**
	 * @param nrSteps the nrSteps to set
	 */
	public void setNrSteps(int nrSteps) {
		this.nrSteps = nrSteps;
	}

	/**
	 * @return the nrRepetitions
	 */
	public int getNrRepetitions() {
		return nrRepetitions;
	}

	/**
	 * @param nrRepetitions the nrRepetitions to set
	 */
	public void setNrRepetitions(int nrRepetitions) {
		this.nrRepetitions = nrRepetitions;
	}

	@Override
	/**
	 * damit die funktion toString sinnvolles Zeug ausgibt
	 */
	public String toString() {
		return "Repetition [nrSteps=" + this.nrSteps + ", nrRepetitions=" + this.nrRepetitions + "]";
	}


	
}
