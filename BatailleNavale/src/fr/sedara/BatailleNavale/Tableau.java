package fr.sedara.BatailleNavale;

import java.util.ArrayList;
import java.util.List;

public class Tableau {
	
	private Case[][] tableau = new Case[10][10];
	private boolean bateauxPlaced;
	private List<Type> listOfBateau;
	
	
	public Tableau(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				this.tableau[j][i] = new Case(new Position(j, i));
			}
		}
		listOfBateau = new ArrayList<>();
		listOfBateau.add(Type.CONTRE_TORPILLEUR);
		listOfBateau.add(Type.CROISEUR);
		listOfBateau.add(Type.PORTE_AVIONS);
		listOfBateau.add(Type.SOUS_MARIN);
		listOfBateau.add(Type.TORPILLEUR);		
		bateauxPlaced = false;
	}
	
	public Case getCase(Position position){
		return this.tableau[position.getX()][position.getY()];
	}
	
	public boolean isBateauxPlaced() {
		return bateauxPlaced;
	}
	
	public boolean isInListOfBateau(Type type){
		for(Type t : listOfBateau){
			if(type == t)
				return true;
		}
		return false;
	}
	
	public String toString(){
		String str = "******************************************************\n   0    1    2    3    4    5    6    7    8    9";
		for(int i=0;i<10;i++){
			str += "\n"+i;
			for(int j=0;j<10;j++){
				str += "*("+this.tableau[j][i].toString() +")*";
			}
		}
		str += "\n******************************************************";
		return str;
	}
	
	public void putBateau(int x, int y, Type type, String direction){
		if(isInListOfBateau(type)){
		List<Case> list = new ArrayList<>();
		Case casee = getCase(new Position(x, y));
		Case caseTemp = new Case();
		boolean bool = false;
		try{
		for(int i=0;i<Type.getSize(type);i++){
			if(direction.equalsIgnoreCase("h"))
				caseTemp = getCase(new Position(casee.getPosition().getX()+i,casee.getPosition().getY()));
			
			if(direction.equalsIgnoreCase("v"))
				caseTemp = getCase(new Position(casee.getPosition().getX(),casee.getPosition().getY()-i));
			
			if(caseTemp.getType() != Type.NULL || casee.getType() != Type.NULL){
				list.clear();
				System.out.println("Un bateau est déjà présent dans la trajectoire de placement.");
				bool = true;
				break;
			}
				
			
			list.add(caseTemp);
		}
		for(Case c : list){
			c.setType(type);
		}
		if(!bool)
			listOfBateau.remove(type);
		if(listOfBateau.isEmpty())
			bateauxPlaced = true;
		System.out.println(1);
		}catch(ArrayIndexOutOfBoundsException e){System.out.println("Bateau mal placé.");};
		}else
			System.out.println("Le bateau n'est plus disponible.");
		
	}
	
	public boolean win(){
		Case casee;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				casee = getCase(new Position(i, j));
				if(casee.getType() != Type.NULL && !casee.isHit())				
					return false;
			}
		}
		return true;
	}

}
