package fr.sedara.Echec;

public class Case {
	
	private Position position;
	private Pion pion;
	
	public Case(){
		this.position = null;
		this.pion = null;
	}
	
	public Case(Position position){
		this.position = position;
		this.pion = null;
	}
	
	public String toString(){
		if(this.pion == null)
			return "  ";
		else
			return this.pion.toString();
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Pion getPion() {
		return pion;
	}
	public void setPion(Pion pion) {
		this.pion = pion;
	}

}
