package fr.sedara.Othello;


public class setPlayableJButtonCases {
	
	public static void setPlayableCases(Couleur couleur){
		for(int l=0;l<8;l++){
			for(int k=0;k<8;k++){
				Othello.tableau.getCase(new Position(l, k)).setPlayable(false);
			}
		}
		Othello.tableau.setPlayableCases(couleur);
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				TaskDisplay.tableau[i][j].setPlayable();
		}
		}
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(TaskDisplay.tableau[i][j].isPlayable())
					return;
		}
		}
		Othello.turn++;
		
		for(int l=0;l<8;l++){
			for(int k=0;k<8;k++){
				Othello.tableau.getCase(new Position(l, k)).setPlayable(false);
			}
		}
		Othello.tableau.setPlayableCases(couleur == Couleur.BLANC ? Couleur.NOIR : Couleur.BLANC);
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				TaskDisplay.tableau[i][j].setPlayable();
		}
		}
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(TaskDisplay.tableau[i][j].isPlayable())
					return;
		}
		}
		Othello.tableau.blanc = 0;
		Othello.tableau.noir = 0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(TaskDisplay.tableau[i][j].getCasee().getCouleur() == Couleur.BLANC)
					Othello.tableau.blanc++;
				if(TaskDisplay.tableau[i][j].getCasee().getCouleur() == Couleur.NOIR)
					Othello.tableau.noir++;
		}
		}
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(TaskDisplay.tableau[i][j].getCasee().getCouleur() == Couleur.NULL){
					TaskDisplay.activateWin();
					return;
				}
		}
		}
		
	}

}
