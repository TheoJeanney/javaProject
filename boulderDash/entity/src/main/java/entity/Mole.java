package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Mole extends Enemy {
<<<<<<< HEAD
	
<<<<<<< HEAD
<<<<<<< HEAD
	private BufferedImage sprite ; //=BoomMole.png , put the picture here, and don't forget the FINAL.
	private final boolean lethal = true;
	private final boolean breakable = true;
	private final boolean crushable = true;
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
	public Mole(Point position) {
		super(position);
		setAttribute(Attribute.lethal,true);
		setAttribute(Attribute.breakable,true);
		setAttribute(Attribute.crushable,true);
		setAttribute(Attribute.explodable,true);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO=BoomMole.png , put the picture here, and don't forget the FINAL.Do we need to put it into constructor???
<<<<<<< HEAD
>>>>>>> ec97a75... Entity :D
=======
>>>>>>> theo

	
}
