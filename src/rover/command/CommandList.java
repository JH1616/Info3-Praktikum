/**
 * 
 */
package rover.command;

/**
 * @author jorn
 *
 */
public class CommandList {
	
	private Element root = null;
	private Element last = null;
	
	/**
	 * @param args Element hinten anhaengen
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
	 * @param args
	 */
	public boolean remove(int position){
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
	 * @param args
	 */
	public Command get(int position){
		Element jumper = this.root;
		
		for(int i = 0; i<position && jumper!=null; jumper = jumper.getNext()) i++;
		
		if(jumper == null) return null;
		
		return jumper.getCommand();
	}
	
	
	
	/**
	 * @param args
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
	 * @param args
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
	
	
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		try{
		return "CommandList [root=" + root.getCommand().toString() + ", last=" + last.getCommand().toString() + "]";
		}
		catch (NullPointerException e){
			return "CommandList is emty!";
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommandList test = new CommandList();
		
		test.add(new Gear());
		test.add(new Repetition());
		test.add(new Pause());
		
		System.out.println("Runde 1:");
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		
		System.out.println("Runde 2:");
		test.remove(2);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		
		System.out.println("Runde 3:");
		test.remove(1);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		
		System.out.println("Runde 4:");
		test.remove(0);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		
		System.out.println("Runde 5:");
		test.add(new Gear());
		test.add(new Repetition());
		test.add(new Pause());
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 6:");
		test.moveUp(3);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 7:");
		test.moveUp(2);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 8:");
		test.moveUp(1);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 9:");
		test.moveUp(0);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 10:");
		test.moveDown(0);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 11:");
		test.moveDown(1);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 12:");
		test.moveDown(2);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("Runde 13:");
		test.moveDown(3);
		for(int i=0; test.get(i) != null; i++){
			System.out.println(test.get(i).toString());
		}
		System.out.println(test);
		System.out.println("--------------------------------------------------------------------------");
	}

}


class Element {
	private Element next;
	private Element prev;
	private Command command;
	
	
	public Element(Element next, Element prev, Command command) {
		//super();
		this.next = next;
		this.prev = prev;
		this.command = command;
		
		if(this.prev!=null){
			this.prev.setNext(this);
		}
	}


	
	
	
	/**
	 * @return the next
	 */
	public Element getNext() {
		return next;
	}





	/**
	 * @param next the next to set
	 */
	public void setNext(Element next) {
		this.next = next;
	}





	/**
	 * @return the prev
	 */
	public Element getPrev() {
		return prev;
	}





	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Element prev) {
		this.prev = prev;
	}





	/**
	 * @return the element
	 */
	public Command getCommand() {
		return this.command;
	}


	/**
	 * @param element the element to set
	 */
	public void setCommand(Command element) {
		this.command = element;
	}
	
	
}