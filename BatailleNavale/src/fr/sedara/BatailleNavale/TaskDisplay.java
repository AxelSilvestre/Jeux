package fr.sedara.BatailleNavale;

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
	private JButtonCase[][] tableau = new JButtonCase[3][3];
	//private static Signe winnerSigne = Signe.NULL;
	private static JButtonRetry buttonRetry = new JButtonRetry();
	private static JButtonQuit buttonQuit = new JButtonQuit();


	public void run() {
		
		fenetre = new JFrame();
		fenetre.setTitle("Morpion by Sedara");
		fenetre.setSize(600, 600);
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
		JPanel buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(3,3));
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				this.tableau[j][i] = new JButtonCase(new Position(j, i));
				buttonGrid.add(this.tableau[j][i]);
				this.tableau[j][i].setSigne(Signe.NULL);
		}
		}		
		fenetre.add(buttonGrid);

		
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event)	{
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
	
	public static void activateWin(Signe signe){
		winnerSigne = signe;
		fenetre.setEnabled(false);
		fenetreJLabel = new JFrame("Partie terminée");
		fenetreJLabel.setSize(300, 100);
		fenetreJLabel.setResizable(false);

		JLabel jLabel;
		if(Morpion.turn != -1)
			jLabel = new JLabel("Le joueur "+winnerSigne.toString()+" gagne la partie!", new ImageIcon("icon.png"), SwingConstants.CENTER);
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
