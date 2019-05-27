package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Diamond extends Mobile {

	public Diamond(Point position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO= Diamong.png , put the picture here and don't forget the FINAL.
	private final boolean heavy = true;
	private final boolean breakable = true;
	private final boolean collectable = true;
	private final boolean rolling = true;
	private final boolean falling = true;
	
}
