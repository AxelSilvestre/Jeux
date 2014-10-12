package fr.sedara.Othello;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Othello {
	
	static Tableau tableau; 
	static int turn;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		turn = 1;
		tableau = new Tableau();
		SwingUtilities.invokeLater(new TaskDisplay());
		//jouerConsole();
	}
	
	public static void jouerConsole(){
		int nextX;
		int nextY;
		while(true){
		System.out.println(tableau.toString());
		System.out.println("Tour de "+(turn%2 == 0 ? "Blanc" : "Noir"));
		try{
		nextX = sc.nextInt();
		nextY = sc.nextInt();
		try{
		if(tableau.win(nextX,nextY))
			break;
		}catch(ArrayIndexOutOfBoundsException e){System.out.println("L'un de vos coordonnées est incorrect.");};
		}catch(InputMismatchException e){System.out.println("Entrez des chiffres voyons!");};
		}

		
		System.out.println(tableau.toString());
		if(tableau.noir == tableau.blanc){
			System.out.println("Egalité!");
			return;
		}		
		System.out.println("Le joueur "+(tableau.blanc>tableau.noir ? "Blanc" : "Noir")+" gagne la partie avec un total de "+(tableau.blanc>tableau.noir ? tableau.blanc : tableau.noir) +" cases contre "+
		(tableau.blanc<tableau.noir ? tableau.blanc : tableau.noir)+" pour le joueur "+(tableau.blanc>tableau.noir ? "Blanc" : "Noir"));
	}

}
