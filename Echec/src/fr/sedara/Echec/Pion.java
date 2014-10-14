package fr.sedara.Echec;

import java.util.ArrayList;
import java.util.List;

public class Pion {
	
	private Couleur couleur;
	private Type type;
	private boolean played;	
	
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
						}				
					

					break;
		case FOU : for(Position position : positionList){
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
					}
					break;
		case TOUR : for(Position position : positionList){
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
					}
					break;

		case ROI : ;
					break;
		case CAVALIER : ;
					break;
		case REINE : ;
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

}
