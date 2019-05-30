package model;

//import java.sql.ResultSet;
import java.awt.Point;

import entity.*;

 /**
  * <h1>GameHandler Class</h1>
  * allows us to handle all objects, interactions, and simulations within our game,
  * <p>
  * all other game classes will revolve around this class, mainly entity which deals with our objects
  * were dependent on DAOHandler, DBConnection, and Entity
  * </p>
  * 
  * @author Thomas Barbod Varjavandi (alias - Deiaros)
  * @version 0.9.0
  * @since 0.9.0
  */
 public class GameHandler {
 
    private Entity[][] level;
    private Entity player;
    private Entity exit;
    private int counterDiamondLeft;
    private int counterScore;
    private int counterTime; // Time in seconds stored as an int

    //private static enum coordinateType {x,y};

    /**
    * <h1>GameHandler Constructor</h1>
    *
    */
    public GameHandler()
    {
        // @TODO define parameters
        //setLevel(new Entity[40][20]);
        // @TODO get count of stage entities stored in DB with stored procedure
        /*ResultSet tempSet;  
        while (tempSet.next())
        {
            int entityX = tempSet.getInt("enpX");
            int entityY = tempSet.getInt("enpY");

            // @TODO go through each entry in a level entity placmetn query
            switch (tempSet.getString("entName")) 
            { // @TODO change this to a function that gives me
                case "Hole":
                    placeEntity(new Hole(entityX, entityY), entityX, entityY);
                    break;
                case "Dirt":
                    placeEntity(new Dirt(entityX, entityY), entityX, entityY);
                    break;
                case "Wall":
                    placeEntity(new Wall(entityX, entityY), entityX, entityY);
                    break;
                case "Boulder":
                    placeEntity(new Boulder(entityX, entityY), entityX, entityY);
                    break;
                case "Diamond":
                    placeEntity(new Diamond(entityX, entityY), entityX, entityY);
                    break;
                case "Player":
                    this.player = new Player(entityX, entityY);
                    placeEntity(this.player, entityX, entityY);
                    break;
                case "Exit":
                    this.exit = new Exit(entityX, entityY);
                    placeEntity(new Wall(entityX, entityY), entityX, entityY);
                    break;
                case "Mole":
                    placeEntity(new Mole(entityX, entityY), entityX, entityY);
                    break;
                case "BoomMole":
                    placeEntity(new BoomMole(entityX, entityY), entityX, entityY);
                    break;
                default:
                    break;
            }
        }*/
        //setCounter(CounterType.DIAMOND, 0); // @TODO change 0 to function that gets stage diamond from DB
        //setCounter(CounterType.TIME, 0); // @TODO change 0 to function that gets stage time from DB
        //setCounter(CounterType.SCORE, 0);
    }
    
	/**
    * <h1>getPlayer Method</h1>
    * returns player value stocked
    *
    * @return entity player stored in this.player
    */
    public Entity getPlayer()
    {
		return this.player;
	}

	/**
	* <h1>setPlayer Method</h1>
	* set player variable's value
	*
	* @param player entity we want to set
	*/
	public void setPlayer(Entity player)
	{
		this.player = player;
	}
	
	/**
    * <h1>playerIsAlive Method</h1>
    * check if player variable is pointing to a player object
    *
    * @return boolean weather or not we find a player
    */
	public boolean playerIsAlive()
	{
		if(this.player instanceof Player)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
    * <h1>getExity Method</h1>
    * returns exit value stocked
    *
    * @return entity exit stored in this.exit
    */
	public Entity getExit()
	{
		return this.exit;
	}

	/**
	* <h1>setExit Method</h1>
	* set exit variable's value
	*
	* @param exit entity we want to set
	*/
	public void setExit(Entity exit)
	{
		this.exit = exit;
	}

	/**
    * <h1>getEntity Method</h1>
    * return an entity in the level matrix
    *
    * @param entityX the entities X position
    * @param entityY the entities Y position
    * @return entity in matrix
    */
    public Entity getEntity(int entityX, int entityY) 
    {
        return this.level[entityX][entityY];
    }

    /**
    * <h1>placeEntity Method</h1>
    * places or more accurately inserts an object Entity into the level grid-array
    *
    * @param newEntity passes the entity we want to place e.g. stock in gameHandler array
    * @param entityX the entities X position
    * @param entityY the entities Y position
    */
    public void placeEntity(Entity newEntity, int entityX, int entityY) 
    {
        this.level[entityX][entityY] = newEntity;
        newEntity.setPosition(entityX, entityY);
    }

    /**
    * <h1>deleteEntity Method</h1>
    * deletes Entity objects form level grid-array, using object coordinate
    *
    * @param entityX the entities X position
    * @param entityY the entities Y position
    */
    public void deleteEntity(int entityX, int entityY) 
    {
    	Entity oldEntity = this.level[entityX][entityY];
    	this.level[entityX][entityY] = new Hole(entityX, entityY);
        if (oldEntity instanceof Player)
        {
        	setPlayer(null);
        }
    }

    /**
    * <h1>deleteEntity Method</h1>
    * deletes Entity objects form level grid-array, using entity pointer
    *
    * @param oldEntity pointer to the entity
    */
    public void deleteEntity(Entity oldEntity) 
    {
        this.level[getEntityX(oldEntity)][getEntityY(oldEntity)] = new Hole(oldEntity.getPosition());
        if (oldEntity instanceof Player)
        {
        	setPlayer(null);
        }
    }

    /**
    * <h1>moveEntity Method</h1>
    * moves Entity objects in level grid-array, using entity and destination coordinates
    *
    * @param oldX the entities current X position
    * @param oldY the entities current Y position
    * @param newX the entities destination X position
    * @param newY the entities destination Y position
    * @param moveDir the Direction the entity want to move
    */
    public void moveEntity(int oldX, int oldY, int newX, int newY, Direction moveDir) 
    {
    	System.out.println("HI");
    	System.out.println("Moving (BEFORE) - " + this.level[oldX][oldY] + " to " + this.level[newX][newY]);
    	System.out.println("MoveCoords - " + oldX + ", " + oldY + " to " + newX + ", " +newY);
    	System.out.println("*MOVE TEST" + handleInteraction(oldX, oldY, newX, newY));

        if(handleInteraction(oldX, oldY, newX, newY))
        {
        	System.out.println("We Can Move");
        	System.out.println("Moving - " + this.level[oldX][oldY] + " to " + this.level[newX][newY]);
        	System.out.println("MoveCoords - " + oldX + ", " + oldY + " to " + newX + ", " +newY);
            this.level[newX][newY] = this.level[oldX][oldY];
            deleteEntity(oldX, oldY);
        	System.out.println("Moved - OLD: " + this.level[oldX][oldY] + " NEW: " + this.level[newX][newY]);
        	System.out.println("CASCADE CALL");
            startCascade(oldX, oldY, moveDir);
            if(this.level[newX][newY].getAttribute(Attribute.falling) && moveDir == Direction.DOWN)
            {
            	System.out.println("Still Moving...");
                moveEntity(newX, newY, newX, newY + 1, Direction.DOWN);
            }
        }

    }
    
    // @TODO add move with just direction and remove direction

    /**
    * <h1>moveEntity Method</h1>
    * moves Entity objects in level grid-array, using entity pointer and destination coordinates
    *
    * @param movingEntity pointer to the entity
    * @param newX the entities destination X position
    * @param newY the entities destination Y position
    * @param moveDir the Direction the entity want to move
    */
    public void moveEntity(Entity movingEntity, int newX, int newY, Direction moveDir) 
    {
        if(handleInteraction(movingEntity, newX, newY))
        {
        	int oldX = getEntityX(movingEntity);
        	int oldY = getEntityY(movingEntity);
            this.level[newX][newY] = this.level[getEntityX(movingEntity)][getEntityY(movingEntity)];
            deleteEntity(oldX, oldY);
            startCascade(oldX, oldY, moveDir);
            if(this.level[newX][newY].getAttribute(Attribute.falling) && moveDir == Direction.DOWN)
            {
                moveEntity(newX, newY, newX, newY + 1, Direction.DOWN);
            }
        }
    }

    /**
    * <h1>setLevel Method</h1>
    * passes the an entity array newLevel to the level variable to set this objects current array
    *
    * @param newLevel the level entity array
    */
    public void setLevel(Entity[][] newLevel) 
    {
        this.level = newLevel;
    }

    /**
    * <h1>getLevel Method</h1>
    * passes the an entity array newLevel to the level variable to set this objects current array
    *
    * @return entity array containing our stored objects
    */
    public Entity[][] getLevel()
    {
        return this.level;
    }

    /**
    * <h1>setCounter Method</h1>
    * sets a specified counters new value
    *
    * @param counter which counter are we treating
    * @param newValue new value for our counter
    */
    public void setCounter(CounterType counter, int newValue)
    {
        switch (counter) {
            case DIAMOND:
                this.counterDiamondLeft = newValue;
                if (newValue <= 0)
                {
                    int exitX = getEntityX(this.exit);
                    int exitY = getEntityY(this.exit);
                    deleteEntity(exitX, exitY);
                    placeEntity(this.exit, exitX, exitY);
                }
                break;
            case TIME:
                this.counterTime = newValue;
                break;
            case SCORE:
                this.counterScore = newValue;
                break;
        }
    }

    /**
    * <h1>getCounter Method</h1>
    * sets a specified counters new value
    *
    * @param counter which counter are we treating
    * @return value of our counter in int
    */
    public int getCounter(CounterType counter)
    {
        switch (counter) {
            case DIAMOND:
                return this.counterDiamondLeft;
            case TIME:
                return this.counterTime;
            case SCORE:
                return this.counterScore;
            default:
                throw new IllegalArgumentException("Asked for counter other than Diamond, Time or Score!");
        }
    }

    /**
    * <h1>handleInteraction Method</h1>
    * handles interaction between two entity objects, uses actors X and Y coordinates to determine what happens
    *
    * @param actX the actors current X position
    * @param actY the actors current Y position
    * @param sbjX the subject current X position
    * @param sbjY the subject current Y position
    * @return weather of not an object can move through another object
    */
    public boolean handleInteraction(int actX, int actY, int sbjX, int sbjY) 
    {
    	Entity actor = this.level[actX][actY];
    	Entity subject = this.level[sbjX][sbjY];
        if (actor instanceof Player)
        {

        	if (subject.getAttribute(Attribute.collectable))
            {
                // @TODO add check for diamond before chaning score
                setCounter(CounterType.DIAMOND, getCounter(CounterType.DIAMOND) - 1);
                // @TODO add check for exit and end game
            }
            if (subject.getAttribute(Attribute.lethal))
            {
                // @TODO end game kill/delete player?
 
            }
            if (subject.getAttribute(Attribute.breakable))
            {
                deleteEntity(subject);
                return true;
            }
            if (subject.getAttribute(Attribute.solid))
            {
                return false;
            }
            else
            {
            	return true;
            }
        }
        else
        {
            if (subject.getAttribute(Attribute.solid))
            {
                return false;
            }
            else 
            {
                if (subject.getAttribute(Attribute.crushable) && actor.getAttribute(Attribute.heavy))
                {
                    // @TODO end game kill/delete crushable
                    // @TODO if player end game?
                }
                return true;
            }
        }
    }

    /**
    * <h1>handleInteraction Method</h1>
    * handles interaction between two entity objects, uses actors X and Y coordinates to determine what happens
    *
    * @param actor the entity object
    * @param sbjX the subject current X position
    * @param sbjY the subject current Y position
    * @return weather of not an object can move through another object
    */
    public boolean handleInteraction(Entity actor, int sbjX, int sbjY) // @TODO change to subject object based
    {
    	Entity subject = this.level[sbjX][sbjY];
        if (actor instanceof Player)
        {

        	if (subject.getAttribute(Attribute.collectable))
            {
                // @TODO add check for diamond before chaning score
                setCounter(CounterType.DIAMOND, getCounter(CounterType.DIAMOND) - 1);
                // @TODO add check for exit and end game
            }
            if (subject.getAttribute(Attribute.lethal))
            {
                // @TODO end game kill/delete player?
 
            }
            if (subject.getAttribute(Attribute.breakable))
            {
                deleteEntity(subject);
                return true;
            }
            if (subject.getAttribute(Attribute.solid))
            {
                return false;
            }
            else
            {
            	return true;
            }
        }
        else
        {
            if (subject.getAttribute(Attribute.solid))
            {
                return false;
            }
            else 
            {
                if (subject.getAttribute(Attribute.crushable) && actor.getAttribute(Attribute.heavy))
                {
                    // @TODO end game kill/delete crushable
                    // @TODO if player end game?
                }
                return true;
            }
        }
    }
    
    /**
    * <h1>handleRolling Method</h1>
    * handles a rollable object rolling check and movement
    *
    * @param checkPointX the affected objects current X coordinate
    * @param checkPointY the affected objects current Y coordinate
    */
    public void handleRolling(int checkPointX, int checkPointY)
    {
        if(this.level[checkPointX + 1][checkPointY] instanceof Hole && this.level[checkPointX + 1][checkPointY + 1] instanceof Hole)
        {
        	System.out.println("ROLL 1");
            moveEntity(checkPointX, checkPointY, checkPointX + 1, checkPointY, Direction.RIGHT);
            System.out.println("ROLL 2");
            moveEntity(checkPointX + 1, checkPointY, checkPointX + 1, checkPointY + 1, Direction.DOWN);
            System.out.println("ROLL OUT");
        }
        else if(this.level[checkPointX - 1][checkPointY] instanceof Hole && this.level[checkPointX - 1][checkPointY + 1] instanceof Hole)
        {
        	System.out.println("ROLL 1-2");
        	moveEntity(checkPointX, checkPointY, checkPointX - 1, checkPointY, Direction.LEFT);
        	System.out.println("ROLL 2-2");
            moveEntity(checkPointX - 1, checkPointY, checkPointX - 1, checkPointY + 1, Direction.DOWN);
            System.out.println("ROLL OUT");
        }
    }

    /**
    * <h1>handleCascade Method</h1>
    * handles individual points that are sent by startCascade()
    *
    * @param checkPoint the affected objects current position
    */
    public void handleCascade(Point checkPoint)
    {
    	System.out.println("CASCADE IN");
    	System.out.println("checkPoint - " + checkPoint);
    	int checkPointX = (int) checkPoint.getX();
    	int checkPointY = (int) checkPoint.getY();
    	System.out.println("checkPointX - " + checkPointX);
    	System.out.println("checkPointY - " + checkPointY);
    	if (checkPointX < 0 || checkPointY < 0)
    	{
    		System.out.println("CASCADE FAIL");
    		return;
    	}
    	System.out.println("What Cascades? - " + this.level[checkPointX][checkPointY]);

        if(this.level[checkPointX][checkPointY].getAttribute(Attribute.falling))
        {
        	System.out.println("FALLING");
            moveEntity(checkPointX, checkPointY, checkPointX, checkPointY + 1, Direction.DOWN);
        }
        if(this.level[checkPointX][checkPointY].getAttribute(Attribute.rolling) && this.level[checkPointX][checkPointY + 1].getAttribute(Attribute.rolling))
        {
        	System.out.println("ROLLING");
        	handleRolling(checkPointX, checkPointY);
        }
        
    }
    
    /**
    * <h1>start Cascade Method</h1>
    * starts interaction around the actors X and Y coordinates to determine what happens
    *
    * @param actX the actors current X position
    * @param actY the actors current Y position
    * @param moveDir the actors move direction
    */
    public void startCascade(int actX, int actY, Direction moveDir)
    {
        Entity actor = this.level[actX][actY];
        Point actPoint = actor.getPosition();

        Point NP = new Point(actPoint);
        NP.translate(0, -1);
        Point WP = new Point(actPoint);
        WP.translate(-1, 0);
        Point EP = new Point(actPoint);
        EP.translate(1, 0);
        Point NWP = new Point(actPoint);
        NWP.translate(-1, -1);
        Point NEP = new Point(actPoint);
        NEP.translate(1, -1);
        
    	System.out.println("CASCADE START");
    	System.out.println("PointStart - " + actPoint);
    	System.out.println("11, 9 CHECK - " + this.level[11][9]);

        
        switch (moveDir) {
            case UP:
            	System.out.println("UP");
                System.out.println("Starting WP - " + WP);
                handleCascade(WP);
                System.out.println("Starting EP - " + EP);
                handleCascade(EP);
                System.out.println("Starting NWP - " + NWP);
                handleCascade(NWP);
                System.out.println("Starting NEP - " + NEP);
                handleCascade(NEP);
                break;
            case DOWN:
            	System.out.println("NORTH");
            	System.out.println("Starting NP - " + NP);
                handleCascade(NP);
                System.out.println("Starting WP - " + WP);
                handleCascade(WP);
                System.out.println("Starting EP - " + EP);
                handleCascade(EP);
                System.out.println("Starting NWP - " + NWP);
                handleCascade(NWP);
                System.out.println("Starting NEP - " + NEP);
                handleCascade(NEP);
                break;
            case LEFT:
            	System.out.println("LEFT");
            	System.out.println("Starting NP - " + NP);
                handleCascade(NP);
                System.out.println("Starting EP - " + EP);
                handleCascade(EP);
                System.out.println("Starting NEP - " + NEP);
                handleCascade(NEP);
                break;
            case RIGHT:
            	System.out.println("RIGHT");
            	System.out.println("Starting NP - " + NP);
                handleCascade(NP);
                System.out.println("Starting WP - " + WP);
                handleCascade(WP);
                System.out.println("Starting NWP - " + NWP);
                handleCascade(NWP);
                break;
            default:
                break;
        }
    }

    /**
    * <h1>handleCascade Method</h1>
    * handles interaction around the actors entity object to determine what happens
    *
    * @param actor the actors entity object
    * @param moveDir the actors move direction
    */
    public void startCascade(Entity actor, Direction moveDir)
    {
        Point actPoint = actor.getPosition();
        Point NP = new Point(actPoint);
        NP.translate(0, -1);
        Point WP = new Point(actPoint);
        WP.translate(-1, 0);
        Point EP = new Point(actPoint);
        EP.translate(1, 0);
        Point NWP = new Point(actPoint);
        NWP.translate(-1, -1);
        Point NEP = new Point(actPoint);
        NEP.translate(1, -1);
        
        System.out.println("CASCADE START");
    	System.out.println("PointStart - " + actPoint);
    	System.out.println("11, 9 CHECK - " + this.level[11][9]);

        switch (moveDir) {
        case UP:
        	System.out.println("UP");
            System.out.println("Starting WP - " + WP);
            handleCascade(WP);
            System.out.println("Starting EP - " + EP);
            handleCascade(EP);
            System.out.println("Starting NWP - " + NWP);
            handleCascade(NWP);
            System.out.println("Starting NEP - " + NEP);
            handleCascade(NEP);
            break;
        case DOWN:
        	System.out.println("NORTH");
        	System.out.println("Starting NP - " + NP);
            handleCascade(NP);
            System.out.println("Starting WP - " + WP);
            handleCascade(WP);
            System.out.println("Starting EP - " + EP);
            handleCascade(EP);
            System.out.println("Starting NWP - " + NWP);
            handleCascade(NWP);
            System.out.println("Starting NEP - " + NEP);
            handleCascade(NEP);
            break;
        case LEFT:
        	System.out.println("LEFT");
        	System.out.println("Starting NP - " + NP);
            handleCascade(NP);
            System.out.println("Starting EP - " + EP);
            handleCascade(EP);
            System.out.println("Starting NEP - " + NEP);
            handleCascade(NEP);
            break;
        case RIGHT:
        	System.out.println("RIGHT");
        	System.out.println("Starting NP - " + NP);
            handleCascade(NP);
            System.out.println("Starting WP - " + WP);
            handleCascade(WP);
            System.out.println("Starting NWP - " + NWP);
            handleCascade(NWP);
            break;
        default:
            break;
        }
    }
    
    /**
    * <h1>getEntityX Method</h1>
    * Retrieves and converts an entity's X coordinate as int
    *
    * @param ent the entity in question
    * @return entity ent's X coordinate
    */
    public int getEntityX(Entity ent)
    {
    	int coordX = (int) ent.getPosition().getX();
    	return coordX;
    }
    
    /**
    * <h1>getEntityY Method</h1>
    * Retrieves and converts an entity's Y coordinate as int
    *
    * @param ent the entity in question
    * @return entity ent's Y coordinate
    */
    public int getEntityY(Entity ent)
    {
    	int coordY = (int) ent.getPosition().getY();
    	return coordY;
    }
}