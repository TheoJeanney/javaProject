package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Dirt extends Static {
	
	public Dirt(Point position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ; //@TODO=Dirt.png, put the picture here and put the FINAL.
	private final boolean breakable = true;
	private final boolean explodable = true;

}
