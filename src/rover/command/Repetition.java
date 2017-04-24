package rover.command;

/**
 * noch nicht klar was das später tut
 */
public class Repetition extends Command implements IRepetition{
	private int nrSteps;
	private int nrRepetitions;
	
	/**
	 * getter steps
	 */
	public int getNrSteps() {
		return this.nrSteps;
	}

	/**
	 * setter steps
	 */
	public void setNrSteps(int nrSteps) {
		this.nrSteps = nrSteps;
	}

	/**
	 * getter wiederholungen
	 */
	public int getNrRepetitions() {
		return nrRepetitions;
	}

	/**
	 * setter widerholungen 
	 */
	public void setNrRepetitions(int nrRepetitions) {
		this.nrRepetitions = nrRepetitions;
	}
	
	@Override
	/**
	 * damit die funktion toString sinnvolles Zeug enthält
	 */
	public String toString() {
		return "Repetition [nrSteps=" + this.nrSteps + ", nrRepetitions=" + this.nrRepetitions + "]";
	}

	/**
	 * Bis jetzt Sinnlos...
	 */
	public int getJumpAdress() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Bis jetzt Sinnlos...
	 */
	public int getNrRepetition() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
