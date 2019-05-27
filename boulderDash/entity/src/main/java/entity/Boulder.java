package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Boulder extends  Mobile {
	
	public Boulder(Point position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	private BufferedImage sprite ;//@TODO = Boulder.png , put the picture here and don't forget the FINAL.
	private final boolean solid = true;
	private final boolean heavy = true;
	private final boolean explodable = true;
	private final boolean rolling = true;
	private final boolean falling = true;

	

}
