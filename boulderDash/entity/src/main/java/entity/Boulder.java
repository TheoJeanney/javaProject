package entity;

import java.awt.image.BufferedImage;

public class Boulder extends  Mobile {
	
<<<<<<< HEAD
	private BufferedImage sprite ;//= Boulder.png , put the picture here and don't forget the FINAL.
	private final boolean solid = true;
	private final boolean heavy = true;
	private final boolean explodable = true;
	private final boolean rolling = true;
	private final boolean falling = true;

	
=======
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
>>>>>>> ec97a75... Entity :D

}
