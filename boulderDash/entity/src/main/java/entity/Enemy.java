package entity;

import java.awt.Point;

/**
 * <h1>Enemy Class</h1>
 * Regroup our enemies.
 * <p>
 * This is the base of the structure of an enemy.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/


public class Enemy extends Mobile {
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Enemy(Point position) {
		super(position);
		setAttribute(Attribute.martyrdom,false);
	}
}
