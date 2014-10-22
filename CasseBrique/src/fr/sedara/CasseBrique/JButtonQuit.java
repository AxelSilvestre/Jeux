package fr.sedara.CasseBrique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonQuit extends JButton implements ActionListener{
	
	public JButtonQuit(){
		super();
		this.setText("Quitter");
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		TaskDisplay.fenetreJLabel.dispose();
		TaskDisplay.fenetre.dispose();
	}
}
