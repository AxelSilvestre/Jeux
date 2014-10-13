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
		
		switch (this.type){
		case PION : if(this.couleur == Couleur.BLANC)
					break;
		case FOU : ;
					break;
		case TOUR : ;
					break;
		case REINE : ;
					break;
		case ROI : ;
					break;
		case CAVALIER : ;
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
