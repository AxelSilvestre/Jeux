package fr.sedara.Echec;

import java.util.Scanner;

public class Echec {
	
	public static Tableau tableau;
	public static int turn;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		turn =0;
		tableau = new Tableau();
		System.out.println(tableau.toString());
		//int nextInt = sc.nextInt();

		}

}
