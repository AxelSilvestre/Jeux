package fr.sedara.CasseBrique;


import javax.swing.SwingUtilities;

public class Cassebrique {
	
	public static Terrain terrain;
	
	public static void main(String[] args){
		terrain = new Terrain();
		//System.out.println(terrain.tableau.toString());
		SwingUtilities.invokeLater(new TaskDisplay());
	}

}
