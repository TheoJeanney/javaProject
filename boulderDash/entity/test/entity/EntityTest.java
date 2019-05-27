package entity;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Théo
 *
 */

public class EntityTest {
	
	private Entity entity;
	private Point testPoint = new Point(1,1);

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

	@SuppressWarnings("deprecation")
	@Test
	public void testGetPosition() {
		final double expectedX = 1.0;
		final double expectedY = 1.0;
		
		final Entity entity = new Wall(testPoint);
		System.out.println("x : ");
		System.out.println("x : " + entity.getPosition().getX());
		assertEquals(expectedX,entity.getPosition().getX(),0);
		
	}

	@Test
	public void testSetPositionPoint() {
		final Point position= new Point(1,1);
		
		
		
	}

	@Test
	public void testSetPositionIntegerInteger() {
		//fail("Not yet implemented");
	}

}
