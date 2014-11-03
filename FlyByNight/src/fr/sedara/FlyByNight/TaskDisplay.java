package fr.sedara.FlyByNight;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

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
	JLabel jLabel;
	private JMenuItem menuItemAPropos;
	private JMenuItem menuItemFermer;
	private JMenuItem menuItemNewGame;
	static JLabelCase[][] tableau = new JLabelCase[30][30];
	private static JButtonMenu buttonMenu = new JButtonMenu();
	private static JButtonQuit buttonQuit = new JButtonQuit();


	public void run() {
		
		fenetre = new JFrame();
		fenetre.setTitle("Fly By Night by Sedara");
		fenetre.setSize(800, 800);
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
		buttonGrid.setLayout(new GridLayout(30,30));
		for(int i=0;i<30;i++){
			for(int j=0;j<30;j++){
				TaskDisplay.tableau[j][i] = new JLabelCase(FlyByNight.tableau.getCase(new Position(j,i)));
				buttonGrid.add(TaskDisplay.tableau[j][i]);
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
		if(itemSelectionne == this.menuItemNewGame){
			for(int i=0;i<30;i++){
				for(int j=0;j<30;j++){
					tableau[i][j].setIcon();
				}
			}
			
			fenetre.addKeyListener(this);
			
		    final Timer timer = new Timer();
		    timer.schedule (new TimerTask() {
		    public void run()
		        { 
					for(int i=0;i<30;i++){
						for(int j=0;j<30;j++){
							tableau[i][j].setIcon();
						}
					}
					
		    		if(!FlyByNight.tableau.win()){
		    			activateWin();
		    			timer.cancel();
		    			return;
		    		}
		        		

		        }
		     }, 0, 300);
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

		JLabel jLabel = new JLabel("Partie terminée avec un score de : "+FlyByNight.tableau.getScore());
		jLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JSplitPane splitPaneSuperieur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneSuperieur.setEnabled(false);
		
		JSplitPane splitPaneInferieur;
		splitPaneInferieur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(0,2));
		jPanel.add(buttonMenu);
		jPanel.add(buttonQuit);
		splitPaneInferieur.add(jPanel);
		splitPaneInferieur.setEnabled(false);
		
		splitPaneSuperieur.add(jLabel);
		splitPaneSuperieur.add(splitPaneInferieur);
		fenetreJLabel.getContentPane().add(splitPaneSuperieur);
		fenetreJLabel.setLocationRelativeTo(null);
		fenetreJLabel.setVisible(true);
	}


	public void keyPressed(KeyEvent e) {
		try{
		if(e.getKeyCode() == KeyEvent.VK_UP){
			FlyByNight.tableau.setFlyeur(new Position(FlyByNight.tableau.getFlyeur().getPosition().getX(),
					FlyByNight.tableau.getFlyeur().getPosition().getY()-1));
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			FlyByNight.tableau.setFlyeur(new Position(FlyByNight.tableau.getFlyeur().getPosition().getX(),
					FlyByNight.tableau.getFlyeur().getPosition().getY()+1));
		}
		}catch(ArrayIndexOutOfBoundsException ee){};	
		

	}


	public void keyReleased(KeyEvent e) {
		
	}
	


	public void keyTyped(KeyEvent e) {
	
	}



}


