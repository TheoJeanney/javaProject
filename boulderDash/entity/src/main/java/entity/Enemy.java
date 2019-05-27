package entity;

<<<<<<< HEAD:boulderDash/entity/src/main/java/entity/Ennemy.java
public class Ennemy extends Mobile {
	
	private boolean martyrdom = false;

=======
import java.awt.Point;

public class Enemy extends Mobile {
	
	public Enemy(Point position) {
		super(position);
		setAttribute(Attribute.martyrdom,false);
		// TODO Auto-generated constructor stub
	}
>>>>>>> ec97a75... Entity :D:boulderDash/entity/src/main/java/entity/Enemy.java
}
