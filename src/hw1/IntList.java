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
 
    /* Constructs an IntList with the same sequenc of numbers */
    /* that appear in the array elements.                     */
    public IntList(int[] elements) {
        for(int i = elements.length-1; i >= 0; i--) {
            first = new IntNode(elements[i], first);
        }
    }
 
    /* Print out all the numbers in the list in order. */
    public void printOut() {
        for(IntNode current = first; current != null; current = current.next) {
            StdOut.print(current.number + " ");
        }
        StdOut.println();
    }
 
    /*
     * Reverse the order in which the numbers appear in the list.
     */
    public void reverse() {
        /* WRITE YOUR CODE FOR THIS METHOD IN THE BOX BELOW */
    }
 
    public static void main(String[] args) {
        int[] array = {9, -3, 1, 7};
        IntList list = new IntList(array);
        list.printOut();  // Prints out:        9 -3 1 7
        list.reverse();
        list.printOut();  // Should print out:  7 1 -3 9
        }
   }
}