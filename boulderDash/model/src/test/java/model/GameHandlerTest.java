package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.*;
import model.GameHandler;
import contract.Direction;
import contract.GameLevels;
import contract.CounterType;


public class GameHandlerTest {
	GameHandler game = new GameHandler();
	GameHandler gameSet = new GameHandler();
	GameHandler gameGet = new GameHandler();
	GameHandler gameInter = new GameHandler();
	GameHandler gameCasc = new GameHandler();
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		gameGet.setCounter(CounterType.DIAMOND, 1);
		gameGet.setCounter(CounterType.TIME, 1);
		gameGet.setCounter(CounterType.SCORE, 1);
		gameGet.setLevel(testMaxtrix);
		game.setLevel(testMaxtrix2);
		gameInter.setLevel(interMaxtrix);
		gameCasc.setLevel(cascMaxtrix);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGameLoop() {
		GameHandler testGame = new GameHandler(GameLevels.LevelOne);
		System.out.println(testGame.getEntity(29,0));
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
				/*if (testGame.getEntity(i,j) instanceof Player) 
				{
					System.out.print("@ "); 
				}
				else
				{
					System.out.print(testGame.getEntity(i,j).getClass().getSimpleName().charAt(0) + " "); 
				}*/
			}
		}
		//testGame.moveEntity(testGame.getPlayer(),(int) testGame.getPlayer().getPosition().getX(),(int) testGame.getPlayer().getPosition().getY() - 1, Direction.UP);
		System.out.println("");
		System.out.println("--------------------------------------------------------");
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
	}

	@Test
	public void testGameHandler() {
		GameHandler testGame = new GameHandler(GameLevels.LevelOne);
		//System.out.println(testGame.getEntity(0, 1));
	}	
	
	@Test
	public void testGetPlayer() {
		final Entity expected = testPlayer;
		gameGet.setPlayer(testPlayer);
		assertEquals(expected, gameGet.getPlayer());
	}
	
	@Test
	public void testSetPlayerEntity() {
		final Entity expected = testPlayer;
		gameSet.setPlayer(testPlayer);
		assertEquals(expected, gameSet.getPlayer());
	}
	
	@Test
	public void testPlayerIsAlive() {
		final boolean expected = true;
		final boolean expected2 = false;
		game.setPlayer(testPlayer);
		game.placeEntity(testPlayer, 11, 11);
		assertEquals(expected, game.playerIsAlive());
		game.deleteEntity(11, 11);
		assertEquals(expected2, game.playerIsAlive());
	}
	
	@Test
	public void testGetExit() {
		final Entity expected = testExit;
		gameGet.setExit(testExit);
		assertEquals(expected, gameGet.getExit());
	}
	
	@Test
	public void testSetExitEntity() {
		final Entity expected = testExit;
		gameGet.setExit(testExit);
		assertEquals(expected, gameGet.getExit());
	}

	@Test
	public void testPlaceEntity() {
		final Entity expected = testWall;
		game.placeEntity(testWall, 22, 1);
		assertEquals(expected, game.getEntity(22, 1));
	}

	@Test
	public void testDeleteEntityIntInt() {
		final Entity expected = testBoulder;
		final String expected2 = testHole.getClass().getSimpleName();
		game.placeEntity(testBoulder, 2, 1);
		assertEquals(expected, game.getEntity(2, 1));
		game.deleteEntity(2, 1);
		final Entity fetchedEntity = game.getEntity(2, 1);
		final String FEClass = fetchedEntity.getClass().getSimpleName();
		assertEquals(expected2, FEClass);
	}

	@Test
	public void testDeleteEntityEntity() {
		final Entity expected = testBoulder;
		final String expected2 = testHole.getClass().getSimpleName();
		game.placeEntity(testBoulder, 2, 1);
		assertEquals(expected, game.getEntity(2, 1));
		game.deleteEntity(game.getEntity(2, 1));
		final Entity fetchedEntity = game.getEntity(2, 1);
		final String FEClass = fetchedEntity.getClass().getSimpleName();
		assertEquals(expected2, FEClass);	
	}

	
	@Test
	public void testGetEntity() {
		final Entity expected = testDirt;
		game.placeEntity(testDirt, 0, 1);
		assertEquals(expected, game.getEntity(0, 1));
	}

	@Test
	public void testSetLevel() {
		final Entity expected = testDirt;
		gameSet.setLevel(new Entity[40][20]);
		gameSet.placeEntity(testDirt, 0, 1);
		assertEquals(expected, gameSet.getEntity(0, 1));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetLevel() {
		final Entity[][] expected = testMaxtrix;
		assertEquals(expected, gameGet.getLevel());
	}

	@Test
	public void testSetCounter() {
		final int expected = 2;
		gameSet.setCounter(CounterType.DIAMOND, 2);
		gameSet.setCounter(CounterType.TIME, 2);
		gameSet.setCounter(CounterType.SCORE, 2);
		assertEquals(expected, gameSet.getCounter(CounterType.DIAMOND));
		assertEquals(expected, gameSet.getCounter(CounterType.TIME));
		assertEquals(expected, gameSet.getCounter(CounterType.SCORE));
	}

	@Test
	public void testGetCounter() {
		final int expected = 1;
		assertEquals(expected, gameGet.getCounter(CounterType.DIAMOND));
		assertEquals(expected, gameGet.getCounter(CounterType.TIME));
		assertEquals(expected, gameGet.getCounter(CounterType.SCORE));
	}

	@Test
	public void testGetEntityX() {
		final int expected = 0;
		assertEquals(expected, game.getEntityX(testBoulder));
	}

	@Test
	public void testGetEntityY() {
		final int expected = 0;
		assertEquals(expected, game.getEntityY(testBoulder));	}

}
