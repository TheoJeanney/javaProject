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
	private BufferedImage sprite ; //@TODO=Dirt.png, put the picture here and put the FINAL.Do we need to put it into constructor???

}
