package entity;

import java.awt.Point;

public class Mobile extends Entity {
	
	public Mobile(Point position) {
		super(position);
		setAttribute(Attribute.rolling,false);
		setAttribute(Attribute.falling,false);
		// TODO Auto-generated constructor stub
	}

}
