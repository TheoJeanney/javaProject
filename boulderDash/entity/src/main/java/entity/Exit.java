package entity;

/**
* @author Théo
*
*/

import java.awt.Point;

public class Exit extends Static {

	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Exit(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.collectable, true);
		setAttribute(Attribute.breakable, true);
		setAttribute(Attribute.solid, true);
		// @TODO Auto-generated constructor stub
	}

}
