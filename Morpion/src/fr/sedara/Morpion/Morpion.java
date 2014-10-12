package fr.sedara.Morpion;

import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Morpion {
	
	public static Tableau tableau;
	static Scanner sc = new Scanner(System.in);
	public static int turn;

	public static void main(String[] args) {
		turn = 0;
		tableau = new Tableau();
		SwingUtilities.invokeLater(new TaskDisplay());
		//jouerConsole();

	}
	
	public static void jouerConsole(){
		while(!tableau.win()){
			System.out.println(tableau.toString());
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x > 2 || x < 0 || y < 0 || y > 2)
				System.out.println("Case incorrecte.");
			else{
				if(turn==0){
					if(tableau.putSigne(x, y, Signe.CROIX))
						turn++;						
				}else{
					if(tableau.putSigne(x, y, Signe.ROND))
						turn++;
				}
				turn=turn%2;
			}
		}
		System.out.println(tableau.toString());
		System.out.println("Le joueur "+(turn == 0 ? "Rond" : "Croix")+ " gagne la partie.");
	}

}
