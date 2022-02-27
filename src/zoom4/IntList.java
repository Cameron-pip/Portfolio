package zoom4;

import edu.princeton.cs.algs4.StdOut;

public class IntList {
	private static class IntNode {
		private int number;
		private IntNode next;
		
		public IntNode(int number, IntNode next) {
			this.number = number;
			this.next = next;
		}
	}
	
	private IntNode first;
		
	public IntList(int[] elements) {
		for(int i = elements.length-1; i >= 0; i--) {
			// create a node for the number elements[i] and add it to the list at the front
			first = new IntNode(elements[i], first);
		}
	}
	
	public IntList() {
		first = null;
	}
	
	public void printOut() {
		// TODO
		throw new RuntimeException("Not Implemented");
	}
	
	public void insertAtFront(int newNumber) {
		// TODO
		throw new RuntimeException();
	}
	
	public int sum() {
		// TODO
		throw new RuntimeException("Not Implemented");
	}
	
	public boolean contains(int i) {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	
	public void deleteFromFront() {
		// TODO
		throw new RuntimeException("Not Implemented");
	}
	
	public void insertAtBack(int newNumber) {
		// TODO
		throw new RuntimeException("Not Implemented");
	}

	public void deleteFromBack() {
		// TODO
		throw new RuntimeException("Not Implemented");
	}
	
	public void incrementAll() {
		// TODO
		throw new RuntimeException("Not Implemented");
	}
	
	// How would you do the following?
	public void remove(int number) {
		// TODO (Homework)
		throw new RuntimeException("Not Implemented");
	}
	
	
	public static void main(String[] args) {
		int[] array = {9, -3, 1};
		IntList list = new IntList(array);
		list.printOut();
		StdOut.println("sum is " + list.sum());
		list.incrementAll();
		list.printOut();
		StdOut.println("sum is " + list.sum());
	}
}
