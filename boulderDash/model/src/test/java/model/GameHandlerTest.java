package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.*;
import model.*;

public class GameHandlerTest {
	
    GameHandler game = new GameHandler();
    Entity testBoulder = new Boulder(0,0);
    //Entity testDiamond = new Diamond(1,0);
    //Entity testDirt = new Dirt(0,1);
    //Entity testWall = new Wall(1,1);
    //Entity testPlayer = new Player(0,2);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("oh");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("eh");
	}

	@Before
	public void setUp() throws Exception {

		System.out.println("ah");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("he");
	}

	@Test
	public void testGameHandler() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlaceEntity() {
		final GameHandler test = new GameHandler();
		
		game.placeEntity(testBoulder, 1, 1);
		
		
	}

	@Test
	public void testDeleteEntityIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEntityEntity() {
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
	public void testSetLevel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLevel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCounter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCounter() {
		fail("Not yet implemented");
	}

	@Test
	public void testHandleInteractionIntIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testHandleInteractionEntityIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testHandleCascade() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartCascadeIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartCascadeEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEntityX() {
        System.out.println("why");
        final int expected = 0;
        assertEquals(expected, game.getEntityX(testBoulder));
	}

	@Test
	public void testGetEntityY() {
		final int expected = 0;
        assertEquals(expected, game.getEntityY(testBoulder));
	}

}
