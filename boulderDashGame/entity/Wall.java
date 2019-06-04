package boulderDashGame.entity;

import java.awt.Point;

/**
 * <h1>Wall Class</h1>
 * The wall and it's function.
 * <p>
 * This object is used to do the outline of our map.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/



public class Wall extends Static {
	
	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Wall(int posX, int posY)
	{
		super(posX, posY);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid,true);
		setAttribute(Attribute.rolling, true);
	}
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Wall(Point position)
	{
		super(position);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid,true);
		setAttribute(Attribute.rolling, true);
	}
}
