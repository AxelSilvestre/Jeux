package fr.sedara.Dames;

public class Dames {
	
	public static Tableau tableau;
	
	public static void main(String[] args){
		tableau = new Tableau();
		tableau.getCase(new Position(2, 5)).setCouleur(Couleur.NOIR);
		tableau.getCase(new Position(5, 2)).setCouleur(null);
		tableau.getCase(new Position(3, 2)).setCouleur(null);
		System.out.println(tableau.toString());
		for(Case c : tableau.getAvailableMoves(tableau.getCase(new Position(1,6)), null)){
			System.out.println(c.getPosition().getX()+","+c.getPosition().getY());
		}
	}

}
