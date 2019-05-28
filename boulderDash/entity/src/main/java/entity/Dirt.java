package entity;

/**
* @author Théo
*
*/

import java.awt.Point;

public class Dirt extends Static {
	
	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Dirt(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.breakable, true);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid, true);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Dirt(Point position) {
		super(position);
		setAttribute(Attribute.breakable, true);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid, true);
		// TODO Auto-generated constructor stub
	}

}
