package fr.sedara.Snake;

import java.util.ArrayList;
import java.util.List;



public class Tableau {
	
	private Case[][] tableau = new Case[20][20];
	private List<Case> snake = new ArrayList<Case>();
	private String dir;
	
	public Tableau(){
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				this.tableau[j][i] = new Case(new Position(j, i));
			}
		}
		this.snake.add(getCase(new Position(10, 10)));
		this.snake.add(getCase(new Position(11, 10)));
		this.dir = "droite";
	}
	
	
	public Case getCase(Position position){
		return this.tableau[position.getX()][position.getY()];
	}
	
	public String toString(){
		String str = "************************************************************";
		for(int i=0;i<20;i++){
			str += "\n";
			for(int j=0;j<20;j++){
				str += "["+getCase(new Position(j,i))+"]";
			}
		}
		str += "\n************************************************************";
		return str;
	}
	
	public Position getRelativePosition(Position position, String dir){
		
		if(dir.equalsIgnoreCase("haut"))
			return new Position(position.getX(), position.getY()-1);
		if(dir.equalsIgnoreCase("bas"))
			return new Position(position.getX(), position.getY()+1);
		if(dir.equalsIgnoreCase("droite"))
			return new Position(position.getX()+1, position.getY());
		if(dir.equalsIgnoreCase("gauche"))
			return new Position(position.getX()-1, position.getY());		
		
		return null;
	}
	
	public void setSnake(){
		for(Case casee : this.snake){
			casee.setState(1);
		}

	}
	
	public String getDir(){
		return this.dir;
	}
	
	public void setDir(String dir){
		this.dir = dir;
	}
	
	
	
}
