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
	public Exit(Point position) {
		super(position);
		setAttribute(Attribute.collectable, true);
		setAttribute(Attribute.breakable, true);
		// @TODO Auto-generated constructor stub
	}

}
