package entity;

/**
* @author Théo
*
*/

import java.awt.Point;

public class Mobile extends Entity {
	
	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position             
     */
	public Mobile(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.rolling,false);
		setAttribute(Attribute.falling,false);
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
		setAttribute(Attribute.rolling,false);
		setAttribute(Attribute.falling,false);
		// TODO Auto-generated constructor stub
	}
}
