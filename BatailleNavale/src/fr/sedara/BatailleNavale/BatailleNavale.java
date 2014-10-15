package fr.sedara.BatailleNavale;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BatailleNavale {

	public static Tableau tableau;
	public static Tableau tableauAdverse;
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		tableau = new Tableau();
		tableauAdverse = new Tableau();
		System.out.println(tableau.toString());
		jouerConsole();
	}
	
	public static void jouerConsole(){
		int x;
		int y;
		int t;
		Type type = Type.NULL;
		String dir;
		while(!tableau.isBateauxPlaced()){
			System.out.println("Choisissez un type de bateau à placer :\n1:Porte-avions (5 cases)\n2:Croiseur (4 cases)\n3:Contre-torpilleur (3 cases)\n4:Sous-marin (3 cases)\n5:Torpilleur (2 cases)");
			t = sc.nextInt();
			if(t<6 && t>0)
			switch(t){
			case 1 : type = Type.PORTE_AVIONS;break;
			case 2 : type = Type.CROISEUR;break;
			case 3 : type = Type.CONTRE_TORPILLEUR;break;
			case 4 : type = Type.SOUS_MARIN; break;
			case 5 : type = Type.TORPILLEUR; break;
			}
			else{
				System.out.println("Mauvais choix. Recommencez.");
				jouerConsole();
				return;
			}
			System.out.println("x:");
			x = sc.nextInt();
			System.out.println("y:");
			y = sc.nextInt();
			System.out.println("Horizontal (h) ? Vertical (v)?");
			dir = sc.next();
			
			try{
			tableau.putBateau(x, y, type, dir);
			}catch(ArrayIndexOutOfBoundsException e){System.out.println("Case invalide.");};
			System.out.println(tableau.toString());
		}
		while(!tableau.win()){
			try{
			x = sc.nextInt();
			y = sc.nextInt();
			try{
			Case casee = tableau.getCase(new Position(x, y));
			casee.setHit(true);
			System.out.println(tableau.toString());
			}catch(ArrayIndexOutOfBoundsException e){};
			}catch(InputMismatchException e){};
			
		}System.out.println("Partie terminée.");
	}

}
