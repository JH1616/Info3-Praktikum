/**
* Aufgabenblatt 2
* Aufgabe 2
* Bearbeitungsdauer:  min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/
package rover;

import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import GUI.Konsole;
import GUI.TableUpdater;
import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.IComListener;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;
import rover.command.Command;
import rover.command.Direction;
import rover.command.Gear;
import rover.command.Pause;
import rover.command.Repetition;

/**
 * 
 * Zentralverwaltung der Commands
 */
public class ControlModel implements IComListener{
	
	private static ControlModel instance=null;
	private CommandType[] commandTypes;
	private CommandList controlProcess;
	private IOType io_obj;
	private TableUpdater tUpdate;
	private int selectedRow;
	private Konsole konsole;
	private ComHandler comHandler;
	
	
	
	/**
	 * @param konsole the konsole to set
	 */
	public void setKonsole(Konsole konsole) {
		this.konsole = konsole;
	}



	/**
	 * 
	 */
	private ControlModel(){
		
		commandTypes = new CommandType[4];
		controlProcess = new CommandList();
		this.tUpdate = new TableUpdater();
		
		this.comHandler = ComHandler.getInstance();
		this.comHandler.register(this);

	}
	
	
	
	
	/**
	 * @return the comHandler
	 */
	public ComHandler getComHandler() {
		return comHandler;
	}



	/**
	 * @return the selectedRow
	 */
	public int getSelectedRow() {
		return selectedRow;
	}



	/**
	 * @param selectedRow the selectedRow to set
	 */
	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}



	/**
	 * 
	 * @return the instance
	 */
	public static ControlModel getInstance(){
		if (instance==null)
			instance = new ControlModel();
		return instance;
	}
	
	/**
	 * @return the tUpdate
	 */
	public TableUpdater gettUpdate() {
		return tUpdate;
	}
	
	/**
	 * befuellt das Array CommandTypes
	 */
	public void createCommandTypes(){
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}
	
	/**
	 * neue verketteten Liste
	 * @param f
	 * @return true wenn erfolgreich, 
	 */
	public boolean blanew(){
	    for(;controlProcess.remove(0););
	    
		return true;
	}
	
	/**
	 * auslesen der Commads aus dem File f und speichern in der verketteten Liste
	 * @param f
	 * @return true wenn erfolgreich, 
	 */
	public boolean load(File f){
	    
	    this.io_obj = new TextFile(f, false);
	    
	    Vector<String> data = new Vector<String>();
	    this.io_obj.read(data);
	    this.io_obj.close();
	
	    String[] zeile1;
	    blanew();
	    
		for(String zeile0 : data){
			String [] zeile = zeile0.split(" ");
			for(int j = 1; j < zeile.length; j+=1){
				zeile[j] = (zeile[j].split("="))[1];
				zeile[j] = zeile[j].replaceAll(",", "");
				zeile[j] = zeile[j].replaceAll("]", "");
			}
			
			if(zeile[0].equals("Gear")){
				controlProcess.add(new Gear(Integer.parseInt(zeile[1]), Double.parseDouble(zeile[2])));
			}
			else if(zeile[0].equals("Repetition")) {
				controlProcess.add(new Repetition(Integer.parseInt(zeile[1]), Integer.parseInt(zeile[2])));
			}
			else if(zeile[0].equals("Pause")){
				controlProcess.add(new Pause(Double.parseDouble(zeile[1])));
			}
			else if(zeile[0].equals("Direction")){
				controlProcess.add(new Direction(Integer.parseInt(zeile[1])));
			}
		}

		return true;
	}
	
	/**
	 * speichern der Commands in der verketteten Liste im File f
	 * @param f
	 * @return
	 */
	public boolean save (File f){
		
	    this.io_obj = new TextFile(f, false);		// false -> ueberschreiben
		
		Vector<String> data = new Vector<String>();
		
		for(int i = 0;  null != controlProcess.get(i); i+=1)
			data.add(controlProcess.get(i).toString());	
		
		this.io_obj.write(data);
		this.io_obj.close();
		return true;
	}
	
	/**
	 * 
	 * @param c
	 */
	public void commandPerformed(Command c){
		System.out.println(c.toString());
		//damit die Methode irgendwas macht
	}
	
	/**
	 * Zugriff auf verkettete Liste
	 * @return the controlProcess
	 */
	public CommandList getControlProcess(){
		return controlProcess;
	}

	/**
	 * @return the commandTypes
	 */
	public CommandType[] getCommandTypes() {
		return commandTypes;
	}



	@Override
	public void commandPerformed(ICommand arg0) {
		this.konsole.addText(arg0.toString());
		
	}
	
	
	
}
