package fr.sedara.Snake;



public class Snake implements Runnable {
	
	public static Tableau tableau;

	public static void main(String[] args) {
		tableau = new Tableau();
		tableau.setSnake();
		System.out.println(tableau.toString());
	}
	


	public void run() {
		
		
	}


}
