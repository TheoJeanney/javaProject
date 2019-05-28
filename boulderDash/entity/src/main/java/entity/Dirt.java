package entity;

/**
* @author Théo
*
*/

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Dirt extends Static {
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Dirt(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.breakable, true);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid, true);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO=Dirt.png, put the picture here and put the FINAL.Do we need to put it into constructor???

}
