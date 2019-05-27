package entity;

import java.awt.image.BufferedImage;

public class Player extends Mobile {

<<<<<<< HEAD
	private BufferedImage sprite ; //= Rockford.png , put there the picture and don't forget the FINAL.
	private final boolean crushable = true;
	private final boolean explosable = true;
=======
	public Player(Point position) {
		super(position);
		setAttribute(Attribute.crushable,true);
		setAttribute(Attribute.explodable,true);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO= Rockford.png , put there the picture and don't forget the FINAL.Do we need to put it into constructor???

>>>>>>> ec97a75... Entity :D
	
	
	
}
