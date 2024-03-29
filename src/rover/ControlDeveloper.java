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

package rover;

import java.io.File;

import GUI.Configuration;
import GUI.RoverView;
import GUI.TableUpdater;
import rover.command.Command;
import rover.command.Direction;
import rover.command.Gear;
import rover.command.Pause;
import rover.command.Repetition;

/**
 *erzeugt ein Array bestehend aus allen Kommandos
 */
public class ControlDeveloper {
	
	private Command [] commands;

	
	String name = "Control-Developer"; //Objektvariable

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
		this.name = name;
	}
	
	/**
	 * Konstruktor erzeugt 4stelliges Kommandoarray
	 */
	public ControlDeveloper(){
		this.commands = new Command[4];

	}
	
	/**
	 * Erzeugen von Command-Objekten im Array commands
	 */
	public void testCommands(){
		commands[0]= new Direction();
		commands[1]= new Gear();
		commands[2]= new Repetition();
		commands[3]= new Pause();
	}

	/**
	 * Ausgeben der Kommandos
	 */
	public void printCommands(){
		for (Command i : commands){
			if (i!=null){
				System.out.println(i.toString());
			}
		}
	}
	
	/**
	 * Testfunktion
	 */
	public static void main(String[] args){
		//ControlDeveloper test = new ControlDeveloper();
		//test.printCommands();
		//test.testCommands();
		//test.printCommands();
		
		/*ControlModel testCM = ControlModel.getInstance();		
		CommandList testCL = testCM.getControlProcess();
		testCL.add(new Repetition());
		testCL.add(new Repetition());
		testCL.add(new Gear());
		testCM.createCommandTypes();
		File f = new File("test.txt");
		testCM.save(f);
		
		testCM.load(f);
		
		for(int i = 0;  null != testCL.get(i); i+=1)
			System.out.println(testCL.get(i).toString());
			*/
		
		ControlModel testCM = ControlModel.getInstance();
		CommandList testCL = testCM.getControlProcess();
		testCM.createCommandTypes();
		
		CommandType[] testCT = testCM.getCommandTypes();
		
		testCL.add(new Gear());
		testCL.add(new Direction());
		testCL.add(new Pause(4));
		testCL.add(new Gear(3,8));
		testCL.add(new Gear(5,2));
		
		RoverView window = new RoverView();
		


		window.setVisible(true);

		
	}
	

}
