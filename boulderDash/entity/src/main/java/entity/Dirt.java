package entity;

import java.awt.image.BufferedImage;

public class Dirt extends Static {
	
<<<<<<< HEAD
	private BufferedImage sprite ; //=Dirt.png, put the picture here and put the FINAL.
	private final boolean breakable = true;
	private final boolean explodable = true;
=======
	public Dirt(Point position) {
		super(position);
		setAttribute(Attribute.breakable, true);
		setAttribute(Attribute.explodable, true);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO=Dirt.png, put the picture here and put the FINAL.Do we need to put it into constructor???
>>>>>>> ec97a75... Entity :D

}
