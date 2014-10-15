package fr.sedara.Echec;

import java.util.ArrayList;
import java.util.List;

public class Pion {
	
	private Couleur couleur;
	private Type type;
	private boolean played;
	private boolean echec;
	private boolean math;
	
	public Pion(Couleur couleur, Type type){
		this.couleur = couleur;
		this.type = type;
		this.played = false;
	}
	
	public String toString(){
		String str = "";
		if(this.couleur == Couleur.BLANC)
			str += "B";
		else
			str += "N";
		
		switch (this.type){
		case PION : str += "P";
					break;
		case FOU : str += "F";
					break;
		case TOUR : str += "T";
					break;
		case REINE : str += "Q";
					break;
		case ROI : str += "K";
					break;
		case CAVALIER : str += "C";
					break;
		}
		return str;
	}
	
	public List<Case> getAvailableMoves(Case casee){
		List<Case> list = new ArrayList<>();
		List<Position> positionList = new RelativeMoves(this.couleur, this.type).getRelativeMoves();
		
		switch (this.type){
		case PION : 	
						for(Position position : positionList){
						try{
						Case caseTemp = Echec.tableau.getCase(new Position(casee.getPosition().getX()+position.getX(),casee.getPosition().getY()+position.getY()));
						if(caseTemp.getPion().getCouleur() != this.couleur){
						if(position.equals(new Position(0, -2)) && !this.isPlayed() && this.couleur == Couleur.BLANC){
							list.add(caseTemp);
						}
						else if(position.equals(new Position(0, 2)) && !this.isPlayed() && this.couleur == Couleur.NOIR)
							list.add(caseTemp);
						}
						else if((position.equals(new Position(-1, -1)) || position.equals(new Position(1, -1))) && this.couleur == Couleur.BLANC){
							if(caseTemp.getPion() != null)
								list.add(caseTemp);
						}else if((position.equals(new Position(1, 1)) || position.equals(new Position(-1, 1))) && this.couleur == Couleur.NOIR){
							if(caseTemp.getPion() != null)
								list.add(caseTemp);
						}
						else
							list.add(caseTemp);
						}catch(ArrayIndexOutOfBoundsException e){};
						}				
		

					break;
		case REINE :
		case TOUR : 
		case FOU : 
					for(Position position : positionList){
						try{
						Case caseTemp = Echec.tableau.getCase(new Position(casee.getPosition().getX(),casee.getPosition().getY()));
						try{
						while(true){
							caseTemp = Echec.tableau.getCase(new Position(caseTemp.getPosition().getX()+position.getX(),caseTemp.getPosition().getY()+position.getY()));
							if(caseTemp.getPion() == null)
								list.add(caseTemp);
							else{
								if(caseTemp.getPion().getCouleur() == this.couleur)
									break;
								if(caseTemp.getPion().getCouleur() != this.couleur){
									list.add(caseTemp);
									break;
								}
							}
						}
						}catch(ArrayIndexOutOfBoundsException e){break;}
					}catch(ArrayIndexOutOfBoundsException e){};
					}
					break;


		case CAVALIER : 
						for(Position position : positionList){
							try{
							Case caseTemp = Echec.tableau.getCase(new Position(casee.getPosition().getX()+position.getX(),casee.getPosition().getY()+position.getY()));
							if(caseTemp.getPion() == null || (caseTemp.getPion() != null && caseTemp.getPion().getCouleur() != this.couleur))
								list.add(caseTemp);
							}catch(ArrayIndexOutOfBoundsException e){};
					}
					break;
					
		case ROI : try{  // TODO
			Case caseTemp;
			for(Position position : positionList){
				caseTemp = Echec.tableau.getCase(new Position(casee.getPosition().getX()+position.getX(),casee.getPosition().getY()+position.getY()));
				if((caseTemp.getPion() == null || caseTemp.getPion().getCouleur() != this.couleur) && !isEchec(casee) )
				list.add(caseTemp);
			}
				
		}catch(ArrayIndexOutOfBoundsException e){};
			break;
		
		}
		
		
		
		return list;
	}

	
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public boolean isPlayed() {
		return played;
	}

	public void setPionPlayed(boolean played) {
		this.played = played;
	}
	
	public boolean isMath(Case caseOfKing){ // TODO
		List<List<Case>> listTemp = new ArrayList<>();
		Case caseTemp;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				caseTemp = Echec.tableau.getCase(new Position(i, j));
				if(caseTemp.getPion() != null && caseTemp.getPion().getCouleur() == this.couleur)
					listTemp.add(getAvailableMoves(caseTemp));					
			}
		}
			for(List<Case> listOfList : listTemp){
				for(Case caseOfList : listOfList){
					caseTemp = new Case(caseOfList.getPosition());
					caseTemp.setPion(caseOfList.getPion());
					
					
				}
			}
		
		
		return false;
	}

	public boolean isEchec(Case casee) {
		echec = false;
		List<List<Case>> listTemp = new ArrayList<>();
		Case caseTemp;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				caseTemp = Echec.tableau.getCase(new Position(i, j));
				if(caseTemp.getPion() != null && caseTemp.getPion().getCouleur() != this.couleur)
					listTemp.add(getAvailableMoves(caseTemp));					
			}
		}
		loop:
		for(List<Case> listOfList : listTemp){
			for(Case caseOfList : listOfList){
				if(caseOfList.equals(casee)){
					echec = true;
					break loop;
				}
			}
		}		
		
		return echec;
	}

	public void setEchec(boolean echec) {
		this.echec = echec;
	}

}
