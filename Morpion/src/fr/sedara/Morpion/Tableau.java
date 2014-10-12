package fr.sedara.Morpion;

import java.util.ArrayList;
import java.util.List;


public class Tableau {
	
	private Case[][] tableau = new Case[3][3];
	private int[] nearbyCases = {-1,0,1};
	
	public Tableau(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				this.tableau[j][i] = new Case(new Position(j, i), Signe.NULL);
			}
		}
	}
	
	
	public Case getCase(int x, int y){
		return tableau[x][y];
	}
	
	public String toString(){
		String str = "*********************************";
		str += "\n   0    1    2";
		for(int i=0;i<3;i++){
			str+= "\n"+i;
			for(int j=0;j<3;j++){
				str += "*("+ this.tableau[j][i].toString() + ")*";
			}
		}
		str+= "\n**********************************";
		return str;
				
	}
	
	public List<Case> getNerbyCasesSameSigne(Case casee){
		List<Case> list = new ArrayList<>();
		Case caseTemp = new Case();
		Signe signe = casee.getSigne();
		for(int k=0;k<3;k++){
			for(int l=0;l<3;l++){
				try{
					caseTemp = tableau[casee.getPosition().getX()+nearbyCases[k]][casee.getPosition().getY()+nearbyCases[l]];
					if(signe == caseTemp.getSigne() && signe != Signe.NULL && !caseTemp.equals(casee))
						list.add(caseTemp);					
				}catch(ArrayIndexOutOfBoundsException e){};
			}
		}
		
		
		
		
		return list;
	}
	
	
	public boolean win(){
		Case casee;
		Case caseTemp;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				casee = tableau[i][j];
				for(Case caseOfList : getNerbyCasesSameSigne(casee)){
					int dirX = caseOfList.getPosition().getX()-casee.getPosition().getX();
					int dirY = caseOfList.getPosition().getY()-casee.getPosition().getY();
					int newPosX = caseOfList.getPosition().getX()+dirX;
					int newPosY = caseOfList.getPosition().getY()+dirY;
					try{
					caseTemp = getCase(newPosX, newPosY);
					if(caseTemp.getSigne() == casee.getSigne())
						return true;
					}catch(ArrayIndexOutOfBoundsException e){};
					
				}
	
		}
		}
		Signe signe = Signe.CROIX;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){				
				casee = tableau[i][j];
				if(casee.getSigne() == Signe.NULL){
					signe = Signe.NULL;
					break;
			}
			}
			}
	if(signe == Signe.NULL)	
		return false;
	else{
		Morpion.turn = -1;
		return true;
	}
	}

	public boolean putSigne(int x, int y, Signe signe){
		if(tableau[x][y].getSigne() == Signe.NULL){
		    tableau[x][y].setSigne(signe);
			return true;
		}else{
			System.out.println("Case déjà jouée.");
		    return false;
		}
		
	}

}
