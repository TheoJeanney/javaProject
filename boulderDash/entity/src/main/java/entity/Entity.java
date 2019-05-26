package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {

	private BufferedImage sprite;
	private Point position;
	private boolean solid = false;
	private boolean lethal = false;
	private boolean heavy = false;
	private boolean breakable = false;
	private boolean crushable = false;
	private boolean explodable = false;
	private boolean collectable = false;
	
	public Point getPosition() {
		return null;
	}
	
	public void setPosition(Point position){
		
	}
	
	public void setPosition(Integer posX,Integer posY){
		
	}

	
}
