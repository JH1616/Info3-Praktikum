/**
* Aufgabenblatt 1
* Aufgabe 4
* Bearbeitungsdauer:  min
* Bemerkungen:
*    keine
*
* @author Lydia Eicher & Joern Hoffarth
* @version 1.0
*/
package rover;

import rover.command.Command;
import rover.command.Gear;
import rover.command.Pause;
import rover.command.Repetition;

/**
 * Erstellt eine Liste aus Kommandos
 *
 */
public class CommandList {
	
	private Element root = null;
	private Element last = null;
	
	/**
	 * haengt ein Kommandoobjekt an die liste hinten an
	 */
	public boolean add(Command command){
		if(this.last == null){
			this.root = new Element(null, null, command);
			this.last = this.root;
		}
		else{
			this.last = new Element(null, this.last, command);
		}
		
		return true;
	}
	
	
	/**
	 * loescht das n.-Kommando
	 */
	public boolean remove(int position){
		if (position < 0) return false;
		
		Element jumper = this.root;

		for(int i = 0; i<position && jumper!=null; jumper = jumper.getNext()) i++;
		
		if (jumper == null) return false;
		
		if (jumper.getPrev() == null){
			if (jumper.getNext() == null){
				this.root = null;
				this.last = null;
				return true;
			} 
			this.root=jumper.getNext();
			jumper.getNext().setPrev(null);
			return true;
		}
		
		if (jumper.getNext() == null){
			this.last=jumper.getPrev();
			jumper.getPrev().setNext(null);
			return true;
		}
		
		jumper.getPrev().setNext(jumper.getNext());
		jumper.getNext().setPrev(jumper.getPrev());
					
		return true;
	}
	
	
	
	/**
	 * gibt das n.-Kommando zurueck
	 */
	public Command get(int position){
		Element jumper = this.root;
		
		for(int i = 0; i<position && jumper!=null; jumper = jumper.getNext()) i++;
		
		if(jumper == null) return null;
		
		return jumper.getCommand();
	}
	
	
	
	/**
	 * verschiebt das n.-Kommando eine Stelle nach hinten
	 */
	public boolean moveDown(int position){
		Element jumper = this.root;
		
		for(int i = 0; i<position && jumper!=null; jumper = jumper.getNext()) i++;
		
		if (jumper == null) return false;
		if (jumper.getNext() == null) return false;
		if (jumper.getNext().getNext() == null) this.last = jumper;
		
		Element save1 = jumper.getNext().getNext();
		jumper.getNext().setNext(jumper);
		jumper.getNext().setPrev(jumper.getPrev());
		
		if(jumper.getPrev()==null)
			this.root = jumper.getNext();
		else
			jumper.getPrev().setNext(jumper.getNext());	
		
		
		jumper.setPrev(jumper.getNext());
		jumper.setNext(save1);
		if(save1!=null) save1.setPrev(jumper);
					
		return true;
	}
	
	

	/**
	 * verschiebt das n.-Kommando eine Stelle nach vorne
	 */
	public boolean moveUp(int position){
		Element jumper = this.root;
		
		for(int i = 0; i<position && jumper!=null; jumper = jumper.getNext()) i++;
		
		if (jumper == null) return false;
		if (jumper.getPrev() == null) return false;
		if (jumper.getPrev().getPrev() == null) this.root = jumper;
		
		
		Element save1 = jumper.getPrev().getPrev();
		jumper.getPrev().setPrev(jumper);
		jumper.getPrev().setNext(jumper.getNext());
		
		if(jumper.getNext()==null)
			this.last = jumper.getPrev();
		else
			jumper.getNext().setPrev(jumper.getPrev());	
		
		jumper.setNext(jumper.getPrev());
		jumper.setPrev(save1);
		
		if(save1!=null) save1.setNext(jumper);
		
					
		return true;
	}
	
	
		
	/**
	 * gibt alle Kommandos zurueck. Fuer leere liste CommandList is emty.
	 */
	@Override
	public String toString() {
		try{
			for(int i=0; this.get(i) != null; i++){
				System.out.println(this.get(i).toString());
			}
			return "CommandList [root=" + root.getCommand().toString() + ", last=" + last.getCommand().toString() + "]";
		}
		catch (NullPointerException e){
			return "CommandList is emty!";
		}
	}


	/**
	 * test Funktion fuer die eigene Klasse
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommandList test = new CommandList();
		
		test.add(new Gear());
		test.add(new Repetition());
		test.add(new Pause());
		System.out.println("Runde 1:");
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		
		System.out.println("Runde 2:");
		test.remove(2);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		
		System.out.println("Runde 3:");
		test.remove(1);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		
		System.out.println("Runde 4:");
		test.remove(0);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		
		System.out.println("Runde 5:");
		test.add(new Gear());
		test.add(new Repetition());
		test.add(new Pause());
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 6:");
		test.moveUp(3);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 7:");
		test.moveUp(2);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 8:");
		test.moveUp(1);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 9:");
		test.moveUp(0);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 10:");
		test.moveDown(0);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 11:");
		test.moveDown(1);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 12:");
		test.moveDown(2);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 13:");
		test.moveDown(3);
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
	}

}


class Element {
	private Element next;
	private Element prev;
	private Command command;
	
	
	public Element(Element next, Element prev, Command command) {
		this.next = next;
		this.prev = prev;
		this.command = command;
		
		if(this.prev!=null){
			this.prev.setNext(this);
		}
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element next) {
		this.next = next;
	}

	public Element getPrev() {
		return prev;
	}

	public void setPrev(Element prev) {
		this.prev = prev;
	}

	public Command getCommand() {
		return this.command;
	}

	public void setCommand(Command element) {
		this.command = element;
	}
	
	
}