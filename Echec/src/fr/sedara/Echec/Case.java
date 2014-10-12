package fr.sedara.Echec;

public class Case {
	
	private Position position;
	private Piontest pion;
	
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
	public Piontest getPion() {
		return pion;
	}
	public void setPion(Piontest pion) {
		this.pion = pion;
	}

}
