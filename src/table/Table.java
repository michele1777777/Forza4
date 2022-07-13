package table;

import game.GameColor;

/**
 * The table class wich represents the game table.
 * @author Leuti Michele
 */
public class Table{
	
	/**
	 * A parameter that represents the lenght of the table.
	 */
	private int lenght;
	
	/**
	 * A parameter that represents the height of the table.
	 */
	private int height;
	
	/**
	 * A columns' array that represents the table.
	 */
	private Column[] columns;
	
	/**
	 * The table class constructor.
	 * @param lenght the lenght of the table.
	 * @param height the height of the table.
	 */
	public Table(int lenght, int height) {
		this.lenght = lenght; //set the length of the table.
		this.height = height; //set the height of the table.
		this.columns = new Column[lenght]; //initializes an array of columns equal in size to the length given in input.
		for (int i = 0; i < lenght; i++) { 
			this.columns[i] = new Column(height); //builds the table.
		}
	}
	
	/**
	 * Get the lenght of the table.
	 * @return the lenght of the table.
	 */
	public int getLenght() {
		return this.lenght;
	}
	
	/**
	 * Returns the height of the table.
	 * @return the height of the table.
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Get the cell of the specified column given in input.
	 * @param row the row index of the cell to be get.
	 * @param column the column index of the cell to be get.
	 * @return a cell object.
	 */
	public Cell getCell(int row, int column){
		Column c = this.getColumn(column);
		return c.getCell(row);
	}
	
	/**
	 * Get the table as an array of columns.
	 * @return A column array.
	 */
	public Column[] getColumns(){
		return this.columns;
	}
	
	/**
	 * Get the k-th row of the game table.
	 * @param k the index of the row of the table to be get.
	 * @return row the row of the table as a cell array.
	 */
	public Cell[] getRow(int k) {
		if (k < 0 || k >= this.height) {
			throw new IndexOutOfBoundsException("Invalid row index"); //handles the exception in case the column cell index is incorrect.
		}
		Cell[] row = new Cell[this.lenght]; //initialize the row as an array of cells.
		for (int i = 0; i < this.lenght; i++) {
			row[i] = this.getCell(k, i); //builds the row.
		}
		return row;
	}
	
	/**
	 * Get the k-th diagonal of the game table.
	 * @param k the index of the diagonal of the table to be get.
	 * @return diagonal the diagonal of the table as a cell array.
	 */
	public Cell[] getDiagonal(int k) {
		int maxIndex = this.lenght + this.height - 1;
		if (k < 0 || k >= maxIndex) {//Handles the exception when the diagonal index is an invalid value.
			throw new IndexOutOfBoundsException("Invalid diagonal index");
		}
		Cell[] diagonal; //Initializes the diagonal variable as an array of cell objects.
		int startColumn; //the startColumn index
		int startRow; //the row index
		int lenDiagonal;//the diagonal lenght
		int maxHeight = this.height - 1;
		if (k <= maxHeight) {
			startColumn = 0;
			startRow = maxHeight - k;
			lenDiagonal = k + 1;
			if(k == maxHeight && this.height != this.lenght) {
				lenDiagonal--;
			}
		}
		else {
			startColumn = k - maxHeight;
			startRow = 0;
			lenDiagonal = 2*this.height - k - 1; //square
			if (this.height > this.lenght) {
				lenDiagonal--;
			}
			else if(this.height < this.lenght){
				lenDiagonal++;
			}
		}
		diagonal = new Cell[lenDiagonal];
		for (int i = 0; i < lenDiagonal; i++) {	
			diagonal[i] = this.getCell(startRow + i, startColumn + i);
		}
		return diagonal;
	}
	
	/**
	 * Get the k-th anti-diagonal of the game table.
	 * @param k the index of the anti-diagonal to be get.
	 * @return antidiagonal the anti-diagonal of the table as a cell array.
	 */
	public Cell[] getAntidiagonal(int k) {
		int maxIndex = this.lenght + this.height - 1; //Handles the exception when the anti-diagonal index is an invalid value.
		if (k < 0 || k >= maxIndex) {
			throw new IndexOutOfBoundsException("Invalid antidiagonal index");
		}
		Cell[] antidiagonal;
		int startColumn;
		int startRow;
		int lenDiagonal;
		int maxLenght = this.lenght - 1;
		
		if (k <= maxLenght) { //the first anti-diagonals.
			startColumn = k;
			startRow = 0;
			lenDiagonal = k + 1;
			if(k == maxLenght && this.height != this.lenght) {
				lenDiagonal--;
			}
		}
		else { //the last anti-diagonals.
			startColumn = maxLenght;
			startRow = k - this.lenght + 1;
			lenDiagonal = 2*this.lenght - k - 1; 
			if (this.height < this.lenght) {
				lenDiagonal--;
			}
			else if(this.height > this.lenght){
				lenDiagonal++;
			}
		}
		antidiagonal = new Cell[lenDiagonal];
		for (int i = 0; i < lenDiagonal; i++) {	
			antidiagonal[i] = this.getCell(startRow + i, startColumn - i);
		}
		return antidiagonal;
	}

	/**
	 * Get the k-th column of the table.
	 * @param k the index of the column to be get.
	 * @return the k-th column.
	 */
	public Column getColumn(int k) {
		if (k < 0 || k >= this.lenght) { //handles exception when k is an invalid value.
			throw new IndexOutOfBoundsException("Invalid column index");
		}
		return this.columns[k];
	}
	
	/**
	 * Occupies the first available cell of the specified column.
	 * @param color the cell color to be filled.
	 * @param column the index of the column to be occupied.
	 */
	public void insert(GameColor color, int column){
		Column c = this.getColumn(column); //torna la colonna d
		c.insert(color);
	}
	
	/**
	 * Allow to view the table on screen.
	 * @return the table as a string
	 */
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder(); 
		
		for(int j = this.height - 1; j >= 0; j--){ //j the index of the table row occupied by the cell to be get. 
			for (int i = 0; i < this.lenght; i++){ //i the index of the table column occupied by the cell to be get.
				str.append(this.getCell(j, i)); 
				if (i == this.lenght - 1){
					str.append("\n");
				}
				else{
					str.append(", ");
				}
			}
		}
		return str.toString();
	}
	
	
}
