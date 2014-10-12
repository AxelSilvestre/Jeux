package fr.sedara.Othello;

public class Case {
	
	private Position position;
	private Couleur couleur;
	private boolean playable;
	
	public Case(){
		this.position = null;
		this.couleur = Couleur.NULL;
		this.playable = false;
	}
	
	public Case(Position position){
		this.position = position;
		this.couleur = Couleur.NULL;
		this.playable = false;
	}
	
	public String toString(){
		if(this.couleur == Couleur.BLANC)
			return "B";
		if(this.couleur == Couleur.NOIR)
			return  "N";		
		return " ";
	}	
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public boolean isPlayable() {
		return playable;
	}

	public void setPlayable(boolean playable) {
		this.playable = playable;
	}

}
