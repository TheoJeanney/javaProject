package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * <h1>Diamond Class </h1>
 * Diamond and its function.
 * <p>
 * We will use this function to permit the player to collect this type.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/


public class Diamond extends Mobile {

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
	private BufferedImage sprite ; //@TODO= Diamong.png , put the picture here and don't forget the FINAL.Do we need to put it into constructor???
	
}
