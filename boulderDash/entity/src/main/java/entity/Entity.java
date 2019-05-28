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



public abstract class Entity {

	private BufferedImage sprite;
	private Point position;
	HashMap<Attribute, Boolean> attributeSet = new HashMap<Attribute, Boolean>();

	/**
     * Constructor with all informations
     *
     * @param position , position of the object.
     *          
     */
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
	
	/**
     * Method that get the position
     *
     * 
     * @return position of the entity        
     *          
     */
	public Point getPosition() {
		return position;
	}
	
	/**
     * Method that set the position with a position parameter
     *
     * @param newPosition , position of the object.
     *     
     *          
     */
	public void setPosition(Point newPosition){
		this.position = newPosition;
	}
	
	/**
     * Method that set the position with an position X and a position Y.
     *
     * @param posX , coordinate X of the object.
     * @param posY , coordinate Y of the object.       
     *          
     */
	public void setPosition(Integer posX,Integer posY){
		this.position.x = posX;
		this.position.y = posY;
	}
	
	/**
     * Method that set the attribute at true or false.
     *
     * @param choice , this is the choice of the attribute.
     * @param confirmExplode , true of false.
     *          
     */
	public void setAttribute(Attribute choice, boolean confirmExplode){
		
		this.attributeSet.put(choice, confirmExplode);
	}
	
	/**
     * Method that get the attribute
     *
     * @param choice , this is the choice of the attribute.
     * 
     * @return the choice of the attribute.      
     *          
     */
	public boolean getAttribute(Attribute choice){
		
		return this.attributeSet.get(choice);
	}
	
	/**
     * Method that permit to put invincible a object.
     *
     */
	
	public void setInvincible(){
		this.attributeSet.put(Attribute.crushable, false);
		this.attributeSet.put(Attribute.explodable, false);
		this.attributeSet.put(Attribute.breakable,false);
	}
	
}
