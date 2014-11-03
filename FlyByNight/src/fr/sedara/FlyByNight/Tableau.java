package fr.sedara.FlyByNight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tableau {
	
	private Case[][] tableau = new Case[30][30];
	private Case flyeur;
	private List<Case> walls;
	private float space;
	private int score;
	private int count;
	
	public Tableau(){
		for(int i=0;i<30;i++){
			for(int j=0;j<30;j++){
				this.tableau[j][i] = new Case(new Position(j, i));
			}
		}
		this.flyeur = getCase(new Position(5, 5));
		this.flyeur.setType(Type.FLYEUR);
		this.walls = new ArrayList<Case>();
		this.space = 10L;
		score = 0;
		count = 0;
	}
	
	public Case getCase(Position position){
		return this.tableau[position.getX()][position.getY()];
	}
	
	public String toString(){
		String str = "";
		for(int i=0;i<30;i++){
			str += "\n";
			for(int j=0;j<30;j++){
				str += "[" + getCase(new Position(j, i)).toString() +"]";
			}
		}
		str += "\n";
		return str;
	}
	
	public void setWalls(){
		Random rand = new Random();
		for(int i=0;i<30;i++){
			walls.add(getCase(new Position(29, i)));
			getCase(new Position(29, i)).setType(Type.MUR);
		}
		int y = rand.nextInt(29);
		int n = rand.nextInt(5)+ (int) space;
		for(int i=0;i<n;i++){
			try{
			getCase(new Position(29, y-i)).setType(null);
			walls.remove(getCase(new Position(29, y-i)));
			}catch(ArrayIndexOutOfBoundsException e){};
		}
		
		
	}
	
	public void wallsForward(){
		List<Case> list = new ArrayList<Case>();
		List<Case> list2 = new ArrayList<Case>();
		
		for(Case c : walls){
			try{
			list2.add(c);
			c = getCase(new Position(c.getPosition().getX()-1, c.getPosition().getY()));
			list.add(c);
			}catch(ArrayIndexOutOfBoundsException e){};
			
		}
		for(Case c : list2){
			c.setType(null);
			walls.remove(c);
		}
		
		for(Case c : list){
			c.setType(Type.MUR);
			walls.add(c);
		}
	}
	
	public void incrementScore(){
		for(int i=0;i<30;i++){
			if(getCase(new Position(4, i)).getType() == Type.MUR){
				score++;
				if(space > 0){
					float d = (float) 0.05;
					space = space -  d;
				}					
				return;
			}
		}
	}
	

	
	public boolean win(){
		if(count == 7){
			setWalls();
			count = 0;
		}
		else
			count++;
		
		wallsForward();
		incrementScore();
		
		for(Case c : this.walls){
			if(this.flyeur.equals(c))
				return false;
		}
		
		
		return true;
	}

	public void setFlyeur(Position position) {
		try{
		Case c = this.flyeur;
		this.flyeur = getCase(position);
		this.flyeur.setType(Type.FLYEUR);
		c.setType(null);
		}catch(ArrayIndexOutOfBoundsException e){};
	}

	public Case getFlyeur() {
		return flyeur;
	}

	public int getScore() {
		return score;
	}
	

}
