package entity;

/**
* @author Théo
*
*/
import java.awt.Point;

public class BoomMole extends Mole {
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
	public BoomMole(Point position) {
		super(position);
		setAttribute(Attribute.martyrdom,true);
		// TODO Auto-generated constructor stub
	}
}
