package entity;

/**
* @author Théo
*
*/

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Wall extends Static {
	
	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Wall(int posX, int posY)
	{
		super(posX, posY);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid,true);
		setAttribute(Attribute.rolling, true);
	}
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Wall(Point position)
	{
		super(position);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid,true);
		setAttribute(Attribute.rolling, true);
	}
}
