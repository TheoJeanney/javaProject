package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {

	private BufferedImage sprite;
	private Point position;
<<<<<<< HEAD
	private boolean solid = false;
	private boolean lethal = false;
	private boolean heavy = false;
	private boolean breakable = false;
	private boolean crushable = false;
	private boolean explodable = false;
	private boolean collectable = false;
=======
	HashMap<Attribute, Boolean> attributeSet = new HashMap<Attribute, Boolean>();

	public Entity(Point position){
		
		setPosition(position);
		setAttribute(Attribute.solid, false);
		setAttribute(Attribute.lethal, false);
		setAttribute(Attribute.heavy, false);
		setAttribute(Attribute.breakable, false);
		setAttribute(Attribute.crushable, false);
		setAttribute(Attribute.explodable, false);
		setAttribute(Attribute.collectable, false);
	}
	
>>>>>>> ec97a75... Entity :D
	
	public Point getPosition() {
		return null;
	}
	
	public void setPosition(Point position){
		
	}
	
	public void setPosition(Integer posX,Integer posY){
<<<<<<< HEAD
		
	}

=======
		this.position.x = posX;
		this.position.y = posY;
	}
	
	public void setAttribute(Attribute choice, boolean confirmExplode){
		
		this.attributeSet.put(choice, confirmExplode);
	}
	
	public boolean getAttribute(Attribute choice){
		
		return this.attributeSet.get(choice);
	}
	
	public void setInvincible(){
		this.attributeSet.put(Attribute.crushable, false);
		this.attributeSet.put(Attribute.explodable, false);
		this.attributeSet.put(Attribute.breakable,false);
	}
>>>>>>> ec97a75... Entity :D
	
}
