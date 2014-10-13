package fr.sedara.Echec;

public class Tableau {
	
	private Case[][] tableau = new Case[8][8];
	
	public Tableau(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				this.tableau[j][i] = new Case(new Position(j, i));
			}
		}
		setBeginingPions();
	}
	
	public Case getCase(Position position){
		return this.tableau[position.getX()][position.getY()];
	}
	
	public void setBeginingPions(){
		getCase(new Position(0, 0)).setPion(new Pion(Couleur.NOIR, Type.TOUR));
		getCase(new Position(1, 0)).setPion(new Pion(Couleur.NOIR, Type.CAVALIER));
		getCase(new Position(2, 0)).setPion(new Pion(Couleur.NOIR, Type.FOU));
		getCase(new Position(3, 0)).setPion(new Pion(Couleur.NOIR, Type.REINE));
		getCase(new Position(4, 0)).setPion(new Pion(Couleur.NOIR, Type.ROI));
		getCase(new Position(5, 0)).setPion(new Pion(Couleur.NOIR, Type.FOU));
		getCase(new Position(6, 0)).setPion(new Pion(Couleur.NOIR, Type.CAVALIER));
		getCase(new Position(7, 0)).setPion(new Pion(Couleur.NOIR, Type.TOUR));
		
		getCase(new Position(0, 1)).setPion(new Pion(Couleur.NOIR, Type.PION));
		getCase(new Position(1, 1)).setPion(new Pion(Couleur.NOIR, Type.PION));
		getCase(new Position(2, 1)).setPion(new Pion(Couleur.NOIR, Type.PION));
		getCase(new Position(3, 1)).setPion(new Pion(Couleur.NOIR, Type.PION));
		getCase(new Position(4, 1)).setPion(new Pion(Couleur.NOIR, Type.PION));
		getCase(new Position(5, 1)).setPion(new Pion(Couleur.NOIR, Type.PION));
		getCase(new Position(6, 1)).setPion(new Pion(Couleur.NOIR, Type.PION));
		getCase(new Position(7, 1)).setPion(new Pion(Couleur.NOIR, Type.PION));
		
		
		getCase(new Position(0, 6)).setPion(new Pion(Couleur.BLANC, Type.PION));
		getCase(new Position(1, 6)).setPion(new Pion(Couleur.BLANC, Type.PION));
		getCase(new Position(2, 6)).setPion(new Pion(Couleur.BLANC, Type.PION));
		getCase(new Position(3, 6)).setPion(new Pion(Couleur.BLANC, Type.PION));
		getCase(new Position(4, 6)).setPion(new Pion(Couleur.BLANC, Type.PION));
		getCase(new Position(5, 6)).setPion(new Pion(Couleur.BLANC, Type.PION));
		getCase(new Position(6, 6)).setPion(new Pion(Couleur.BLANC, Type.PION));
		getCase(new Position(7, 6)).setPion(new Pion(Couleur.BLANC, Type.PION));
		
		getCase(new Position(0, 7)).setPion(new Pion(Couleur.BLANC, Type.TOUR));
		getCase(new Position(1, 7)).setPion(new Pion(Couleur.BLANC, Type.CAVALIER));
		getCase(new Position(2, 7)).setPion(new Pion(Couleur.BLANC, Type.FOU));
		getCase(new Position(3, 7)).setPion(new Pion(Couleur.BLANC, Type.REINE));
		getCase(new Position(4, 7)).setPion(new Pion(Couleur.BLANC, Type.ROI));
		getCase(new Position(5, 7)).setPion(new Pion(Couleur.BLANC, Type.FOU));
		getCase(new Position(6, 7)).setPion(new Pion(Couleur.BLANC, Type.CAVALIER));
		getCase(new Position(7, 7)).setPion(new Pion(Couleur.BLANC, Type.TOUR));
		
		
	}
	
	public String toString(){
		String str = "****************************************************************\n   0     1     2     3     4     5     6     7";
		for(int i=0;i<8;i++){
			str += "\n"+i;
			for(int j=0;j<8;j++){
				str += "*("+getCase(new Position(j, i)).toString()+")*";
			}
		}
		str += "\n****************************************************************";
		return str;
		
	}

}
