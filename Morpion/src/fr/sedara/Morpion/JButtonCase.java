package fr.sedara.Morpion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonCase extends JButton implements ActionListener {

	private Signe signe;
	private Case casee;
	private final static ImageIcon CROIX =  new ImageIcon("images/croix.jpg");
	private final static ImageIcon ROND =  new ImageIcon("images/rond.jpg");
	private final static ImageIcon NULL =  new ImageIcon("images/null.jpg"); 
	
	public JButtonCase(Position position) 
	{
		super();
		this.signe = Signe.NULL;
		this.casee = Morpion.tableau.getCase(position.getX(),position.getY());
		this.addActionListener(this);
	}
	
	public void setSigne(Signe signe){
		if(signe == Signe.CROIX)
			this.setIcon(CROIX);
		if(signe == Signe.ROND)
			this.setIcon(ROND);
		if(signe == Signe.NULL)
			this.setIcon(NULL);
		this.signe = signe;
	}

	public void actionPerformed(ActionEvent e) {
		if(this.signe == Signe.NULL){
			if(Morpion.turn%2 == 0 && signe != Signe.CROIX){
				Morpion.turn++;
				setSigne(Signe.CROIX);
			}
			else{
				setSigne(Signe.ROND);
				Morpion.turn++;
				}
		}
		
		this.casee.setSigne(this.signe);
		if(Morpion.tableau.win())
			TaskDisplay.activateWin(signe);	
		
	}

	}
