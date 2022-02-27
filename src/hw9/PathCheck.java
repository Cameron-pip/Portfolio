package hw9;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * A class used to determine if a path exists from the top of a grid to the bottom
 */
public class PathCheck {

	// IMPORTANT:
	// Use the uf field below to help you solve the problem.
	// Note, however, that this one field is not enough.
	// You will need to have additional fields, but you must use
	// the uf field in solving the problem.
	private WeightedQuickUnionUF uf;
	private int[] prevSelected;
	private int size;
	private int length;
	
	/**
	 * Models an initial <code>size</code> by <code>size</code> grid with no cells selected.
	 * 
	 * @param size the length and width of the grid.
	 */
	public PathCheck(int size) {
		uf = new WeightedQuickUnionUF(2+(size*size));
		prevSelected = new int[size*size];
		length = 0;
		this.size = size;
	}
		
	/**
	 * Selects the cell in given <code>row</code> and <code>col</code> and returns
	 * <code>true<code> if there is a path of selected cells from the top of the grid
	 * to the bottom, and <code>false</code> otherwise.
	 * 
	 * @param row the row of the cell to be selected.
	 * @param col the column of the cell to be selected.
	 * @return <code>true<code> if there is a path of selected cells from the top of the grid
	 * to the bottom, and <code>false</code> otherwise.
	 * @throws IllegalArgumentException if either <code>row</code> or <code>col</code> is
	 * out of bounds (greater than or equal to size or negative).
	 * */
	
	public boolean select(int row, int col) throws IllegalArgumentException {
		
		if(row < 0 || row >= size || col < 0 || col >= size)
			throw new IllegalArgumentException();
		
		int selected = col + (row * size);
		int up = col + ((row-1) * size);
		int down = col + ((row+1) * size);
		int left = col-1 + (row * size);
		int right = col+1 + (row * size);
		
		if(up < 0) 
			uf.union(selected, (size*size));
		else for(int i = 0; i < length; i++)
			if (prevSelected[i] == up)
		        uf.union(up, selected);
		
		if(down > (size*size)-1) 
			uf.union(selected, (size*size)+1);
		else for(int i = 0; i < length; i++)
			if (prevSelected[i] == down)
		        uf.union(down, selected);
		
		if(col != 0)
			for(int i = 0; i < length; i++)
				if (prevSelected[i] == left)
			        uf.union(left, selected);
			
		if(col != size-1)
			for(int i = 0; i < length; i++)
				if (prevSelected[i] == right)
			        uf.union(right, selected);
		
		
		//boolean sel = false;
		//if (length != 0) {
			//for (int x : prevSelected) {
			//	if (x == selected)
			//		sel = true;
			//}
			//if (sel == false) {
			prevSelected[length] = selected;
			length++;
			//}
		//}
			
		
		if(uf.connected((size*size), (size*size)+1)) 
			return true;
		return false;
	}
}

//size may be one too big i.e. checking to see if 17 and 18 in same set not 16 and 17
