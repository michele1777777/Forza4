package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import game.Forza4;

/**
 * The WinnerWindow class that manage the winner window frame.
 * @author Leuti Michele
 */
public class WinnerWindow extends JFrame implements ActionListener{
	
	/**
	 * A Forza4 static attribute.
	 */
	public static Forza4 game;
	
	/**
	 * The dimension of the frame.
	 */
	private final Dimension WINDOW_DIM = new Dimension(600, 500);

	/**
	 * A JPanel that contains the background.
	 */
	private JPanel background;
	
	/**
	 * A JPanel that contains the winner information.
	 */
	private JPanel winnerInfoPanel;
	
	/**
	 * A JPanel that contains new game, main menu and quit buttonss.
	 */
	private JPanel buttonsPanel;
	
	/**
	 * The new game buttons.
	 */
	private JButton newGameButton;
	
	/**
	 * The main menu buttons.
	 */
	private JButton mainMenuButton;
	
	/**
	 * The quit buttons.
	 */
	private JButton quitButton;
	
	/**
	 * The constructor of the WinnerWindow class.
	 */
	public WinnerWindow() {
		this.setup();
		this.addComponent();
	}
	
	/**
	 * Add component to the frame.
	 */
	private void addComponent() {
        this.createBackground();
        this.createWinnerInfoPanel();
        this.createButtonsPanel();
    }
	
	/**
	 * Create the background panel.
	 */
	private void createBackground() {
        this.background = this.createPanel(null, new Color(8,12,36), 0, 0, 600,500); //Setup the background panel.
        JLabel winnerLabel = new JLabel(); //Initialize a Jlabel
        winnerLabel.setIcon(this.createImageIcon("Images/winner.png")); //Set the icon of the JLabel
        winnerLabel.setBounds(0, 0, 600, 246);
        this.background.add(winnerLabel); //Add the JLabel to the background panel
        this.add(background); //Add the background panel to the frame.
    }
	
	/**
	 * Create the winner information panel. 
	 */
	private void createWinnerInfoPanel() {
		this.winnerInfoPanel = this.createPanel(null, new Color(8,12,36), 0, 220, 600,100); //Setup the background panel.
		this.winnerInfoPanel.setLayout(new GridBagLayout()); //Set the winner info panel layout.
		JLabel winnerInfo = new JLabel("Player " + game.getCurrentPlayer().toString() + " is the Winner!!"); //Create the winner info label.
		winnerInfo.setForeground(game.getCurrentPlayerColor().get()); //Setup the label.
		winnerInfo.setBackground(new Color(8,12,36));
		winnerInfo.setFont(new Font("", Font.CENTER_BASELINE, 25));
		this.winnerInfoPanel.add(winnerInfo); //Add the label to the winner info panel.
		this.background.add(this.winnerInfoPanel); //Add the winner info panel to the background.
	}
	
	/**
	 * Create the buttons panel.
	 */
	private void createButtonsPanel() {
		this.buttonsPanel =  this.createPanel(null, new Color(8,12,36), 0, 330, 600, 250); //Initialize the buttons panel.
		this.newGameButton = this.createNewGameButton(); //Creates the bottons.
		this.mainMenuButton = this.createMainMenuButton(); 
		this.quitButton = this.createQuitButton();
		this.newGameButton.setBounds(150, 0, 300, 30); //Setup the buttonss bounds.
		this.mainMenuButton.setBounds(150, 55, 300, 30);
		this.quitButton.setBounds(150,110, 300, 30);
		this.buttonsPanel.add(this.newGameButton); //Add the bottons to the buttons panel.
		this.buttonsPanel.add(this.mainMenuButton);
		this.buttonsPanel.add(this.quitButton);
		this.background.add(this.buttonsPanel); //Add the buttons panel to the buttons.
	}
	
	/**
	 * Create the main menu buttons.
	 * @return mainMenuButton the main menu buttons.
	 */
	private JButton createMainMenuButton() {
		JButton mainMenuButton = new JButton("MAIN MENU");; //Initialize the main menu buttons.
		mainMenuButton.setFont(new Font("", Font.CENTER_BASELINE, 13)); //Setup the buttons.
		mainMenuButton.setBorder(null);
		mainMenuButton.setBounds(75,30,187,40);
		mainMenuButton.setForeground(new Color(247,246,241));
		mainMenuButton.setBackground(new Color(33,65,119));
		mainMenuButton.getModel().addChangeListener(new ChangeListener(){ //It allows to change background and foreground colors when mouse rolls over the buttons.
			@Override
			public void stateChanged(ChangeEvent e) {
				ButtonModel model = (ButtonModel) e.getSource();
				if (model.isRollover()) {
					mainMenuButton.setBackground(new Color(247,246,241));
					mainMenuButton.setForeground(new Color(33,65,119));
					}
				else {
					mainMenuButton.setForeground(new Color(247,246,241));
					mainMenuButton.setBackground(new Color(33,65,119));
				}
			}
		});
		mainMenuButton.addActionListener(this); //Add the buttons action.
		return mainMenuButton;
	}
	
	/**
	 * Creates the new game buttons.
	 * @return newGameButton, the new game buttons.
	 */
	private JButton createNewGameButton() {
		JButton newGameButton = new JButton("NEW GAME");; //Initialize the new game buttons.
		newGameButton.setFont(new Font("", Font.CENTER_BASELINE, 13));//Setup the buttons.
		newGameButton.setBorder(null);
		newGameButton.setForeground(new Color(247,246,241));
		newGameButton.setBackground(new Color(33,65,119));
		newGameButton.getModel().addChangeListener(new ChangeListener(){//It allows to change background and foreground colors when mouse rolls over the buttons.
			@Override
			public void stateChanged(ChangeEvent e) {
				ButtonModel model = (ButtonModel) e.getSource();
				if (model.isRollover()) {
					newGameButton.setBackground(new Color(247,246,241));
					newGameButton.setForeground(new Color(33,65,119));
					}
				else {
					newGameButton.setForeground(new Color(247,246,241));
					newGameButton.setBackground(new Color(33,65,119));
				}
			}
		});
		newGameButton.addActionListener(this); //Add the buttons action.
		return newGameButton;
	}
	
	/**
	 * Creates the quit buttons.
	 * @return quitButton, the quit buttons.
	 */
	private JButton createQuitButton() {
		JButton quitButton = new JButton("QUIT");//Initialize the quit buttons.
		quitButton.setBorder(null); //Setup the buttons.
		quitButton.setForeground(new Color(247,246,241));
		quitButton.setBackground(new Color(33,65,119));
		quitButton.setFont(new Font("", Font.CENTER_BASELINE, 15));
		quitButton.getModel().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {//It allows to change background and foreground colors when mouse rolls over the buttons.
				ButtonModel model = (ButtonModel) e.getSource();
				if (model.isRollover()) {
					quitButton.setBackground(new Color(247,246,241));
					quitButton.setForeground(new Color(33,65,119));
					}
				else {
					quitButton.setForeground(new Color(247,246,241));
					quitButton.setBackground(new Color(33,65,119));
				}
			}
		});
		quitButton.addActionListener(this); //Add the buttons action.
		return quitButton;
	}
	
	
	/**
	 * Creates a JPanel.
	 * @param border the border of the JPanel.
	 * @param color the background color of the JPanel-
	 * @param x the x coordinate of the JPanel.
	 * @param y the y coordinate of the JPanel.
	 * @param width the width of the JPanel.
	 * @param height the height of the JPanel.
	 * @return panel a JPanel object.
	 */
	private JPanel createPanel(Border border, Color color, int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        panel.setBorder(border);
        return panel;
    }
	
	/**
	 * Create an Image object.
	 * @param path the path of the image.
	 * @return image an Image object.
	 */
	private Image createImage(String path) {
		Image image = Toolkit.getDefaultToolkit().createImage(path);
		return image;
	}
	
	/**
	 * Create an ImageIcon object.
	 * @param path the path of the image.
	 * @return img an ImageIcon object.
	 */
	private ImageIcon createImageIcon(String path) {
		Image image = Toolkit.getDefaultToolkit().createImage(path);
		ImageIcon img = new ImageIcon(image);
		return img;
	}
	
	/**
	 * The method of the actionListener interface that allows to perform actions with buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.newGameButton) { 
			WindowManager.switchToSelectionWindow(); //The new game action.
		} 
		else if(e.getSource() == this.mainMenuButton) {
			WindowManager.switchToStartWindow(); //The main menu action.
		}
		else { 
			WindowManager.quit(); //The main menu action.
		}
	}
	
	/**
	 * Setup the frame.
	 */
	private void setup() {
		game = GameWindow.game;
        this.getContentPane().setPreferredSize(WINDOW_DIM); //Choose the dimension of the frame
        this.setIconImage(this.createImage("Images/Forza4_i.png")); //Choose the icon of the frame.
        this.pack();  
        this.setTitle("Forza4 - winner window"); //Set the title.
        this.setResizable(false); //Set the frame to a non-resizable frame.
        this.setLocationRelativeTo(null); //Set the frame to the center of the screen.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows when the botton x it's pressed to stop the program.
        this.setVisible(true); //Set the frame to visible.
    }
}
	
