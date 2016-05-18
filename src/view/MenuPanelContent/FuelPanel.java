package view.MenuPanelContent;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import UtilityClasses.ImageLoader;

@SuppressWarnings("serial")
public class FuelPanel extends JPanel {
	
	// Fuel Bar
	public static JProgressBar fuel = new JProgressBar(0, 10000);

	// Blank Pictures for Fuel Bar
	JLabel northFuel = new JLabel(ImageLoader.loadIcon("Menupanel/north_fuel.png"));
	JLabel eastFuel = new JLabel(ImageLoader.loadIcon("Menupanel/west_east.png"));
	JLabel southFuel = new JLabel(ImageLoader.loadIcon("Menupanel/south.png"));
	JLabel westFuel = new JLabel(ImageLoader.loadIcon("Menupanel/west_east.png"));

	public FuelPanel() {

		// Design of Fuel Bar
		Border border = new LineBorder(Color.DARK_GRAY, 2);
		fuel.setForeground(Color.GREEN);
		fuel.setBackground(Color.LIGHT_GRAY);
		fuel.setBorder(border);
		fuel.setValue(10000);

		// Adding Components to fuelPanel + Design
		setLayout(new BorderLayout());
		setOpaque(false);
		add(northFuel, BorderLayout.NORTH);
		add(eastFuel, BorderLayout.EAST);
		add(fuel, BorderLayout.CENTER);
		add(southFuel, BorderLayout.SOUTH);
		add(westFuel, BorderLayout.WEST);
	}

	public static JProgressBar getFuel() {
		return fuel;
	}
	
	
}