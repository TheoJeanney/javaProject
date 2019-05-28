package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Wall extends Static {
	
	private BufferedImage sprite ; //@TODO=Wall.png , put the picture here and put FINAL. Do we need to put it into constructor???
	
	public Wall(Point position)
	{
		super(position);
		setAttribute(Attribute.explodable, true);
		setAttribute(Attribute.solid,true);
	}

}
