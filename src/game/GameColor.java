package game;

import java.awt.Color;

/**
 * The GameColor enum.
 * @author Leuti Michele
 */
public enum GameColor{
	
	/**
	 * The red color in (r, g, b).
	 */
	RED(255,0,0),
	
	/**
	 * The yellow color in (r, g, b).
	 */
	YELLOW(255,201,14),
	
	/**
	 * The white color in (r, g, b).
	 */
	WHITE(255,255,255),
	
	/**
	 * The blue color in (r, g, b).
	 */
	BLUE(217,248,255),
	
	/**
	 * The black color in (r, g, b).
	 */
	BLACK(0,0,0),
	
	/**
	 * The green color in (r, g, b).
	 */
	GREEN(20,148,68),
	
	/**
	 * A null value color.
	 */
	EMPTY(-1,-1,-1);
	
	/**
	 * An object color from the Color class from java.awt.Color .
	 */
	private Color color;
	
	/**
	 * The constructor of the enum GameColor.
	 * @param r the red value of the color.
	 * @param g the green value of the color.
	 * @param b the blue value of the color.
	 */
	GameColor(int r, int g, int b){
		if (r == -1 || g == -1 || b == -1) {
			this.color = null;
		}
		else{
			this.color = new Color(r, g, b);
		}
	}
	
	/**
	 * Match a string to its specific color.
	 * @param color a string that represents the specified color of the GameColors attributes.
	 * @return The selected GameColor object.
	 */
	public static GameColor match(String color) {
		switch (color) {
		case "R": return RED;
		case "W": return WHITE;
		case "Y": return YELLOW;
		case "N": return BLACK;
		case "G": return GREEN;
		case "B": return BLUE;
		default: return EMPTY;
		}
	}
	
	/**
	 * Get the Color object.
	 * @return the color object.
	 */

	public Color get() {
		return this.color;
	}
	
	/**
	 * Allows to view the cell's colors on sceen.
	 */
	@Override
	public String toString() {
		switch (this) {
		case RED: return "R";
		case YELLOW: return "Y";
		case WHITE: return "W";
		case BLACK: return "N";
		case GREEN: return "G";
		case BLUE: return "B";
		default: return "-";
		}
	}
	
}
