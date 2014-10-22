package fr.sedara.CasseBrique;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JLabelBrique extends JLabel{
	
	private Brique brique;
	private final static ImageIcon BRIQUE = new ImageIcon("images/rouge.gif");
	private final static ImageIcon BARRE = new ImageIcon("images/vert.jpg");
	
	public JLabelBrique(Brique brique){
		super();
		this.brique = brique;
	}


	public Brique getBrique() {
		return brique;
	}

	public void setBrique() {
		if(this.brique.getState() == 1)
			this.setIcon(BRIQUE);
		if(this.brique.isHasBar())
			this.setIcon(BARRE);
	}
	

}
