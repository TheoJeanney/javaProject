package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Mole extends Ennemy {
	
	public Mole(Point position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO=BoomMole.png , put the picture here, and don't forget the FINAL.
	private final boolean lethal = true;
	private final boolean breakable = true;
	private final boolean crushable = true;
	private final boolean explodable = true;
	
	
	

}
