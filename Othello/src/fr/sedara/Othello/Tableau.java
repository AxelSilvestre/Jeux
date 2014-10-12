package fr.sedara.Othello;

import java.util.ArrayList;
import java.util.List;

public class Tableau {
	
	private Case[][] tableau = new Case[8][8];
	private int[] nearbyCases = {-1,0,1};
    public int blanc;
	public int noir;
		
	
	public Tableau(){
		blanc = 0;
		noir = 0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				this.tableau[j][i] = new Case(new Position(j, i));
			}
		}
		this.tableau[4][4].setCouleur(Couleur.BLANC);
		this.tableau[3][3].setCouleur(Couleur.BLANC);
		this.tableau[4][3].setCouleur(Couleur.NOIR);
		this.tableau[3][4].setCouleur(Couleur.NOIR);
	}
	
	public Case getCase(Position position){
		return this.tableau[position.getX()][position.getY()];
	}
	
	public String toString(){
		String str = "*******************************************\n   0    1    2    3    4    5    6    7";
		for(int i=0;i<8;i++){
			str += "\n"+i;
			for(int j=0;j<8;j++){
				str +="*("+tableau[j][i].toString()+")*";				
			}				
		}
		str += "\n*******************************************";
		return str;
	}
	
	
	public void setPlayableCases(Couleur couleur){
		Case casee;
		int dirX;
		int dirY;
		for(int k=0;k<8;k++){
			for(int l=0;l<8;l++){
				casee = getCase(new Position(l, k));
			if(casee.getCouleur() != Couleur.NULL && casee.getCouleur() == couleur){
			for(Case caseTemp : getNearbyCasesOppositeColor(casee)){
				dirX = caseTemp.getPosition().getX()-casee.getPosition().getX();
				dirY = caseTemp.getPosition().getY()-casee.getPosition().getY();
				try{
					while(true){											
						if(caseTemp.getCouleur() == Couleur.NULL){
							caseTemp.setPlayable(true);
							break;
						}
						if(caseTemp.getCouleur() == couleur){
							break;
						}
						caseTemp = getCase(new Position(caseTemp.getPosition().getX()+dirX,caseTemp.getPosition().getY()+dirY));
						}
					
				
				
				}catch(ArrayIndexOutOfBoundsException e){};
			}
		}
			}
		
		}
	}
	
	public List<Case> getNearbyCasesOppositeColor(Case casee){
		List<Case> list = new ArrayList<>();
		Case caseTemp;
		Couleur couleur = casee.getCouleur();
		int newX;
		int newY;
			for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				try{
				newX = casee.getPosition().getX()+nearbyCases[i];
				newY = casee.getPosition().getY()+nearbyCases[j];
				caseTemp = getCase(new Position(newX,newY));
				if(!caseTemp.equals(casee) && caseTemp.getCouleur() != Couleur.NULL && caseTemp.getCouleur() != couleur){
					list.add(caseTemp);
				}
				}catch(ArrayIndexOutOfBoundsException e){};
			}
		}
		
		return list;
	}
	
	public void captureCases(Case casee, Couleur couleur){
		List<Case> list = new ArrayList<>();
		int dirX;
		int dirY;
			for(Case caseTemp : getNearbyCasesOppositeColor(casee)){
				dirX = caseTemp.getPosition().getX()-casee.getPosition().getX();
				dirY = caseTemp.getPosition().getY()-casee.getPosition().getY();
					while(true){
						try{
						if(caseTemp.getCouleur() == couleur){
							break;
						}
						if(caseTemp.getCouleur() != couleur && caseTemp.getCouleur() != Couleur.NULL){
							list.add(caseTemp);
						}
						if(caseTemp.getCouleur() == Couleur.NULL)
							list.clear();
						
						caseTemp = getCase(new Position(caseTemp.getPosition().getX()+dirX,caseTemp.getPosition().getY()+dirY));
						}catch(ArrayIndexOutOfBoundsException e){list.clear();break;};
				}
					for(Case c : list){
						c.setCouleur(couleur);
					}
			}
		
		
		
		
	}
	
	
	
	public boolean win(int x, int y){
		Case casee;
		
		for(int k=0;k<8;k++){
			for(int l=0;l<8;l++){
				getCase(new Position(l, k)).setPlayable(false);
			}
		}
		Couleur couleur;
		if(Othello.turn%2 == 0)
			couleur = Couleur.BLANC;
		else
			couleur = Couleur.NOIR;
		setPlayableCases(couleur);
		
		endloop:
		for(int k=0;k<8;k++){
			for(int l=0;l<8;l++){
				if(getCase(new Position(l, k)).isPlayable())
					break endloop;
				if(k == 7 && l == 7){
				System.out.println("No playable square available. Trun changed to "+couleur.toString());
				Othello.turn++;				
				if(Othello.turn%2 == 0)
					couleur = Couleur.BLANC;
				else
					couleur = Couleur.NOIR;
				
				setPlayableCases(couleur);
				
				endloop2:
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						if(getCase(new Position(i, j)).isPlayable())
							break endloop2;
						if(i == 7 && j == 7){
							for(int o=0;o<8;o++){
								for(int p=0;p<8;p++){
									casee = getCase(new Position(o, p));
									if(casee.getCouleur() == Couleur.BLANC)
										blanc++;
									if(casee.getCouleur() == Couleur.NOIR)
										noir++;
								}
							}							
							System.out.println(toString());
							return true;
						}
					
					}
				}
				}


			}
		}

		casee = getCase(new Position(x, y));
		if(!casee.isPlayable()){
			System.out.println("Case non jouable.");
		}
		else
		{

		Othello.turn++;
		casee.setPlayable(false);
		casee.setCouleur(couleur);	
		captureCases(casee, couleur);

		}
		for(int k=0;k<8;k++){
			for(int l=0;l<8;l++){
				if(getCase(new Position(l, k)).getCouleur() == Couleur.NULL)
					return false;				
			}
		}
		for(int k=0;k<8;k++){
			for(int l=0;l<8;l++){
				casee = getCase(new Position(l, k));
				if(casee.getCouleur() == Couleur.BLANC)
					blanc++;
				else
					noir++;
			}
		}
		System.out.println(toString());
		return true;
	}
	
	
	
	
}
