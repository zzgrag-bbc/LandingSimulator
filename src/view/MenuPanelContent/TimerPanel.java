package view.MenuPanelContent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import UtilityClasses.ImageLoader;

/**
 * Kreiert einen Timer.
 */
@SuppressWarnings("serial")
public class TimerPanel extends JPanel {

	private JTextArea timer = new JTextArea(" 00:00:00");

	// Blank Pictures for Timer
	private JLabel northTimer = new JLabel(ImageLoader.loadIcon("Menupanel/north_timer.png"));
	private JLabel eastTimer = new JLabel(ImageLoader.loadIcon("Menupanel/west_east.png"));
	private JLabel southTimer = new JLabel(ImageLoader.loadIcon("Menupanel/south.png"));
	private JLabel westTimer = new JLabel(ImageLoader.loadIcon("Menupanel/west_east.png"));

	/**
	 * Setzt das Design des Timers.
	 */
	
	public TimerPanel() {

		// Border & Font
		Border border = new LineBorder(Color.DARK_GRAY, 2);
		Font font = new Font("Arial", Font.BOLD, 22);

		// Adding Components to timerPanel + Design
		timer.setFont(font);
		timer.setBorder(border);
		setLayout(new BorderLayout());
		setOpaque(false);
		add(northTimer, BorderLayout.NORTH);
		add(eastTimer, BorderLayout.EAST);
		add(timer, BorderLayout.CENTER);
		add(southTimer, BorderLayout.SOUTH);
		add(westTimer, BorderLayout.WEST);
	}
	
	public void setTimerText(String formattedTimerText)
	{
		timer.setText(formattedTimerText);
	}

}
