package fr.sedara.CasseBrique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonRetry extends JButton implements ActionListener{
	 
	public JButtonRetry(){
		super();
		this.setText("Recommencer");
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		TaskDisplay.fenetreJLabel.dispose();
		TaskDisplay.fenetre.dispose();
		Cassebrique.main(null);
	}
}
