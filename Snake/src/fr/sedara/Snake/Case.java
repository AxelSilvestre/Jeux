package fr.sedara.Snake;

public class Case {
	
	private Position position;
	private int state;
	
	public Case(){
		this.position = null;
		this.state = 0;
	}
	
	public Case(Position position){
		this.position = position;
		this.state = 0;
	}
	
	public String toString(){
		if(this.state == 1)
			return "X";
		if(this.state == -1)
			return "O";
		return " ";
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	

}
