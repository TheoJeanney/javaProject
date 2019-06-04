package boulderDashGame.view;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

import javax.swing.*;

import boulderDashGame.contract.CounterType;
import boulderDashGame.contract.Direction;
import boulderDashGame.contract.DisplayType;
import boulderDashGame.contract.EndType;
import boulderDashGame.contract.GameLevels;
import boulderDashGame.controller.GameController;
import boulderDashGame.controller.GameEnemyAI;
import boulderDashGame.model.GameHandler;

/**
 * <h1>View Class</h1>
 * The View of the game.
 * <p>
 * This class is the object that is used to quit the game.
 * <p>
 * 
* @author joana
* @version 9.2
* @since 0.9.0
*/

public class View implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container contents;
	JTextField keyText = new JTextField(80);
	GameHandler gameHandler;
	GameController gameController;
	GameEnemyAI gameAI;
	JFrame gameFrame;
	JFrame menuFrame;
    JFrame endFrame;
	
	private JLabel[][] labelGrid = new JLabel[19][30];
	
	public View()
	{
		setGameHandler(new GameHandler(GameLevels.LevelOne));
		setGameController(new GameController(this, gameHandler));
		gameDisplay();
		gameMenu();
		getMenuFrame().setVisible(true);
	}
	
	public GameController getGameController() {
		return gameController;
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
	
	public GameHandler getGameHandler() {
		return gameHandler;
	}

	public void setGameHandler(GameHandler gameHandler) {
		this.gameHandler = gameHandler;
	}

	public JFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(JFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public JFrame getMenuFrame() {
		return menuFrame;
	}

	public void setMenuFrame(JFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	public JFrame getEndFrame() {
		return endFrame;
	}

	public void setEndFrame(JFrame endFrame) {
		this.endFrame = endFrame;
	}

	public void gameDisplay()
	{
		setGameFrame(new JFrame("BoulderDash Game"));
		contents = getGameFrame().getContentPane();
		contents.setLayout(new GridLayout(19,30));
		//keyText.addKeyListener(this);
		getGameFrame().addKeyListener(this);
		//contents.add(keyText, BorderLayout.NORTH);
		
		
		for(int m = 0; m < 19; m++) {
 		   for(int n = 0; n < 30; n++) {
 				System.out.println("hey " + m + " " + n);

 			  labelGrid[m][n] = new JLabel();
 			 labelGrid[m][n].setIcon(new ImageIcon("C:\\Users\\Thomas\\Desktop\\Boulder_B.png"));
 			 contents.add(labelGrid[m][n]);
 			System.out.println("OUT");
 		   }
 		}
		getGameFrame().setSize(1000, 650);
		getGameFrame().setLocationRelativeTo(null);
		getGameFrame().setVisible(false);
		labelGrid[0][0].setText("<html><font color='white'>10</font></html>");
	}

	public void gameMenu()
	{
		setMenuFrame(new JFrame("BoulderDash Menu"));
		
		JLabel lbl = new JLabel("Choose a Level and Press OK:");
		JLabel lim = new JLabel();
	    lbl.setHorizontalAlignment(JLabel.CENTER);  
	    lbl.setSize(400,100);
	    lbl.setBounds(135,300,400,100);

	    lim.setHorizontalAlignment(JLabel.CENTER);  
	    lim.setBounds(35,10,600,300);

		lbl.setFont(new Font(lbl.getFont().getName(), lbl.getFont().getStyle(), 22));
		lim.setIcon(new ImageIcon("C:\\Users\\Thomas\\Desktop\\images\\BD-logo.png"));
		//lbl.setPreferredSize(new Dimension(200, 200));
		//lbl.setBorder( BorderFactory.createEmptyBorder(0,100,0,0) );
		JButton btn = new JButton("OK");
		btn.setBounds(370,400,75,20);
		
		//String levels[] = {"Level 1","Level 2","Level 3","Level 4","Level 5"};
	    final JComboBox<GameLevels> cmb = new JComboBox<GameLevels>(GameLevels.values());    
	    cmb.setBounds(220,400,90,20);   
	    
	    getMenuFrame().add(cmb);
	    getMenuFrame().add(lbl);
	    getMenuFrame().add(lim);
	    getMenuFrame().add(btn);
		
	    getMenuFrame().setLayout(null);
		getMenuFrame().setSize(700, 500);
		getMenuFrame().setLocationRelativeTo(null);
		getMenuFrame().setVisible(true);
		
		btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            	GameLevels levelChoice = (GameLevels) cmb.getSelectedItem();
            	launchGame(levelChoice);
            	getGameFrame().setVisible(true);
            	if (getEndFrame() != null)
            	{
            		getEndFrame().setVisible(false);
            	}
            	setDiamondCounter();
            	getGameController().startEnemyAI();
            }
        });
	}
	
	public void gameEnd(EndType endType)
	{
		setEndFrame(new JFrame("BoulderDash Game Ended"));
		String endTxt = "Um... Why...";;
		switch (endType)
		{
			case WIN:
				endTxt = "You WON!";
				break;
			case DEAD:
				endTxt = "You DIED...";
				break;
			case LOSE:
				endTxt = "You LOST...";
				break;
		}
		JLabel lbl = new JLabel(endTxt);
		lbl.setFont(new Font(lbl.getFont().getName(), lbl.getFont().getStyle(), 30));
		
		getEndFrame().add(lbl);

		getEndFrame().setSize(1000, 650);
		getEndFrame().setLocationRelativeTo(getGameFrame());
		getEndFrame().setVisible(true);
		getGameFrame().setVisible(false);

	}
	
	public void launchGame(GameLevels choiceLevel)
	{
		if (getGameHandler() == null || getGameController() == null)
		{
			setGameHandler(new GameHandler(GameLevels.LevelOne));
			setGameController(new GameController(this, gameHandler));
		}
		getGameHandler().refreshGame(choiceLevel);
    	getGameController().updateView();
	}
	
	
	
    public void setImageLabel(String path, int x, int y)
    {
    	labelGrid[y][x].setIcon(new ImageIcon(path));
    	
    }
    
    public void setDiamondCounter()
    {
    	labelGrid[0][0].setIcon(new ImageIcon("C:\\Users\\Thomas\\Desktop\\images\\diam4.png"));
    	labelGrid[0][0].setHorizontalTextPosition(JLabel.CENTER);
    	labelGrid[0][0].setText("<html><font color='white'>" + getGameHandler().getCounter(CounterType.DIAMOND) + "</font></html>");
    	labelGrid[0][0].setFont(new Font(labelGrid[0][0].getFont().getName(), labelGrid[0][0].getFont().getStyle(), 30));
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_UP)
		{
			getGameController().orderPerform(Direction.UP);
		}
		else if (keyCode == KeyEvent.VK_DOWN)
		{
			getGameController().orderPerform(Direction.DOWN);
		}
		else if (keyCode == KeyEvent.VK_LEFT)
		{
			getGameController().orderPerform(Direction.LEFT);
		}
		else if (keyCode == KeyEvent.VK_RIGHT)
		{
			getGameController().orderPerform(Direction.RIGHT);
		}
		else if (keyCode == KeyEvent.VK_ALT)
		{
			Timer timer = new Timer();
			gameAI = new GameEnemyAI(gameHandler, gameController);
	        timer.schedule(gameAI, 0, 2000);
		}
		else if (keyCode == KeyEvent.VK_SPACE)
		{
			gameAI.loop();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
