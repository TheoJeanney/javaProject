package entity;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoulderTest {
	
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
		this.entity = new Boulder(testPoint);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
     * Test is the object is explodable.
     *          
     */
	
	@Test
	public void testExplosable(){
		
		final boolean expected = true;
		
		System.out.println("Explodable : " + entity.getAttribute(Attribute.explodable));
		assertEquals(expected,entity.getAttribute(Attribute.explodable));
		
		
	}
	/**
     * Test is the object is crushable.
     *          
     */
	
	@Test
	public void testCrushable(){
		
		final boolean expected = false;
		
		System.out.println("Crushable : " + entity.getAttribute(Attribute.crushable));
		assertEquals(expected,entity.getAttribute(Attribute.crushable));
		
		
	}
	
	/**
     * Test is the object is breakable.
     *          
     */
	@Test
	public void testBreakable(){
		
		final boolean expected = false;
		
		System.out.println("Breakable : " + entity.getAttribute(Attribute.breakable));
		assertEquals(expected,entity.getAttribute(Attribute.breakable));
		
		
	}
	
	/**
     * Test is the object is solid.
     *          
     */
	
	@Test
	public void testSolid(){
		
		final boolean expected = true;
		
		System.out.println("Solid : " + entity.getAttribute(Attribute.solid));
		assertEquals(expected,entity.getAttribute(Attribute.solid));	
	}
	
	/**
     * Test is the object is lethal.
     *          
     */
	
	@Test
	public void testLethal(){
		
		final boolean expected = false;
		
		System.out.println("Lethal : " + entity.getAttribute(Attribute.lethal));
		assertEquals(expected,entity.getAttribute(Attribute.lethal));	
	}
	
	/**
     * Test is the object is heavy.
     *          
     */
	
	@Test
	public void testHeavy(){
		
		final boolean expected = true;
		
		System.out.println("Heavy : " + entity.getAttribute(Attribute.heavy));
		assertEquals(expected,entity.getAttribute(Attribute.heavy));	
	}
	
	/**
     * Test is the object is collectable.
     *          
     */
	
	@Test
	public void testCollectable(){
		
		final boolean expected = false;
		
		System.out.println("Collectable : " + entity.getAttribute(Attribute.collectable));
		assertEquals(expected,entity.getAttribute(Attribute.collectable));	
	}
	
	/**
     * Test is the object is rolling.
     *          
     */
	
	@Test
	public void testRolling(){
		final boolean expected = true;
		
		System.out.println("Rolling : " + entity.getAttribute(Attribute.rolling));
		assertEquals(expected,entity.getAttribute(Attribute.rolling));	
	}
	
	/**
     * Test is the object is falling.
     *          
     */
	
	@Test
	public void testFalling(){
		
		final boolean expected = true;
		
		System.out.println("Falling : " + entity.getAttribute(Attribute.falling));
		assertEquals(expected,entity.getAttribute(Attribute.falling));	
	}

}
