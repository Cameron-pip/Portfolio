package hw7;

import edu.princeton.cs.algs4.StdOut;

public class IntList {
	private static class IntNode {
		private int data;
		private IntNode next;

		public IntNode(int d, IntNode n) {
			data = d;
			next = n;
		}
	}

	private IntNode first;

	public IntList() {
		first = null;
	}

	public IntList(int[] a) {
		first = null;
		for (int i = a.length - 1; i >= 0; i--)
			first = new IntNode(a[i], first);
	}

	public void insertAtFront(int item) {
		first = new IntNode(item, first);
	}

	public void printList() {
		for (IntNode current = first; current != null; current = current.next)
			StdOut.println(current.data);
	}

	public void printListR() {
		printListH(first);
	}

	private void printListH(IntNode l) {
		if (l == null)
			return;
		else {
			StdOut.println(l.data);
			printListH(l.next);
		}
	}

	public int sum() {
		int sum = 0;
		for (IntNode current = first; current != null; current = current.next)
			sum += current.data;
		return sum;
	}

	public int sumR() {
		return sumH(first);
	}

	private int sumH(IntNode n) {
		if (n == null)
			return 0;
		else {
			int temp = sumH(n.next);
			temp += n.data;
			return temp;
		}
	}

	public boolean contains(int target) {
		for (IntNode current = first; current != null; current = current.next)
			if (current.data == target)
				return true;
		return false;
	}

	public boolean containsR(int target) {
		return containsH(first, target);
	}

	private boolean containsH(IntNode n, int target) {
		if (n == null)
			return false;
		else {
			if (n.data == target)
				return true;
			boolean temp = containsH(n.next, target);
			return temp;
		}
	}

	public String toString() {
		if (first == null)
			return "";
		String result = "" + first.data;
		for (IntNode current = first.next; current != null; current = current.next)
			result = result + ", " + current.data;
		return result;
	}

	public String toStringR() {
		if (first == null)
			return "";
		return toStringH(first);
	}

	private String toStringH(IntNode n) {
		if (n.next == null) {
			return n.data + "";
		} else {
			String temp = toStringH(n.next);
			temp = n.data + ", " + temp;
			return temp;
		}
	}

	public void delete(int target) {
		IntNode current = first;
		if (first.data == target) {
			first = first.next;
			return;
		}
		while (current.next != null && current.next.data != target)
			current = current.next;
		if (current.next != null)
			current.next = current.next.next;
	}

	public void deleteR(int target) {
		first = deleteH(first, target);
	}

	private IntNode deleteH(IntNode n, int target) {
		if (n == null) {
			return null;
		} else if (n.data == target) {
			return n.next;
		} else {
			IntNode temp = deleteH(n.next, target);
			n.next = temp;
			return n;
		}
	}

	public void insertAtPosition(int position, int data) {
		throw new RuntimeException("Not implemented");
	}

	public void insertAtPositionR(int position, int data) {
		first = insertAtPositionH(first, position, data);
	}

	public IntNode insertAtPositionH(IntNode n, int position, int data) {
		if (n == null) {
			if (position == 0) {
				n = new IntNode(data, null);
				return n;
			} else {
				throw new IndexOutOfBoundsException();
			}
		} else if (position == 0) {
			IntNode temp = new IntNode(data, n);
			return temp;
		} else {
			IntNode temp = insertAtPositionH(n.next, position - 1, data);
			n.next = temp;
			return n;
		}
	}

	/******** New functions ********/

	/**
	 * Returns the first position in the list that contains <code>target</code> or
	 * -1 if <code>target</code> is not in the list. MUST USE A LOOP
	 * 
	 * @param target the data item to search for
	 * @return the first position that contains <code>target</code>.
	 */
	public int indexOf(int target) {
		int counter = 0;
		for (IntNode current = first; current != null; current = current.next) {
			if (current.data == target){
					return counter;
			}
			counter++;
		}
		return -1;
	}

	/**
	 * Returns the first position in the list that contains <code>target</code> or
	 * -1 if <code>target</code> is not in the list. CANNOT USE A LOOP
	 * 
	 * @param target the data item to search for
	 * @return the first position that contains <code>target</code>.
	 */
	public int indexOfR(int target) {
		return indexOfH(first, target, 0);
	}
	
	public int indexOfH(IntNode n, int target, int index) {
		if (n == null) {
			return -1;
		}
		else if(target == n.data) {
			return index;
		}
		else {
			return indexOfH(n.next, target, index+1);
		}
	}


	/**
	 * Inserts <code>data</code> at the end of the list. MUST USE A LOOP
	 * 
	 * @param data the data item to be inserted.
	 */
	public void insertAtBack(int data) {
		if (first == null) {
			first = new IntNode(data, null);
		}
		else {
			boolean i = false;
			for (IntNode current = first; current != null; current = current.next) {
				if(current.next == null && i == false) {
					current.next = new IntNode(data, null);
					i = true;
				}
			}
		}
	}

	/**
	 * Inserts <code>data</code> at the end of the list. CANNOT USE A LOOP
	 * 
	 * @param data the data item to be inserted.
	 */
	public void insertAtBackR(int data) {
		insertAtBackH(first, data);
	}
	
	public void insertAtBackH(IntNode n, int data) {
		if(first == null) {
			first = new IntNode(data, null);
		}
		else if(n.next == null)
			n.next = new IntNode(data, null);
		else
			insertAtBackH(n.next, data);
		
	}


	/**
	 * Removes the data item currently at the given position from the list. MUST USE
	 * A LOOP
	 * 
	 * @param position the index containing the data item to be deleted
	 * @throws IndexOutOfBoundsException if the given position is not a valid
	 *                                   position in the list.
	 */
	public void deleteFromPosition(int position) {
		if((position < 0)||(first == null)) {
			throw new IndexOutOfBoundsException();
		}
		else if(position == 0) {
			if(first.next == null) {
				first = null;
			}
			else {
				first = first.next;
			}
		}
		else if (position > 0) {
			int size = -1;
			for (IntNode current = first; current != null; current = current.next) {
				size++;
			}
			if(position > size) {
				throw new IndexOutOfBoundsException();
			}
		}
		try {
			int counter = 1;IntNode current = first;
			while (true) {
				if(counter == position) {
					if(current.next.next == null) {
						current.next = null;
						break;
					}
					else {
						current.next = current.next.next;
						break;
					}
				}
				counter++;
				if (current.next == null) {
					break;
				}
				current = current.next;
			}
		}
		catch(NullPointerException e) {
		}
	}
	


	/**
	 * Removes the data item currently at the given position from the list. CANNOT
	 * USE A LOOP
	 * 
	 * @param position the index containing the data item to be deleted
	 * @throws IndexOutOfBoundsException if the given position is not a valid
	 *                                   position in the list.
	 */
	public void deleteFromPositionR(int position) {
		deleteFromPositionH(first, position, 0);
	}
	
	public void deleteFromPositionH(IntNode n, int position, int intPos) {
		if((position < 0)||(n == null)) {
			throw new IndexOutOfBoundsException();
		}
		else if(position == 0) {
			first = n.next;
		}
		else if(n.next == null) {
			throw new IndexOutOfBoundsException();
		}
		else if(intPos+1 == position) {
			n.next = n.next.next;
		}
		
		else {
			deleteFromPositionH(n.next, position, intPos+1);
		}
	}



	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4 };
		IntList list = new IntList(data);
		StdOut.println(list.toStringR());
		for(int i = 4; i >= 0; i--) {
			list.insertAtPositionR(i,0);
			StdOut.println(list.toStringR());
		}
	}

}
