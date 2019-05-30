package entity;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityTest {
	
	
	private Point testPoint = new Point (1,1);
	private Entity entity = new Dirt(testPoint);

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

	/**
     * Test is the object has a good position.
     *          
     */
	@Test
	public void testGetPosition() {
		final double expectedX = 1.0;
		final double expectedY = 1.0;
		
		System.out.println("x : " + entity.getPosition().getX());
		System.out.println("y : " + entity.getPosition().getY());
		
		assertEquals(expectedX,entity.getPosition().getX(),0);
		assertEquals(expectedY, entity.getPosition().getY(),0);
		
	}

	/**
     * Test is the attribute of an object is well implemented. 
     *          
     */
	
	@Test
	public void testGetAttribute() {
		final boolean expected = true;
		
		System.out.println("test : "+ entity.getAttribute(Attribute.breakable));
		assertEquals(expected, entity.getAttribute(Attribute.breakable));
		
	}


}