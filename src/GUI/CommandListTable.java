/**
* Aufgabenblatt 3
* Aufgabe 1
* Bearbeitungsdauer:  min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/
package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import rover.CommandList;
import rover.command.Command;
import rover.command.Direction;
import rover.command.Gear;

/**
 * 
 *
 */
public class CommandListTable extends JPanel{
	
	public CommandListTable (CommandList liste){
	//bisher BorderLayout - GridBagLayout sinnvoller wegen Buttons?
		super(new BorderLayout());
	
	//Verarbeitet Liste in rowData (ähnlich wie load Methode in ControlModel)
		String [][] rowData = new String[liste.getLength()][3];

		for (int i=0; i < liste.getLength() & liste.get(i)!=null; i++){
			String [] zeile = liste.get(i).toString().split(" ");
			rowData[i][0] = Integer.toString(i+1);
			rowData[i][1] = zeile[0];
			for(int j = 1; j < zeile.length; j+=1){
				zeile[j] = (zeile[j].split("="))[1];
				zeile[j] = zeile[j].replaceAll(",", "");
				zeile[j] = zeile[j].replaceAll("]", "");
			}
			if (zeile[0].equals("Gear"))
				rowData[i][2] = zeile[1]+ " cm/sec, "+zeile[2] + " sec";
			else if (zeile[0].equals("Repetition"))
				//Einheiten??
				rowData[i][2] = zeile[1]+ " Steps, "+ zeile[2]+ " repetitions";
			else if (zeile[0].equals("Pause"))
				rowData[i][2] = zeile[1]+" sec";
			else if (zeile[0].equals("Direction"))
				rowData[i][2] = zeile[1]+" Degree";
		}
		
	// Erstellen Tabelle mit Spaltennamen
		String[] header = {"No.", "Command", "Configuration"};
		JTable table = new JTable(rowData, header);
		
	    this.add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
}
