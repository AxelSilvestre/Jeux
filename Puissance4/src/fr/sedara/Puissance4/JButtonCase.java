package fr.sedara.Puissance4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


@SuppressWarnings("serial")
public class JButtonCase extends JButton implements ActionListener{
	
	private int x;
	
	public JButtonCase(int x) {
		super();
		this.x = x;
		this.addActionListener(this);
	}
	


	public void actionPerformed(ActionEvent e) {
		if(Puissance4.turn%2 == 0)
			Puissance4.tableau.putCouleur(this.x,Couleur.BLANC);
		else		
			Puissance4.tableau.putCouleur(this.x,Couleur.NOIR);
		if(Puissance4.tableau.full){
			this.setText("Plein");
			Puissance4.turn--;
		}

		for(int i=5;i>-1;i--){
			Couleur couleur = TaskDisplay.tableau[x][i].getCouleur();
			if(couleur == Couleur.NULL){
			TaskDisplay.tableau[x][i].setCouleur(Puissance4.turn%2 == 0 ? Couleur.BLANC : Couleur.NOIR);
			break;
			}
		}

		Puissance4.turn++;
		if(Puissance4.tableau.win())
			TaskDisplay.activateWin((Puissance4.turn%2 == 1 ? Couleur.BLANC : Couleur.NOIR));

		
	}
}
