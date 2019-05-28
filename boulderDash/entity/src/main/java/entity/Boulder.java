package entity;


/**
* @author Théo
*
*/

import java.awt.Point;
import java.awt.image.BufferedImage;

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
