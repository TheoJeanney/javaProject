package boulderDashGame.controller;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import boulderDashGame.model.GameHandler;
import boulderDashGame.view.View;
import boulderDashGame.view.GameGridFrame;
import boulderDashGame.contract.CounterType;
import boulderDashGame.contract.Direction;
import boulderDashGame.contract.GameLevels;
import boulderDashGame.contract.IView;
import boulderDashGame.entity.Boulder;
import boulderDashGame.entity.Diamond;
import boulderDashGame.entity.Dirt;
import boulderDashGame.entity.Entity;
import boulderDashGame.entity.Exit;
import boulderDashGame.entity.Hole;
import boulderDashGame.entity.Player;
import boulderDashGame.entity.Wall;

public class ControllerGameTest {
	
	GameHandler game = new GameHandler(GameLevels.LevelOne);
	GameHandler gameSet = new GameHandler(GameLevels.LevelOne);
	GameHandler gameGet = new GameHandler(GameLevels.LevelOne);
	GameHandler gameInter = new GameHandler(GameLevels.LevelOne);
	GameHandler gameCasc = new GameHandler(GameLevels.LevelOne);
	Entity testBoulder = new Boulder(0,0);
	Entity testDiamond = new Diamond(1,0);
	Entity testDirt = new Dirt(0,1);
	Entity testWall = new Wall(1,1);
	Entity testHole = new Hole(22,2);
	Entity testPlayer = new Player(0,2);
	Entity testExit = new Exit(0,5);
	Entity[][] testMaxtrix = new Entity[40][30];
	Entity[][] testMaxtrix2 = new Entity[40][30];
	Entity[][] interMaxtrix = new Entity[50][50];
	Entity[][] cascMaxtrix = new Entity[50][50];
	
	//GameController controlGameInter = new ControllerGame(new View(), gameInter);
	//GameController controlGameCasc = new ControllerGame(new View(), gameCasc);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		gameInter.setLevel(interMaxtrix);
		gameCasc.setLevel(cascMaxtrix);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testControllerGame() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGameLoop() throws InterruptedException {
		//GameHandler testGame = new GameHandler(GameLevels.LevelOne);
		GameGridFrame view = new GameGridFrame();
		//GameController testController = new GameController(view, testGame);
		//view.setController(testController);
		
		//view.createImageLabel("C:\\Users\\Thomas\\Desktop\\Wall_B.png", 10, 10);
		//view.createImageLabel("C:\\Users\\Thomas\\Desktop\\Boulder.png", 0, 0);
		//view.createImageLabel("C:\\Users\\Thomas\\Desktop\\Boulder_t.png", 0, 0);
		//testController.updateView();
		//view.createImageLabel("C:\\Users\\Thomas\\Desktop\\Boulder.png", 0, 0);

		TimeUnit.SECONDS.sleep(100);
		//System.out.println("TEST MOVE " + testGame.getPlayer() + " " + testGame.getPlayer().getPosition().getX() + "," + testGame.getPlayer().getPosition().getY());
		//System.out.println("TEST MOVE2 " + testGame.getPlayer());
		//testController.moveEntity(testGame.getPlayer(),(int) testGame.getPlayer().getPosition().getX() - 1,(int) testGame.getPlayer().getPosition().getY(), Direction.LEFT);
		//System.out.println("OUUT MOVE");
		//TimeUnit.SECONDS.sleep(3);
		//System.out.println("TEST MOVE2 " + testGame.getPlayer());
		//System.out.println("TEST MOVE2" + testGame.getPlayer() + " " + testGame.getPlayer().getPosition().getX() + "," + testGame.getPlayer().getPosition().getY());
		/*System.out.println(testGame.getEntity(29,0));
		for (int i = 0; i < testGame.getLevel().length; i++) 
		{
			System.out.println("");
			for (int j = 0; j < testGame.getLevel()[i].length; j++)
			{
				if (testGame.getEntity(j,i) instanceof Player) 
				{
					System.out.print("* "); 
				}
				else
				{
					System.out.print(testGame.getEntity(j,i).getClass().getSimpleName().charAt(0) + " "); 
				}
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("-----------------------------------------------------------");
		testController.moveEntity(testGame.getPlayer(),(int) testGame.getPlayer().getPosition().getX(),(int) testGame.getPlayer().getPosition().getY() - 1, Direction.UP);
		System.out.println("-----------------------------------------------------------");
		for (int i = 0; i < testGame.getLevel().length; i++) 
		{
			System.out.println("");
			for (int j = 0; j < testGame.getLevel()[i].length; j++)
			{
				if (testGame.getEntity(j,i) instanceof Player) 
				{
					System.out.print("* "); 
				}
				else
				{
					System.out.print(testGame.getEntity(j,i).getClass().getSimpleName().charAt(0) + " "); 
				}
			}
		}*/
	}

	@Test
	public void testControl() {
		fail("Not yet implemented");
	}

	@Test
	public void testOrderPerform() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateView() {
		fail("Not yet implemented");
	}

	@Test
	public void testEndGame() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveEntityIntIntIntIntDirection() {
		fail("Not yet implemented");
	}

	@Test
	public void testHandleInteractionEntityIntInt() {
		// Test Player to Diamond
		final int expected = 2;
		final boolean expectedreturn = true;
		final int expected2 = 1;
		
		gameInter.placeEntity(new Player(1,1), 1, 1);
		gameInter.placeEntity(new Diamond(2,1), 2,1);
		gameInter.placeEntity(new Diamond(3,1), 3,1);
		gameInter.setCounter(CounterType.DIAMOND, 2);
		gameInter.placeEntity(new Wall(3,3), 3, 3);
		gameInter.setExit(new Exit(3, 3));
		assertEquals(expected, gameInter.getCounter(CounterType.DIAMOND));
		assertEquals(expectedreturn, controlGameInter.handleInteraction(gameInter.getEntity(1, 1),2,1));
		assertEquals(expected2, gameInter.getCounter(CounterType.DIAMOND));
		assertTrue(gameInter.getEntity(2, 1) instanceof Hole);
		assertEquals(expectedreturn, controlGameInter.handleInteraction(gameInter.getEntity(1, 1),3,1));
		
		// Test Player to Wall
		final boolean expextedreturn2 = false;
		
		gameInter.placeEntity(new Wall(4,1), 4,1);
		assertEquals(expextedreturn2, controlGameInter.handleInteraction(gameInter.getEntity(1, 1),4,1));
		
		//Test Boulder to Wall
		final boolean expextedreturn3 = false;
		
		gameInter.placeEntity(new Boulder(5,1), 5,1);
		gameInter.placeEntity(new Wall(5,2), 5,2);
		assertEquals(expextedreturn3, controlGameInter.handleInteraction(gameInter.getEntity(5, 1),5,2));

		//Test Boulder to Hole
		final boolean expextedreturn4 = true;
		
		gameInter.placeEntity(new Boulder(6,1), 6,1);
		gameInter.placeEntity(new Hole(6,2), 6,2);
		assertEquals(expextedreturn4, controlGameInter.handleInteraction(gameInter.getEntity(6, 1),6,2));	}

	@Test
	public void testHandleRolling() {
		Entity cascadeHole = new Hole(1,1);
		final Entity expected = cascadeHole;
		gameCasc.placeEntity(cascadeHole, 11,11);
		gameCasc.placeEntity(new Dirt(9,10), 9,10);
		gameCasc.placeEntity(new Dirt(9,11), 9,11);
		gameCasc.placeEntity(new Dirt(9,12), 9,12);
		gameCasc.placeEntity(new Dirt(11,10), 11,10);
		gameCasc.placeEntity(new Dirt(10,10), 10,10);
		gameCasc.placeEntity(new Dirt(12,10), 12,10);
		gameCasc.placeEntity(new Boulder(10,11), 10,11);
		gameCasc.placeEntity(new Dirt(12,11), 12,11);
		gameCasc.placeEntity(new Wall(10,12), 10,12);
		gameCasc.placeEntity(new Dirt(12,12), 12,12);
		gameCasc.placeEntity(new Hole(11,12), 11,12);
		gameCasc.placeEntity(new Dirt(11,13), 11,13);
		assertEquals(expected, gameCasc.getEntity(11, 11));
		controlGameCasc.startCascade(11,11,Direction.UP);
		assertTrue(gameCasc.getEntity(11, 12) instanceof Boulder);
	}
	
	@Test
	public void testHandleCascade() {
		Entity cascadeHole = new Hole(1,1);
		final Entity expected = cascadeHole;
		gameCasc.placeEntity(cascadeHole, 11,11);
		gameCasc.placeEntity(new Dirt(9,10), 9,10);
		gameCasc.placeEntity(new Dirt(9,11), 9,11);
		gameCasc.placeEntity(new Dirt(9,12), 9,12);
		gameCasc.placeEntity(new Dirt(11,10), 11,10);
		gameCasc.placeEntity(new Dirt(10,10), 10,10);
		gameCasc.placeEntity(new Dirt(12,10), 12,10);
		gameCasc.placeEntity(new Boulder(10,11), 10,11);
		gameCasc.placeEntity(new Dirt(12,11), 12,11);
		gameCasc.placeEntity(new Wall(10,12), 10,12);
		gameCasc.placeEntity(new Dirt(12,12), 12,12);
		gameCasc.placeEntity(new Hole(11,12), 11,12);
		gameCasc.placeEntity(new Dirt(11,13), 11,13);
		assertEquals(expected, gameCasc.getEntity(11, 11));
		controlGameCasc.startCascade(11,11,Direction.UP);
		assertTrue(gameCasc.getEntity(11, 12) instanceof Boulder);
	}

	@Test
	public void testStartCascadeIntInt() {
		Entity cascadeHole = new Hole(1,1);
		final Entity expected = cascadeHole;
		gameCasc.placeEntity(cascadeHole, 1,1);
		gameCasc.placeEntity(new Boulder(1,0), 1,0);
		gameCasc.placeEntity(new Dirt(0,0), 0,0);
		gameCasc.placeEntity(new Dirt(2,0), 2,0);
		gameCasc.placeEntity(new Dirt(0,1), 0,1);
		gameCasc.placeEntity(new Dirt(2,1), 2,1);
		gameCasc.placeEntity(new Dirt(0,2), 0,2);
		gameCasc.placeEntity(new Dirt(2,2), 2,2);
		gameCasc.placeEntity(new Dirt(1,2), 1,2);
		assertEquals(expected, gameCasc.getEntity(1, 1));
		controlGameCasc.startCascade(1,1,Direction.LEFT);
		assertTrue(gameCasc.getEntity(1, 1) instanceof Boulder);
	}

	@Test
	public void testStartCascadeEntity() {
		Entity cascadeHole = new Hole(11,11);
		final Entity expected = cascadeHole;
		gameCasc.placeEntity(cascadeHole, 11,11);
		gameCasc.placeEntity(new Dirt(10,8), 10,8);
		gameCasc.placeEntity(new Dirt(12,8), 12,8);
		gameCasc.placeEntity(new Dirt(10,9), 10,9);
		gameCasc.placeEntity(new Dirt(12,9), 12,9);
		gameCasc.placeEntity(new Dirt(11,8), 11,8);
		gameCasc.placeEntity(new Boulder(11,10), 11,10);
		gameCasc.placeEntity(new Boulder(11,9), 11,9);
		gameCasc.placeEntity(new Dirt(10,10), 10,10);
		gameCasc.placeEntity(new Dirt(12,10), 12,10);
		gameCasc.placeEntity(new Dirt(10,11), 10,11);
		gameCasc.placeEntity(new Dirt(12,11), 12,11);
		gameCasc.placeEntity(new Dirt(10,12), 10,12);
		gameCasc.placeEntity(new Dirt(12,12), 12,12);
		gameCasc.placeEntity(new Dirt(11,12), 11,12);
		assertEquals(expected, gameCasc.getEntity(11, 11));
		controlGameCasc.startCascade(cascadeHole,Direction.LEFT);
		assertTrue(gameCasc.getEntity(11, 10) instanceof Boulder);
		assertTrue(gameCasc.getEntity(11, 11) instanceof Boulder);
	}

}
