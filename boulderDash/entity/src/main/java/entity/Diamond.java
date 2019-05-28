package entity;

/**
* @author Théo
*
*/

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Diamond extends Mobile {

	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Diamond(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.heavy,true);
		setAttribute(Attribute.breakable,true);
		setAttribute(Attribute.collectable,true);
		setAttribute(Attribute.rolling,true);
		setAttribute(Attribute.falling,true);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Diamond(Point position) {
		super(position);
		setAttribute(Attribute.heavy,true);
		setAttribute(Attribute.breakable,true);
		setAttribute(Attribute.collectable,true);
		setAttribute(Attribute.rolling,true);
		setAttribute(Attribute.falling,true);
		// TODO Auto-generated constructor stub
	}
	
}
