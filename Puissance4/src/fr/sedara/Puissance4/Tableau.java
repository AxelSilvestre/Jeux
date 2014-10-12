package fr.sedara.Puissance4;

import java.util.ArrayList;
import java.util.List;

public class Tableau {
	
	private Case[][] tableau;
	public boolean full;
	public int columnForAI;
	
	public Tableau(){
		this.tableau = new Case[7][6];
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				this.tableau[j][i] = new Case(new Position(j,i));
			}
		}
	}
	
	public String toString(){
		String str = "***************************************************\n  0    1    2    3    4    5    6";
		for(int i=0;i<6;i++){
			str += "\n";
			for(int j=0;j<7;j++){
				str += "*("+this.tableau[j][i].toString()+")*";
			}
		}
		str += "\n\n***************************************************";
		return str;
	}
	
	public Case getCase(int x, int y){
		return this.tableau[x][y];
	}
	
	public void putCouleur(int x, Couleur couleur){
		full = false;
		Case casee = new Case();
		int line = 6;
		for(int i=0;i<6;i++){
			casee = getCase(x,i);
			if(casee.getCouleur() != Couleur.NULL){
				line = i;
				break;
			}
			}
		if(line == 6){
			getCase(x, 5).setCouleur(couleur);
			return;
		}
		if(line != 6 && line != 0){
			getCase(x, line-1).setCouleur(couleur);
			return;
		}
		
		System.out.println("Colonne pleine.");
		full = true;
			
		}
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Case> getNearbyCases(Case casee){
		List<Case> list = new ArrayList();
		if(casee.getPosition().getX() == 0 && casee.getPosition().getY() == 0){
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()+1));
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()+1));
		}
		
		if(casee.getPosition().getX() == 6 && casee.getPosition().getY() == 5){
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()));
		}
		
		if(casee.getPosition().getX() == 0 && casee.getPosition().getY() == 5){
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()-1));
		}
		
		if(casee.getPosition().getX() == 6 && casee.getPosition().getY() == 0){
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()+1));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()+1));
		}
		
		if(casee.getPosition().getX() == 0 && casee.getPosition().getY() != 0 && casee.getPosition().getY() != 5){
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()+1));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()+1));
		}
		
		if(casee.getPosition().getX() == 6 && casee.getPosition().getY() != 0 && casee.getPosition().getY() != 5){
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()+1));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()+1));
		}
		
		if(casee.getPosition().getY() == 0 && casee.getPosition().getX() != 0 && casee.getPosition().getX() != 6){
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()+1));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()+1));
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()+1));
		}
		
		if(casee.getPosition().getY() == 5 && casee.getPosition().getX() != 0 && casee.getPosition().getX() != 6){
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()-1));
		}
		if (casee.getPosition().getY() != 5 && casee.getPosition().getY() != 0 && casee.getPosition().getX() != 6 && casee.getPosition().getX() != 0){
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()+1));
			list.add(getCase(casee.getPosition().getX(), casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()+1));
			list.add(getCase(casee.getPosition().getX()+1, casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()-1));
			list.add(getCase(casee.getPosition().getX()-1, casee.getPosition().getY()+1));
		}
			
		return list;
		
	}
	
	public boolean win(){
		Case casee = new Case();
		Case casee2 = new Case();
		Case caseTemp = new Case();
		for(int i=0;i<7;i++){
			for(int j=0;j<6;j++){
				casee2 = getCase(i, j);
				Couleur couleur = casee2.getCouleur();
				if(couleur != Couleur.NULL){
				for(Case caseOfList : getNearbyCases(casee2)){
					if(couleur == caseOfList.getCouleur()){
						caseTemp = new Case();
						casee = getCase(i, j);	
						int dirX = caseOfList.getPosition().getX()-casee.getPosition().getX();
						int dirY = caseOfList.getPosition().getY()-casee.getPosition().getY();
						casee = caseOfList;
						for(int count = 0; count < 3; count++){
						if(couleur == casee.getCouleur()){								
						caseTemp = casee;
						int newPosX = caseTemp.getPosition().getX()+dirX;
						int newPosY = caseTemp.getPosition().getY()+dirY;
						if(newPosX < 7 && newPosY < 6 && newPosX > -1 && newPosY > -1){
						casee = getCase(newPosX, newPosY);
						if(count == 2){
							this.columnForAI = casee2.getPosition().getX();
							return true;
						}
						}else
							break;
						}
						}
					}
				}
				}
			}
					
						
		}

		return false;
	}
		
}
