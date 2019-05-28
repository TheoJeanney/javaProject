package entity;

import java.awt.Point;


/**
 * <h1>Mobile Class</h1>
 * Regroup our Mobile.
 * <p>
 * This is the base of the structure of a mobile object.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/



public class Mobile extends Entity {
	
	public Mobile(Point position) {
		super(position);
		setAttribute(Attribute.rolling,false);
		setAttribute(Attribute.falling,false);
		// TODO Auto-generated constructor stub
	}

}
