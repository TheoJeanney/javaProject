package entity;

/**
* @author Théo
*
*/

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Mole extends Enemy {
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Mole(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.lethal,true);
		setAttribute(Attribute.breakable,true);
		setAttribute(Attribute.crushable,true);
		setAttribute(Attribute.explodable,true);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO=BoomMole.png , put the picture here, and don't forget the FINAL.Do we need to put it into constructor???

	
}
