package fr.sedara.Snake;

import javax.swing.SwingUtilities;



public class Snake {
	
	public static Tableau tableau;

	public static void main(String[] args) {
		tableau = new Tableau();
		tableau.setSnake();
		tableau.setObjectiveCase();
		SwingUtilities.invokeLater(new TaskDisplay());
		
	}

}
