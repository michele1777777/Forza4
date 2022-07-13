package game;

import java.io.File;
import java.util.Scanner;
/**
 * The GameLoader class takes care of loading the game from a file.
 * @author Leuti Michele
 */
public class GameLoader {
	
	/**
	 * Load saved game information from file.
	 * @param path the path file.
	 * @throws Exception 
	 * @return A Forza4 Object.
	 */
	public static Forza4 loadFromFile(String path) throws Exception {
		/* The input file is in this format:
		 * h, l(tab)
		 * NameP1, color1
		 * NameP2, color2
		 * initialPlayer
		 * moves
		 */
		try {
			Scanner s = new Scanner(new File(path));
			String[] parts = s.nextLine().split(","); 
			int H = Integer.parseInt(parts[1]); //The height of the table.
			int L = Integer.parseInt(parts[0]); //The lenght of the table.
			parts = s.nextLine().split(",");
			Player p1 = new Player(parts[0], GameColor.match(parts[1])); //Recreates the players from the saved game.
			parts = s.nextLine().split(",");
			Player p2 = new Player(parts[0], GameColor.match(parts[1]));
			parts = s.nextLine().split(",");
			int initialPlayer = Integer.parseInt(parts[0]); //The initial player that started the saved game.
			Forza4 game = new Forza4(L, H, initialPlayer, p1, p2);
			parts = s.nextLine().split(",");
			for (String move : parts) {
				move = move.trim();
				if (move.equals("-")) {
					break;
				}
				else {
					game.makeMove(Integer.parseInt(move)); //Makes the move made during the game that was saved.
				}
			}
			s.close();
			return game;
		} catch (Exception e) { 
			throw new Exception ("The file is corrupted or not found.");//Handles the exception when the file is corrupted(invalid form) or not found.
		}
		
	}
}
