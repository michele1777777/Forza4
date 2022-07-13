package main;

import java.io.File;
import java.io.FileInputStream;

import game.Forza4;
import game.GameColor;
import game.GameLoader;
import game.GameSaver;
import game.Player;

/**
 * The Forza4 class test.
 * @author Leuti Michele
 */
public class Forza4Test {
	
	/**
	 * The main method of the Forza4Test
	 * @param args 
	 */
	public static void main(String[] args){
		Player p1 = new Player("Mic", GameColor.GREEN);
		Player p2 = new Player("Sim", GameColor.BLACK);
		Forza4 game = new Forza4(7, 6, 0, p1, p2);
		game.makeMove(2);
		game.makeMove(4);
		game.makeMove(3);
		game.makeMove(3);
		game.makeMove(5);
		game.makeMove(6);
		System.out.println("Test 1: Generic test...\n");
		String table = "-, -, -, -, -, -, -\n"
				+ "-, -, -, -, -, -, -\n"
				+ "-, -, -, -, -, -, -\n"
				+ "-, -, -, -, -, -, -\n"
				+ "-, -, -, N, -, -, -\n"
				+ "-, -, G, G, N, G, N\n";
		if (table.equals(game.toString())) {
			System.out.println(game.toString());
			System.out.println("Generic test passed!\n");
		}
		else {
			System.out.println("Test not passed!");
		}
		
		System.out.println("Test 2: Save/Load test...\n");
		boolean isSaved = GameSaver.saveToFile(game, "test.f4g");
		if (isSaved) {
			System.out.println("Game saved successfully...");
		}
		try {
			game = GameLoader.loadFromFile("test.f4g");
			System.out.println("Game loaded successfully...\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (table.equals(game.toString())) {
			System.out.println(game.toString());
			System.out.println("Save/Load test passed!\n");
		}
		else {
			System.out.println("Test not passed!");
		}
		
		System.out.println("Test 3: Vertical win test...\n");
		game.makeMove(5);
		game.makeMove(6);
		game.makeMove(5);
		game.makeMove(6);
		int status = game.makeMove(5);
		if (status == 1) {
			System.out.println(game.toString());
			System.out.println("Vertical win test passed!\n");
		}
		else {
			System.out.println("Test not passed!");
		}
		
		try {
			game = GameLoader.loadFromFile("test.f4g");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test 4: Horizzontal win test...\n");
		game.makeMove(1);
		game.makeMove(6);
		status = game.makeMove(0);
		if (status == 1) {
			System.out.println(game.toString());
			System.out.println("Horizontal win test passed!\n");
		}
		else {
			System.out.println("Test not passed!");
		}
		
		try {
			game = GameLoader.loadFromFile("test.f4g");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test 5: Diagonal win test...\n");
		game.makeMove(4);
		game.makeMove(5);
		game.makeMove(5);
		game.makeMove(6);
		game.makeMove(6);
		game.makeMove(0);
		status = game.makeMove(6);
		if (status == 1) {
			System.out.println(game.toString());
			System.out.println("Diagonal win test passed!\n");
		}
		else {
			System.out.println("Test not passed!");
		}
		
		try {
			game = GameLoader.loadFromFile("test.f4g");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Test 6: Anti-diagonal win test...\n");
		game.makeMove(2);
		game.makeMove(2);
		game.makeMove(1);
		game.makeMove(1);
		game.makeMove(1);
		status = game.makeMove(1);
		if (status == 1) {
			System.out.println(game.toString());
			System.out.println("Anti-diagonal win test passed!\n");
		}
		else {
			System.out.println("Test not passed!");
		}
		File f = new File("test.f4g");
		System.out.println("Attempting to delete " + f.getAbsolutePath());
		if (!f.exists())
		  System.out.println("Doesn't exist");
		else if (!f.canWrite())
		  System.out.println("No write permission");
		else
		{
		  if (f.delete())
		    System.out.println("   Deleted!");
		  else
		    System.out.println("	Delete failed - reason unknown");
		}
	}

}
