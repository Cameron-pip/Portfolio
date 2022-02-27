package hw2;

public class CheckStrings {
	/**
	 * Returns true if the Strings in w appear in sorted order
	 * (alphabetical order) and false otherwise.
	 * 
	 * @param w the array of Strings to check
	 * @return true if the Strings in w appear in sorted order
	 * and false otherwise.
	 */
	public static boolean isSorted(String[] w) {
		// TODO - Replace line below with correct code.
		for(int word=0; word < w.length - 1 ; word++ ) {
			int x = w[word].compareToIgnoreCase(w[word+1]);
			if (x > 0){
				return false;
			}
					
						
	}
		return true;
	
	}
	/**
	 * Returns true if at least one String in w appears more than once
	 * and false otherwise.
	 * 
	 * @param w the array of Strings to check
	 * @return true if at least one String in w appears more than once
	 * and false otherwise.
	 */
	public static boolean hasDuplicate(String[] w) {
		// TODO - Replace line below with correct code.
		for(int word=0; word < w.length ; word++ ) {
			int counter = 0;
			for (String a: w) { 
				if (w[word] == a) {
					counter ++; 
				}
				if (counter == 2) {
					return true;
				}	
			}
		}
		return false;
	}
}
