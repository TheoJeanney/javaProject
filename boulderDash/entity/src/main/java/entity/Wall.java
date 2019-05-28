package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;


/**
 * <h1>Wall Class</h1>
 * The wall and it's function.
 * <p>
 * This object is used to do the outline of our map.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/


public class Wall extends Static {
	
	private BufferedImage sprite ; //@TODO=Wall.png , put the picture here and put FINAL. Do we need to put it into constructor???
	
	public Wall(Point position)
	{
		super(position);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid,true);
	}

}
