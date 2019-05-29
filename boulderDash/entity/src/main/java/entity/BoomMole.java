package entity;

import java.awt.Point;

/**
 * <h1>BoomMole Class </h1>
 * Enemies and its function.
 * <p>
 * We will use this class to check what the boomMole is able to do.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/



public class BoomMole extends Mole {
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public BoomMole(Point position) {
		super(position);
		setAttribute(Attribute.martyrdom,true);
		// TODO Auto-generated constructor stub
	}
}
