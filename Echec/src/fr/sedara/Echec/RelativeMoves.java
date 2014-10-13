package fr.sedara.Echec;

import java.util.ArrayList;
import java.util.List;

public class RelativeMoves {
	
	private List<Position> relativeMoves = new ArrayList<>();
	
	public RelativeMoves(Couleur couleur, Type type){
		if(couleur == Couleur.BLANC){
			switch (type){
			case PION : relativeMoves.add(new Position(0,-2));
			relativeMoves.add(new Position(0,-1));
			relativeMoves.add(new Position(-1,-1));
			relativeMoves.add(new Position(+1,-1));
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
			case CAVALIER : relativeMoves.add(new Position(0,-1)); // TODO
			relativeMoves.add(new Position(0,+1));
			relativeMoves.add(new Position(-1,0));
			relativeMoves.add(new Position(+1,0));
			relativeMoves.add(new Position(-1,-1));
			relativeMoves.add(new Position(+1,+1));
			relativeMoves.add(new Position(-1,+1));
			relativeMoves.add(new Position(+1,-1));
				break;
			case REINE : ;
				break;
			}
		}
	}

	public List<Position> getRelativeMoves() {
		return relativeMoves;
	}
	
	

}
