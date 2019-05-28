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
     * @param position , position of the object.
     *          
     */
	public Enemy(Point position) {
		super(position);
		setAttribute(Attribute.martyrdom,false);
		// TODO Auto-generated constructor stub
	}
}
