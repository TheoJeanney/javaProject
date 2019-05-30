package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;


/**
 * <h1>Player Class</h1>
 * The class of the player.
 * <p>
 * This is what the player can do.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/

public class Player extends Mobile {

	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Player(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.crushable,true);
		setAttribute(Attribute.explodable,true);
		// TODO Auto-generated constructor stub
	}

	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Player(Point position) {
		super(position);
		setAttribute(Attribute.crushable,true);
		setAttribute(Attribute.explodable,true);
		// TODO Auto-generated constructor stub
	}
	
}
