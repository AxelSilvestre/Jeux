package fr.sedara.Echec;

public class Echec {
	
	public static Tableau tableau;
	public static int turn;
	
	public static void main(String[] args){
		turn =0;
		tableau = new Tableau();
		System.out.println(tableau.toString());
	}

}
