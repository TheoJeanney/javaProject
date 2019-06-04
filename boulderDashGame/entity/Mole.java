package boulderDashGame.entity;

import java.awt.Point;

/**
 * <h1>Enemy Class</h1>
 * One of our enemy.
 * <p>
 * This enemy wont be able to explode.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/



public class Mole extends Enemy {
	
	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Mole(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.lethal,true);
		setAttribute(Attribute.breakable,true);
		setAttribute(Attribute.crushable,true);
		setAttribute(Attribute.explodable,true);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Mole(Point position) {
		super(position);
		setAttribute(Attribute.lethal,true);
		setAttribute(Attribute.breakable,true);
		setAttribute(Attribute.crushable,true);
		setAttribute(Attribute.explodable,true);
		// TODO Auto-generated constructor stub
	}
	
}
