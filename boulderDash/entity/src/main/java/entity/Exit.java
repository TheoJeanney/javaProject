package entity;

import java.awt.Point;


/**
 * <h1>Exit Class</h1>
 * The door to exit the game.
 * <p>
 * This class is the object that is used to quit the game.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/


public class Exit extends Static {

	public Exit(Point position) {
		super(position);
		setAttribute(Attribute.collectable, true);
		
		// @TODO Auto-generated constructor stub
	}

}
