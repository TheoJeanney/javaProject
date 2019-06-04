package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.GameHandler;
import view.View;

import contract.CounterType;
import contract.Direction;
import entity.Boulder;
import entity.Diamond;
import entity.Dirt;
import entity.Entity;
import entity.Exit;
import entity.Hole;
import entity.Player;
import entity.Wall;

public class ControllerGameTest {
	
	GameHandler gameInter = new GameHandler();
	GameHandler gameCasc = new GameHandler();
	
	ControllerGame controlGameInter = new ControllerGame(new View(), gameInter);
	ControllerGame controlGameCasc = new ControllerGame(new View(), gameCasc);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testControllerGame() {
		fail("Not yet implemented");
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
	public void testMoveEntityEntityIntIntDirection() {
		fail("Not yet implemented");
	}

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
		assertEquals(expectedreturn, controlGameInter.handleInteraction(1,1,2,1));
		assertEquals(expected2, gameInter.getCounter(CounterType.DIAMOND));
		assertTrue(gameInter.getEntity(2, 1) instanceof Hole);
		assertEquals(expectedreturn, controlGameInter.handleInteraction(1,1,3,1));
		
		// Test Player to Wall
		final boolean expextedreturn2 = false;
		
		gameInter.placeEntity(new Wall(4,1), 4,1);
		assertEquals(expextedreturn2, controlGameInter.handleInteraction(1,1,4,1));
		
		//Test Boulder to Wall
		final boolean expextedreturn3 = false;
		
		gameInter.placeEntity(new Boulder(5,1), 5,1);
		gameInter.placeEntity(new Wall(5,2), 5,2);
		assertEquals(expextedreturn3, controlGameInter.handleInteraction(5,1,5,2));

		//Test Boulder to Hole
		final boolean expextedreturn4 = true;
		
		gameInter.placeEntity(new Boulder(6,1), 6,1);
		gameInter.placeEntity(new Hole(6,2), 6,2);
		assertEquals(expextedreturn4, controlGameInter.handleInteraction(6,1,6,2));
		
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
