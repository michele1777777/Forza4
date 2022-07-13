package game;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The gamesaver class takes care of saving the current game.
 * @author Leuti Michele
 */
public class GameSaver{
	
	/**
	 * Save all the information and moves of the current game to a file.
	 * @param game the Forza4 object.
	 * @param path the string path of the file.
	 * @return true if the save was successful otherwise false.
	 */
	public static boolean saveToFile(Forza4 game, String path) {
		int H = game.getTableHeight(); //The height of the table.
		int L = game.getTableLength(); //The lenght of the table.
		Player p1 = game.getPlayer1(); //Player 1.
		Player p2 = game.getPlayer2(); //Player 2.
		int initialPlayer = game.getInitialPlayer(); //The initial player.
		String moves = game.getMoves();//The moves of the game.
		try {
			FileWriter writer = new FileWriter(path);					//File format:
			writer.write("" + L + "," + H);								//h, w (tab)
			writer.write("\n" + p1.getName() + "," + p1.getColor());	//p1, color1
			writer.write("\n" + p2.getName() + "," + p2.getColor());	// p2, color2
			writer.write("\n" + initialPlayer);							//initialPlayer
			writer.write("\n" + moves);									//moves
			writer.close();															
			return true;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
