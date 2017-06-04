/**
 * 
 */
package GUI;

import rover.CommandList;
import rover.CommandType;
import rover.command.Direction;
import rover.command.Gear;
import rover.command.Pause;
import rover.command.Repetition;

/**
 * 
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//Sachen in ControlDeveloper geschrieben
		
		CommandType [] types = {new CommandType("Gear"), new CommandType("Direction"), new CommandType("Pause")};
	    // später Liste aus ControlModel
		
	//STRG 7
//		CommandList liste = new CommandList();
//	    liste.add(new Gear());
//	    liste.add(new Direction());
//	    liste.add(new Pause(4));
//	    liste.add(new Gear(3,8));
//	    liste.add(new Gear(5,2));
//		RoverView window = new RoverView(types, liste);
//	    Configuration window1 = new Configuration(new Gear());
//	    Configuration window2 = new Configuration(new Pause());
//	    Configuration window3 = new Configuration(new Direction());
//	    Configuration window4 = new Configuration(new Repetition());
//		window.setVisible(true);
//		window1.setVisible(true);
		//window2.setVisible(true);
		//window3.setVisible(true);
		//window4.setVisible(true);
		
	}

}
