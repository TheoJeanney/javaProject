package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;


/**
 * <h1>Boulder Class </h1>
 * Boulder and its function.
 * <p>
 * we will use this class to check what can do the boulder.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/

public class Boulder extends  Mobile {
	
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public Boulder(Point position) {
		super(position);
		setAttribute(Attribute.solid,true);
		setAttribute(Attribute.heavy,true);
		setAttribute(Attribute.explodable,true);
		setAttribute(Attribute.rolling,true);
		setAttribute(Attribute.falling,true);
		
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ;//@TODO = Boulder.png , put the picture here and don't forget the FINAL.Do we need to put it into constructor???

}
