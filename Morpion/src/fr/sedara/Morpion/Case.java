package fr.sedara.Morpion;


public class Case {
	
	private Position position;
	private Signe signe;
	
	public Case(){
		this.position = null;
		this.signe = Signe.NULL;
	}
	
	public Case(Position position, Signe signe){
		this.position = position;
		this.signe = signe;
	}
	
	public String toString(){
		if(this.signe == Signe.CROIX)
			return "X";
		if(this.signe == Signe.ROND)
			return "O";
		return " ";
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Signe getSigne() {
		return signe;
	}
	public void setSigne(Signe signe) {
		this.signe = signe;
	}
	

}
