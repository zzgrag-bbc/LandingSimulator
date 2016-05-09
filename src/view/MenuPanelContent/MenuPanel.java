package view.MenuPanelContent;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;

import UtilityClasses.ImageLoader;
import UtilityClasses.ImagePanel;

@SuppressWarnings("serial")
public class MenuPanel extends ImagePanel {

	private static final Image BACKGROUND = ImageLoader.Image("Menupanel/menupanel_background.jpg");

	// Creating Panels
	private JButton startButton = new StartButton();
	private JButton changeButton = new ChangeButton();
	private JButton quitButton = new QuitButton();
	private JPanel fuelPanel = new FuelPanel();
	private JPanel scorePanel = new ScorePanel();
	private JPanel timerPanel = new TimerPanel();

	public MenuPanel() {

		super(BACKGROUND);

		// Adding Components to Layout
		setLayout(new GridLayout(8, 1));
		add(startButton);
		add(changeButton);
		add(quitButton);
		add(fuelPanel);
		add(scorePanel);
		add(timerPanel);
	}

	public JButton getStartButton() {
		return startButton;
	}
}