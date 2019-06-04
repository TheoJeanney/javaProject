package boulderDashGame.controller;

import java.util.Random;
import java.util.TimerTask;

import boulderDashGame.contract.Direction;
import boulderDashGame.entity.Boulder;
import boulderDashGame.entity.Diamond;
import boulderDashGame.entity.Dirt;
import boulderDashGame.entity.Exit;
import boulderDashGame.entity.Hole;
import boulderDashGame.entity.Mole;
import boulderDashGame.entity.Player;
import boulderDashGame.entity.Wall;
import boulderDashGame.model.GameHandler;

public class GameEnemyAI extends TimerTask{
	
	GameHandler gameHandler;
	GameController gameController;
	Random rand = new Random();
	int check = 0;

	public GameHandler getGameHandler() {
		return this.gameHandler;
	}

	public void setGameHandler(GameHandler gameHandler) {
		this.gameHandler = gameHandler;
	}

	public GameController getGameController() {
		return this.gameController;
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
	
	public GameEnemyAI(GameHandler newGameHandler, GameController newGameController)
	{ 
		setGameHandler(newGameHandler);
		setGameController(newGameController);
	}

	@Override
	public void run() {
		loop();
	}
	
	public void loop()
	{
		for (int i = 0; i < getGameHandler().getLevel().length; i++) 
		{
			for (int j = 0; j < getGameHandler().getLevel()[i].length; j++)
			{
				if (getGameHandler().getEntity(j,i) instanceof Mole) 
				{
					int x= rand.nextInt(2 + 1) - 1;
					int y= rand.nextInt(2 + 1) - 1;

					getGameController().moveEntity(j, i, j + x, i + y, Direction.DOWN); // down checks everything so it works...
					check = check + 1;
				}
				
			}
		}
		if (check == 0)
		{
			getGameController().getTimer().cancel();
		}
	}

	
}
