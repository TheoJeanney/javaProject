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

	public Player(Point position) {
		super(position);
		setAttribute(Attribute.crushable,true);
		setAttribute(Attribute.explodable,true);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO= Rockford.png , put there the picture and don't forget the FINAL.Do we need to put it into constructor???

	
	
}
