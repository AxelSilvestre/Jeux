package fr.sedara.BatailleNavale;

public class Case {
	
	private Position position;
	private Type type;
	private boolean hit;

	public Case(){
		this.position = null;
		this.type = Type.NULL;
		this.hit = false;
	}
	
	public Case(Position position){
		this.position = position;
		this.type = Type.NULL;
		this.hit = false;
	}
	

	public String toString(){
		if(isHit())
			return"X";
		
		if(this.type == Type.NULL)
			return " ";
		else{
			Type type = this.type;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

}
