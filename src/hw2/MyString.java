package hw2;

/**
 * 
 * A class that mimics how Java's String class behaves without using the String class
 * in any way.
 *
 */
public class MyString {
	private char[] data;
	
	/**
	 * Construcs a <code>MyString</code> object to represent the text in
	 * <code>string</code>
	 * @param string a <code>char</code> array containing the characters
	 * 		  of the text we are representing.
	 */
	public MyString(char[] string) {
		data = string;
	}

	public char charAt(int i) {
		return data[i];
	}

	public int length() {
		return data.length;
	}

	/**
	 * Returns the index of the first occurrence of c in the MyString if
	 * c is present; otherwise, -1 is returned.
	 * 
	 * @param c the character to find
	 * @return the index of the first occurrence of c in the MyString if
	 * c is present; otherwise, -1 is returned.
	 */
	public int indexOf(char c) {
		for(int letter=0; letter < data.length ; letter++ ) {
			if (data[letter] == c) {
				return letter;
			}
		}
		return -1;
	}

	/**
	 * Returns true if <code>this</code> MyString and <code>other</code> reresent
	 * the same string (have the same characters at the same positions) and false
	 * otherwise.
	 * 
	 * @param other the other <code>MyString</code> to compare with.
	 * @return true if <code>this</code> MyString and <code>other</code> reresent
	 * the same string (have the same characters at the same positions) and false
	 * otherwise.
	 */
	public boolean equals(MyString other) {
		if (data.length != other.data.length) {
			return false;
		}
		for (int letter=0; letter < data.length ; letter++ ) {
			if (data[letter] != other.data[letter]) {
				return false;
			}
		}
		return true;
		}
		
		
		/**if (data.equals(other.data)) {
			return true;
		}
		else {
			return false;
		}
		}
		 */
	
	/**
	 * A lexicographical comparison of <code>this MyString</code> to <code>other</code>.
	 * The comparison is case sensitive, meaning it might not return the correct answer
	 * if the text being compared isn't all the same case.
	 * 
	 * @param other the <code>MyString<code> to compare against.
	 * @return a negative number if <code>this</code> appears before <code>other</code>
	 * in the dictionary, a positive number if <code>this</code> appears after
	 * <code>other</code> in the dictonary, and 0 if <code>this</code> and <code>other</code>
	 * represent the same <code>String</code>
	 */
	public int compareTo(MyString other) {
		if (data.length == other.data.length) {
			for (int letter=0; letter < data.length; letter++) {
				if(data[letter] > other.data[letter]) {
					return 1;
				}
				else if(data[letter] < other.data[letter]) {
					return -1;
				}
			}
		}
		else if (data.length > other.data.length) {
			return 1;
		}
		else if (data.length < other.data.length) {
			return -1;
		}
		return 0;
	}
	
	/**
	 * Returns a <code>MyString</code> resulting from replacing all occurrences of <code>oldChar</code>
	 * in this string with <code>newChar</code>.  If the character <code>oldChar</code> does not occur
	 * in the character sequence represented by this <code>MyString</code> object, then a reference to
	 * this <code>MyString</code> object is returned. Otherwise, a <code>MyString</code> object is
	 * returned that represents a character sequence identical to the character sequence represented by
	 * this <code>MyString</code> object, except that every occurrence of <code>oldChar</code> is
	 * replaced by an occurrence of <code>newChar</code>.
	 * @param oldChar the old character
	 * @param newChar the new character
	 * @return a <code>MyString</code> resulting from replacing all occurrences of <code>oldChar</code>
	 * in this string with <code>newChar</code>
	 */
	public MyString replace(char oldChar, char newChar) {
		MyString replaced = new MyString(data);
		replaced.data = data;
		
		for(int letter=0; letter < replaced.data.length; letter++) {
			if (replaced.data[letter] == oldChar) {
				replaced.data[letter] = newChar;
			}
		}
		return replaced;
	}
}
