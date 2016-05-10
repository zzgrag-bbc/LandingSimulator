package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JWindow;

import view.MenuPanelContent.MenuPanel;
import view.PlayPanelContent.PlayPanel;
import view.Screens.StartScreenPanel;

@SuppressWarnings("serial")
public class View extends JWindow {

	// Instance Variables
	private StartScreenPanel startScreenPanel;

	// Constructor
	private View() {
		setSize(1920, 1080);
		setLayout(new BorderLayout());
		startScreenPanel = new StartScreenPanel(this);
		add(startScreenPanel);
		setVisible(true);
	}

	public void start() {
		remove(startScreenPanel);

		MenuPanel menuPanel = new MenuPanel();
		add(menuPanel, BorderLayout.WEST);

		PlayPanel playPanel = new PlayPanel();
		add(playPanel, BorderLayout.CENTER);
		pack();

		playPanel.setLandscapePositions();
		playPanel.setUfoPosition();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new View();
			}
		});
	}
}
