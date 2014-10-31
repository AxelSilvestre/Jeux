package fr.sedara.Dames;

import java.util.ArrayList;
import java.util.List;

public class Tableau {
	
	private Case[][] tableau = new Case[10][10];
	private int[] relativeMoves = {-1,1};
	
	public Tableau(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				this.tableau[j][i] = new Case(new Position(j, i), ((j+i)%2 == 0 ? TypeCouleurCase.CLAIR : TypeCouleurCase.FONCE));
			}
		}
		setCouleur();
	}
	
	public Case getCase(Position position){
		return this.tableau[position.getX()][position.getY()];
	}
	
	public String toString(){
		String str = "**********************************************\n  0  1  2  3  4  5  6  7  8  9";
		for(int i=0;i<10;i++){
			str += "\n"+i;
			for(int j=0;j<10;j++){
				str += "["+getCase(new Position(j, i)).toString() + "]";
			}
		}
		
		str += "\n*********************************************************";
		return str;
	}
	
	public void setCouleur(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(getCase(new Position(i, j)).getTypeCouleurCase() == TypeCouleurCase.FONCE){
					getCase(new Position(i, j)).setType(Type.PION);
					if(j<4)
						getCase(new Position(i, j)).setCouleur(Couleur.NOIR);
					else if(j>5)
						getCase(new Position(i, j)).setCouleur(Couleur.BLANC);
				}
			}
		}
	}
	
	
	public List<Case> getAvailableMoves(Case casee){
		List<Case> list = new ArrayList<Case>();
		if(casee.getType() == Type.PION){
				for(int i=0;i<2;i++){
					for(int j=0;j<2;j++){
						Case c = getCase(new Position(casee.getPosition().getX()+relativeMoves[i], casee.getPosition().getY()+relativeMoves[j]));
						while(c.getCouleur() != casee.getCouleur()){
							c = getCase(new Position(c.getPosition().getX()+relativeMoves[i], c.getPosition().getY()+relativeMoves[j]));
						}
					}
				}
			}
		
		
		return null;
	}

}
