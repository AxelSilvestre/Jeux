package fr.sedara.Echec;

import java.util.ArrayList;
import java.util.List;

public class RelativeMoves {
	
	private List<Position> relativeMoves = new ArrayList<>();
	
	public RelativeMoves(Couleur couleur, Type type){
		
			switch (type){
			case PION : if(couleur == Couleur.BLANC){
				relativeMoves.add(new Position(0,-2));
				relativeMoves.add(new Position(0,-1));
				relativeMoves.add(new Position(-1,-1));
				relativeMoves.add(new Position(1,-1));
			}
			if(couleur == Couleur.NOIR){
				relativeMoves.add(new Position(0,2));
				relativeMoves.add(new Position(0,1));
				relativeMoves.add(new Position(-1,1));
				relativeMoves.add(new Position(1,1));
			}

				break;
			case FOU : relativeMoves.add(new Position(-1,-1));
			relativeMoves.add(new Position(+1,+1));
			relativeMoves.add(new Position(-1,+1));
			relativeMoves.add(new Position(+1,-1));
				break;
			case TOUR : relativeMoves.add(new Position(0,-1));
			relativeMoves.add(new Position(0,+1));
			relativeMoves.add(new Position(-1,0));
			relativeMoves.add(new Position(+1,0));
				break;
			case ROI : relativeMoves.add(new Position(0,-1));
			relativeMoves.add(new Position(0,+1));
			relativeMoves.add(new Position(-1,0));
			relativeMoves.add(new Position(+1,0));
			relativeMoves.add(new Position(-1,-1));
			relativeMoves.add(new Position(+1,+1));
			relativeMoves.add(new Position(-1,+1));
			relativeMoves.add(new Position(+1,-1));
				break;
			case CAVALIER : relativeMoves.add(new Position(1,2));
			relativeMoves.add(new Position(2,1));
			relativeMoves.add(new Position(2,-1));
			relativeMoves.add(new Position(1,-2));
			relativeMoves.add(new Position(-1,-2));
			relativeMoves.add(new Position(-2,-1));
			relativeMoves.add(new Position(-2,1));
			relativeMoves.add(new Position(-1,2));
				break;
			case REINE : relativeMoves.add(new Position(0,-1));
			relativeMoves.add(new Position(0,+1));
			relativeMoves.add(new Position(-1,0));
			relativeMoves.add(new Position(+1,0));
			relativeMoves.add(new Position(-1,-1));
			relativeMoves.add(new Position(+1,+1));
			relativeMoves.add(new Position(-1,+1));
			relativeMoves.add(new Position(+1,-1));
				break;
			}
		}
	public List<Position> getRelativeMoves() {
		return relativeMoves;
	}
	
	

}
