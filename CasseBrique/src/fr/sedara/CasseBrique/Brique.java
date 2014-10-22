package fr.sedara.CasseBrique;

public class Brique {
	
	private Position position;
	private int state;
	private boolean hasBall;
	private boolean hasBar;
	
	public Brique(){
		this.position = null;
		this.state = -1;
	}
	
	public Brique(Position position){
		this.position = position;
		this.state = -1;
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
	
	public boolean isHasBall() {
		return hasBall;
	}

	public void setHasBall(boolean hasBall) {
		this.hasBall = hasBall;
	}

	public boolean isHasBar() {
		return hasBar;
	}

	public void setHasBar(boolean hasBar) {
		this.hasBar = hasBar;
	}

	public String toString(){
		if(state == 1)
			return "X";
		if(hasBall)
			return "O";
		if(hasBar)
			return "8";
		return " ";
	}

}
