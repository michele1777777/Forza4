package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;

import game.GameLoader;

/**
 * The StartWindow class that manage the start window frame.
 * @author Leuti Michele
 */
public class StartWindow extends JFrame implements ActionListener{
	
	/**
	 * The dimension of the frame.
	 */
	private final Dimension WINDOW_DIM = new Dimension(600, 500);
	
	/**
	 * A JPanel that contains the background.
	 */
	private JPanel background;
	
	/**
	 * A JPanel that contains the title label.
	 */
	private JPanel titlePanel;
	
	/**
	 * A JLabel that contains the title image.
	 */
	private JLabel titleLabel;

	/**
	 * A JLabel which contains the image label.
	 */
	private JPanel imagePanel;
	
	/**
	 * A JLabel which contains the image of the start window.
	 */
	private JLabel imageLabel;
	
	/**
	 * A JPanel that contains the start button, the load button and the quit button.
	 */
	private JPanel buttonPanel;
	
	/**
	 * The new game button.
	 */
	private JButton newGameButton;
	
	/**
	 * The load game button.
	 */
	private JButton loadGameButton;
	
	/**
	 * The quit button.
	 */
	private JButton quitButton;
	
	/**
	 * The constructor of the StartWindow class.
	 */
	public StartWindow() {
		this.addComponent();
		this.setup();
	}
	
	/**
	 * Adds component on frame.
	 */
	private void addComponent() {
        this.createBackground();
        this.createButtonPanel();
        this.createImagePanel();
        this.createTitlePanel();
    }
	
	/**
	 * Create the background panel.
	 */
	private void createBackground() {
        this.background = this.createPanel(null, new Color(8,12,36), 0, 0, 600, 500);
        this.add(background);
    }
	
	/**
	 * Create the image panel.
	 */
	private void createTitlePanel() {
		this.titlePanel = this.createPanel(null, null, 0,0,600,100);
		this.titleLabel = new JLabel();
		this.titleLabel.setIcon(this.createImageIcon("Images/title.png"));
		this.titleLabel.setBounds(100,0,400,100);
		this.titlePanel.add(this.titleLabel);
		this.background.add(this.titlePanel);
	}
	
	/**
	 * Create the image panel.
	 */
	private void createImagePanel() {
		this.imagePanel = this.createPanel(null, null, 170,75,600,600);
		this.imageLabel = new JLabel();
		this.imageLabel.setIcon(this.createImageIcon("Images/forza4.png"));
		this.imageLabel.setBounds(0,10,250,250);
		this.imagePanel.add(this.imageLabel);
		this.background.add(this.imagePanel);
	}
	
	/**
	 * Create the button panel.
	 */
	private void createButtonPanel() {
		this.buttonPanel =  this.createPanel(null, null, 0, 350, 600, 250);
		this.loadGameButton = this.createLoadButton();
		this.newGameButton = this.createNewGameButton();
		this.quitButton = this.createQuitButton();
		this.newGameButton.setBounds(150, 0, 300, 30);
		this.loadGameButton.setBounds(150, 50, 300, 30);
		this.quitButton.setBounds(150,100, 300, 30);
		this.buttonPanel.add(this.loadGameButton);
		this.buttonPanel.add(this.newGameButton);
		this.buttonPanel.add(this.quitButton);
		this.background.add(this.buttonPanel);
	}
	
	private JButton createNewGameButton() {
		JButton newGameButton = new JButton("NEW GAME");; //Initialize the new game button.
		newGameButton.setFont(new Font("", Font.CENTER_BASELINE, 13)); //Setup the button.
		newGameButton.setBorder(null);
		newGameButton.setForeground(new Color(247,246,241));
		newGameButton.setBackground(new Color(33,65,119));
		newGameButton.getModel().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) { //It allows to change background and foreground colors when mouse rolls over the button.
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
	
	private JButton createLoadButton() {
		JButton loadButton = new JButton("LOAD GAME");//Initialize the load game button.
		loadButton.setBorder(null); //Setup the button.
		loadButton.setFont(new Font("", Font.CENTER_BASELINE, 13));
		loadButton.setForeground(new Color(247,246,241));
		loadButton.setBackground(new Color(33,65,119));
		loadButton.getModel().addChangeListener(new ChangeListener(){ //It allows to change background and foreground colors when mouse rolls over the button.
			@Override
			public void stateChanged(ChangeEvent e) {
				ButtonModel model = (ButtonModel) e.getSource();
				if (model.isRollover()) {
					loadButton.setBackground(new Color(247,246,241));
					loadButton.setForeground(new Color(33,65,119));
					}
				else {
					loadButton.setForeground(new Color(247,246,241));
					loadButton.setBackground(new Color(33,65,119));
				}
			}
		});
		loadButton.addActionListener(this); //Add the button action.
		return loadButton;
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
	 * The method of the actionListener interface that allows to perform actions with buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.newGameButton) { //The new game button action.
			WindowManager.switchToSelectionWindow(); //Open the selection window.
		} 
		else if(e.getSource() == this.loadGameButton) { //the load game button action.
			JFileChooser fileChooser = new JFileChooser(); //Initialize a fileChooser
			fileChooser.setAcceptAllFileFilterUsed(false); //Setup the file chooser and the relative filter.
			fileChooser.setFileFilter(new FileFilter() {
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
				int choise = fileChooser.showOpenDialog(null);
				if (choise == JFileChooser.APPROVE_OPTION) {
					String fileName = fileChooser.getSelectedFile().getPath(); //The path of the choosen file.
					GameWindow.game = GameLoader.loadFromFile(fileName); //Load game from file.
					WindowManager.switchToGameWindow(); //Open the game window
				}
			}
			catch(Exception error){
				error.printStackTrace();
			}
		}
		else { //The quit botton action.
			WindowManager.quit(); 
		}
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
        this.setTitle("Forza4 - main menu"); //Set the title.
        this.setResizable(false); //Set the frame to a non-resizable frame.
        this.setLocationRelativeTo(null); //Set the frame to the center of the screen.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows when the botton x it's pressed to stop the program.
        this.setVisible(true); //Set the frame to visible.
    } 
	
}
