package model;

import java.sql.ResultSet;

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
    private int counterDiamondLeft;
    private int counterScore;
    private int counterTime; // Time in seconds stored as an int

    static enum coordinateType {x,y};
    static enum counterType {DIAMOND, TIME, SCORE};
    static enum direction {UP, DOWN, LEFT, RIGHT};

    /**
    * <h1>GameHandler Constructor</h1>
    *
    * @TODO define parameters
    * @param undefined needs to be defined
    * @return constructor returns nothing
    */
    public GameHandler() {
        setLevel(new Entity[40][25]);
        // @TODO get count of stage entities stored in DB with stored procedure
        int templvlSize = 300; // DB stage entity count
        for (int ls = 0; ls < templvlSize; ls++)
        {
            // @TODO go through each entry in a level entity placmetn query
            ResultSet tempSet;  
            switch (tempSet.getString("entName")) { // @TODO change this to a function that gives me
                case "Empty":
                    createEntity(new , entityX, entityY);
                    break;
                case "Dirt":
                    
                    break;
                case "Wall":
                    
                    break;
                case "Boulder":
                    
                    break;
                case "Diamond":
                    
                    break;
                case "Player":
                    
                    break;
                case "Exit":
                    
                    break;
                case "Mole":
                    
                    break;
                case "BoomMole":
                    
                    break;
                default:
                    break;
            }
            createEntity(new Entity, entityX, entityY);
        }
        setCounter(counterType.DIAMOND, 0); // @TODO change 0 to function that gets stage diamond from DB
        setCounter(counterType.TIME, 0); // @TODO change 0 to function that gets stage time from DB
        setCounter(counterType.SCORE, 0);


    }
    
    /**
    * <h1>createEntity Method</h1>
    * creates or more accuratly inserts a object withing the Entity family into the level grid-array
    *
    * @param newEntity passes the entity we want to create e.g. stock in gameHandler array
    * @param entityX the entities X position
    * @param entityY the entities Y position
    * @return nothing (void)
    */
    public void createEntity(Entity newEntity, int entityX, int entityY) 
    {
        this.level[entityX][entityY] = newEntity;
    }

    /**
    * <h1>deleteEntity Method</h1>
    * deletes Entity objects form level grid-array, using object coordinate
    *
    * @param entityX the entities X position
    * @param entityY the entities Y position
    * @return nothing (void)
    */
    public void deleteEntity(int entityX, int entityY) 
    {
        
    }

    /**
    * <h1>deleteEntity Method</h1>
    * deletes Entity objects form level grid-array, using entity pointer
    *
    * @param oldEntity pointer to the entity
    * @return nothing (void)
    */
    public void deleteEntity(Entity oldEntity) 
    {
        
    }

    /**
    * <h1>moveEntity Method</h1>
    * moves Entity objects in level grid-array, using entity and destination coordinates
    *
    * @param oldX the entities current X position
    * @param oldY the entities current Y position
    * @param newX the entities destination X position
    * @param newY the entities destination Y position
    * @param moveDir the direction the entity want to move
    * @return nothing (void)
    */
    public void moveEntity(int oldX, int oldY, int newX, int newY, direction moveDir) 
    {
        // @TODO call entity interaction before anything else
    }

    /**
    * <h1>moveEntity Method</h1>
    * moves Entity objects in level grid-array, using entity pointer and destination coordinates
    *
    * @param movingEntity pointer to the entity
    * @param newX the entities destination X position
    * @param newY the entities destination Y position
    * @param moveDir the direction the entity want to move
    * @return nothing (void)
    */
    public void moveEntity(Entity movingEntity, int newX, int newY, direction moveDir) 
    {
        
    }

    /**
    * <h1>setLevel Method</h1>
    * passes the an entity array newLevel to the level variable to set this objects current array
    *
    * @param newLevel the level entity array
    * @return nothing (void)
    */
    public void setLevel(Entity[][] newLevel) 
    {
        this.level = level;
    }

    /**
    * <h1>getLevel Method</h1>
    * passes the an entity array newLevel to the level variable to set this objects current array
    *
    * @return entity array containing our stored objects
    */
    public Entity[][] getLevel()
    {

    }

    /**
    * <h1>setCounter Method</h1>
    * sets a specified counters new value
    *
    * @param counter which counter are we treating
    * @param newValue new value for our counter
    * @return nothing (void)
    */
    public void setCounter(counterType counter, int newValue)
    {
        switch (counter) {
            case DIAMOND:
                this.counterDiamondLeft = newValue;
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
    public int getCounter(counterType counter)
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
    * @param actDir the direction the entity is interacting with
    * @return nothing (void)
    */
    public void handleInteraction(int actX, int actY, direction actDir) 
    {
        
    }

    /**
    * <h1>handleInteraction Method</h1>
    * handles interaction between two entity objects, uses actors X and Y coordinates to determine what happens
    *
    * @param actor the entity object
    * @param actDir the direction the entity is interacting with
    * @return nothing (void)
    */
    public void handleInteraction(Entity actor, int sbjX, int sbjY, direction actDir) 
    {
        
    }

    /**
    * <h1>handleCascade Method</h1>
    * handles interaction around the actors X and Y coordinates to determine what happens
    *
    * @param actX the actors current X position
    * @param actY the actors current Y position
    * @param actDir the direction the entity is moving
    * @return nothing (void)
    */
    public void handleCascade(int actX, int actY, direction actDir)
    {
        
    }

    /**
    * <h1>handleCascade Method</h1>
    * handles interaction around the actors entity object to determine what happens
    *
    * @param actor the actors entity object
    * @param actDir the direction the entity is moving
    * @return nothing (void)
    */
    public void handleCascade(Entity actor, direction actDir)
    {
        
    }
}