package entity;

import java.awt.Point;

public class Enemy extends Mobile {
	
	public Enemy(Point position) {
		super(position);
		setAttribute(Attribute.martyrdom,false);
		// TODO Auto-generated constructor stub
	}
}
