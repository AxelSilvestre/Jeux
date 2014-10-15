package fr.sedara.BatailleNavale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonCase extends JButton implements ActionListener {

//	private Signe signe;
	private Case casee; 
	
	public JButtonCase(Position position) 
	{
		super();
	//	this.signe = Signe.NULL;
	//	this.casee = Morpion.tableau.getCase(position.getX(),position.getY());
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}