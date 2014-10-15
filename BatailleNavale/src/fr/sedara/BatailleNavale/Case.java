package fr.sedara.BatailleNavale;

public class Case {
	
	private Position position;
	private Bateau bateau;
	private boolean hit;

	public Case(){
		this.position = null;
		this.bateau = null;
		this.hit = false;
	}
	
	public Case(Position position){
		this.position = position;
		this.bateau = null;
		this.hit = false;
	}
	

	public String toString(){
		if(isHit())
			return"X";
		
		if(this.bateau == null)
			return " ";
		else{
			Type type = this.bateau.getType();
			if(type == Type.CONTRE_TORPILLEUR)
				return "c";
			else if(type == Type.TORPILLEUR)
				return "T";
			else if(type == Type.PORTE_AVIONS)
				return "P";
			else if(type == Type.SOUS_MARIN)
				return "S";
			else
				return "C";
		}
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}
	
	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

}
