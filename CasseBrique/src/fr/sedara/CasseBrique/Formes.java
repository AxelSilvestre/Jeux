package fr.sedara.CasseBrique;

import java.util.ArrayList;
import java.util.List;

public enum Formes {
	
	CARRE,
	TRIANGLE_BAS,
	TRIANGLE_HAUT,
	DOUBLE_TRIANGLE,
	CROIX_ADDITION,
	CROIX_MULTIPLICATION;
	
	/**
	 * @param dimension: La longueur du côté du carré sur l'axe des abscisses
	 * ou de la base du triangle. Le chiffre doit être impair, s'il ne l'est pas,
	 *  l'impair directement supérieur sera pris.
	 */
	public static List<Position> createShape(Formes forme, int dimension){
		List<Position> list = new ArrayList<Position>();
		int[] tab = {-1,0,1};
		int l;
		int k;
		l = (9-dimension)/2;
		
		switch(forme){
		case CROIX_ADDITION:
			list.add(new Position(4, 4));
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(tab[i] != tab[j] && tab[i] != -tab[j]){
						int count =0;
						Position position = new Position(4, 4);
						while(count<dimension/2){
							position = new Position(position.getX()+tab[i], position.getY()+tab[j]);
							list.add(position);
							count++;
						}
					}
				}
			}
			break;
			
		case CROIX_MULTIPLICATION:
			list.add(new Position(4, 4));
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(tab[i] == tab[j] || tab[i] == -tab[j]){
						int count =0;
						Position position = new Position(4, 4);
						while(count<dimension/2){
							position = new Position(position.getX()+tab[i], position.getY()+tab[j]);
							list.add(position);
							count++;
						}
					}
				}
			}
			break;
		case CARRE:
			for(int i=l;i<9-l;i++){
				for(int j=l;j<9-l;j++){
					list.add(new Position(i, j));
				}
			}
			break;
		case TRIANGLE_HAUT:
			k = l;
			for(int i=6-l;i>l-1;i--){
				 for(int j=k;j<9-k;j++){
					 list.add(new Position(j,i));
				 }
				 k++;
			}	
			
			break;
		case TRIANGLE_BAS:
			k = l;
			for(int i=l+2;i<9-l;i++){
				 for(int j=k;j<9-k;j++){
					 list.add(new Position(j,i));
				 }
				 k++;
			}			
			break;
		case DOUBLE_TRIANGLE:
			k = 8-l;
			for(int i=l;i<9-l;i++){
				 for(int j=8-k;j>k-1;j--){
					 list.add(new Position(i,j));
				 }
				 k--;
			}
			k = l;
			for(int i=l;i<9-l;i++){
				 for(int j=k;j<9-k;j++){
					 list.add(new Position(i,j));
				 }
				 k++;
			}	
			
			break;
		}
		
		return list;
		
	}

}
