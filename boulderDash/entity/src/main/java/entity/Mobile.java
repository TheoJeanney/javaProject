package entity;

import java.awt.Point;

/**
 * <h1>Mobile Class</h1>
 * Regroup our Mobile.
 * <p>
 * This is the base of the structure of a mobile object.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/


public class Mobile extends Entity {
	
	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position             
     */
	public Mobile(int posX, int posY) {
		super(posX, posY);

		// TODO Auto-generated constructor stub
	}
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Mobile(Point position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
}
