package fr.sedara.Othello;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;


public class TaskDisplay implements Runnable, ActionListener {

	public static JFrame fenetre;
	public static JFrame fenetreJLabel;
	JLabel jLabel;
	private JMenuItem menuItemAPropos;
	private JMenuItem menuItemFermer;
	public static JButtonCase[][] tableau = new JButtonCase[8][8];
	private static JButtonRetry buttonRetry = new JButtonRetry();
	private static JButtonQuit buttonQuit = new JButtonQuit();
	public static JLabel jLabelInfo = new JLabel();
	
	public void run() {
		
		fenetre = new JFrame();
		fenetre.setTitle("Othello by Sedara");
		fenetre.setSize(770,620);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		this.menuItemAPropos = new JMenuItem("A propos");
		this.menuItemAPropos.addActionListener(this);
		menu.add(menuItemAPropos);
		this.menuItemFermer = new JMenuItem("Fermer");
		this.menuItemFermer.addActionListener(this);
		menu.add(menuItemFermer);
		menuBar.add(menu);
		fenetre.setJMenuBar(menuBar);
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(8,8));
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				tableau[j][i] = new JButtonCase(new Position(j, i));
				grid.add(tableau[j][i]);
		}
		}
		tableau[4][4].setCouleur(Couleur.BLANC);
		tableau[3][3].setCouleur(Couleur.BLANC);
		tableau[4][3].setCouleur(Couleur.NOIR);
		tableau[3][4].setCouleur(Couleur.NOIR);
		Othello.tableau.setPlayableCases(Couleur.NOIR);
		setPlayableJButtonCases.setPlayableCases(Couleur.NOIR);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setEnabled(false);
	//	splitPane.setLayout(new GridLayout(0, 0));
		setTextJLabelInfo();
		splitPane.add(jLabelInfo);
		splitPane.add(grid);
		fenetre.add(splitPane);

		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);

	}


	public void actionPerformed(ActionEvent event) {
		JMenuItem itemSelectionne = (JMenuItem) event.getSource();
		if (itemSelectionne == this.menuItemAPropos)
		{
		JOptionPane.showMessageDialog(fenetre, "Made by Sedara\nContact : axel.sedara@gmail.com", "A propos", JOptionPane.INFORMATION_MESSAGE);
		return;
		}
		if (itemSelectionne == this.menuItemFermer)
		{
		if (JOptionPane.showConfirmDialog(fenetre, "Fermer l'application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		fenetre.dispose();
		}	
		
	}
	
	public static void setTextJLabelInfo(){
		Othello.tableau.blanc = 0;
		Othello.tableau.noir = 0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(TaskDisplay.tableau[i][j].getCasee().getCouleur() == Couleur.BLANC)
					Othello.tableau.blanc++;
				if(TaskDisplay.tableau[i][j].getCasee().getCouleur() == Couleur.NOIR)
					Othello.tableau.noir++;
		}
		}
		jLabelInfo.setText("<html>Informations:<br><br>Noir : "+Othello.tableau.noir+"<br>Blanc : "+Othello.tableau.blanc+"<br><br> Tour du joueur "+(Othello.turn%2 == 0 ? "Blanc." : "Noir.")+"</html>");
		Othello.tableau.blanc = 0;
		Othello.tableau.noir = 0;
	}
	
	public static void activateWin(){
		fenetre.setEnabled(false);
		fenetreJLabel = new JFrame("Partie terminée");
		fenetreJLabel.setSize(500, 100);
		fenetreJLabel.setResizable(false);

		JLabel jLabel;
		if(Othello.tableau.blanc != Othello.tableau.noir)
			jLabel = new JLabel("Le joueur "+(Othello.tableau.blanc > Othello.tableau.noir ? "Blanc" : "Noir")+" gagne la partie avec "
					+ ((Othello.tableau.blanc > Othello.tableau.noir ? Othello.tableau.blanc : Othello.tableau.noir)+" cases contre " +
			(Othello.tableau.blanc > Othello.tableau.noir ? Othello.tableau.noir : Othello.tableau.blanc))+" pour le joueur "+
					(Othello.tableau.blanc < Othello.tableau.noir ? "Blanc." : "Noir."), new ImageIcon("icon.png"), SwingConstants.CENTER);
		else
			jLabel = new JLabel("Egalité!", new ImageIcon("icon.png"), SwingConstants.CENTER);
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

}
