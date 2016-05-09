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

@SuppressWarnings("serial")
public class TimerPanel extends JPanel {

	public static JTextArea timer = new JTextArea(" 00:00:00");
	
	// Blank Pictures for Timer
	JLabel northTimer = new JLabel(ImageLoader.loadIcon("Menupanel/north_timer.png"));
	JLabel eastTimer = new JLabel(ImageLoader.loadIcon("Menupanel/west_east.png"));
	JLabel southTimer = new JLabel(ImageLoader.loadIcon("Menupanel/south.png"));
	JLabel westTimer = new JLabel(ImageLoader.loadIcon("Menupanel/west_east.png"));
	
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

}
