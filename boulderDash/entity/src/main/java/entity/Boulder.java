package entity;


/**
* @author Théo
*
*/

import java.awt.Point;

public class Boulder extends  Mobile {
	
	/**
     * Constructor with all informations
     *
     * @param posX entity X position
     * @param posY entity Y position
     *          
     */
	public Boulder(int posX, int posY) {
		super(posX, posY);
		setAttribute(Attribute.solid,true);
		setAttribute(Attribute.heavy,true);
		setAttribute(Attribute.explodable,true);
		setAttribute(Attribute.rolling,true);
		setAttribute(Attribute.falling,true);
		
		// TODO Auto-generated constructor stub
	}
	
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

}
