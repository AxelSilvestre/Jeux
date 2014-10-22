package fr.sedara.CasseBrique;

public class Terrain {
	
	public static Tableau tableau;
	
	public Terrain(){
		tableau = new Tableau();
		tableau.setShape(Formes.CARRE, 7);
	}

}
