package fr.sedara.FlyByNight;

import javax.swing.SwingUtilities;

public class FlyByNight {
	
	public static Tableau tableau;

	public static void main(String[] args) {
		tableau = new Tableau();
		SwingUtilities.invokeLater(new TaskDisplay());

	}

}
