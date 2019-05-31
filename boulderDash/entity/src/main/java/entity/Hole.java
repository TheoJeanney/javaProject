package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * <h1>Hole Class</h1>
 * The dirt when the player walk on.
 * <p>
 * We will use this class to change the view of our map.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/


public class Hole extends Static {

	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Hole(Point position) {
		super(position);
	}
	
	private BufferedImage sprite ; //@TODO=Dirt.png, put the picture here and put the FINAL.Do we need to put it into constructor???

}
