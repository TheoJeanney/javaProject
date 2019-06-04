package controller;

import java.awt.Point;
import contract.CounterType;
import contract.Direction;
import contract.IView;
import entity.Attribute;
import entity.Diamond;
import entity.Entity;
import entity.Exit;
import entity.Hole;
import entity.Player;
import model.GameHandler;

/**
 * The Class Controller.
 */
public class ControllerGame implements IController {

    /** The view. */
    private IView view;

    /** The model. */
    private GameHandler model;
    
    private enum endType { WIN, LOSE, DEAD };

    /**
     * Instantiates a new controller.
     *
     * @param view
     *          the view
     * @param model
     *          the model
     */
    public ControllerGame (final IView view, final GameHandler model) {
        this.setView(view);
        this.setModel(model);
    }

    /**
     * Control.
     */
    /*
     * (non-Javadoc)
     *
     * @see contract.IController#control()
     */
    @Override
	public void control() {
        this.view.printMessage("Press the keyboard arrows to move on the map.");
    }
    
    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    private void setView(final IView view) {
        this.view = view;
    }

    /**
     * Sets the model.
     *
     * @param model
     *          the new model
     */
    private void setModel(final GameHandler model) {
        this.model = model;
    }

    /**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
    /*
     * (non-Javadoc)
     *
     * @see contract.IController#orderPerform(contract.ControllerOrder)
     */
    @Override
	public void orderPerform(Direction controllerOrder) {
    	Entity player = this.model.getPlayer();
    	int playerX = (int) player.getPosition().getX();
    	int playerY = (int) player.getPosition().getY();
        switch (controllerOrder) {
            case UP:
                moveEntity(player, playerX, playerY - 1, Direction.UP);
                break;
            case DOWN:
            	moveEntity(player, playerX, playerY + 1, Direction.DOWN);
                break;
            case RIGHT:
            	moveEntity(player, playerX + 1, playerY, Direction.RIGHT);
                break;
            case LEFT:
            	moveEntity(player, playerX - 1, playerY, Direction.LEFT);
                break;
            default:
                break;
        }
    }
    
    public void updateView()
    {
    	
    }
    
    public void endGame(endType endType)
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
     * @param moveDir the Direction the entity want to move
     */
     @Override
     public void moveEntity(int oldX, int oldY, int newX, int newY, Direction moveDir) 
     {
         // handleInteraction() allows us to deal with interaction between mover and the object in front of them
         if(handleInteraction(oldX, oldY, newX, newY))
         {
        	 this.model.placeEntity( this.model.getEntity(oldX,oldY), newY, newX);
             this.model.deleteEntity(oldX, oldY);
             updateView();
             startCascade(oldX, oldY, moveDir); // Calls a method that deals with Entity around mover

             // If we have a falling Entity like Boulders we keep going, handleInteraction will know when to stop
             if( this.model.getEntity(newY,newX).getAttribute(Attribute.falling) && moveDir == Direction.DOWN)
             {
                 moveEntity(newX, newY, newX, newY + 1, Direction.DOWN);
             }
         }

     }
     
     // TODO add move with just direction and remove direction

     /**
     * <h1>moveEntity Method</h1>
     * moves Entity objects in level grid-array, using entity pointer and destination coordinates
     *
     * @param movingEntity pointer to the entity
     * @param newX the entities destination X position
     * @param newY the entities destination Y position
     * @param moveDir the Direction the entity want to move
     */
     @Override
     public void moveEntity(Entity movingEntity, int newX, int newY, Direction moveDir) 
     {
         if(handleInteraction(movingEntity, newX, newY))
         {
         	int oldX =  this.model.getEntityX(movingEntity);
         	int oldY =  this.model.getEntityY(movingEntity);
         	this.model.placeEntity( this.model.getEntity( this.model.getEntityX(movingEntity), this.model.getEntityY(movingEntity)), newY, newX);
            this.model.deleteEntity(oldX, oldY);
            updateView();
            startCascade(oldX, oldY, moveDir);
			if( this.model.getEntity(newX,newY).getAttribute(Attribute.falling) && moveDir == Direction.DOWN)
			{
			    moveEntity(newX, newY, newX, newY + 1, Direction.DOWN);
			}
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
      @Override
      public boolean handleInteraction(int actX, int actY, int sbjX, int sbjY) 
      {
      	Entity actor =  this.model.getEntity(actX,actY);
      	Entity subject =  this.model.getEntity(sbjX,sbjY);
          if (actor instanceof Player)
          {

          	if (subject.getAttribute(Attribute.collectable))
              {
                  if(subject instanceof Diamond)
                  {
                	   this.model.setCounter(CounterType.DIAMOND,  this.model.getCounter(CounterType.DIAMOND) - 1);
                  }
                  if(subject instanceof Exit)
                  {
                      endGame(endType.WIN);
                  }
              }
              if (subject.getAttribute(Attribute.lethal))
              {
            	   this.model.deleteEntity(actor);
            	   this.model.setPlayer(null);
            	   endGame(endType.DEAD);
              }
              if (subject.getAttribute(Attribute.breakable))
              {
            	   this.model.deleteEntity(subject);
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
                  // If the actor is heavy (like Boulder) and subject is crushable (like Player)
                  if (subject.getAttribute(Attribute.crushable) && actor.getAttribute(Attribute.heavy))
                  {
                	   this.model.deleteEntity(subject);
                      if (subject instanceof Player)
                      {
                    	   this.model.setPlayer(null);
                    	   endGame(endType.DEAD);          
                      }
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
      @Override
      public boolean handleInteraction(Entity actor, int sbjX, int sbjY) // TODO change to subject object based
      {
      	Entity subject =  this.model.getEntity(sbjX,sbjY);
          if (actor instanceof Player)
          {

          	if (subject.getAttribute(Attribute.collectable))
              {
                  if(subject instanceof Diamond)
                  {
                	   this.model.setCounter(CounterType.DIAMOND,  this.model.getCounter(CounterType.DIAMOND) - 1);
                  }
                  if(subject instanceof Exit)
                  {
                	  endGame(endType.WIN);
                  }
              }
              if (subject.getAttribute(Attribute.lethal))
              {
            	   this.model.deleteEntity(actor);
            	   this.model.setPlayer(null);
            	   endGame(endType.DEAD);
              }
              if (subject.getAttribute(Attribute.breakable))
              {
            	   this.model.deleteEntity(subject);
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
                  // If the actor is heavy (like Boulder) and subject is crushable (like Player)
                  if (subject.getAttribute(Attribute.crushable) && actor.getAttribute(Attribute.heavy))
                  {
                	   this.model.deleteEntity(subject);
                      if (subject instanceof Player)
                      {
                    	   this.model.setPlayer(null);
                    	   endGame(endType.DEAD);
                      }
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
       @Override
       public void handleRolling(int checkPointX, int checkPointY)
       {
           // Rolls either right or left
           if( this.model.getEntity(checkPointX + 1,checkPointY) instanceof Hole &&  this.model.getEntity(checkPointX + 1,checkPointY + 1) instanceof Hole)
           {
               moveEntity(checkPointX, checkPointY, checkPointX + 1, checkPointY, Direction.RIGHT);
               moveEntity(checkPointX + 1, checkPointY, checkPointX + 1, checkPointY + 1, Direction.DOWN);
           }
           else if( this.model.getEntity(checkPointX - 1,checkPointY) instanceof Hole &&  this.model.getEntity(checkPointX - 1,checkPointY + 1) instanceof Hole)
           {
        	   moveEntity(checkPointX, checkPointY, checkPointX - 1, checkPointY, Direction.LEFT);
               moveEntity(checkPointX - 1, checkPointY, checkPointX - 1, checkPointY + 1, Direction.DOWN);
           }
       }

       /**
       * <h1>handleCascade Method</h1>
       * handles individual points that are sent by startCascade()
       *
       * @param checkPoint the affected objects current position
       */
       @Override
       public void handleCascade(Point checkPoint)
       {
       	int checkPointX = (int) checkPoint.getX();
           int checkPointY = (int) checkPoint.getY();
           
           // Check for
       	if (checkPointX < 0 || checkPointY < 0)
       	{
               return;
               // TODO check for bottom of map as well
       	}

           if( this.model.getEntity(checkPointX,checkPointY).getAttribute(Attribute.falling))
           {
               moveEntity(checkPointX, checkPointY, checkPointX, checkPointY + 1, Direction.DOWN);
           }
           if( this.model.getEntity(checkPointX,checkPointY).getAttribute(Attribute.rolling) &&  this.model.getEntity(checkPointX,checkPointY + 1).getAttribute(Attribute.rolling))
           {
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
       @Override
       public void startCascade(int actX, int actY, Direction moveDir)
       {
           Entity actor =  this.model.getEntity(actX,actY);
           Point actPoint = actor.getPosition();

           // Gets all points above and to each side of actor
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

           // calls handleCascade() on all relevant points based on move direction
           switch (moveDir) {
               case UP:
                   handleCascade(WP);
                   handleCascade(EP);
                   handleCascade(NWP);
                   handleCascade(NEP);
                   break;
               case DOWN:
                   handleCascade(NP);
                   handleCascade(WP);
                   handleCascade(EP);
                   handleCascade(NWP);
                   handleCascade(NEP);
                   break;
               case LEFT:
                   handleCascade(NP);
                   handleCascade(EP);
                   handleCascade(NEP);
                   break;
               case RIGHT:
                   handleCascade(NP);
                   handleCascade(WP);
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
       @Override
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

           switch (moveDir) {
               case UP:
                   handleCascade(WP);
                   handleCascade(EP);
                   handleCascade(NWP);
                   handleCascade(NEP);
                   break;
               case DOWN:
                   handleCascade(NP);
                   handleCascade(WP);
                   handleCascade(EP);
                   handleCascade(NWP);
                   handleCascade(NEP);
                   break;
               case LEFT:
                   handleCascade(NP);
                   handleCascade(EP);
                   handleCascade(NEP);
                   break;
               case RIGHT:
                   handleCascade(NP);
                   handleCascade(WP);
                   handleCascade(NWP);
                   break;
               default:
                   break;
           }
       }

}