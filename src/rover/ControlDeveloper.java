/**
* Aufgabenblatt 1
* Aufgabe 1
* Bearbeitungsdauer: 10 min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Jörn Hoffarth
* @version 1.0
*/

package rover;

/**
 * Beispiel zum Zeigen des Unterschieds zwischen Klasssen und Objekt -variablen
 */
public class ControlDeveloper {
	static String className = "Control-Developer"; //Klassenvariable
	String name = "Control-Developer"; //Objektvariable
	
	
	/**
	 * gibt den Namen der KlassenVariable zurueck
	 */
	public static String getName2() {
		return className;
	}

	
	/**
	 * setzt den Namen der KlassenVariable
	 */
	public static void setName2(String className) {
		ControlDeveloper.className = className;
	}

	
	/**
	 * gibt den Namen der Objektvariablen zurueck
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * setzt den Namen der Objektvariablen
	 */
	public void setName(String name) {
		//automatisch erzeugter setter
		this.name = name;
	}
	
	
	/**
	 * test main methode der Klasse ControlDeveloper
	 */
	public static void main(String[] args) {
		
		//direkte ausgabe von Klassenvariablen
		System.out.println(ControlDeveloper.className);
		//indirekte ausgabe von Klassenvariablen
		System.out.println(ControlDeveloper.getName2());
		
		//erzeugen eines testobjekts
		ControlDeveloper test = new ControlDeveloper();
		//direkte ausgabe von Objektvariablen
		System.out.println(test.name);
		//indirekte ausgabe von Objektvariablen
		System.out.println(test.getName());
		
	
	}

}
