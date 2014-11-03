package fr.sedara.FlyByNight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonMenu extends JButton implements ActionListener{
	 
	public JButtonMenu(){
		super();
		this.setText("Menu Principal");
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		TaskDisplay.fenetreJLabel.dispose();
		TaskDisplay.fenetre.dispose();
		FlyByNight.main(null);
	}
}
