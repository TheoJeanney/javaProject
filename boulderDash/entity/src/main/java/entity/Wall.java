package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Wall extends Static {
	
	private BufferedImage sprite ; //@TODO=Wall.png , put the picture here and put FINAL.
	private final boolean solid = true;
	private final boolean explodable = true;
	
	public Wall(Point position)
	{
		super(position);
		
	}

}
