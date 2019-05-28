package entity;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * <h1>Entity Class</h1>
 * The class for entity and the methods.
 * <p>
 * This class is using to initialize our attributes. Then there are methods to get the private attributes of this class.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/




/**
 * @author Théo
 *
 */
public abstract class Entity {

	private BufferedImage sprite;
	private Point position;
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
	
}
