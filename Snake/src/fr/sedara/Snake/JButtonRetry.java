package fr.sedara.Snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonRetry extends JButton implements ActionListener{
	 
	public JButtonRetry(){
		super();
		this.setText("Menu Principal");
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		TaskDisplay.fenetreJLabel.dispose();
		TaskDisplay.fenetre.setEnabled(true);
		TaskDisplay.fenetre.toFront();
		for(int i=0;i<40;i++){
			for(int j=0;j<40;j++){
				TaskDisplay.tableau[i][j].setIcon(null);
			}
		}
		TaskDisplay.setDisplayBegining();
	}

	


}
