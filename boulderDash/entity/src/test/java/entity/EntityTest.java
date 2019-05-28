package entity;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityTest {
	
	private Entity entity;
	private Point testPoint = new Point (1,1);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.entity.setPosition(testPoint);
		this.entity.attributeSet.put(Attribute.breakable, true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPosition() {
		final double expectedX = 1.0;
		final double expectedY = 1.0;
		
		System.out.println("x : " + entity.getPosition().getX());
		System.out.println("y : " + entity.getPosition().getY());
		
		assertEquals(expectedX,entity.getPosition().getX(),0);
		assertEquals(expectedY, entity.getPosition().getY(),0);
		
	}

	@SuppressWarnings("null")
	@Test
	public void testGetAttribute() {
		final boolean expected = true;
		final Entity entity = null;
		
		System.out.println("test : "+ entity.getAttribute(Attribute.breakable));
		assertEquals(expected, entity.getAttribute(Attribute.breakable));
		
	}


}
