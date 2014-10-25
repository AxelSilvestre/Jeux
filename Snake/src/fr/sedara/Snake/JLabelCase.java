package fr.sedara.Snake;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JLabelCase extends JLabel{
	
	private final static ImageIcon SNAKE = new ImageIcon("images/vert.jpg");
	private final static ImageIcon OBJECTIVE = new ImageIcon("images/rouge.gif");
	private Case casee;
	
	public JLabelCase(Case casee){
		super();
		this.casee = casee;
	}
	
	public void setIcon(){
		if(this.casee.getState() == 1){
			this.setIcon(SNAKE);
			return;
		}
		if(this.casee.getState() == -1){
			this.setIcon(OBJECTIVE);
			return;
		}
		this.setIcon(null);
		
	}
	

	
	
}
