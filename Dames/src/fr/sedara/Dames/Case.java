package fr.sedara.Dames;

public class Case {
	
	private Position position;
	private Couleur couleur;
	private TypeCouleurCase typeCouleurCase;
	private Type type;
	
	public Case(){
		this.position = null;
		this.couleur = null;
		this.type = null;
		this.typeCouleurCase = null;
	}
	
	public Case(Position position, TypeCouleurCase typeCouleurCase){
		this.position = position;
		this.typeCouleurCase = typeCouleurCase;
	}
	
	public String toString(){
		if(this.couleur == Couleur.BLANC)
			return "B";
		if(this.couleur == Couleur.NOIR)
			return "N";
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public TypeCouleurCase getTypeCouleurCase() {
		return typeCouleurCase;
	}

	public void setTypeCouleurCase(TypeCouleurCase typeCouleurCase) {
		this.typeCouleurCase = typeCouleurCase;
	}
	
	

}
