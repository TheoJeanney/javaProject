package boulderDashGame.entity;

import java.awt.Point;
/**
 * <h1>Hole Class</h1>
 * The dirt when the player walk on.
 * <p>
 * We will use this class to change the view of our map.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/


public class Hole extends Static {
	
	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Hole(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.crushable,true);

		// TODO Auto-generated constructor stub
	}
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Hole(Point position) {
		super(position);
		setAttribute(Attribute.crushable,true);

		// TODO Auto-generated constructor stub
	}
}
