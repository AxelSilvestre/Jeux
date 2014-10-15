package fr.sedara.BatailleNavale;

public enum Type {
	
	PORTE_AVIONS,
	CROISEUR,
	CONTRE_TORPILLEUR,
	SOUS_MARIN,
	TORPILLEUR;
	
	public static int getSize(Type type){
		switch(type){
		case PORTE_AVIONS :
		case SOUS_MARIN : return 5;
		case CROISEUR : return 4;
		case TORPILLEUR : return 2;
		case CONTRE_TORPILLEUR :  return 3;
		}
		return 0;
		
	}

}
