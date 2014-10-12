package fr.sedara.Puissance4;

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
	public static JLabelCase[][] tableau = new JLabelCase[7][6];
	private JButtonCase[] tableauCase = new JButtonCase[7];
	private static Couleur winnerCouleur = Couleur.NULL;
	private static JButtonRetry buttonRetry = new JButtonRetry();
	private static JButtonQuit buttonQuit = new JButtonQuit();
	
	public void run() {
		
		fenetre = new JFrame();
		fenetre.setTitle("Puissance 4 by Sedara");
		fenetre.setSize(620,620);
		fenetre.setResizable(false);
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
		grid.setLayout(new GridLayout(7,7));
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				tableau[j][i] = new JLabelCase(new Position(j, i));
				tableau[j][i].setText(j+","+i);
				grid.add(tableau[j][i]);
		}
		}
		for(int i=0;i<7;i++){
			this.tableauCase[i] = new JButtonCase(i);
			grid.add(this.tableauCase[i]);
		}
		fenetre.add(grid);

		
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
	
	public static void activateWin(Couleur couleur){
		winnerCouleur = couleur;
		fenetre.setEnabled(false);
		fenetreJLabel = new JFrame("Partie terminée");
		fenetreJLabel.setSize(300, 100);
		fenetreJLabel.setResizable(false);

		JLabel jLabel;
		if(Puissance4.turn != -1)
			jLabel = new JLabel("Le joueur "+(winnerCouleur == Couleur.BLANC ? "Rouge" : "Bleu")+" gagne la partie!", new ImageIcon("icon.png"), SwingConstants.CENTER);
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
