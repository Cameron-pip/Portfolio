package zoom4;

import edu.princeton.cs.algs4.StdOut;

public class IntNode2 {
	private int number;
	private IntNode2 next;
	
	public IntNode2(int number, IntNode2 next) {
		this.number = number;
		this.next = next;
	}
	
	public static void main(String[] args) {
		IntNode2 firstNode = new IntNode2(333, null);
		firstNode = new IntNode2(22, firstNode);
		firstNode = new IntNode2(1, firstNode);
		// Print out the value of the third node
		
		
		// Change the value of the second node from 22 to 20
		
		
		// Insert a node with value 10 between the 1 and the 20 (between 1st and 2nd nodes)
		
				
		// Print out all the numbers in the list
		
	}
}
