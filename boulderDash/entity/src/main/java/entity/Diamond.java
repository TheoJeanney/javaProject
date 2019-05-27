package entity;

import java.awt.image.BufferedImage;

public class Diamond extends Mobile {

<<<<<<< HEAD
	private BufferedImage sprite ; //= Diamong.png , put the picture here and don't forget the FINAL.
	private final boolean heavy = true;
	private final boolean breakable = true;
	private final boolean collectable = true;
	private final boolean rolling = true;
	private final boolean falling = true;
=======
	public Diamond(Point position) {
		super(position);
		setAttribute(Attribute.heavy,true);
		setAttribute(Attribute.breakable,true);
		setAttribute(Attribute.collectable,true);
		setAttribute(Attribute.rolling,true);
		setAttribute(Attribute.falling,true);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO= Diamong.png , put the picture here and don't forget the FINAL.Do we need to put it into constructor???
>>>>>>> ec97a75... Entity :D
	
}
