package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;


/**
 * <h1>Dirt Class</h1>
 * Dirt and its function.
 * <p>
 * We will use this class to build our map.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/

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
