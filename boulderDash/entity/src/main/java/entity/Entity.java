package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * @author Théo
 *
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
	
	public Entity(Point position){
		
		setPosition(position);
	
		
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(Point newPosition){
		this.position = newPosition;
	}
	
	public void setPosition(Integer posX,Integer posY){
		this.position.x = posX;
		this.position.y = posY;
	}

	
}
