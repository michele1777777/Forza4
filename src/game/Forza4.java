package game;
import java.util.Scanner;
import table.Table;

/**
 * The Forza4 class.
 * @author Leuti Michele
 */
public class Forza4{
	
	/**
	 * A parameter that represents the game table.
	 */
	private Table table;
	
	/**
	 * A parameter that represents the gameLogic.
	 */
	private GameLogic gameLogic;
	
	/**
	 * A parameter that represents player one.
	 */
	private Player p1;
	
	/**
	 * A parameter that represents player two.
	 */
	private Player p2;
	
	/**
	 * The constructor of the class Forza4 with a standard 7 * 6 size table.
	 * @param p1 player one.
	 * @param p2 player two.
	 */
	public Forza4(Player p1, Player p2){
		this(7,6, p1, p2);
	}
	
	/**
	 * The constructor of the class Forza4 which allows to modify the table size.
	 * @param lenght the lenght of the table.
	 * @param height the height of the table.
	 * @param p1 player one.
	 * @param p2 player two.
	 */
	public Forza4(int lenght, int height, Player p1, Player p2){
		if (lenght < 4 || height < 4) {//Handels exception when the size of the table is less then 4 * 4.
			throw new IllegalArgumentException("The table must at least be 4 x 4");
		}
		this.table = new Table(lenght, height);
		this.gameLogic = new GameLogic(this.table, p1, p2);
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	 * The constructor of the class Forza4, it's used to recreate the game table when a game is loaded.
	 * @param lenght the lenght of the table.
	 * @param height the height of the table.
	 * @param initialPlayer the player who made the first move.
	 * @param p1 player one.
	 * @param p2 player two. 
	 */
	public Forza4(int lenght, int height, int initialPlayer, Player p1, Player p2) {
		this(lenght, height, p1, p2);
		this.gameLogic = new GameLogic(this.table, initialPlayer, p1, p2); 
	}
	
	/**
	 * Allows the player to occupy a position on the game table.
	 * @param column the column of the table to to occupy a position.
	 * @return the int status of the game4.
	 */
	public int makeMove(int column) {
		return this.gameLogic.makeMove(column);
	}
	
	/**
	 * Get a string of moves. It's used to recreate the previous moves when a game is loaded.
	 * @return a string in which there are the moves of the game.
	 */
	public String getMoves() {
		StringBuilder str = new StringBuilder(); //Initialize a string builder.
		int[] moves = this.gameLogic.getMoves(); //returns an int [] array of moves. 
		for (int i = 0; i < moves.length - 1; i++) {
			if (moves[i] == -1) {
				str.append("-, "); //if moves is null (== -1) it appends to string "-"
			}
			else {
				str.append(moves[i] + ", ");//else appends the column index the index of the column in which the move was made.
			}
		}
		if (moves[moves.length - 1] == -1) {
			str.append("-");
		}
		else {
			str.append(moves[moves.length - 1]);
		}
		return str.toString();
	}
	
	/**
	 * Allows to run the game.
	 */
	public void runGame(){
		Scanner s = new Scanner(System.in);
		while (true){
			System.out.println(this.table.toString());//Print the table on screen.
			System.out.print("Player " + this.gameLogic.getCurrentPlayer() + " is your turn!\n");
			System.out.print("1) Choose the column to make a move;\n2) Type \"save\" to save the current game; \n"
					+ "3) Press \"exit\" to exit the current game.\n");
			String input = s.nextLine(); //Saves user input in a variable.
			if (input.toLowerCase().equals("save")) {
				System.out.println("Scegli il nome del file di salvataggio (ext \".f4g\": ");
				input = s.nextLine();
				boolean isSaved = false;
				if (input.endsWith(".f4g")){
					isSaved = GameSaver.saveToFile(this, input);//If the user input is equal to save the game is saved.
				}
				else {
					isSaved = GameSaver.saveToFile(this, input + ".f4g");
				}
				if (isSaved) {
					System.out.println("Game saved with success");
				}
				else {
					System.out.println("Impossible to save the current game");
				}
				continue;
			}
			else if (input.toLowerCase().equals("exit")) {
				System.out.println("Game ended successfully.");
				break;
			}
			int column;
			try {
				column = Integer.parseInt(input); //else user input must to be an index of the column of the table to occupy a position.
			}
			catch(Exception e) {
				e.getMessage();
				continue; //handels exception when the user input it's invalid.
			}
			int status = this.makeMove(column); //An int variable that represents thes current status of the game.
			if (status == 1) {
				System.out.println(this.table.toString());
				System.out.print("Player " + this.gameLogic.getCurrentPlayer() + " is the winner!\n");
				break;
			}
			if (status == 2) {
				System.out.println(this.table.toString());
				System.out.println("The game ended in a draw!");
				break;
			}
		}
		s.close(); 
	}
	
	/**
	 * Get player one.
	 * @return A player object.
	 */
	public Player getPlayer1() {
		return this.p1;
	}
	
	/**
	 * Get player two.
	 * @return A player object.
	 */
	public Player getPlayer2() {
		return this.p2;
	}
	
	/**
	 * Get the lenght of the game table.
	 * @return the table lenght.
	 */
	public int getTableLength() {
		return this.table.getLenght();
	}
	
	/**
	 * Get the height of the game table.
	 * @return the table height.
	 */
	public int getTableHeight() {
		return this.table.getHeight();
	}
	
	/**
	 * Get the intial player of the current game.
	 * @return the initial player object.
	 */
	public int getInitialPlayer() {
		return this.gameLogic.getInitialPlayer();
	}
	
	/**
	 * Get the current color of the player.
	 * @return A GameColor object, the color of the player.
	 */
	public GameColor getCurrentPlayerColor() {
		Player p = this.gameLogic.getCurrentPlayer();
		return (p.getColor());
	}
	
	/**
	 * Get the current player.
	 * @return a player object, the current player.
	 */
	public Player getCurrentPlayer() {
		return this.gameLogic.getCurrentPlayer();
	}
	
	/**
	 * Get the color of the selected cell.
	 * @param row the row index of the cell.
	 * @param column the column index of the cell.
	 * @return A GameColor object, the color of the cell.
	 */
	public GameColor getCellColor(int row, int column) {
		return this.gameLogic.getCellColor(row, column);
	}
	
	/**
	 * Get the index of the last colored cell of the selected column.
	 * @param column the column index.
	 * @return the last cell index value.
	 */
	public int getColumnLastIndex(int column) {
		return this.table.getColumn(column).getLastCellIndex();
	}
	
	/**
	 * Allows to view table on screen.
	 */
	@Override
	public String toString() {
		return this.table.toString();
	}
}
