package boulderDashGame.entity;

import java.awt.Point;

/**
 * <h1>Static Class</h1>
 * Regroup the static object.
 * <p>
 * The base of our object that does not move.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/



public class Static extends Entity {

	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Static(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Static(Point position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

}
