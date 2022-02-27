package DS1.hw1.copy;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HW1 {
	public static void main(String[] args) {
		StdOut.print("File to read in: ");
		String filename = StdIn.readLine();
		In infile = new In(filename);
		int[] numbers = infile.readAllInts();

		int total = sum(numbers);
		StdOut.println("The sum is: " + total);
		int max1 = largest(numbers);
		StdOut.println("The largest is: " + max1);
		int max2 = secondLargest(numbers);
		StdOut.println("The second largest is: " + max2);

		StdOut.println("\nCreating second array with only the even numbers.");
		int[] evens = getEvens(numbers);
		total = sum(evens);
		StdOut.println("The sum is: " + total);
		max1 = largest(evens);
		StdOut.println("The largest is: " + max1);
		max2 = secondLargest(evens);
		StdOut.println("The second largest is: " + max2);
	}

	private static int sum(int[] a) {
		int tot = 0;
		// for (int x : a)
		for(int i=0; i < a.length ; i++ ) {
			tot += a[i];
		}
		//StdOut.println(tot);
		return tot;
	}

	private static int largest(int[] a) {
		int large = -1;
		for (int x : a) {
			if (x >= large) {
				large = x;
			}
		}
		return large;
	}

	private static int secondLargest(int[] a) {
		int large = -1;
		int large2 = -1;
		for (int x : a) {
			if (x > large) {
				large = x;
				}
			else if (x > large2) {
				large2 = x;
			}
		}
		return large2;
	}

	private static int[] getEvens(int[] a) {
		int count = 0;
		for(int i=0; i < a.length ; i++ ) {
			if (a[i]%2 == 0) {
				count += 1;
			}
		}
		int evens[] = new int[count];
		for(int e=0; e < a.length ; e++ ) {
			if (a[e]%2 == 0) {
				count -= 1;
				evens[count] = a[e];
			}
		}
		return evens;
	}
}
