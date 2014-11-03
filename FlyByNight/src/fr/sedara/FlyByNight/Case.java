package fr.sedara.FlyByNight;

public class Case {
	
	private Position position;
	private Type type;
	
	public Case(){
		this.position = null;
		this.type = null;
	}
	
	public Case(Position position){
		this.position = position;
		this.type = null;
	}
	
	
	public String toString(){
		if(this.type == Type.MUR)
			return "M";
		if(this.type == Type.FLYEUR)
			return "F";
		return " ";
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
	
	

}
