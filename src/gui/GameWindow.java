package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;

import game.Forza4;
import game.GameColor;
import game.GameSaver;

/**
 * The GameWindow class that manage the game window frame.
 * @author Leuti Michele
 */
public class GameWindow extends JFrame implements ActionListener{
	
	/**
	 * A Forza4 static attribute.
	 */
	public static Forza4 game = null;
	
	/**
	 * The dimension of the frame.
	 */
	private final Dimension WINDOW_DIM = new Dimension(600, 500);
	
	/**
	 * A JPanel that contains the background.
	 */
	private JPanel background;
	
	/**
	 * The initial x coordinate of the table.
	 */
	private int tableX;
	
	/**
	 * The initial y coordinate of the table.
	 */
	private int tableY;
	
	/**
	 * A JPanel that contains the versus' info graphics.
	 */
	private JPanel versusPanel;
	
	/**
	 * A JPanel that contains the table graphics.
	 */
	private JPanel tablePanel;
	
	/**
	 * A Jlabel matrix representing the table cells.
	 */
	private JLabel[][] table;
	
	/**
	 * A JPanel that contains the insert buttons.
	 */
	private JPanel insertPanel;
	
	/**
	 * A JButton array representing the insert buttons.
	 */
	private JButton[] insertButtons;
	
	/**
	 * A JPanel that contains the save button and the main menu button.
	 */
	private JPanel buttonsPanel;
	
	/**
	 * The save button.
	 */
	private JButton saveButton;
	
	/**
	 * The main menu button.
	 */
	private JButton mainMenuButton;
	
	/**
	 * A JPanel that contains the turn info Label.
	 */
	private JPanel gameTurnsPanel;
	
	/**
	 * A JLabel that cointaint the game turn information graphics.
	 */
	private JLabel turnInfo;
	
	/**
	 * The constructor of the GameWindow class.
	 */
	public GameWindow() {
		this.addComponent(); 
		this.setup(); 
	}
	
	/**
	 * Add components to the frame.
	 */
	private void addComponent() {
        this.createBackground(); 
        this.createVersusPanel();
        this.createTablePanel();
        this.createInsertButtonsPanel();
        this.createButtonsPanel();
        this.createGameTurnsPanel();
    }
	
	/**
	 * Create the background panel.
	 */
	private void createBackground() {
        this.background = this.createPanel(null, new Color(8,12,36), 0, 0, 600,500);//Setup the panel
        this.add(background);
    }
	
	/**
	 * Create the versus panel.
	 */
	private void createVersusPanel() {
		this.versusPanel = this.createPanel(null, new Color(8,12,36), 0, 0, 600, 60); //Setup the panel
		JLabel vsLabel = new JLabel(); //create a new JLabel.
		vsLabel.setBounds(275, 10, 50, 43); //Set the bounds of the JLabel.
		vsLabel.setIcon(this.createImageIcon("Images/vs.png"));//Set the icon of the JLabel.
		this.versusPanel.add(vsLabel); //add the label to the versus panel.
		JPanel p1Panel = this.createPanel(null, new Color(8,12,36), 0, 0, 275, 60); //Setup the panel which contains the player one name.
		p1Panel.setLayout(new GridBagLayout()); //Set the layout panel as GridBagLayout which allows you to automatically center the panel components.
		JLabel p1Label = new JLabel(game.getPlayer1().toString()); //Initialize the player one label.
		p1Label.setFont(new Font("", Font.CENTER_BASELINE, 35)); 
		p1Label.setForeground(game.getPlayer1().getColor().get());
		p1Panel.add(p1Label); //add the label to the panel.
		JPanel p2Panel = this.createPanel(null, new Color(8,12,36), 325, 0, 265, 60); //Setup the panel which contains the player two name.
		p2Panel.setLayout(new GridBagLayout()); //Set the layout as a gridBagLayout.
		JLabel p2Label = new JLabel(game.getPlayer2().toString()); //Initialize the player two label.
		p2Label.setFont(new Font("", Font.CENTER_BASELINE, 35));
		p2Label.setForeground(game.getPlayer2().getColor().get());
		p2Panel.add(p2Label); //add the label to the panel.
		this.versusPanel.add(p1Panel); //add the panel 1 to the versus panel.
		this.versusPanel.add(p2Panel); //add the panel 2 to the versus panel.
		this.background.add(this.versusPanel); //add the versus panel to the background panel.
	}
	
	/**
	 * Create the Panel which contains the table.
	 */
	private void createTablePanel() {
		int L = game.getTableLength(); //the lenght of the table.
		int H = game.getTableHeight(); //the height of the table.
		
		switch(L) {//A switch that allows to center the panel for all the table dimension.
		case 5: this.tablePanel = this.createPanel(null,  new Color(0,37,225), 195, 165, 40 * L + 10, 40 * H + 10);
				this.tableX = 195;
				this.tableY = 160;
		break;
		case 6: this.tablePanel = this.createPanel(null,  new Color(0,37,225), 175, 135, 40 * L + 10 , 40 * H + 10);
				this.tableX = 175;
				this.tableY = 125;
		break;
		case 7: this.tablePanel = this.createPanel(null,  new Color(0,37,225), 155, 115, 40 * L + 10 , 40 * H + 10);
				this.tableX = 155;
				this.tableY = 115;		
		break;
		case 8: this.tablePanel = this.createPanel(null,  new Color(28,57,187), 135, 115, 40 * L + 10, 40 * H + 10);
				this.tableX = 135;
				this.tableY = 115;
		break;
		}
		this.tablePanel.setBorder(BorderFactory.createLineBorder(new Color(83,113,235)));//set the border of the panel.
		this.createTable(L, H); //create the table.
		this.background.add(this.tablePanel); //add the table panel to the background panel.
	}
	
	/**
	 * Creates the table as a JLabel matrix.
	 * @param L the lenght of the table.
	 * @param H the height of the table.
	 */
	private void createTable(int L, int H) {
		this.table = new JLabel[L][H]; //Initialize the JLabel matrix.
		for (int i = 0; i < L; i++) { 
			for (int j = 0; j < H; j++) {
				this.table[i][j] = new JLabel(); //Initialize the JLabel
				GameColor cellColor = game.getCellColor(j, i); //Get the color of the specified cell 
				this.changeCellColor(this.table[i][j], cellColor); //Change the color of the JLabel according to the color of the table's cell object.
				int k = 5 + 40 * (H - 1); //A parameter to set the bounds of all the JLabel.
				this.table[i][j].setBounds(5 + 40 * i, k - j * 40, 40, 40);//Set up the bounds of the JLabel.
				this.tablePanel.add(this.table[i][j]); //Add the JLabel to the table Panel.
			}
		}
	}
	
	/**
	 * Creates panel which contains the insert buttons.
	 */
	private void createInsertButtonsPanel() {
		int L = game.getTableLength(); 
		int H = game.getTableHeight();
		this.insertPanel = this.createPanel(null,  new Color(8,12,36), this.tableX - 3, this.tableY - 30, 40 * L + 10, 40 * H + 10);
		this.createButtons(); //Create the insert buttons.
		this.background.add(this.insertPanel); //Add the insert panel to the background panel.
	}
	
	/**
	 * Create the insert buttons.
	 */
	private void createButtons() {
		int L = game.getTableLength();
		this.insertButtons = new JButton[L];
		for (int i = 0; i < L; i++) {
				this.insertButtons[i] = new JButton(); //Initalizes a new button.
				this.insertButtons[i].addActionListener(this); //Setup the action of the button.
				this.insertButtons[i].setIcon(this.createImageIcon("Images/arrow.png")); //Setup the icon of the button.
				this.insertButtons[i].setBorder(null); //Setup the botton border to a null value.
				this.insertButtons[i].setBackground(new Color(8,12,36)); //Set the color background of the button.
				this.insertButtons[i].setBounds(i * 40 + 10, 0, 30, 30); //Set the bounds of the button.
				this.insertPanel.add(this.insertButtons[i]); //Add the button to the insert panel.
			}
	}
	
	/**
	 * Create the panal that contains the save and the main menu button.
	 */
	private void createButtonsPanel() {
		this.saveButton = this.createsaveButton(); //Create the save button.
		this.mainMenuButton = this.createMainMenuButton(); //Create the main menu button.
		int L = game.getTableLength();
		switch(L) {//handles to insert the save and the main menu button to the correct posizion on the frame according to different table sizes.
		case 5: this.buttonsPanel = this.createPanel(null, new Color(8,12,36), this.tableX + (40 * L) + 60, this.tableY + 20 , 100, 200);
			break;
		case 6: this.buttonsPanel = this.createPanel(null, new Color(8,12,36), this.tableX + (40 * L) + 50, this.tableY + 50 , 100, 200);
			break;
		case 7: this.buttonsPanel = this.createPanel(null, new Color(8,12,36), this.tableX + (40 * L) + 42, this.tableY + 60 , 100, 200);
			break;
		case 8: this.buttonsPanel = this.createPanel(null, new Color(8,12,36), this.tableX + (40 * L) + 33, this.tableY + 75 , 100, 200);
			break;
		}
		this.buttonsPanel.add(this.saveButton); //Add the save button to the button panel.
		this.buttonsPanel.add(this.mainMenuButton); //Add the main menu button to the button panel.
		this.background.add(this.buttonsPanel); //Add the main menu button to the button panel.
	}
	
	/**
	 * Creates the save button.
	 * @return saveButton the save button.
	 */
	private JButton createsaveButton() {
		JButton saveButton = new JButton("SAVE GAME"); //Initializes the button
		saveButton.setBorder(null);
		saveButton.setFont(new Font("", Font.CENTER_BASELINE, 13)); 
		saveButton.setBounds(0,20, 90, 30);
		saveButton.setForeground(new Color(247,246,241));
		saveButton.setBackground(new Color(33,65,119));
		saveButton.getModel().addChangeListener(new ChangeListener(){ 
			@Override
			public void stateChanged(ChangeEvent e) { //It allows to change background and foreground colors when mouse rolls over the button.
				ButtonModel model = (ButtonModel) e.getSource();
				if (model.isRollover()) {
					saveButton.setBackground(new Color(247,246,241));
					saveButton.setForeground(new Color(33,65,119));
					}
				else {
					saveButton.setBackground(new Color(33,65,119));
					saveButton.setForeground(new Color(247,246,241));
				}
			}
		});
		saveButton.addActionListener(this); //Add the button action.
		return saveButton;
	}
	
	/**
	 * Creates the main menu button.
	 * @return mainMenuButton the main menu button.
	 */
	private JButton createMainMenuButton() {
		JButton mainMenuButton = new JButton("MAIN MENU");; //Initializes the button
		mainMenuButton.setFont(new Font("", Font.CENTER_BASELINE, 13));
		mainMenuButton.setBorder(null);
		mainMenuButton.setBounds(0,80,90,30);
		mainMenuButton.setForeground(new Color(247,246,241));
		mainMenuButton.setBackground(new Color(33,65,119));
		mainMenuButton.getModel().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) { //It allows to change background and foreground colors when mouse rolls over the button.
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
		mainMenuButton.addActionListener(this); //Add the button action.
		return mainMenuButton;
	}
	
	/**
	 * Creates the game turn info panel.
	 */
	private void createGameTurnsPanel() {
		this.gameTurnsPanel = this.createPanel(null, new Color(8,12,36), 0, 375, 600, 125); //Initializes the panel.
		this.gameTurnsPanel.setLayout(new GridBagLayout());
		this.turnInfo = new JLabel("Player " + game.getCurrentPlayer().toString() + " is your turn!"); //Initializes the label which contains the game turn info.
		this.turnInfo.setFont(new Font("", Font.CENTER_BASELINE, 20)); 
		this.turnInfo.setForeground(game.getCurrentPlayerColor().get()); //Set the foreground according to the color of the player.	
		this.gameTurnsPanel.add(turnInfo); //Add the label to the game turn panel.
		this.background.add(this.gameTurnsPanel); //add the game turn panel to the background.
	}
	
	/**
	 * The method of the actionListener interface that allows to perform actions with buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent e) { //override of the actionListener method
		for (int i = 0; i < this.insertButtons.length; i++) {
			if (e.getSource() == this.insertButtons[i]) { //If the button pressed is one of the insert buttons
				GameColor color = game.getCurrentPlayerColor(); //get the color of the current player.
				if (game.getColumnLastIndex(i) == game.getTableHeight() - 1) { 
					JOptionPane.showMessageDialog(this, "The column is full!", "Warning", JOptionPane.WARNING_MESSAGE); //When a column is full shows a warning message.
				}
				else {
					int status = game.makeMove(i); //Makes the move
					this.turnInfo.setText("Player " + game.getCurrentPlayer().toString() + " is your turn!");//Set the turn info label.
					this.turnInfo.setFont(new Font("", Font.CENTER_BASELINE, 20));
					this.turnInfo.setForeground(game.getCurrentPlayerColor().get());
					int j = game.getColumnLastIndex(i);
					this.changeCellColor(this.table[i][j], color); //change the color ot the occupied cell.
					if (status == 1) {
						WindowManager.switchToWinnerWindow(); //Open the winner frame.
						for (JButton button : this.insertButtons) { //Disable all the buttons.
							button.setEnabled(false); 
							button.setVisible(false);
						}
						this.turnInfo.setVisible(false);
						this.saveButton.setEnabled(false);
						this.saveButton.setVisible(false);
						this.mainMenuButton.setEnabled(false);
						this.mainMenuButton.setVisible(false);
						break;
					}
					if (status == 2) {
						for (JButton button : this.insertButtons) {//Disable all the buttons.
							button.setEnabled(false);
							button.setVisible(false);
						}
						this.turnInfo.setVisible(false);
						this.saveButton.setEnabled(false);
						this.saveButton.setVisible(false);
						this.mainMenuButton.setEnabled(false);
						this.mainMenuButton.setVisible(false);
						WindowManager.switchToParityWindow();//Switch to the parity window.
						break;
					}
				}
				
			}
		}
		if (e.getSource() == this.saveButton) {
			JFileChooser fileChooser = new JFileChooser(); //Initialize a file Chooser
			fileChooser.setAcceptAllFileFilterUsed(false); //Setup the file chooser
			fileChooser.setFileFilter(new FileFilter() { //Initilize a filter.
			   public String getDescription() {
			       return "Forza4 game file (*.f4g)";
			   }

			   public boolean accept(File f) {
			       if (f.isDirectory()) {
			           return true;
			       } else {
			           String filename = f.getName().toLowerCase();
			           return filename.endsWith(".f4g");
			       }
			   }
			});
			
			try {
				int choise = fileChooser.showSaveDialog(null);
				if (choise == JFileChooser.APPROVE_OPTION) { 
					String fileName = fileChooser.getSelectedFile().getPath(); //The path of the choosen file.
					if (!fileName.endsWith(".f4g")) {
						fileName = fileName + ".f4g";
					}
					boolean isSaved = GameSaver.saveToFile(game, fileName); 
					if (isSaved) {
						JOptionPane.showMessageDialog(this, "Game saved successfully", "Info", JOptionPane.INFORMATION_MESSAGE); //Shows an info pop-up.
					}
				}
			}
			catch(Exception er){
				er.printStackTrace();
			}
		}
		if (e.getSource() == this.mainMenuButton) {
			WindowManager.switchToStartWindow();
		}
	}
	
	/**
	 * Changes the color cell to the one given in input.
	 * @param Cell the cell to be filled.
	 * @param color the color chosen to color the cell.
	 */
	private void changeCellColor(JLabel cell, GameColor color) {
		String image;
		switch (color) {//A switch that handles all the color keys.
		case RED : image = "Images/redCell.png";
		break;
		case YELLOW : image = "Images/yellowCell.png";
		break;
		case GREEN : image = "Images/greenCell.png";
		break;
		case BLUE: image = "Images/blueCell.png";
		break;
		default: image = "Images/whiteCell.png";
		break;
		}
		cell.setIcon(this.createImageIcon(image)); //Change the JLabel icon according to the color given in input.
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
	 * Setup the frame.
	 */
	private void setup() {
        this.getContentPane().setPreferredSize(WINDOW_DIM); //Choose the dimension of the frame
        this.setIconImage(this.createImage("Images/Forza4_i.png")); //Choose the icon of the frame.
        this.pack();  
        this.setTitle("Forza4 - Game"); //Set the title.
        this.setResizable(false); //Set the frame to a non-resizable frame.
        this.setLocationRelativeTo(null); //Set the frame to the center of the screen.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows when the botton x it's pressed to stop the program.
        this.setVisible(true); //Set the frame to visible.
    } 
}
