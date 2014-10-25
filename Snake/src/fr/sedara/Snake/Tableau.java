package fr.sedara.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Tableau {
	
	private Case[][] tableau = new Case[40][40];
	private List<Case> snake = new ArrayList<Case>();
	private String dir;
	public int score;
	
	public Tableau(){
		for(int i=0;i<40;i++){
			for(int j=0;j<40;j++){
				this.tableau[j][i] = new Case(new Position(j, i));
			}
		}
		this.dir = "droite";
		score = 0;
	}
	
	public void setFirstCases(){
		for(Case c : this.snake)
			c.setState(0);
		this.snake.clear();
		this.snake.add(getCase(new Position(20, 20)));
		this.snake.add(getCase(new Position(21, 20)));
		this.snake.add(getCase(new Position(22, 20)));
	}
	
	public void setFirstCasesForAnim(){
		for(Case c : this.snake)
			c.setState(0);
		this.snake.clear();
		this.snake.add(getCase(new Position(5, 5)));
		this.snake.add(getCase(new Position(6, 5)));
		this.snake.add(getCase(new Position(7, 5)));
	}
	
	public List<Case> getListSnake(){
		return this.snake;
	}
	
	
	public Case getCase(Position position){
		return this.tableau[position.getX()][position.getY()];
	}
	
	public String toString(){
		String str = "************************************************************";
		for(int i=0;i<40;i++){
			str += "\n";
			for(int j=0;j<40;j++){
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
	
	public String getOppositeDir(String str){
		
		switch(str){
		case "droite" : return "gauche";
		case "gauche" : return "droite";
		case "haut" : return "bas";
		case "bas" : return "haut";
		}
		return null;
	}
	
	public void setSnake(){
		for(Case casee : this.snake){
			casee.setState(1);
		}

	}
	
	public boolean play(){
		
		try{
		Case casee = this.snake.get(this.snake.size() -1);
		casee = getCase(getRelativePosition(casee.getPosition(), this.dir));
				
		for(Case c : this.snake){
			if(casee.equals(c))
				return false;
		}
		this.snake.add(casee);
		if(casee.getState() == -1){
			setObjectiveCase();
			score++;
		}
		else{
			Case c = this.snake.get(0);
			c.setState(0);
			this.snake.remove(0);
		}
			
		setSnake();
		return true;
		}catch(ArrayIndexOutOfBoundsException e){return false;}
		
	}
	
	public void playAnim(){
		
		Case casee = this.snake.get(this.snake.size() -1);
		
		if(casee.getPosition().getX() == 35 && casee.getPosition().getY() == 5)
			dir = "bas";
		if(casee.getPosition().getX() == 35 && casee.getPosition().getY() == 35)
			dir = "gauche";
		if(casee.getPosition().getX() == 5 && casee.getPosition().getY() == 35)
			dir = "haut";
		if(casee.getPosition().getX() == 5 && casee.getPosition().getY() == 5)
			dir = "droite";
		
		casee = getCase(getRelativePosition(casee.getPosition(), this.dir));
				
		this.snake.add(casee);
		Case c = this.snake.get(0);
		c.setState(0);
		this.snake.remove(0);
		setSnake();
		
	}
	
	public void setObjectiveCase(){
		
		Random randX = new Random();
		Random randY = new Random();
		int x = randX.nextInt(39);
		int y = randY.nextInt(39);
		Case casee = getCase(new Position(x, y));
		for(Case c : this.snake){
			if(casee.getPosition().equals(c.getPosition())){
				setObjectiveCase();
				return;
			}
		}
		getCase(casee.getPosition()).setState(-1);
		
	}
	
	public String getDir(){
		return this.dir;
	}
	
	public void setDir(String dir){
		this.dir = dir;
	}
	
	
	
}
