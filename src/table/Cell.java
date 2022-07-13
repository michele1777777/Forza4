package table;

import game.GameColor;

/** 
 * the cell class is the most basic part of the table class which represents the game table. 
 * @author Leuti Michele
 */

public class Cell{
	
	/**
	 * The color associated with the cell, which represents a specified player.
	 */
	private GameColor color; 
	
	/**
	 * Constructor of an empty cell.
	 */
	public Cell(){
		this.color = GameColor.EMPTY; //initializes the cell with a null color
	}
	
	/**
	 * Constructor of an occupied cell.
	 * @param color the cell color.
	 */
	public Cell(GameColor color) {
		this.color = color; //initializes the cell with the given color input
	}
	
	/**
	 * Sets the color of the cell to the one given in input.
	 * @param color the color to be set.
	 */
	public void setColor(GameColor color){
		this.color = color;
	}
	
	/**
	 * Get the color of the cell.
	 * @return the Color Object.
	 */
	public GameColor getColor() {
		return this.color;
	}
	
	/**
	 * Allows to view the cell on screen.
	 * @return A string with the color of the cell.
	 */
	@Override
	public String toString(){
		return this.color.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
