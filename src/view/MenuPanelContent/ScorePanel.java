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
public class ScorePanel extends JPanel {

	// Blank Pictures for Score
	JLabel northScore = new JLabel(ImageLoader.loadIcon("Menupanel/north_score.png"));
	JLabel eastScore = new JLabel(ImageLoader.loadIcon("Menupanel/west_east.png"));
	JLabel southScore = new JLabel(ImageLoader.loadIcon("Menupanel/south.png"));
	JLabel westScore = new JLabel(ImageLoader.loadIcon("Menupanel/west_east.png"));

	public ScorePanel() {

		// TextArea to display Score
		JTextArea score = new JTextArea(" 0000");

		// Border & Font
		Border border = new LineBorder(Color.DARK_GRAY, 2);
		Font font = new Font("Arial", Font.BOLD, 22);

		// Adding Components to scorePanel + Design
		score.setFont(font);
		score.setBorder(border);
		setLayout(new BorderLayout());
		setOpaque(false);
		add(northScore, BorderLayout.NORTH);
		add(eastScore, BorderLayout.EAST);
		add(score, BorderLayout.CENTER);
		add(southScore, BorderLayout.SOUTH);
		add(westScore, BorderLayout.WEST);
	}

}
