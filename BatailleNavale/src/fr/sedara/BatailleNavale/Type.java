package fr.sedara.BatailleNavale;

public enum Type {
	
	PORTE_AVIONS,
	CROISEUR,
	CONTRE_TORPILLEUR,
	SOUS_MARIN,
	TORPILLEUR,
	NULL;
	
	public static int getSize(Type type){
		switch(type){
		case PORTE_AVIONS : return 5;
		case CROISEUR : return 4;
		case TORPILLEUR : return 2;
		case CONTRE_TORPILLEUR :
		case SOUS_MARIN : return 3;
		case NULL : return 0;
		}
		return 0;
		
	}

}
