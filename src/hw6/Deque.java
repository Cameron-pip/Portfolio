package hw6;

import java.util.NoSuchElementException;

/**
 * This is a skeleton file for your homework. Complete the functions below. You
 * may also edit the function "main" to test your code.
 * 
 * You should not use any loops or recursions.  Your code needs to run in
 * constant time.  It is OK if your testing code has loops (like in checkInvariants).
 *
 * You must not add fields or static variables. As always, you must not change
 * the declaration of any method nor the name of the class or of this file.
 */

public class Deque<T> {

	private Node<T> first;	// A reference to the first item in the Dequeue (or
							// null if empty)
	private Node<T> last;	// A reference to the last item in the Dequeue (or
							// null if empty)
	private int N; 			// The number of items currently in the Dequeue

	static class Node<T> {
		
		public T item;			// The data stored at this node.
		public Node<T> next;	// The node to the right (or null if there is no
								// node to the right)
		public Node<T> prev;	// The node to the left (or null if there is no
								// node to the left)
	}

	/**
	 * Construct an empty <code>Deque</code>.
	 */
	public Deque() {
		first = null;
		last = null;
		N = 0;
	}

	/**
	 * Tests if the <code>Dequeue</code> is empty.
	 * 
	 * @return <code>true</code> if this <code>Deque</code> is empty and false
	 *         otherwise.
	 */
	public boolean isEmpty() {
		if(N == 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns the number of items currenlty in this <code>Deque</code>.
	 * 
	 * @return the number of items currenlty in this <code>Deque</code>
	 */
	public int size() {
		return N;
	}

	/**
	 * Inserts an item into the front of this <code>Deque</code>.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void pushFront(T item) {
		if(N>0) {
			Node<T> oldFirst = first;
			first = new Node<T>();
			first.item = item;
			oldFirst.prev = first;
			first.next = oldFirst;
			N++;			
		}
		else if(N==0) {
			first = new Node<T>();
			last = first;
			first.item = item;
			N++;
		}
	}

	/**
	 * Inserts an item into the back of this <code>Deque</code>.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void pushBack(T item) {
		if(N>0) {
			Node<T> oldLast = last;
			last = new Node<T>();
			last.item = item;
			last.prev = oldLast;
			oldLast.next = last;
			N++;
		}
		else if(N==0) {
			first = new Node<T>();
			last = first;
			first.item = item;
			N++;			
		}
	}

	/**
	 * Removes and returns the item at the front of this <code>Deque</code>.
	 * 
	 * @return the item at the front of this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popFront() {
		if(N==0)
			throw new NoSuchElementException();
		else if(N==1) {
			Node<T> oldFirst = first;
			first = null;
			N--;
			return oldFirst.item;
		}
		else {
			Node<T> oldFirst = first;
			first = oldFirst.next;
			first.prev = null;
			N--;
			return oldFirst.item;
		}	
	}

	/**
	 * Removes and returns the item at the back of this <code>Deque</code>.
	 * 
	 * @return the item at the back this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popBack() {
		if(N==0)
			throw new NoSuchElementException();
		else if(N==1) {
			Node<T> oldLast = last;
			last = null;
			N--;
			return oldLast.item;
		}
		else {
			Node<T> oldLast = last;
			last = oldLast.prev;
			last.next = null;
			N--;
			return oldLast.item;
		}	
	}
}
