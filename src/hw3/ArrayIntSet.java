package hw3;

public class ArrayIntSet {
	private int[] data;
	private int size;

	public ArrayIntSet(int capacity) {
		data = new int[capacity];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean contains(int i) {
		for (int index = 0; index < size; index++) {
			if (data[index] == i)
				return true;
		}
		return false;
	}

	// Ignore this equals method. Write the code for the other equals method.
	public boolean equals(Object otherObject) {
		ArrayIntSet other = (ArrayIntSet) otherObject;
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
		if(this.size() == data.length) {
			return false;
		}
		if (contains(element)) {
			return false;
		}
		this.size ++;
		data[this.size()-1] = element;
		return true;
	}

	/**
	 * Removes an element from the set.
	 * 
	 * @param element the element to be removed
	 * @return <code>ture</code> if the element was removed and <code>false</code>
	 *         otherwise.
	 */
	public boolean removeElement(int element) {
		if(this.size == 0) {
			return false;
		}
		if(contains(element) == false) {
			return false;
		}
		for(int x = 0; x < this.size(); x++) {
			if(data[x] == element) {
				data[x] = 0;
				data[x] = data[size()-1];
				size --;
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if <code>this</code> and <code>other</code> have the same
	 * elements and false otherwise.
	 * 
	 * @param other the set to compare against for equality
	 * @return true if <code>this</code> and <code>other</code> have the same
	 *         elements and false otherwise.
	 */
	public boolean equals(ArrayIntSet other) {
		if(size() == 0 && other.size() == 0) {
			return true;	
		}
		int counter = 0;
		for(int x: data) {
			for(int y: other.data) {
				if(x == y) {
					counter ++;
					if (counter == this.size() && counter == other.size()){
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Changes the set so that it is equal the union of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to union with
	 */
	public void union(ArrayIntSet other) {
		if(other.size != 0) {
			for(int x: other.data) {
				if(contains(x)== false) {
					addElement(x);
				}
			}
		}
	}
	/**
	 * Changes the set so that is equal the intersection of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to intersect with
	 */
	public void intersect(ArrayIntSet other) {
		for(int y: data) {
			if(other.contains(y) == false) {
				removeElement(y);
			}
		}
	}
}
