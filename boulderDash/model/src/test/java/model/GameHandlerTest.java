package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.*;
import model.GameHandler;
import model.Direction;
import model.CounterType;

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
	Entity[][] testMaxtrix = new Entity[40][20];
	Entity[][] testMaxtrix2 = new Entity[40][20];
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
	public void testGameHandler() {
		fail("Not yet implemented");
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
	public void testMoveEntityIntIntIntIntDirection() {
		final Entity expected = testPlayer;
		game.placeEntity(testPlayer, 1, 1);
		game.placeEntity(new Dirt(1,0), 1, 0);
		game.placeEntity(new Dirt(2,0), 2, 0);
		game.placeEntity(new Dirt(0,0), 0, 0);
		game.placeEntity(new Dirt(2,1), 2, 1);
		game.placeEntity(new Dirt(0,1), 0, 1);
		game.placeEntity(new Dirt(1,2), 1, 2);
		game.moveEntity(1, 1, 1, 2, Direction.DOWN);
		assertEquals(expected, game.getEntity(1,2));
	}

	@Test
	public void testMoveEntityEntityIntIntDirection() {
		final Entity expected = testPlayer;
		game.placeEntity(testPlayer, 1, 1);
		game.placeEntity(new Dirt(1,0), 1, 0);
		game.placeEntity(new Dirt(2,0), 2, 0);
		game.placeEntity(new Dirt(0,0), 0, 0);
		game.placeEntity(new Dirt(2,1), 2, 1);
		game.placeEntity(new Dirt(0,1), 0, 1);
		game.placeEntity(new Dirt(1,2), 1, 2);
		game.moveEntity(testPlayer, 1, 2, Direction.DOWN);
		assertEquals(expected, game.getEntity(1,2));
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
		assertEquals(expected, gameGet.getCounter(CounterType.SCORE));	}

	@Test
	public void testHandleInteractionIntIntIntInt() {
		
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
		assertEquals(expectedreturn, gameInter.handleInteraction(1,1,2,1));
		assertEquals(expected2, gameInter.getCounter(CounterType.DIAMOND));
		assertTrue(gameInter.getEntity(2, 1) instanceof Hole);
		assertEquals(expectedreturn, gameInter.handleInteraction(1,1,3,1));
		
		// Test Player to Wall
		final boolean expextedreturn2 = false;
		
		gameInter.placeEntity(new Wall(4,1), 4,1);
		assertEquals(expextedreturn2, gameInter.handleInteraction(1,1,4,1));
		
		//Test Boulder to Wall
		final boolean expextedreturn3 = false;
		
		gameInter.placeEntity(new Boulder(5,1), 5,1);
		gameInter.placeEntity(new Wall(5,2), 5,2);
		assertEquals(expextedreturn3, gameInter.handleInteraction(5,1,5,2));

		//Test Boulder to Hole
		final boolean expextedreturn4 = true;
		
		gameInter.placeEntity(new Boulder(6,1), 6,1);
		gameInter.placeEntity(new Hole(6,2), 6,2);
		assertEquals(expextedreturn4, gameInter.handleInteraction(6,1,6,2));
		
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
		assertEquals(expectedreturn, gameInter.handleInteraction(gameInter.getEntity(1, 1),2,1));
		assertEquals(expected2, gameInter.getCounter(CounterType.DIAMOND));
		assertTrue(gameInter.getEntity(2, 1) instanceof Hole);
		assertEquals(expectedreturn, gameInter.handleInteraction(gameInter.getEntity(1, 1),3,1));
		
		// Test Player to Wall
		final boolean expextedreturn2 = false;
		
		gameInter.placeEntity(new Wall(4,1), 4,1);
		assertEquals(expextedreturn2, gameInter.handleInteraction(gameInter.getEntity(1, 1),4,1));
		
		//Test Boulder to Wall
		final boolean expextedreturn3 = false;
		
		gameInter.placeEntity(new Boulder(5,1), 5,1);
		gameInter.placeEntity(new Wall(5,2), 5,2);
		assertEquals(expextedreturn3, gameInter.handleInteraction(gameInter.getEntity(5, 1),5,2));

		//Test Boulder to Hole
		final boolean expextedreturn4 = true;
		
		gameInter.placeEntity(new Boulder(6,1), 6,1);
		gameInter.placeEntity(new Hole(6,2), 6,2);
		assertEquals(expextedreturn4, gameInter.handleInteraction(gameInter.getEntity(6, 1),6,2));	}

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
		gameCasc.startCascade(11,11,Direction.UP);
		System.out.println(gameCasc.getEntity(11, 12));
		assertTrue(gameCasc.getEntity(11, 12) instanceof Boulder);	}
	
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
		gameCasc.startCascade(11,11,Direction.UP);
		System.out.println(gameCasc.getEntity(11, 12));
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
		gameCasc.startCascade(1,1,Direction.LEFT);
		System.out.println(gameCasc.getEntity(1, 0));
		System.out.println(gameCasc.getEntity(1, 1));
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
		System.out.println(cascadeHole.getPosition());
		gameCasc.startCascade(cascadeHole,Direction.LEFT);
		System.out.println(gameCasc.getEntity(11, 9));
		System.out.println(gameCasc.getEntity(11, 10));
		System.out.println(gameCasc.getEntity(11, 11));
		assertTrue(gameCasc.getEntity(11, 10) instanceof Boulder);
		assertTrue(gameCasc.getEntity(11, 11) instanceof Boulder);
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
