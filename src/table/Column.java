package table;

import game.GameColor;

/**
 * The column class represents the game table column.
 * @author Leuti Michele
 */
public class Column {
	
	/**
	 * the column's height.
	 */
	private int height;
	
	/**
	 * A cell's array which rappresents the column.
	 */
	private Cell[] cells;
	
	/**
	 * A parameter that represents the index of the next cell to be filled.
	 */
	private int nextCell;
	
	/**
	 * Constructor of the column class.
	 * @param height the column's height to be set.
	 */
	public Column(int height) {
		this.height = height; //set the column's height
		this.nextCell = 0; 
		this.cells = new Cell[height]; //initializes an array of dimensions equal to the height of the input column
		for (int i = 0; i < height; i++) {
			this.cells[i] = new Cell(); //builds the array of cells representing the game table column
		}
	}
	
	/**
	 * Get the index of the last occupied cell.
	 * @return the index of the last occupied cell.
	 */
	public int getLastCellIndex() {
		return this.nextCell - 1;
	}
	
	/**
	 * Get the k-th cell of the column.
	 * @param k the index of the cell to be get.
	 * @return the k-th cell.
	 */
	public Cell getCell (int k) {
		if (k < 0 || k >= this.height) { //handles the exception in case the column cell index is incorrect.
			throw new IndexOutOfBoundsException("Invalid cell index");
		}
		return this.cells[k];
	}
	
	/**
	 * Get the height of the column.
	 * @return the height of the column
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * Get the column.
	 * @return the column
	 */
	public Cell[] getCells() {
		return this.cells;
	}
	
	/**
	 * Colors the first avaible cell of the column.
	 * @param color the color of the cell to fill.
	 */
	public void insert(GameColor color){
		if (this.nextCell == this.height){ //handles the exception in case the column is full.
			throw new IndexOutOfBoundsException("The column is full");
		}
		this.cells[this.nextCell].setColor(color);//set the cell color to the one given in input.
		this.nextCell++;
	}
	
	
}
