package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * <h1>Enemy Class</h1>
 * One of our enemy.
 * <p>
 * This enemy wont be able to explode.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/



public class Mole extends Enemy {
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Mole(Point position) {
		super(position);
		setAttribute(Attribute.lethal,true);
		setAttribute(Attribute.breakable,true);
		setAttribute(Attribute.crushable,true);
		setAttribute(Attribute.explodable,true);
	}
	private BufferedImage sprite ; //@TODO=BoomMole.png , put the picture here, and don't forget the FINAL.Do we need to put it into constructor???

	
}
