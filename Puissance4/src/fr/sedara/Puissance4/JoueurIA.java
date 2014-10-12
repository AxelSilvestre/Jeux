package fr.sedara.Puissance4;

import java.util.Random;

public class JoueurIA extends Joueur{
	
	private int difficulty;
	private int[] difficultyRangeCalculs = {1,3,7,10};

	public JoueurIA(Couleur couleur, int difficulty) {
		super(couleur);
		this.difficulty = difficulty;
	}
	
	public int jouer(){
		Tableau tableau = Puissance4.tableau;
		int i = 0;
		while(i<difficultyRangeCalculs[difficulty]){
		i++;
		if(tableau.win()){
			System.out.println("EASY BRO");
			return tableau.columnForAI;
		}
		}		
		Random random = new Random();
		int n = random.nextInt(7);
		return n;		
	}	

}
