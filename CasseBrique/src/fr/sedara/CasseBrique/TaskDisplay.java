package fr.sedara.CasseBrique;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class TaskDisplay implements Runnable, ActionListener, KeyListener {
	
	public static JFrame fenetre;
	public static JFrame fenetreJLabel;
	private JMenuItem menuItemAPropos;
	private JMenuItem menuItemFermer;
	private JMenuItem menuItemNewGame;
	public static JLabelBrique[][] tableau = new JLabelBrique[9][18];
	private static JButtonRetry buttonRetry = new JButtonRetry();
	private static JButtonQuit buttonQuit = new JButtonQuit();


	public void run() {
		
		fenetre = new JFrame();
		fenetre.setTitle("Casse Brique by Sedara");
		fenetre.setSize(800,800);
		fenetre.setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
     	this.menuItemNewGame = new JMenuItem("Nouvelle partie");
		this.menuItemNewGame.addActionListener(this);
		menu.add(menuItemNewGame);
		this.menuItemAPropos = new JMenuItem("A propos");
		this.menuItemAPropos.addActionListener(this);
		menu.add(menuItemAPropos);
		this.menuItemFermer = new JMenuItem("Fermer");
		this.menuItemFermer.addActionListener(this);
		menu.add(menuItemFermer);
		menuBar.add(menu);
		fenetre.setJMenuBar(menuBar);
		JPanel buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(18,9));
		for(int i=0;i<18;i++){
			for(int j=0;j<9;j++){
				tableau[j][i] = new JLabelBrique(Terrain.tableau.getBrique(new Position(j,i)));
				tableau[j][i].setBorder(BorderFactory.createLineBorder(Color.black));
     			buttonGrid.add(tableau[j][i]);
		}
		}		
		fenetre.add(buttonGrid);
		

			
		
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);

	}
	
	public void newGame(){
		
	}

	@Override
	public void actionPerformed(ActionEvent event)	{
		JMenuItem itemSelectionne = (JMenuItem) event.getSource();
		if (itemSelectionne == this.menuItemAPropos)
		{
		JOptionPane.showMessageDialog(fenetre, "Made by Sedara\nContact : axel.sedara@gmail.com", "A propos", JOptionPane.INFORMATION_MESSAGE);
		return;
		}
		if(itemSelectionne == this.menuItemNewGame){
			setBriques();
			fenetre.addKeyListener(this);
		return;
		}
		if (itemSelectionne == this.menuItemFermer)
		{
		if (JOptionPane.showConfirmDialog(fenetre, "Fermer l'application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		fenetre.dispose();
		}	
	}
	
	public static void activateWin(){
		fenetre.setEnabled(false);
		fenetreJLabel = new JFrame("Partie terminée");
		fenetreJLabel.setSize(300, 100);
		fenetreJLabel.setResizable(false);

		JLabel jLabel = new JLabel();
		jLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JSplitPane splitPaneSuperieur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneSuperieur.setEnabled(false);
		
		JSplitPane splitPaneInferieur;
		splitPaneInferieur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(0,2));
		jPanel.add(buttonRetry);
		jPanel.add(buttonQuit);
		splitPaneInferieur.add(jPanel);
		splitPaneInferieur.setEnabled(false);
		
		splitPaneSuperieur.add(jLabel);
		splitPaneSuperieur.add(splitPaneInferieur);
		fenetreJLabel.getContentPane().add(splitPaneSuperieur);
		fenetreJLabel.setLocationRelativeTo(null);
		fenetreJLabel.setVisible(true);
	}
	
	public void setBriques(){
		for(int i=0;i<9;i++){
			for(int j=0;j<18;j++){
					tableau[i][j].setBrique();
		}
	}
	}
	
	public void keyPressed(KeyEvent e) {
		try{
		Brique b = Terrain.tableau.getBrique(Terrain.tableau.getBarre().getPosition());
		Brique dest = new Brique();
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			dest = Terrain.tableau.getBrique(new Position
					(Terrain.tableau.getBarre().getPosition().getX()-1,Terrain.tableau.getBarre().getPosition().getY()));		
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			dest = Terrain.tableau.getBrique(new Position
					(Terrain.tableau.getBarre().getPosition().getX()+1,Terrain.tableau.getBarre().getPosition().getY()));		
		
		Terrain.tableau.getBarre().setPosition(dest.getPosition());			
		Terrain.tableau.getBrique(Terrain.tableau.getBarre().getPosition()).setHasBar(true);
		
		b.setHasBar(false);
		
		for(int i=0;i<9;i++){
			TaskDisplay.tableau[i][17].setBrique();
		}		

	
		}
		}catch(ArrayIndexOutOfBoundsException eout){return;};
}

public void keyReleased(KeyEvent e) {
	
}

public void keyTyped(KeyEvent e) {

}
	


}