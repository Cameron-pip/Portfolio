package hw4;

public class LinkedIntSet {
	private static class Node {
		private int data;
		private Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node first;

	public LinkedIntSet() {
		first = null;
	}

	public int size() {
		int counter = 0;
		for (Node current = first; current != null; current = current.next)
			counter++;
		return counter;
	}

	public boolean contains(int i) {
		for (Node current = first; current != null; current = current.next) {
			if (current.data == i)
				return true;
		}
		return false;
	}

	// Ignore this equals method. Write the code for the other equals method.
	public boolean equals(Object otherObject) {
		LinkedIntSet other = (LinkedIntSet) otherObject;
		return this.equals(other);
	}

	/***************************** NEW METHODS ************************************/

	/**
	 * Adds <code>element</code> to this set if it is not already present and
	 * returns <code>true</code>. If <code>element</code> is already present, the
	 * set is unchanged and <code>false</code> is returned.
	 * 
	 * @param element the element to be added
	 * @return <code>true</code> if the element was added and <code>false</code>
	 *         otherwise.
	 */
	public boolean addElement(int element) {
		if (first == null) {
			first = new Node(element, null);
			return true;
		}
		if (contains(element))
			return false;
		first = new Node(element, first);
		return true;
	}

	/**
	 * Removes an element from the set.
	 * 
	 * @param element the element to be removed
	 * @return <code>true</code> if the element was removed and <code>false</code>
	 *         otherwise.
	 */
	public boolean removeElement(int element) {
		if(contains(element) == false)
			return false;
		int counter = 0;

		for (Node current = first; current != null; current = current.next) {
			if(current.data == element && counter < 1) {
				first = current.next;
				return true;
			}
			counter ++;
			if(current.next.data == element && current.next.next == null) {
				current.next = null;
				return true;
			}
			if(current.next.data == element) {
				current.next =  current.next.next;
				return true;
			}
		}


		return true;
	}

	/**
	 * Returns true if <code>this</code> and <code>other</code> have the same
	 * elements and false otherwise.
	 * 
	 * @param other the set to compare against for equality
	 * @return true if <code>this</code> and <code>other</code> have the same
	 *         elements and false otherwise.
	 */
	public boolean equals(LinkedIntSet other) {
		int count = 0;
		for (Node current = first; current != null; current = current.next) 
			for (Node secondary = other.first; secondary != null; secondary = secondary.next) 
				if(current.data == secondary.data) 
					count ++;
		if(count == size() && count == other.size())
			return true;
		return false;
	}

	/**
	 * Changes the set so that it is equal the union of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to union with
	 */
	public void union(LinkedIntSet other) {
		for (Node current = other.first; current != null; current = current.next) 
			addElement(current.data);
	}

	/**
	 * Changes the set so that is equal the intersection of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to intersect with
	 */
	public void intersect(LinkedIntSet other) {
		for (Node current = first; current != null; current = current.next) {
			if(other.contains(current.data) == false) {
				removeElement(current.data);
			}
		}
	}
}
