package fr.sedara.FlyByNight;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JLabelCase extends JLabel{
	
	private final static ImageIcon FLYEUR = new ImageIcon("images/vert.jpg");
	private final static ImageIcon MUR = new ImageIcon("images/rouge.gif");
	private Case casee;
	
	public JLabelCase(Case casee){
		super();
		this.casee = casee;
	}
	
	public void setIcon(){
		if(this.casee.getType() == Type.MUR){
			this.setIcon(MUR);
			return;
		}
		if(this.casee.getType() == Type.FLYEUR){
			this.setIcon(FLYEUR);
			return;
		}
		this.setIcon(null);
		
	}
}