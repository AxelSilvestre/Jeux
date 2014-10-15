package fr.sedara.BatailleNavale;

public class Tableau {
	
	private Case[][] tableau = new Case[10][10];
	private int HORIZONTAL_X = -1;
	private int HORIZONTAL_Y = 0;
	private int VERTICAL_X = 0;
	private int VERTICAL_Y = 1;
	private boolean bateauPLaced;
	
	
	
	
	public Tableau(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				this.tableau[j][i] = new Case(new Position(j, i));
			}
		}
		bateauPLaced = false;
	}
	
	public Case getCase(Position position){
		return this.tableau[position.getX()][position.getY()];
	}
	
	public String toString(){
		String str = "***********************************************************\n   0    1    2    3    4    5    6    7    8    9";
		for(int i=0;i<10;i++){
			str += "\n"+i;
			for(int j=0;j<10;j++){
				str += "*("+this.tableau[j][i].toString() +")*";
			}
		}
		str += "\n***********************************************************";
		return str;
	}
	
	public void putBateau(int x, int y, Type type){
		Case casee = getCase(new Position(x, y));
		for(int i=0;i<Type.getSize(type);i++){			
			casee.setBateau(bateau);
			
		}
	}

}
