package fr.sedara.Puissance4;

import java.util.Scanner;

import javax.swing.SwingUtilities;


public class Puissance4{
	
	public static Tableau tableau;
	static Scanner sc = new Scanner(System.in);
	static int turn;
	
	public static void main(String[] args){
		turn = 0;
		tableau = new Tableau();
		SwingUtilities.invokeLater(new TaskDisplay());
		//jouerConsole();
	
	}
	
	public static void jouerConsole(){

		int nextint;
		int turn = 0;
		Couleur joueur = Couleur.BLANC;
		while(!tableau.win()){
		System.out.println(tableau.toString());
		nextint = sc.nextInt();
		if(nextint > 6 || nextint < 0)
			System.out.println("Colonne incorrecte.");
		else{
			if(turn == 1)
				tableau.putCouleur(nextint, Couleur.NOIR);
			else
				tableau.putCouleur(nextint, joueur);
			if(!tableau.full){
			turn++;
			turn = turn%2;
			if(turn==0)
				joueur = Couleur.BLANC;
			else
				joueur = Couleur.NOIR;
			}
		}
		
	}
		
		System.out.println(tableau.toString());
		System.out.println("Le joueur " + (joueur == Couleur.BLANC ? "Noir" : "Blanc" )+ " gagne la partie.");
}

}
