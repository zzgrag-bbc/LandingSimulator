package view.MenuPanelContent;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.ActorUfo;
import Model.GameTimer;
import UtilityClasses.ImageLoader;
import UtilityClasses.ImagePanel;
import view.PlayPanelContent.PlayPanel;

@SuppressWarnings("serial")
public class MenuPanel extends ImagePanel {

	private static final Image BACKGROUND = ImageLoader.Image("Menupanel/menupanel_background.jpg");

	// Creating Panels
	private JButton startButton;
	private JButton changeButton = new ChangeButton();
	private JButton quitButton = new QuitButton();
	private JPanel fuelPanel = new FuelPanel();
	private JPanel scorePanel;
	private TimerPanel timerPanel;

	public MenuPanel(PlayPanel playPanel, ScorePanel scorePanel) {

		super(BACKGROUND);
		
		timerPanel = new TimerPanel();
		GameTimer.getInstance().setTimerPanel(timerPanel);
		startButton = new StartButton(playPanel);
		this.scorePanel = scorePanel;

		// Adding Components to Layout
		setLayout(new GridLayout(8, 1));
		add(startButton);
		add(changeButton);
		add(quitButton);
		add(fuelPanel);
		add(this.scorePanel);
		add(timerPanel);
		
		changeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playPanel.getUfo().showNextSprite();
				playPanel.repaint();
				// playPanel.getUfo().setCollisionCircle(new Point(1, 1),  42);
				playPanel.requestFocusInWindow();
			}
		});
	}

	public JButton getStartButton() {
		return startButton;
	}
}