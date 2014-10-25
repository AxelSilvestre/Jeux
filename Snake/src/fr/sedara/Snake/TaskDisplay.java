package fr.sedara.Snake;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

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

public class TaskDisplay implements Runnable, ActionListener, KeyListener {
	
	public static JFrame fenetre;
	public static JFrame fenetreJLabel;
	JLabel jLabel;
	private JMenuItem menuItemAPropos;
	private JMenuItem menuItemFermer;
	private JMenuItem menuItemNewGame;
	static JLabelCase[][] tableau = new JLabelCase[40][40];
	private static JButtonRetry buttonRetry = new JButtonRetry();
	private static JButtonQuit buttonQuit = new JButtonQuit();
	private String str;
	private static boolean begin;
	private final static ImageIcon SNAKE = new ImageIcon("images/vert.jpg");
	private final static ImageIcon OBJECTIVE = new ImageIcon("images/rouge.gif");


	public void run() {
		
		fenetre = new JFrame();
		fenetre.setTitle("Snake by Sedara");
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
		buttonGrid.setLayout(new GridLayout(40,40));
		for(int i=0;i<40;i++){
			for(int j=0;j<40;j++){
				TaskDisplay.tableau[j][i] = new JLabelCase(Snake.tableau.getCase(new Position(j,i)));
				buttonGrid.add(TaskDisplay.tableau[j][i]);
		}
		}		
		fenetre.add(buttonGrid);
		setDisplayBegining();
		
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
			begin = true;
			str = "droite";
			Snake.tableau.setFirstCases();
			Snake.tableau.setDir("droite");
			Snake.tableau.score = 0;
			for(int i=0;i<40;i++){
				for(int j=0;j<40;j++){
					tableau[i][j].setIcon();
				}
			}
			
			fenetre.addKeyListener(this);
			
		    final Timer timer = new Timer();
		    timer.schedule (new TimerTask() {
		    public void run()
		        { 
		    	
	    				if(!str.equalsIgnoreCase(Snake.tableau.getOppositeDir(Snake.tableau.getDir())))
	    					Snake.tableau.setDir(str);
	    				
		            	if(!Snake.tableau.play()){
		            		activateWin();
		            		timer.cancel();
		            		return;
		            	}
		            	for(int i=0;i<40;i++){
		            		for(int j=0;j<40;j++){
		            			tableau[j][i].setIcon();
		            		}
		            			
		            	}
		        		

		            }
		        }, 0, 100);
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

		JLabel jLabel = new JLabel("Partie terminée avec un score de : "+Snake.tableau.score);
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


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			str = "gauche";
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			str = "droite";
		if(e.getKeyCode() == KeyEvent.VK_UP)
			str = "haut";
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			str = "bas";
		

	}


	public void keyReleased(KeyEvent e) {
		
	}
	


	public void keyTyped(KeyEvent e) {
	
	}
	

	
	public static void setDisplayBegining() {
		begin = false;
		Snake.tableau.setDir("droite");
		
		// SNAKE
		
		//S
		TaskDisplay.tableau[11][12].setIcon(SNAKE);
		TaskDisplay.tableau[12][12].setIcon(SNAKE);
		TaskDisplay.tableau[13][12].setIcon(SNAKE);
		TaskDisplay.tableau[11][13].setIcon(SNAKE);
		TaskDisplay.tableau[11][14].setIcon(SNAKE);
		TaskDisplay.tableau[12][14].setIcon(SNAKE);
		TaskDisplay.tableau[13][14].setIcon(SNAKE);
		TaskDisplay.tableau[13][15].setIcon(SNAKE);
		TaskDisplay.tableau[11][16].setIcon(SNAKE);
		TaskDisplay.tableau[12][16].setIcon(SNAKE);
		TaskDisplay.tableau[13][16].setIcon(SNAKE);
		
		//N
		TaskDisplay.tableau[15][12].setIcon(SNAKE);
		TaskDisplay.tableau[15][13].setIcon(SNAKE);
		TaskDisplay.tableau[15][14].setIcon(SNAKE);
		TaskDisplay.tableau[15][15].setIcon(SNAKE);
		TaskDisplay.tableau[15][16].setIcon(SNAKE);
		TaskDisplay.tableau[16][12].setIcon(SNAKE);
		TaskDisplay.tableau[17][12].setIcon(SNAKE);
		TaskDisplay.tableau[17][13].setIcon(SNAKE);
		TaskDisplay.tableau[17][14].setIcon(SNAKE);
		TaskDisplay.tableau[17][15].setIcon(SNAKE);
		TaskDisplay.tableau[17][16].setIcon(SNAKE);
		
		//A
		TaskDisplay.tableau[19][12].setIcon(SNAKE);
		TaskDisplay.tableau[19][13].setIcon(SNAKE);
		TaskDisplay.tableau[19][14].setIcon(SNAKE);
		TaskDisplay.tableau[19][15].setIcon(SNAKE);
		TaskDisplay.tableau[19][16].setIcon(SNAKE);
		TaskDisplay.tableau[20][12].setIcon(SNAKE);
		TaskDisplay.tableau[21][12].setIcon(SNAKE);
		TaskDisplay.tableau[21][13].setIcon(SNAKE);
		TaskDisplay.tableau[21][14].setIcon(SNAKE);
		TaskDisplay.tableau[21][15].setIcon(SNAKE);
		TaskDisplay.tableau[21][16].setIcon(SNAKE);
		TaskDisplay.tableau[20][14].setIcon(SNAKE);
		
		//K
		TaskDisplay.tableau[23][12].setIcon(SNAKE);
		TaskDisplay.tableau[23][13].setIcon(SNAKE);
		TaskDisplay.tableau[23][14].setIcon(SNAKE);
		TaskDisplay.tableau[23][15].setIcon(SNAKE);
		TaskDisplay.tableau[23][16].setIcon(SNAKE);
		TaskDisplay.tableau[25][12].setIcon(SNAKE);
		TaskDisplay.tableau[25][13].setIcon(SNAKE);
		TaskDisplay.tableau[25][15].setIcon(SNAKE);
		TaskDisplay.tableau[25][16].setIcon(SNAKE);
		TaskDisplay.tableau[24][14].setIcon(SNAKE);
		
		//E
		TaskDisplay.tableau[27][12].setIcon(SNAKE);
		TaskDisplay.tableau[27][13].setIcon(SNAKE);
		TaskDisplay.tableau[27][14].setIcon(SNAKE);
		TaskDisplay.tableau[27][15].setIcon(SNAKE);
		TaskDisplay.tableau[27][16].setIcon(SNAKE);
		TaskDisplay.tableau[28][12].setIcon(SNAKE);
		TaskDisplay.tableau[28][14].setIcon(SNAKE);
		TaskDisplay.tableau[28][16].setIcon(SNAKE);
		TaskDisplay.tableau[29][12].setIcon(SNAKE);
		TaskDisplay.tableau[29][16].setIcon(SNAKE);
		
		
		//BY
		
		//B
		TaskDisplay.tableau[17][18].setIcon(SNAKE);
		TaskDisplay.tableau[17][19].setIcon(SNAKE);
		TaskDisplay.tableau[17][20].setIcon(SNAKE);
		TaskDisplay.tableau[17][21].setIcon(SNAKE);
		TaskDisplay.tableau[17][22].setIcon(SNAKE);
		TaskDisplay.tableau[18][18].setIcon(SNAKE);
		TaskDisplay.tableau[18][20].setIcon(SNAKE);
		TaskDisplay.tableau[18][22].setIcon(SNAKE);
		TaskDisplay.tableau[19][19].setIcon(SNAKE);
		TaskDisplay.tableau[19][21].setIcon(SNAKE);
		
		//Y
		TaskDisplay.tableau[23][18].setIcon(SNAKE);
		TaskDisplay.tableau[23][19].setIcon(SNAKE);
		TaskDisplay.tableau[23][20].setIcon(SNAKE);
		TaskDisplay.tableau[22][21].setIcon(SNAKE);
		TaskDisplay.tableau[22][22].setIcon(SNAKE);
		TaskDisplay.tableau[21][18].setIcon(SNAKE);
		TaskDisplay.tableau[21][19].setIcon(SNAKE);
		TaskDisplay.tableau[21][20].setIcon(SNAKE);
		TaskDisplay.tableau[22][20].setIcon(SNAKE);
		
		
		//SEDARA
		
		//S
		TaskDisplay.tableau[9][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[9][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[9][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[9][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[10][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[10][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[10][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[11][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[11][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[11][27].setIcon(OBJECTIVE);
		TaskDisplay.tableau[11][28].setIcon(OBJECTIVE);
		
		//E
		TaskDisplay.tableau[13][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[13][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[13][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[13][27].setIcon(OBJECTIVE);
		TaskDisplay.tableau[13][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[14][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[14][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[14][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[15][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[15][28].setIcon(OBJECTIVE);
		
		//D
		TaskDisplay.tableau[17][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[17][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[17][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[17][27].setIcon(OBJECTIVE);
		TaskDisplay.tableau[17][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[18][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[18][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[19][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[19][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[19][27].setIcon(OBJECTIVE);
		
		//A
		TaskDisplay.tableau[21][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[21][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[21][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[21][27].setIcon(OBJECTIVE);
		TaskDisplay.tableau[21][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[23][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[23][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[23][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[23][27].setIcon(OBJECTIVE);
		TaskDisplay.tableau[23][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[22][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[22][26].setIcon(OBJECTIVE);
		
		
		//R
		TaskDisplay.tableau[25][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[25][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[25][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[25][27].setIcon(OBJECTIVE);
		TaskDisplay.tableau[25][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[26][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[26][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[27][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[27][27].setIcon(OBJECTIVE);
		TaskDisplay.tableau[27][28].setIcon(OBJECTIVE);
		
		//A
		TaskDisplay.tableau[29][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[29][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[29][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[29][27].setIcon(OBJECTIVE);
		TaskDisplay.tableau[29][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[31][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[31][25].setIcon(OBJECTIVE);
		TaskDisplay.tableau[31][26].setIcon(OBJECTIVE);
		TaskDisplay.tableau[31][27].setIcon(OBJECTIVE);
		TaskDisplay.tableau[31][28].setIcon(OBJECTIVE);
		TaskDisplay.tableau[30][24].setIcon(OBJECTIVE);
		TaskDisplay.tableau[30][26].setIcon(OBJECTIVE);
		
		Snake.tableau.setFirstCasesForAnim();
		final Timer timer = new Timer();		
	    timer.schedule (new TimerTask() {
	    public void run()
	        { 
	    		if(begin){
	    			for(int i=0;i<40;i++){
	    				for(int j=0;j<40;j++){
	    					tableau[i][j].setIcon(null);
	    				}
	    			}
            		timer.cancel();
            		return;	
	    		}

	    		Snake.tableau.playAnim();
	    		
	    		for(int i=0;i<40;i++){
	    				tableau[i][5].setIcon();
	    				tableau[i][35].setIcon();
	    				tableau[5][i].setIcon();
	    				tableau[35][i].setIcon();
	    		}

	        		

	        }
	        }, 0, 100);
	
	}


}

