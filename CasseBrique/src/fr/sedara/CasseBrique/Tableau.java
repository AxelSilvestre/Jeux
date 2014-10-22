package fr.sedara.CasseBrique;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tableau {
	
	private Brique[][] tableau = new Brique[9][18];
	private Barre barre;
	private Balle balle;
	
	public Tableau(){
		for(int i=0; i<18;i++){
			for(int j=0;j<9;j++){
				this.tableau[j][i] = new Brique(new Position(j, i));
			}
		}
		this.barre = new Barre();
		getBrique(this.barre.getPosition()).setHasBar(true);
		this.balle = new Balle();
				
	}
	
	public Brique getBrique(Position position){
		return this.tableau[position.getX()][position.getY()];
	}
	
	public String toString(){
		String str = "****************************";
		for(int i=0; i<18;i++){
			str += "\n";
			for(int j=0;j<9;j++){
				str += "["+getBrique(new Position(j, i))+"]";
			}
		}
		str += "\n\n\n\n*****************************";
		return str;
	}
	
	public void setShape(Formes forme, int dimension){
		for(Position position : Formes.createShape(forme, dimension)){
			getBrique(position).setState(1);
		}
	}
	
	public class TableauEvents implements KeyListener{


		public void keyPressed(KeyEvent e) {
			System.out.println(e.getSource().hashCode());
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				Tableau.this.getBrique(Tableau.this.barre.getPosition()).setHasBar(false);
				Tableau.this.barre.setPosition(new Position
						(Tableau.this.barre.getPosition().getX()-1,Tableau.this.barre.getPosition().getY()));
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				Tableau.this.getBrique(Tableau.this.barre.getPosition()).setHasBar(false);
				Tableau.this.barre.setPosition(new Position
						(Tableau.this.barre.getPosition().getX()+1,Tableau.this.barre.getPosition().getY()));
			}
			Tableau.this.getBrique(Tableau.this.barre.getPosition()).setHasBar(true);
		}


		public void keyReleased(KeyEvent e) {

			
		}


		public void keyTyped(KeyEvent e) {

			
		}
		
	}

}
