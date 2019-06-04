package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import contract.CounterType;
import contract.GameLevels;

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
    private DAOHandler DAO = new DAOHandler();

    //private static enum coordinateType {x,y};

    /**
    * <h1>GameHandler Constructor</h1>
    *
    */
    public GameHandler(GameLevels choiceLevel)
    {
        // @TODO define parameters
        setLevel(new Entity[19][30]);
        // @TODO get count of stage entities stored in DB with stored procedure
		ResultSet rs = DAO.getEntityPlacement(GameLevels.LevelOne);
        try 
        {
			while (rs.next())
			{
				
			    // @TODO go through each entry in a level entity placmetn query
				int isInvincible = rs.getInt("enpInvincible");
				int lvlDiamondLeft = rs.getInt("lvlDiamondLeft");
				int lvlTime = rs.getInt("lvlTime");
				int entityX = rs.getInt("enpX");
			    int entityY = rs.getInt("enpY");
				switch (rs.getString("entName")) 
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
				if(isInvincible == 1) { getEntity(entityX, entityY).setInvincible(); }
				setCounter(CounterType.DIAMOND, lvlDiamondLeft); // @TODO change 0 to function that gets stage diamond from DB
		        setCounter(CounterType.TIME, lvlTime); // @TODO change 0 to function that gets stage time from DB
		        setCounter(CounterType.SCORE, 0);
			}
		} 
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    }
    
    public GameHandler()
    {
    	
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
        return this.level[entityY][entityX];
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
        this.level[entityY][entityX] = newEntity;
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
    	Entity oldEntity = getEntity(entityX,entityY);
    	this.level[entityY][entityX] = new Hole(entityX, entityY);
        if (oldEntity instanceof Player)
        {
            setPlayer(null);
            //endGame(gameStage.DEAD); //Controller Class function to end game
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
        this.level[getEntityY(oldEntity)][getEntityX(oldEntity)] = new Hole(oldEntity.getPosition());
        if (oldEntity instanceof Player)
        {
            deleteEntity(oldEntity);
            setPlayer(null);
            //endGame(gameStage.DEAD); //Controller Class function to end game
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

                // If we pick up the last diamond we need to open the Exit()
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