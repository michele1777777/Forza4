package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import game.Forza4;
import game.GameColor;
import game.Player;

/**
 * The SelectionWindow class that manage the selection window frame.
 * @author Leuti Michele
 */
public class SelectionWindow extends JFrame implements ActionListener{
	
	/**
	 * The dimension of the frame.
	 */
	private final Dimension WINDOW_DIM = new Dimension(600,500);
	
	/**
	 * A JPanel that contains the background.
	 */
	private JPanel background;
	
	/**
	 * A JPanel that contains the title label.
	 */
	private JPanel titlePanel;
	
	/**
	 * A JLAbel that contains the title image.
	 */
	private JLabel titleLabel;
	
	/**
	 * A JPanel that contains the player one info label.
	 */
	private JPanel p1infoPanel;
	
	/**
	 * A JTextField contains the player one name.
	 */
	private JTextField p1NameField;
	
	/**
	 * A JRadioButton which allow to choose the red color for the player one.
	 */
	private JRadioButton p1RedColor;
	
	/**
	 * A JRadioButton which allow to choose the red color for the player one.
	 */
	private JRadioButton p1YellowColor;
	
	/**
	 * A JRadioButton which allow to choose the red color for the player one.
	 */
	private JRadioButton p1GreenColor;
	
	/**
	 * A JRadioButton which allow to choose the red color for the player one.
	 */
	private JRadioButton p1BlueColor;
	
	/**
	 * A ButtonGroup which handles the colors button for player one.
	 */
	private ButtonGroup p1ColorGroup;
	
	
	/**
	 * A JPanel that contains the player two info label.
	 */
	private JPanel p2infoPanel;
	
	/**
	 * A JTextField contains the player two name.
	 */
	private JTextField p2NameField;
	
	/**
	 * A JRadioButton which allow to choose the red color for the player two.
	 */
	private JRadioButton p2RedColor;
	
	/**
	 * A JRadioButton which allow to choose the red color for the player two.
	 */
	private JRadioButton p2YellowColor;
	
	/**
	 * A JRadioButton which allow to choose the red color for the player two.
	 */
	private JRadioButton p2GreenColor;
	
	/**
	 * A JRadioButton which allow to choose the red color for the player two.
	 */
	private JRadioButton p2BlueColor;
	
	/**
	 * A ButtonGroup which handles the colors button for player two.
	 */
	private ButtonGroup p2ColorGroup;
	
	/**
	 * A string with contains the information of the color choosen for player one.
	 */
	private String color1Selected;
	
	/**
	 * A string with contains the information of the color choosen for player two.
	 */
	private String color2Selected;
	
	/**
	 * A JPanel wich contains the table dimension button.
	 */
	private JPanel tableDimensionPanel;
	
	/**
	 * A JRadioButton which contains the first choise for the table dimension.
	 */
	private JRadioButton tableDimension0;
	
	/**
	 * A JRadioButton which contains the second choise for the table dimension.
	 */
	private JRadioButton tableDimension1;
	
	/**
	 * A JRadioButton which contains the third choise for the table dimension.
	 */
	private JRadioButton tableDimension2;
	
	/**
	 * A JRadioButton which contains the fourth choise for the table dimension.
	 */
	private JRadioButton tableDimension3;
	
	/**
	 * A ButtonGroup which handles the table dimension buttons.
	 */
	private ButtonGroup tableDimension;
	
	/**
	 * A string with contains the information of the selected table dimension.
	 */
	private String dimensionSelected;
	
	/**
	 * A JPanel that contains the mein menu and the start buttons.
	 */
	private JPanel buttonsPanel;
	
	/**
	 * The main menu button.
	 */
	private JButton mainMenuButton;
	
	/**
	 * The start button.
	 */
	private JButton startButton;
	
	/**
	 * The constructor of the selection window class.
	 */
	public SelectionWindow() {
		this.addComponent();
		this.setup();
	}
	
	/**
	 * Add components to the frame.
	 */
	private void addComponent() {
        this.createBackground();
        this.createTitlePanel();
        this.createP1infoPanel();
        this.createP2infoPanel();
        this.createTableDimensionPanel();
        this.createButtonsPanel();
        this.setIconImage(this.createImage("Images/Forza4_i.png"));
    }
	
	/**
	 * Create the background panel.
	 */
	private void createBackground() {
        this.background = this.createPanel(null, new Color(8,12,36), 0, 0, 600,500); //Initialize the panel.
        this.add(background); //Add the background panel to the frame.
    }
	
	/**
	 * Create the title panel.
	 */
	private void createTitlePanel() {
		this.titlePanel = this.createPanel(null, null, 0,0,600,100); //Initialize the title panel.
		this.titleLabel = new JLabel(); //Initialize the title label.
		this.titleLabel.setIcon(this.createImageIcon("Images/title.png")); //Set the image of the label.
		this.titleLabel.setBounds(100,0,400,100); //Set the bounds of the label.
		this.titlePanel.add(this.titleLabel); //Add the title label to the title panel.
		this.background.add(this.titlePanel); //Add the title panel to the backgroundpanel.
	}
	
	/**
	 * Create the player one info panel.
	 */
	private void createP1infoPanel() {
		this.p1infoPanel = this.createPanel(null, new Color(8,12,36), 0, 100, 600, 100); //Initialize the player one info panel.
		JLabel p1NameLabel = this.createLabel("Choose a name for player 1: "); //Setup the player one name label.
		p1NameLabel.setBounds(30,25,250,25);
		this.p1NameField = this.createNameField(); //Setup the player one name text field.
		JLabel maxCharLabel = new JLabel("(max 12 characters)"); //Setup the max characters label.
		maxCharLabel.setBounds(420,25,150,25);
		maxCharLabel.setForeground(Color.white);
		JLabel p1ColorLabel = this.createLabel("Choose a color for player 1: "); //Setup the player one color label.
		p1ColorLabel.setBounds(30,60,250,25);
		this.createP1ColorGroup(); //Create the color group for player one.
		this.color1Selected = "R"; //Set the string color information for player one to red at the beginning.
		this.p1infoPanel.add(this.p1RedColor); //Add components to the player one info panel.
		this.p1infoPanel.add(this.p1YellowColor);
		this.p1infoPanel.add(this.p1GreenColor);
		this.p1infoPanel.add(this.p1BlueColor);
		this.p1infoPanel.add(p1NameLabel);
		this.p1infoPanel.add(this.p1NameField);
		this.p1infoPanel.add(maxCharLabel);
		this.p1infoPanel.add(p1ColorLabel);
		this.background.add(this.p1infoPanel);
	}
	
	/**
	 * Create the color group for player one.
	 */
	private void createP1ColorGroup() {
		this.p1ColorGroup = new ButtonGroup();//Initialize the button group.
		//Setup the red button.
		this.p1RedColor = this.createRadioButton("Red");
		this.p1RedColor.setIcon(this.createImageIcon("Images/redSelected.png"));
		this.p1RedColor.setBounds(220, 60, 50, 30);
		this.p1RedColor.addActionListener(this);
		//Setup the yellow button.
		this.p1YellowColor = this.createRadioButton("Yellow");
		this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
		this.p1YellowColor.setBounds(280, 60, 70, 30);
		this.p1YellowColor.addActionListener(this);
		//Setup the green button.
		this.p1GreenColor = this.createRadioButton("Green");
		this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
		this.p1GreenColor.setBounds(355, 60, 60, 30);
		this.p1GreenColor.addActionListener(this);
		
		//Setup the blue button.
		this.p1BlueColor = this.createRadioButton("Blue");
		this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
		this.p1BlueColor.setBounds(425, 60, 60, 30);
		this.p1BlueColor.addActionListener(this);
		
		//Add buttons to the color group.
		this.p1ColorGroup.add(this.p1RedColor);
		this.p1ColorGroup.add(this.p1YellowColor);
		this.p1ColorGroup.add(this.p1GreenColor);
		this.p1ColorGroup.add(this.p1BlueColor);
		this.p1ColorGroup.setSelected(this.p1RedColor.getModel(), true);
	}
	
	/**
	 * Create the player one info panel.
	 */
	private void createP2infoPanel() {
		this.p2infoPanel = this.createPanel(null, new Color(8,12,36), 0, 200, 600, 100); //Initialize the player two info panel.
		JLabel p2NameLabel = this.createLabel("Choose a name for player 2: "); //Setup the player two name label.
		p2NameLabel.setBounds(30,25,250,25);
		this.p2NameField = this.createNameField(); //Setup the player two name text field.
		JLabel maxCharLabel = new JLabel("(max 12 characters)"); //Setup the max characters label.
		maxCharLabel.setBounds(420,25,150,25);  
		maxCharLabel.setForeground(Color.white);
		JLabel p2ColorLabel = this.createLabel("Choose a color for player 2: "); //Setup the player two color label.
		p2ColorLabel.setBounds(30,60,250,25);
		this.createP2ColorGroup(); //Create the color group for player two.
		this.color2Selected = "Y"; //Set the string color information for player two to yellow at the beginning.
		this.p2infoPanel.add(this.p2RedColor); //Add components on the player two label.
		this.p2infoPanel.add(this.p2YellowColor);
		this.p2infoPanel.add(this.p2GreenColor);
		this.p2infoPanel.add(this.p2BlueColor);
		this.p2infoPanel.add(p2NameLabel);
		this.p2infoPanel.add(this.p2NameField);
		this.p2infoPanel.add(maxCharLabel);
		this.p2infoPanel.add(p2ColorLabel);
		this.background.add(this.p2infoPanel);
	}
	
	/**
	 * Create the color group for player two.
	 */
	private void createP2ColorGroup() {
		this.p2ColorGroup = new ButtonGroup(); //Initialize the button group.
		
		//Setup the red button.
		this.p2RedColor = this.createRadioButton("Red");
		this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
		this.p2RedColor.setBounds(220, 60, 50, 30);
		this.p2RedColor.addActionListener(this);
		
		//Setup the yellow button.
		this.p2YellowColor = this.createRadioButton("Yellow");
		this.p2YellowColor.setIcon(this.createImageIcon("Images/yellowSelected.png"));
		this.p2YellowColor.setBounds(280, 60, 70, 30);
		this.p2YellowColor.addActionListener(this);
		
		//Setup the green button.
		this.p2GreenColor = this.createRadioButton("Green");
		this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
		this.p2GreenColor.setBounds(355, 60, 60, 30);
		this.p2GreenColor.addActionListener(this);
		
		//Setup the blue button.
		this.p2BlueColor = this.createRadioButton("Blue");
		this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
		this.p2BlueColor.setBounds(425, 60, 60, 30);
		this.p2BlueColor.addActionListener(this);
		
		//Add bottons to the color group.
		this.p2ColorGroup.add(this.p2RedColor);
		this.p2ColorGroup.add(this.p2YellowColor);
		this.p2ColorGroup.add(this.p2GreenColor);
		this.p2ColorGroup.add(this.p2BlueColor);
		this.p2ColorGroup.setSelected(this.p2YellowColor.getModel(), true);
	}
	
	/**
	 * Creates a JLabel.
	 * @param Label the title of the label.
	 * @return newLabel the JLabel created.
	 */
	private JLabel createLabel(String label) {
		JLabel newLabel = new JLabel(label);
		newLabel.setForeground(Color.white);
		return newLabel;
	}
	
	/**
	 * Creates a JTextField.
	 * @return nameField the JTextField created.
	 */
	private JTextField createNameField(){
		JTextField nameField = new JTextField();
		nameField.setBackground(new Color(255,255,255));
		nameField.setBounds(205, 28, 200, 20);
		nameField.setBorder(null);
		return nameField;
	}
	
	/**
	 * Creates the table dimension panel.
	 */
	private void createTableDimensionPanel() {
		this.tableDimensionPanel = this.createPanel(null, new Color(8,12,36), 0, 300, 600, 100); //Setup the table panel.
		JLabel tableDimensionLabel = this.createLabel("Choose a dimension for the game table: ");
		tableDimensionLabel.setBounds(30,10,600,30);
		this.createTableDimensionGroup();
		this.dimensionSelected = "7x6"; //Set the dimension selected information at the beginning to 7x6.
		this.tableDimensionPanel.add(tableDimensionLabel); //Add components to the table dimension panel.
		this.tableDimensionPanel.add(tableDimension0);
		this.tableDimensionPanel.add(tableDimension1);
		this.tableDimensionPanel.add(tableDimension2);
		this.tableDimensionPanel.add(tableDimension3);
		this.background.add(this.tableDimensionPanel); //Add the table dimension panel to the background panel.
	}
	
	/**
	 * Setup the table dimension button group.
	 */
	private void createTableDimensionGroup() {
		this.tableDimension = new ButtonGroup(); //Initialize the button group
		this.tableDimension0 = this.createRadioButton("5x4"); //Set the 5x4 table size button.
		this.tableDimension0.setIcon(this.createImageIcon("Images/white.png"));
		this.tableDimension0.setBounds(125, 50, 50, 20);
		this.tableDimension0.addActionListener(this);
		this.tableDimension1 = this.createRadioButton("6x5"); //Set the 6x5 table size button.
		this.tableDimension1.setIcon(this.createImageIcon("Images/white.png"));
		this.tableDimension1.setBounds(225, 50, 50, 20);
		this.tableDimension1.addActionListener(this);
		this.tableDimension2 = this.createRadioButton("7x6"); //Set the 7x6 table size button.
		this.tableDimension2.setIcon(this.createImageIcon("Images/whiteSelected.png"));
		this.tableDimension2.setBounds(325, 50, 50, 20);
		this.tableDimension2.addActionListener(this);
		this.tableDimension3 = this.createRadioButton("8x7"); //Set the 8x7 table size button.
		this.tableDimension3.setIcon(this.createImageIcon("Images/white.png"));
		this.tableDimension3.setBounds(425, 50, 50, 20);
		this.tableDimension3.addActionListener(this);
		this.tableDimension.add(this.tableDimension0); //Add the buttons to the table dimension button group.
		this.tableDimension.add(this.tableDimension1);
		this.tableDimension.add(this.tableDimension2);
		this.tableDimension.add(this.tableDimension3);
		this.tableDimension.setSelected(this.tableDimension2.getModel(), true);
	}
	
	/**
	 * Create a new JRadioButton.
	 * @param buttonName the name of the button.
	 * @return newButton the button created.
	 */
	private JRadioButton createRadioButton(String buttonName) {
		JRadioButton newButton = new JRadioButton(buttonName);
		newButton.setBackground(new Color(8,12,36));
		newButton.setForeground(Color.white);
		newButton.setBorder(null);
		newButton.setActionCommand(buttonName);
		return newButton;
	}
	
	/**
	 * Create the button panel.
	 */
	private void createButtonsPanel() {
		this.buttonsPanel = this.createPanel(null, new Color(8,12,36), 0, 400, 600, 100); //Setup the button panel.
		this.startButton = this.createStartButton(); //Create the new game button.
		this.mainMenuButton = this.createMainMenuButton(); //Create the main menu button.
		this.buttonsPanel.add(this.startButton); //Add buttons to the button panel
		this.buttonsPanel.add(this.mainMenuButton);
		this.background.add(this.buttonsPanel); //Add the button panel to the background.
	}
	
	/**
	 * Create the main menu button.
	 * @return mainMenuButton the main menu button.
	 */
	private JButton createMainMenuButton() {
		JButton mainMenuButton = new JButton("MAIN MENU");;
		mainMenuButton.setFont(new Font("", Font.CENTER_BASELINE, 13));
		mainMenuButton.setBorder(null);
		mainMenuButton.setBounds(75,30,187,40);
		mainMenuButton.setForeground(new Color(247,246,241));
		mainMenuButton.setBackground(new Color(33,65,119));
		mainMenuButton.getModel().addChangeListener(new ChangeListener(){
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
		mainMenuButton.addActionListener(this);
		return mainMenuButton;
	}
	
	/**
	 * Create the start button.
	 * @return startButton the start button.
	 */
	private JButton createStartButton() {
		JButton startButton = new JButton("START GAME");;
		startButton.setFont(new Font("", Font.CENTER_BASELINE, 13));
		startButton.setBorder(null);
		startButton.setBounds(337,30,187,40);
		startButton.setForeground(new Color(247,246,241));
		startButton.setBackground(new Color(33,65,119));
		startButton.getModel().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				ButtonModel model = (ButtonModel) e.getSource();
				if (model.isRollover()) {
					startButton.setBackground(new Color(247,246,241));
					startButton.setForeground(new Color(33,65,119));
					}
				else {
					startButton.setForeground(new Color(247,246,241));
					startButton.setBackground(new Color(33,65,119));
				}
			}
		});
		startButton.addActionListener(this);
		return startButton;
	}
	
	/**
	 * Setup the game with all the information given in input.
	 */
	private void setGame() {
		String p1Name = this.p1NameField.getText(); //A string containing the player one name.
		String p2Name = this.p2NameField.getText(); //A string containing the player two name.
		//Manages all cases of color selection for the two players and assigns the right color to the two variables containing the information on the chosen color.
		if (this.p1ColorGroup.getSelection() == this.p1BlueColor.getModel()) {
			this.color1Selected = "B";
		}
		else if (this.p1ColorGroup.getSelection() == this.p1GreenColor.getModel()) {
			this.color1Selected = "G";
		}
		else if (this.p1ColorGroup.getSelection() == this.p1YellowColor.getModel()) {
			this.color1Selected = "Y";
		}
		else {
			this.color1Selected = "R";
		}
		if (this.p2ColorGroup.getSelection() == this.p2BlueColor.getModel()) {
			this.color2Selected = "B";
		}
		else if (this.p2ColorGroup.getSelection() == this.p2GreenColor.getModel()) {
			this.color2Selected = "G";
		}
		else if (this.p2ColorGroup.getSelection() == this.p2YellowColor.getModel()) {
			this.color2Selected = "Y";
		}
		else {
			this.color2Selected = "R";
		}
		GameColor p1Color = this.getChoosenPlayerColor(this.color1Selected); //Get the choosen color for player one.
		GameColor p2Color = this.getChoosenPlayerColor(this.color2Selected); //Get the choosen color for player two.
		Player p1 = new Player(p1Name, p1Color); //create the player one.
		Player p2 = new Player(p2Name, p2Color); //create the player two.
		String[] dimensions = this.dimensionSelected.split("x"); //Get the dimension table
		int L = Integer.parseInt(dimensions[0]);
		int H = Integer.parseInt(dimensions[1]);
		GameWindow.game = new Forza4(L, H, p1, p2); //Set the gameWindow game according to the info given in input.
	}
	
	/**
	 * Get the color corresponding to the color string information provided in input.
	 * @param color a string containing the color info.
	 * @return A GameColor object according to the string given in input.
	 */
	private GameColor getChoosenPlayerColor(String color) {
		return GameColor.match(color);
	}
	
	/**
	 * The method of the actionListener interface that allows to perform actions with buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//It allows to change the color bottons icon according to the one selected.
		if (e.getSource() == this.p1RedColor) {
			if (this.p2ColorGroup.getSelection() == this.p2RedColor.getModel()) {
				this.p2ColorGroup.setSelected(this.p2YellowColor.getModel(), true);
				this.p1RedColor.setIcon(this.createImageIcon("Images/redSelected.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
				this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellowSelected.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
			else {
				this.p1RedColor.setIcon(this.createImageIcon("Images/redSelected.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
		}
		
		if (e.getSource() == this.p1YellowColor) {
			if (this.p2ColorGroup.getSelection() == this.p2YellowColor.getModel()) {
				this.p2ColorGroup.setSelected(this.p2GreenColor.getModel(), true);
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellowSelected.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
				this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/greenSelected.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
			else {
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellowSelected.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));	
			}
		}
		
		if (e.getSource() == this.p1GreenColor) {
			if (this.p2ColorGroup.getSelection() == this.p2GreenColor.getModel()) {
				this.p2ColorGroup.setSelected(this.p2BlueColor.getModel(), true);
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/greenSelected.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
				this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blueSelected.png"));
			}
			else {
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/greenSelected.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
		}
		if (e.getSource() == this.p1BlueColor) {
			if (this.p2ColorGroup.getSelection() == this.p2BlueColor.getModel()) {
				this.p2ColorGroup.setSelected(this.p2RedColor.getModel(), true);
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blueSelected.png"));
				this.p2RedColor.setIcon(this.createImageIcon("Images/redSelected.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
			else {
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blueSelected.png"));
			}
		}
		
		if (e.getSource() == this.p2RedColor) {
			if (this.p1ColorGroup.getSelection() == this.p1RedColor.getModel()) {
				this.p1ColorGroup.setSelected(this.p1YellowColor.getModel(), true);
				this.p2RedColor.setIcon(this.createImageIcon("Images/redSelected.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellowSelected.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
			else {
				this.p2RedColor.setIcon(this.createImageIcon("Images/redSelected.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
			}
		}
		
		if (e.getSource() == this.p2YellowColor) {
			if (this.p1ColorGroup.getSelection() == this.p1YellowColor.getModel()) {
				this.p1ColorGroup.setSelected(this.p1GreenColor.getModel(), true);
				this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellowSelected.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/greenSelected.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
			else {
				this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellowSelected.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
		}
		
		if (e.getSource() == this.p2GreenColor) {
			if (this.p1ColorGroup.getSelection() == this.p1GreenColor.getModel()) {
				this.p1ColorGroup.setSelected(this.p1BlueColor.getModel(), true);
				this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/greenSelected.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
				this.p1RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blueSelected.png"));
			}
			else {
				this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/greenSelected.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
		}
		if (e.getSource() == this.p2BlueColor) {
			if (this.p1ColorGroup.getSelection() == this.p1BlueColor.getModel()) {
				this.p1ColorGroup.setSelected(this.p1RedColor.getModel(), true);
				this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blueSelected.png"));
				this.p1RedColor.setIcon(this.createImageIcon("Images/redSelected.png"));
				this.p1YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p1GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p1BlueColor.setIcon(this.createImageIcon("Images/blue.png"));
			}
			else {
				this.p2RedColor.setIcon(this.createImageIcon("Images/red.png"));
				this.p2YellowColor.setIcon(this.createImageIcon("Images/yellow.png"));
				this.p2GreenColor.setIcon(this.createImageIcon("Images/green.png"));
				this.p2BlueColor.setIcon(this.createImageIcon("Images/blueSelected.png"));
			}
		}
		
		if (e.getSource() == this.startButton) { 
			if (this.p1NameField.getText().isEmpty() && this.p2NameField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please choose player names!", "Warning", JOptionPane.WARNING_MESSAGE); //Handle the exception when both player names are empty.
			}
			else if (this.p2NameField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please choose player 2 name!", "Warning", JOptionPane.WARNING_MESSAGE); //Handle the exception when player two name is empty.
			}
			else if (this.p1NameField.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Please choose player 1 name!", "Warning", JOptionPane.WARNING_MESSAGE); //Handle the exception when player one name is empty.
			}
			else if(this.p1NameField.getText().equals(this.p2NameField.getText())) {
				JOptionPane.showMessageDialog(this, "The names of the players must be different.", "Warning", JOptionPane.WARNING_MESSAGE); //Handle the exception when players name are equal.
			}
			else if(this.p1NameField.getText().length() > 12 && this.p2NameField.getText().length() > 12){
				JOptionPane.showMessageDialog(this, "Player names must not exceed 12 characters.", "Warning", JOptionPane.WARNING_MESSAGE); //Handle  exception when both player names are longer than 12 characters.
			}
			else if(this.p2NameField.getText().length() > 12) {
				JOptionPane.showMessageDialog(this, "Player 2 name must not exceed 12 characters.", "Warning", JOptionPane.WARNING_MESSAGE); //Handle  exception when player name is longer than 12 characters.
			}
			else if(this.p1NameField.getText().length() > 12) {
				JOptionPane.showMessageDialog(this, "Player 1 name must not exceed 12 characters.", "Warning", JOptionPane.WARNING_MESSAGE); //Handle exception when player name is longer than 12 characters.
			}
			else { //the start button action.
				this.setGame(); //Set the game.
				WindowManager.switchToGameWindow(); //Open the game window.
			}
		}
		
		if (e.getSource() == this.mainMenuButton) { //the main menu button action.
			WindowManager.switchToStartWindow(); //Open the start window.
		}
		
		//It allows to change the dimension bottons icon according to the one selected.
		if (e.getSource() == this.tableDimension0) {
			this.dimensionSelected = this.tableDimension0.getText();
			this.tableDimension0.setIcon(this.createImageIcon("Images/whiteSelected.png"));
			this.tableDimension1.setIcon(this.createImageIcon("Images/white.png"));
			this.tableDimension2.setIcon(this.createImageIcon("Images/white.png"));
			this.tableDimension3.setIcon(this.createImageIcon("Images/white.png"));
		}
		if (e.getSource() == this.tableDimension1) {
			this.dimensionSelected = this.tableDimension1.getText();
			this.tableDimension1.setIcon(this.createImageIcon("Images/whiteSelected.png"));
			this.tableDimension0.setIcon(this.createImageIcon("Images/white.png"));
			this.tableDimension2.setIcon(this.createImageIcon("Images/white.png"));
			this.tableDimension3.setIcon(this.createImageIcon("Images/white.png"));
		}
		if (e.getSource() == this.tableDimension2) {
			this.dimensionSelected = this.tableDimension2.getText();
			this.tableDimension2.setIcon(this.createImageIcon("Images/whiteSelected.png"));
			this.tableDimension0.setIcon(this.createImageIcon("Images/white.png"));
			this.tableDimension1.setIcon(this.createImageIcon("Images/white.png"));
			this.tableDimension3.setIcon(this.createImageIcon("Images/white.png"));
		}
		if (e.getSource() == this.tableDimension3) {
			this.dimensionSelected = this.tableDimension3.getText();
			this.tableDimension3.setIcon(this.createImageIcon("Images/whiteSelected.png"));
			this.tableDimension0.setIcon(this.createImageIcon("Images/white.png"));
			this.tableDimension1.setIcon(this.createImageIcon("Images/white.png"));
			this.tableDimension2.setIcon(this.createImageIcon("Images/white.png"));
		}
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
        this.setTitle("Forza4 - Selection menu"); //Set the title.
        this.setResizable(false); //Set the frame to a non-resizable frame.
        this.setLocationRelativeTo(null); //Set the frame to the center of the screen.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows when the botton x it's pressed to stop the program.
        this.setVisible(true); //Set the frame to visible.
    } 
}
