package fr.sedara.Othello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonCase extends JButton implements ActionListener{
	
	private Case casee;
	private boolean playable;
	private final static ImageIcon NOIR =  new ImageIcon("images/noir.jpeg");
	private final static ImageIcon BLANC =  new ImageIcon("images/blanc.jpeg");
	private final static ImageIcon NULL =  new ImageIcon("images/null.jpeg"); 
	private final static ImageIcon PLAYABLE =  new ImageIcon("images/play.jpeg"); 
	
	public JButtonCase(Position position){
		super();
		this.playable = false;
		this.casee = Othello.tableau.getCase(position);
		this.setIcon(NULL);
		this.addActionListener(this);
	}
	
	public void setCouleur(Couleur couleur){
		if(couleur == Couleur.BLANC)
			this.setIcon(BLANC);
		if(couleur == Couleur.NOIR)
			this.setIcon(NOIR);
	}
	
	public void setPlayable(){
		if(this.casee.isPlayable()){
			this.setIcon(PLAYABLE);
			this.playable = true;
		}
		if(!this.casee.isPlayable() && this.casee.getCouleur() != Couleur.NULL)
			this.playable = false;
		if(!this.casee.isPlayable() && this.casee.getCouleur() == Couleur.NULL){
			this.playable = false;
			this.setIcon(NULL);
		}
	}

	public void actionPerformed(ActionEvent e){
		if(this.playable){
			this.playable = false;
			if(Othello.turn%2 == 0)
				this.setCouleur(Couleur.BLANC);
			else
				this.setCouleur(Couleur.NOIR);
			
			
			if(Othello.tableau.win(this.casee.getPosition().getX(),this.casee.getPosition().getY()))
				TaskDisplay.activateWin();	

			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					TaskDisplay.tableau[i][j].setCouleur(TaskDisplay.tableau[i][j].getCasee().getCouleur());

					
	
			}
			}
			TaskDisplay.setTextJLabelInfo();	
			setPlayableJButtonCases.setPlayableCases(Othello.turn%2 == 0 ? Couleur.BLANC : Couleur.NOIR);



			
		}

			
		
	}

	public boolean isPlayable() {
		return playable;
	}

	public Case getCasee() {
		return casee;
	}

}
