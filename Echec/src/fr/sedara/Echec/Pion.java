package fr.sedara.Echec;

public class Pion {
	
	private Couleur couleur;
	private Type type;
	private boolean pionPlayed;
	
	public Pion(Couleur couleur, Type type){
		this.couleur = couleur;
		this.type = type;
		this.pionPlayed = false;
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

	public boolean isPionPlayed() {
		return pionPlayed;
	}

	public void setPionPlayed(boolean pionPlayed) {
		this.pionPlayed = pionPlayed;
	}

}
