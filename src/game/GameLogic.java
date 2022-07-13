package game;
import table.Cell;
import table.Column;
import table.Table;
import java.util.Random;

/**
 * The game logic class takes care of all the game rules, like choosing the starting player, making the moves and assigning a winner.
 * @author Leuti Michele
 */
public final class GameLogic {
	
	/**
	 * A parameter that represents the current player.
	 */
	private int currentPlayer;
	
	/**
	 * The game table.
	 */
	private Table table;
	
	/**
	 * An array of players in which there are two players.
	 */
	private Player[] players;
	
	/**
	 * An array of moves in which each int represents the column in which the move was made. 
	 */
	private int[] moves;
	
	/**
	 * A parameter that represents the index in which to enter the move in the array of moves.
	 */
	private int movesCounter;
	
	/**
	 * A parameter that represents the initial player index (0 or 1) of the players' array.
	 */
	private int initialPlayer;
	
	/**
	 * The costructor of the GameLogic Class.
	 * @param table the game table.
	 * @param p1 the player one.
	 * @param p2 the player two.
	 */
	public GameLogic(Table table, Player p1, Player p2){
		this.initialPlayer = this.chooseInitialPlayer(); //Choose randomly the inital player.
		this.currentPlayer = this.initialPlayer; 
		this.table = table;
		this.players = new Player[]{p1, p2};
		this.moves = new int[this.table.getLenght() * this.table.getHeight()];
		for (int i = 0; i < this.moves.length; i++) {
			this.moves[i] =  -1;
		}
		this.movesCounter = 0;
	}
	
	/**
	 * The second costructor of the GameLogic Class, it is used to recreate the game logic of a previously saved game
	 * @param table the game table.
	 * @param initialPlayer the initial player that start the game.
	 * @param p1 the player one.
	 * @param p2 the player two.
	 */
	public GameLogic(Table table, int initialPlayer, Player p1, Player p2) {
		this(table, p1, p2);
		this.initialPlayer = initialPlayer;
		this.currentPlayer = initialPlayer;
	}
	
	/**
	 * Choose randomly the initial player.
	 */
	private int chooseInitialPlayer(){ 
		Random r = new Random();
		return r.nextInt(2);
	}
	
	/**
	 * Get the initial player index of players' array.
	 * @return the initial player.
	 */
	public int getInitialPlayer() {
		return this.initialPlayer;
	}
	
	/**
	 * Get the current player index of players' array.
	 * @return the current player.
	 */
	public Player getCurrentPlayer() {
		return this.players[this.currentPlayer];
	}
	
	/**
	 * Get the color of the selected cell.
	 * @param row the row index of the cell.
	 * @param column the column index of the cell.
	 * @return the cell color.
	 */
	public GameColor getCellColor(int row, int column) {
		return this.table.getCell(row, column).getColor();
	}
	
	/**
	 * Check an array of cells to see if there are 4 consecutive identical cells.
	 * @param cells An array of cells to check.
	 */
	private boolean checkCellsLinearly(Cell[] cells) {
		if (cells.length < 4) {
			return false;
		}
		for (int i = 0; i <= cells.length - 4; i++) {//It scrolls the array up to the fourth last position.
			if (cells[i].getColor() == this.getCurrentPlayer().getColor()) {
				for (int j = i + 1; j <= i + 3; j++) {//Check the next 3 cells if are equals to the i-th one.
					if (cells[j].getColor() != this.getCurrentPlayer().getColor()) {
						return false; 
					}
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check if the match has a winner.
	 * @param column the column where the player made his move.
	 */
	private boolean checkWin(int column) {
			Column col = this.table.getColumn(column); //Get the specified column from the index given in input.
			if (this.checkCellsLinearly(col.getCells())) {
				return true;
			}
			int rowIndex = col.getLastCellIndex(); //Returns the row index of the last occupied cell.
			Cell[] row = this.table.getRow(rowIndex);//Get the specidied row from the row index.
			if (this.checkCellsLinearly(row)) {
				return true; 
			}
		
		for (int i = 0; i < this.table.getHeight() + this.table.getLenght() - 1; i++) {//The index i is the index of the diagonal and the antidiagonal.
			Cell[] diagonal = this.table.getDiagonal(i);
			Cell[] antidiagonal = this.table.getAntidiagonal(i);
			if (this.checkCellsLinearly(diagonal) || this.checkCellsLinearly(antidiagonal)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the match ended in a draw.
	 */
	private boolean checkParity() {
		boolean parity = true;
		for (Column column : this.table.getColumns()) {
			if (column.getLastCellIndex() != column.getHeight() - 1) {//If a column is not fill is not a draw.
				parity = false;
				break;
			}
		}
		return parity; 
	}
	
	/**
	 * Makes the player's move.
	 * @param column the column where the player made his move.
	 * @return 0 if match it's not ended, 1 if it's a win, 2 if it's a draw.
	 */
	public int makeMove(int column){
		try{
			this.table.insert(this.getCurrentPlayer().getColor(), column);//Color the first free cell of the column given in input.
			this.moves[this.movesCounter] = column;//Updates the array of moves.
			movesCounter++;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
		}
		
		if (this.checkParity()) {
			return 2; 
		}
		
		if (this.checkWin(column)) {
			return 1; 
		}
		
		if (this.currentPlayer == 0){
			this.currentPlayer = 1;
		}
		else{
			this.currentPlayer = 0;
		}
		return 0;
	}
	
	/**
	 * Get the moves of the game.
	 * @return the moves.
	 */
	public int[] getMoves() {
		return this.moves;
	}
	
}
