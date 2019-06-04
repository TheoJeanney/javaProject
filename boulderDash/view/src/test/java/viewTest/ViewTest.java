package viewTest;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import view.View;

/**
 * 
 * @author joana
 *
 */

public class ViewTest {
	
	View tester = new View();

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
    public void testKeyCodeToControllerOrderLeft() {
        final ControllerOrder expected = ControllerOrder.LEFT;
        assertEquals(expected,View.keyCodeToControllerOrder(KeyEvent.VK_LEFT));
    }

    @Test
    public void testKeyCodeToControllerOrderRight() {
        final ControllerOrder expected = ControllerOrder.RIGHT;
        assertEquals(expected,View.keyCodeToControllerOrder(KeyEvent.VK_RIGHT));
    }
    
    @Test
    public void testKeyCodeToControllerOrderUp() {
        final ControllerOrder expected = ControllerOrder.UP;
        assertEquals(expected,View.keyCodeToControllerOrder(KeyEvent.VK_UP));
    }
    
    @Test
    public void testKeyCodeToControllerOrderDown() {
        final ControllerOrder expected = ControllerOrder.DOWN;
        assertEquals(expected,View.keyCodeToControllerOrder(KeyEvent.VK_DOWN));
    }
    
        @Test
    public void testPrintMessage() {
        final String expected = "Press the keyboard arrows to move on the map.";
        final String message = "Press the keyboard arrows to move on the map.";
        assertNotSame(expected,message);
        
    }
}