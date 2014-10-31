package fr.sedara.Dames;

public class Dames {
	
	public static Tableau tableau;
	
	public static void main(String[] args){
		tableau = new Tableau();
		System.out.println(tableau.toString());
		tableau.getAvailableMoves(tableau.getCase(new Position(1,6)));
	}

}
