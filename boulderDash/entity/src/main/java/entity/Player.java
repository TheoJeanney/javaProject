package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Player extends Mobile {

	public Player(Point position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO= Rockford.png , put there the picture and don't forget the FINAL.
	private final boolean crushable = true;
	private final boolean explosable = true;
	
	
}
