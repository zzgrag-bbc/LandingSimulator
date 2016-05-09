package Model;

import java.text.DecimalFormat;

import view.MenuPanelContent.TimerPanel;

public class Zeit {

	static int aus = 0;
	static String sekunden = "00";
	static int sekundenZähler = 0;
	static String minuten = "00";
	static int minutenZähler = 0;
	static String stunden = "00";
	static int stundenZähler = 0;

	public Zeit() {
	}

	public void setAus(int ausschalter) {
		aus = ausschalter;
	}

	public void setEin(int einschalten) {
		aus = einschalten;
	}

	public void macheZeit() {
		sekundenZähler++;
		if (sekundenZähler <= 59) {
			DecimalFormat df = new DecimalFormat("00");
			sekunden = df.format(sekundenZähler);
		} else {
			sekundenZähler = 0;
			minutenZähler++;
		}

		if (minutenZähler <= 59) {
			DecimalFormat df = new DecimalFormat("00");
			minuten = df.format(minutenZähler);
		} else {
			minutenZähler = 0;
			stundenZähler++;
		}

		DecimalFormat df = new DecimalFormat("00");
		stunden = df.format(stundenZähler);

		String timeOutput = " " + stunden + ":" + minuten + ":" + sekunden;
		TimerPanel.timer.setText(timeOutput);

	}

	public static int getAus() {
		return aus;
	}
}