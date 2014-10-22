package fr.sedara.CasseBrique;

public class Barre {
	
	private Position position;
	
	public Barre(){
		this.position = new Position(4, 17);
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}	
	

}
