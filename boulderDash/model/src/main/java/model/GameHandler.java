package model;

import java.sql.ResultSet;
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
 
    private static Entity[][] level;
    private static Entity player;
    private static Entity exit;
    private static int counterDiamondLeft;
    private static int counterScore;
    private static int counterTime; // Time in seconds stored as an int

    private static enum coordinateType {x,y};
    private static enum counterType {DIAMOND, TIME, SCORE};
    private static enum direction {UP, DOWN, LEFT, RIGHT};

    /**
    * <h1>GameHandler Constructor</h1>
    *
    * @TODO define parameters
    * @param undefined needs to be defined
    */
    public GameHandler()
    {
        setLevel(new Entity[40][20]);
        // @TODO get count of stage entities stored in DB with stored procedure
        ResultSet tempSet;  
        while (tempSet.next())
        {
            private int entityX = tempSet.getString("enpX");
            private int entityY = tempSet.getString("enpY");

            // @TODO go through each entry in a level entity placmetn query
            switch (tempSet.getString("entName")) 
            { // @TODO change this to a function that gives me
                case "Hole":
                    placeEntity(new Hole(), entityX, entityY);
                    break;
                case "Dirt":
                    placeEntity(new Dirt(), entityX, entityY);
                    break;
                case "Wall":
                    placeEntity(new Wall(), entityX, entityY);
                    break;
                case "Boulder":
                    placeEntity(new Boulder(), entityX, entityY);
                    break;
                case "Diamond":
                    placeEntity(new Diamond(), entityX, entityY);
                    break;
                case "Player":
                    this.player = new Player()
                    placeEntity(this.player, entityX, entityY);
                    break;
                case "Exit":
                    this.exit = new Exit()
                    placeEntity(new Wall(), entityX, entityY);
                    break;
                case "Mole":
                    placeEntity(new Mole(), entityX, entityY);
                    break;
                case "BoomMole":
                    placeEntity(new BoomMole(), entityX, entityY);
                    break;
                default:
                    break;
            }
        }
        setCounter(counterType.DIAMOND, 0); // @TODO change 0 to function that gets stage diamond from DB
        setCounter(counterType.TIME, 0); // @TODO change 0 to function that gets stage time from DB
        setCounter(counterType.SCORE, 0);
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
        this.level[entityX][entityY] = new Hole();
    }

    /**
    * <h1>deleteEntity Method</h1>
    * deletes Entity objects form level grid-array, using entity pointer
    *
    * @param oldEntity pointer to the entity
    */
    public void deleteEntity(Entity oldEntity) 
    {
        this.level[oldEntity.getPosition().getX()][oldEntity.getPosition().getY()] = new Hole();
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
    */
    public void moveEntity(int oldX, int oldY, int newX, int newY, direction moveDir) 
    {
        if(handleInteraction(oldX, oldY, newX, newY))
        {
            this.level[newX][newY] = this.level[oldX][oldX];
            deleteEntity(oldX, oldX);
            if(this.level[newX][newY].getAttribute(Attribute.falling) && moveDir = direction.DOWN)
            {
                moveEntity(newX, newY, newX, newY - 1, direction.DOWN);
            }
        }
        startCascade(oldX, oldY);

    }

    /**
    * <h1>moveEntity Method</h1>
    * moves Entity objects in level grid-array, using entity pointer and destination coordinates
    *
    * @param movingEntity pointer to the entity
    * @param newX the entities destination X position
    * @param newY the entities destination Y position
    * @param moveDir the direction the entity want to move
    */
    public void moveEntity(Entity movingEntity, int newX, int newY, direction moveDir) 
    {
        if(handleInteraction(movingEntity, newX, newY))
        {
            this.level[newX][newY] = this.level[oldEntity.getPosition().getX()][oldEntity.getPosition().getY()];
            this.level[oldEntity.getPosition().getX()][oldEntity.getPosition().getY()] = new Hole();
            if(this.level[newX][newY].getAttribute(Attribute.falling) && moveDir = direction.DOWN)
            {
                moveEntity(newX, newY, newX, newY - 1, direction.DOWN);
            }
        }
        startCascade(movingEntity);
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
        return this.level
    }

    /**
    * <h1>setCounter Method</h1>
    * sets a specified counters new value
    *
    * @param counter which counter are we treating
    * @param newValue new value for our counter
    */
    public void setCounter(counterType counter, int newValue)
    {
        switch (counter) {
            case DIAMOND:
                this.counterDiamondLeft = newValue;
                if (newValue =< 0)
                {
                    private int exitX = this.exit.getPosition().getX();
                    private int exitY = this.exit.getPosition().getY();
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
    * @param sbjX the subject current X position
    * @param sbjY the subject current Y position
    * @return weather of not an object can move through another object
    */
    public boolean handleInteraction(int actX, int actY, int sbjX, int sbjY) 
    {
        if (this.level[actX][actY] = this.player) // @TODO change to player class
        {
            if (this.level[sbjX][sbjY].getAttribute(Attribute.collectable))
            {
                // @TODO add check for diamond before chaning score
                setCounter(counterType.DIAMOND, getCounter(counterType.DIAMOND) - 1);
                // @TODO add check for exit and end game
            }
            else if (this.level[sbjX][sbjY].getAttribute(Attribute.lethal))
            {
                // @TODO end game kill/delete player?
            }
            else if (this.level[sbjX][sbjY].getAttribute(Attribute.breakable) && !(this.level[sbjX][sbjY].getAttribute(Attribute.solid)))
            {
                deleteEntity(sbjX, sbjY);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if (this.level[sbjX][sbjY].getAttribute(Attribute.solid))
            {
                return false;
            }
            else 
            {
                if (this.level[sbjX][sbjY].getAttribute(Attribute.crushable) && this.level[actX][actY].getAttribute(Attribute.heavy))
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
    public boolean handleInteraction(Entity actor, int sbjX, int sbjY) 
    {
        if (actor = this.player) // @TODO change to player class
        {
            if (this.level[sbjX][sbjY].getAttribute(Attribute.collectable))
            {
                // @TODO add check for diamond before changing score
                setCounter(counterType.DIAMOND, getCounter(counterType.DIAMOND) + 1);
            }

            if (this.level[sbjX][sbjY].getAttribute(Attribute.lethal))
            {
                // @TODO end game kill/delete player?
            }

            if (this.level[sbjX][sbjY].getAttribute(Attribute.breakable) && !(this.level[sbjX][sbjY].getAttribute(Attribute.solid)))
            {
                deleteEntity(sbjX, sbjY);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if (this.level[sbjX][sbjY].getAttribute(Attribute.solid))
            {
                return false;
            }
            else (this.level[sbjX][sbjY].getAttribute(Attribute.crushable) && actor.getAttribute(Attribute.heavy))
            {
                // @TODO end game kill/delete player?
                return true;
            }
        }
    }

    /**
    * <h1>handleCascade Method</h1>
    * handles individual points that are sent by startCascade()
    *
    * @param checkPoint the actors current X position
    */
    public void handleCascade(Point checkPoint)
    {

        if(this.level[checkPoint.getX()][checkPoint.getY()].getAttribute(Attribute.falling))
        {
            moveEntity(checkPoint.getX(), checkPoint.getY(), checkPoint.getX(), checkPoint.getY() - 1, direction.DOWN)
        }
        else if(this.level[checkPoint.getX()][checkPoint.getY()].getAttribute(Attribute.rolling) && this.level[checkPoint.getX()][checkPoint.getY() - 1].getAttribute(Attribute.rolling))
        {
            moveEntity(checkPoint.getX(), checkPoint.getY(), checkPoint.getX() - 1, checkPoint.getY(), direction.RIGHT)
            moveEntity(checkPoint.getX(), checkPoint.getY(), checkPoint.getX(), checkPoint.getY() - 1, direction.DOWN)
        }
        
    }
    
    /**
    * <h1>start Cascade Method</h1>
    * starts interaction around the actors X and Y coordinates to determine what happens
    *
    * @param actX the actors current X position
    * @param actY the actors current Y position
    */
    public void startCascade(int actX, int actY)
    {
        private Entity actor = this.level[actX][actY];
        private Point actPoint = actor.getPosition();
        private Point NP = actPoint.translate(0, 1);
        private Point WP = actPoint.translate(-1, 0);
        private Point EP = actPoint.translate(1, 0;
        private Point NWP = actPoint.translate(-1, 1);
        private Point NEP = actPoint.translate(1, 1);

        handleCascade(NP);
        handleCascade(WP);
        handleCascade(EP);
        handleCascade(NWP);
        handleCascade(NEP);
    }

    /**
    * <h1>handleCascade Method</h1>
    * handles interaction around the actors entity object to determine what happens
    *
    * @param actor the actors entity object
    */
    public void startCascade(Entity actor)
    {
        private Point actPoint = actor.getPosition();
        private Point NP = actPoint.translate(0, 1);
        private Point WP = actPoint.translate(-1, 0);
        private Point EP = actPoint.translate(1, 0;
        private Point NWP = actPoint.translate(-1, 1);
        private Point NEP = actPoint.translate(1, 1);

        handleCascade(NP);
        handleCascade(WP);
        handleCascade(EP);
        handleCascade(NWP);
        handleCascade(NEP);
    }
}