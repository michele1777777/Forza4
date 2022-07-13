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

/**
 * The ParityWindow class that manage the parity window frame.
 * @author Leuti Michele
 */
public class ParityWindow extends JFrame implements ActionListener{
	
	/**
	 * The dimension of the frame.
	 */
	private final Dimension WINDOW_DIM = new Dimension(600, 500);
	
	/**
	 * A JPanel that contains the background.
	 */
	private JPanel background;
	
	/**
	 * A JPanel that contains the save button and the main menu button.
	 */
	private JPanel buttonsPanel;
	
	/**
	 * The new game button.
	 */
	private JButton newGameButton;
	
	/**
	 * The new game button.
	 */
	private JButton mainMenuButton;
	
	/**
	 * The main menu button.
	 */
	private JButton quitButton;
		
	/**
	 * The constructor of the GameWindow class.
	 */
	public ParityWindow() {
		this.setup();
		this.addComponent();
	}
	
	/**
	 * Adds components to the frame.
	 */
	private void addComponent() {
        this.createBackground();
        this.createButtonPanel();
    }
	
	/**
	 * Create the background panel.
	 */
	private void createBackground() {
        this.background = this.createPanel(null, new Color(8,12,36), 0, 0, 600,500); //Initialize the background panel.
        JPanel imagePanel = this.createPanel(null, new Color(8,12,36), 0, 20, 600,200); //Initialize a panel which contains the draw image.
        imagePanel.setLayout(new GridBagLayout()); //Set the layout.
        JLabel imageLabel = new JLabel(); //Initialize a JLabel which contains the image.
        imageLabel.setIcon(this.createImageIcon("Images/parity.png")); //Setup the image of the JLabel.
        imagePanel.add(imageLabel); //Add the label to the image panel.
        JPanel drawPanel = this.createPanel(null, new Color(8,12,36), 0, 220, 600,100); //Initialize the panel.
        drawPanel.setLayout(new GridBagLayout()); //Set the layout.
        JLabel drawLabel = new JLabel("Draw!"); //Set the label.
        drawLabel.setFont(new Font("", Font.CENTER_BASELINE, 35));
        drawLabel.setForeground(Color.white);
        drawPanel.add(drawLabel);
        this.background.add(imagePanel); //Add the image panel to the background panel.
        this.background.add(drawPanel); //Add the draw panel to the background panel.
        this.add(background); //Add the background panel to the frame.
    }
	
	/**
	 * Create the panel that contains the save and the main menu button.
	 */
	private void createButtonPanel() {
		this.buttonsPanel =  this.createPanel(null, new Color(8,12,36), 0, 330, 600, 250); //Initialize the button panel.
		this.newGameButton = this.createNewGameButton(); //Creates the bottons.
		this.mainMenuButton = this.createMainMenuButton(); 
		this.quitButton = this.createQuitButton();
		this.newGameButton.setBounds(150, 0, 300, 30); //Setup the buttons bounds.
		this.mainMenuButton.setBounds(150, 55, 300, 30);
		this.quitButton.setBounds(150,110, 300, 30);
		this.buttonsPanel.add(newGameButton); //Add the bottons to the button panel.
		this.buttonsPanel.add(mainMenuButton);
		this.buttonsPanel.add(quitButton);
		this.background.add(buttonsPanel); //Add the button panel to the button.
	}
	
	/**
	 * Create the main menu button.
	 * @return mainMenuButton the main menu button.
	 */
	private JButton createMainMenuButton() {
		JButton mainMenuButton = new JButton("MAIN MENU");; //Initialize the main menu button.
		mainMenuButton.setFont(new Font("", Font.CENTER_BASELINE, 13)); //Setup the button.
		mainMenuButton.setBorder(null);
		mainMenuButton.setBounds(75,30,187,40);
		mainMenuButton.setForeground(new Color(247,246,241));
		mainMenuButton.setBackground(new Color(33,65,119));
		mainMenuButton.getModel().addChangeListener(new ChangeListener(){ //It allows to change background and foreground colors when mouse rolls over the button.
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
		mainMenuButton.addActionListener(this); //Add the button action.
		return mainMenuButton;
	}
	
	/**
	 * Creates the new game button.
	 * @return newGameButton, the new game button.
	 */
	private JButton createNewGameButton() {
		JButton newGameButton = new JButton("NEW GAME");; //Initialize the new game button.
		newGameButton.setFont(new Font("", Font.CENTER_BASELINE, 13));//Setup the button.
		newGameButton.setBorder(null);
		newGameButton.setForeground(new Color(247,246,241));
		newGameButton.setBackground(new Color(33,65,119));
		newGameButton.getModel().addChangeListener(new ChangeListener(){//It allows to change background and foreground colors when mouse rolls over the button.
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
		newGameButton.addActionListener(this); //Add the button action.
		return newGameButton;
	}
	
	/**
	 * Creates the quit button.
	 * @return quitButton, the quit button.
	 */
	private JButton createQuitButton() {
		JButton quitButton = new JButton("QUIT");//Initialize the quit button.
		quitButton.setBorder(null); //Setup the button.
		quitButton.setForeground(new Color(247,246,241));
		quitButton.setBackground(new Color(33,65,119));
		quitButton.setFont(new Font("", Font.CENTER_BASELINE, 15));
		quitButton.getModel().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {//It allows to change background and foreground colors when mouse rolls over the button.
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
		quitButton.addActionListener(this); //Add the button action.
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
        this.getContentPane().setPreferredSize(WINDOW_DIM); //Choose the dimension of the frame
        this.setIconImage(this.createImage("Images/Forza4_i.png")); //Choose the icon of the frame.
        this.pack();  
        this.setTitle("Forza4 - draw window"); //Set the title.
        this.setResizable(false); //Set the frame to a non-resizable frame.
        this.setLocationRelativeTo(null); //Set the frame to the center of the screen.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows when the botton x it's pressed to stop the program.
        this.setVisible(true); //Set the frame to visible.
    } 
	
}
	
