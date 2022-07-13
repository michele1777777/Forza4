package game;

/**
 * The player class.
 * @author Leuti Michele
 */
public class Player {
	
	/**	
	 * The name of the player.
	 */
	private String name;
	
	/**	
	 * The color of the player.
	 */
	private GameColor color;
	
	/**	
	 * The constructor of the class player.
	 * @param name the name of the player.
	 * @param color the Gamecolor of the player
	 */
	public Player(String name, GameColor color) {
		this.name = name;
		this.color = color;
	}
	
	/**
	 * Get the name of the player.
	 * @return the name of the player.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the color of the player.
	 * @return the Gamecolor of the player.
	 */
	public GameColor getColor() {
		return this.color;
	}
	
	/**
	 * Allow to view the player's name on screen.
	 * @return A string with the name of the player.
	 */
	@Override
	public String toString() {
		return this.getName();
	}
}
