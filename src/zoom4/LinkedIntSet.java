package zoom4;

import edu.princeton.cs.algs4.StdOut;

public class LinkedIntSet {
	private static class IntNode {
		private int number;
		private IntNode next;

		public IntNode(int number, IntNode next) {
			this.number = number;
			this.next = next;
		}
	}

	private IntNode first;
	
	// hasDuplicate from HW2 but for int[] instead of String[]
	private boolean hasDuplicate(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j])
					return true;
			}
		}
		return false;
	}

	public LinkedIntSet(int[] elements) {
		if (hasDuplicate(elements)) {
			throw new IllegalArgumentException("The array contains duplicates");
		}
		// TODO 
		throw new RuntimeException("Not implemented");
	}

	public int size() {
		// TODO
		throw new RuntimeException("Not implemented");
	}

	public boolean contains(int i) {
		// TODO
		throw new RuntimeException("Not implemented");
	}


	public static void main(String[] args) {
		int[] array = { 9, -3, 1 };
		LinkedIntSet set = new LinkedIntSet(array);
		for (int i = -10; i <= 10; i++) {
			if (set.contains(i)) {
				StdOut.printf("set contains %d%n", i);
			}
		}
		StdOut.printf("set.size() = %d%n", set.size());
	}
}
