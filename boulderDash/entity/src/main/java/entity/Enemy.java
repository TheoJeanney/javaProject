package entity;

/**
* @author Théo
*
*/

import java.awt.Point;


public class Enemy extends Mobile {
	
	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Enemy(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.martyrdom,false);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Enemy(Point position) {
		super(position);
		setAttribute(Attribute.martyrdom,false);
		// TODO Auto-generated constructor stub
	}
}
