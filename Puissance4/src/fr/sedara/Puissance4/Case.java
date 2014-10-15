package fr.sedara.Puissance4;

public class Case {
	
	private Position position;
	private Couleur couleur;
	
	public Case(){
		this.position = null;
		this.couleur = null;
	}
	
	public Case(Position position){
		this.position = position;
		this.couleur = Couleur.NULL;
	}
	
	public String toString(){
		if(this.couleur == Couleur.NOIR)
			return "N";
		if(this.couleur == Couleur.BLANC)
			return "B";
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

}
