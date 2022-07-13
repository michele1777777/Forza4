package gui;

/**
 * The WindowManager class allows to switch from a window to an other one.
 * @author LeutiMichele
 */
public class WindowManager {
	
	/**
	 * A static StartWindow attribute.
	 */
	private static StartWindow startMenu = null;
	
	/**
	 * A static SelecetionWindow attribute.
	 */
	private static SelectionWindow selectionMenu = null;
	
	/**
	 * A static GameWindow attribute.
	 */
	private static GameWindow gameWindow = null;
	
	/**
	 * A static WinnerWindow attribute.
	 */
	private static WinnerWindow winnerWindow = null;
	
	/**
	 * A static ParityWindow attribute.
	 */
	private static ParityWindow parityWindow = null;
	
	/**
	 * Switch to the start window.
	 */
	public static void switchToStartWindow() {
		closeWindows(); 
		startMenu = new StartWindow();
	}
	
	/**
	 * Switch to the selection window.
	 */
	public static void switchToSelectionWindow() {
		closeWindows();
		selectionMenu = new SelectionWindow();
	}
	
	/**
	 * Switch to the game window.
	 */
	public static void switchToGameWindow() {
		closeWindows();
		gameWindow = new GameWindow();
	}
	
	/**
	 * Switch to the winner window.
	 */
	public static void switchToWinnerWindow() {
		winnerWindow = new WinnerWindow();
	}
	
	/**
	 * Switch to the parity window.
	 */
	public static void switchToParityWindow() {
		parityWindow = new ParityWindow();
	}
	
	/**
	 * Quit the program.
	 */
	public static void quit() {
		closeWindows();
	}
	
	/**
	 * Close all the open windows.
	 */
	private static void closeWindows() {
		if (startMenu != null) {
			startMenu.setVisible(false); //Set the window to non-visible.
			startMenu.dispose(); //Destroys the window.
			startMenu = null;
		}
		if (selectionMenu != null) {
			selectionMenu.setVisible(false);
			selectionMenu.dispose();
			selectionMenu = null;
		}
		if (gameWindow != null) {
			gameWindow.setVisible(false);
			gameWindow.dispose();
			gameWindow = null;
		}
		if (winnerWindow != null) {
			winnerWindow.setVisible(false);
			winnerWindow.dispose();
			winnerWindow = null;
		}
		if (parityWindow != null) {
			parityWindow.setVisible(false);
			parityWindow.dispose();
			parityWindow = null;
		}
	}
}
