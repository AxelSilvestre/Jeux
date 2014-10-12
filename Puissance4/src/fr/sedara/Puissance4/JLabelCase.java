package fr.sedara.Puissance4;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JLabelCase extends JLabel {
	
	private Couleur couleur;
	private Case casee;
	private final static ImageIcon ROUGE =  new ImageIcon("images/rouge.png");
	private final static ImageIcon BLEU =  new ImageIcon("images/bleu.png");
	private final static ImageIcon NULL =  new ImageIcon("images/null.jpg"); 
	
	public JLabelCase(Position position){
		this.couleur = Couleur.NULL;
		setCouleur(this.couleur);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.casee = Puissance4.tableau.getCase(position.getX(),position.getY());
		
	}
	
	public Case getCase() {
		return this.casee;
	}
	
	public Couleur getCouleur(){
		return this.couleur;
	}

	public void setCouleur(Couleur couleur){
		if(couleur == Couleur.BLANC)
			this.setIcon(ROUGE);
		if(couleur == Couleur.NOIR)
			this.setIcon(BLEU);
		if(couleur == Couleur.NULL)
			this.setIcon(NULL);
		this.couleur = couleur;
	}

}
