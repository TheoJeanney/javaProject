package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Dirt extends Static {
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	private BufferedImage sprite ; //=Dirt.png, put the picture here and put the FINAL.
	private final boolean breakable = true;
	private final boolean explodable = true;
=======
=======
>>>>>>> theo
=======
	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
>>>>>>> 5b94aef... javaDocs entity
	public Dirt(Point position) {
		super(position);
		setAttribute(Attribute.breakable, true);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid, true);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO=Dirt.png, put the picture here and put the FINAL.Do we need to put it into constructor???
<<<<<<< HEAD
>>>>>>> ec97a75... Entity :D
=======
>>>>>>> theo

}
