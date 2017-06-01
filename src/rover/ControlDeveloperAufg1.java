/**
* Aufgabenblatt 1
* Aufgabe 1
* Bearbeitungsdauer: min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/

package rover;

/**
 * Beispiel zum Zeigen des Unterschieds zwischen Klasssen und Objekt -variablen
 */
public class ControlDeveloperAufg1 {
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
		ControlDeveloperAufg1.className = className;
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
	 * Testfunktion
	 */
	public static void main(String[] args) {
		
		//direkte ausgabe von Klassenvariablen
		System.out.println(ControlDeveloperAufg1.className);
		//indirekte ausgabe von Klassenvariablen
		System.out.println(ControlDeveloperAufg1.getName2());
		
		//erzeugen eines testobjekts
		ControlDeveloperAufg1 test = new ControlDeveloperAufg1();
		//direkte ausgabe von Objektvariablen
		System.out.println(test.name);
		//indirekte ausgabe von Objektvariablen
		System.out.println(test.getName());
		
	
	}

}
