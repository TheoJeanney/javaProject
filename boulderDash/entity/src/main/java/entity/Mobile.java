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
     * @param position , position of the object.
     *          
     */
	public Mobile(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.rolling,false);
		setAttribute(Attribute.falling,false);
		// TODO Auto-generated constructor stub
	}
}
