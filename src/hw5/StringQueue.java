package hw5;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Stack;
// Stack API found at https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/Stack.html


public class StringQueue {
	//You may NOT add any more fields to this class.
	private Stack<String> stack1;
	private Stack<String> stack2;



	/**
	 * Initializes an empty queue.
	 */
	public StringQueue() {
		stack1 = new Stack<String>(); 
		stack2 = new Stack<String>();
	}

	/**
	 * Returns true if this queue is empty.
	 *
	 * @return {@code true} if this queue is empty; {@code false} otherwise
	 */
	public boolean isEmpty() {
		int counter = 0;
		try {
			stack1.push(stack2.pop());
			stack2.push(stack1.pop());
		}
		catch (NoSuchElementException e) {
			counter++;
		}
		try {
			stack2.push(stack1.pop());
			stack1.push(stack2.pop());
		}
		catch (NoSuchElementException e) {
			counter++;
		}
		if(counter == 2)
			return true;
		return false;
	}

	/**
	 * Returns the number of items in this queue.
	 *
	 * @return the number of items in this queue
	 */
	public int size() {
		int s1Count = 0;
		int s2Count = 0;
		int totalCount = 0;
		while(true) {
			try {
				stack2.push(stack1.pop());
				s1Count++; totalCount++;
			}
			catch (NoSuchElementException e) {
				while (s1Count > 0) {
					stack1.push(stack2.pop());
					s1Count--;
				}
				break;
			}
		}
		while(true) {
			try {
				stack1.push(stack2.pop());
				s2Count++; totalCount++;
			}
			catch (NoSuchElementException e) {
				while (s2Count > 0) {
					stack2.push(stack1.pop());
					s2Count--;
				}
				break;
			}

		}
		return totalCount;
		}
		


	/**
	 * Adds the item to this queue.
	 *
	 * @param  item the item to add
	 */
	public void enqueue(String item) {
		stack1.push(item);
	}

	/**
	 * Removes and returns the item on this queue that was least recently added.
	 * 
	 * @return the item on this queue that was least recently added
	 * @throws NoSuchElementException if the queue is empty
	 */
	public String dequeue() throws NoSuchElementException {
		String rVal = new String();
		if(isEmpty() == true) {
			throw new NoSuchElementException();
		}
		try {
			rVal = stack2.pop();
		}
		catch (NoSuchElementException e){
			while(true) {
				try {
					stack2.push(stack1.pop());
				}
				catch (NoSuchElementException e1) {
					rVal = stack2.pop();
					break;
				}
			}
		}
		return rVal;
	}
}
