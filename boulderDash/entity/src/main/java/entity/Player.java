package entity;

/**
* @author Théo
*
*/

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Player extends Mobile {

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
	private BufferedImage sprite ; //@TODO= Rockford.png , put there the picture and don't forget the FINAL.Do we need to put it into constructor???

	
	
}
