package boulderDashGame.controller;

import java.awt.Point;
import java.util.Timer;

import boulderDashGame.contract.CounterType;
import boulderDashGame.contract.Debug;
import boulderDashGame.contract.Direction;
import boulderDashGame.entity.*;
import boulderDashGame.model.GameHandler;
import boulderDashGame.view.View;
import boulderDashGame.contract.EndType;

/**
* <h1>GameController Class</h1>
* controlls and calls other relevent calsses
* <p>
* runs and sets up the view for players viewing, as well as running the GameHandler
* functions when needed
* </p>
* 
* @author Thomas Barbod Varjavandi (alias - Deiaros)
* @version 0.9.0
* @since 0.9.0
*/
public class GameController implements IController {

    /** The view. */
    private View view;

    /** The model. */
    private GameHandler model;
    private Timer timer;
    
    /**
     * Instantiates a new controller.
     *
     * @param view2
     *          the view
     * @param model
     *          the model
     */
    public GameController (final View view2, final GameHandler model) {
        this.setView(view2);
        this.setModel(model);
        //
    }
    
    public void startEnemyAI()
    {
    	timer = new Timer();
        this.timer.schedule(new GameEnemyAI(model, this), 0, 2000);
    }
    
    
    public Timer getTimer() {
		return this.timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
     * Sets the view.
     *
     * @param view2
     *            the new view
     */
    public void setView(View view2) {
        this.view = view2;
    }

    /**
     * Sets the model.
     *
     * @param model
     *          the new model
     */
    public void setModel(GameHandler model) {
        this.model = model;
    }
    
    public GameHandler getModel() {
        return this.model;
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
                moveEntity(player, playerX, playerY - 1, controllerOrder);
                break;
            case DOWN:
            	moveEntity(player, playerX, playerY + 1, controllerOrder);
                break;
            case RIGHT:
            	moveEntity(player, playerX + 1, playerY, controllerOrder);
                break;
            case LEFT:
            	moveEntity(player, playerX - 1, playerY, controllerOrder);
                break;
            default:
                break;
        }
    }
    
    public void updateView()
    {
    	System.out.println("");
		System.out.println("-----------------------------------------------------------" + this.model.getCounter(CounterType.DIAMOND));
		for (int i = 0; i < this.model.getLevel().length; i++) 
		{
			System.out.println("");
			for (int j = 0; j < this.model.getLevel()[i].length; j++)
			{
				if (this.model.getEntity(j,i) instanceof Wall) 
				{
					System.out.print("| "); 
					 this.view.setImageLabel("C:\\Users\\Thomas\\Desktop\\images\\mur.png", j, i);

				}
				else if (this.model.getEntity(j,i) instanceof Dirt) 
				{
					System.out.print("+ "); 
					this.view.setImageLabel("C:\\Users\\Thomas\\Desktop\\images\\sol.png", j, i); 

				}
				else if (this.model.getEntity(j,i) instanceof Hole) 
				{
					System.out.print(". "); 
					this.view.setImageLabel("C:\\Users\\Thomas\\Desktop\\images\\solnoir.png", j, i);

				}
				else if (this.model.getEntity(j,i) instanceof Boulder) 
				{
					System.out.print("0 "); 
					this.view.setImageLabel("C:\\Users\\Thomas\\Desktop\\images\\roche.png", j, i); 

				}
				else if (this.model.getEntity(j,i) instanceof Diamond) 
				{
					System.out.print("$ "); 
					this.view.setImageLabel("C:\\Users\\Thomas\\Desktop\\images\\diam3.png", j, i); 

				}
				else if (this.model.getEntity(j,i) instanceof Exit) 
				{
					System.out.print("X "); 
					this.view.setImageLabel("C:\\Users\\Thomas\\Desktop\\images\\Exit2.png", j, i); 
				}
				else if (this.model.getEntity(j,i) instanceof Player) 
				{
					System.out.print("@ "); 
					this.view.setImageLabel("C:\\Users\\Thomas\\Desktop\\images\\player.png", j, i); 
				}
				else if (this.model.getEntity(j,i) instanceof Mole) 
				{
					System.out.print("@ "); 
					this.view.setImageLabel("C:\\Users\\Thomas\\Desktop\\images\\mole.png", j, i); 
				}
				else if (this.model.getEntity(j,i) instanceof BoomMole) 
				{
					System.out.print("@ "); 
					this.view.setImageLabel("C:\\Users\\Thomas\\Desktop\\images\\mole.png", j, i); 
				}
				
			}
		}
    }
    
    public void endGame(EndType endType)
    {
    	this.view.gameEnd(endType);
    	getTimer().cancel();
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
        	 this.model.placeEntity( this.model.getEntity(oldX,oldY), newX, newY);
             this.model.deleteEntity(oldX, oldY);
             
             updateView();
             startCascade(oldX, oldY, moveDir); // Calls a method that deals with Entity around mover

             // If we have a falling Entity like Boulders we keep going, handleInteraction will know when to stop
             if( this.model.getEntity(newX,newY).getAttribute(Attribute.falling) /*&& moveDir == Direction.DOWN*/)
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
		int oldX =  this.model.getEntityX(movingEntity);
		int oldY =  this.model.getEntityY(movingEntity);

        // handleInteraction() allows us to deal with interaction between mover and the object in front of them
        if(handleInteraction(oldX, oldY, newX, newY))
        {
	       	 this.model.placeEntity( this.model.getEntity(oldX,oldY), newX, newY);
            this.model.deleteEntity(oldX, oldY);
            
            updateView();
            startCascade(oldX, oldY, moveDir); // Calls a method that deals with Entity around mover

            // If we have a falling Entity like Boulders we keep going, handleInteraction will know when to stop
            if( this.model.getEntity(newX,newY).getAttribute(Attribute.falling) /*&& moveDir == Direction.DOWN*/)
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
                	   view.setDiamondCounter();
                  }
                  if(subject instanceof Exit)
                  {
                      endGame(EndType.WIN);
                  }
              }
              if (subject.getAttribute(Attribute.lethal))
              {
            	   this.model.deleteEntity(actor);
            	   this.model.setPlayer(null);
            	   endGame(EndType.DEAD);
              }
              if (subject.getAttribute(Attribute.breakable))
              {
            	   this.model.deleteEntity(subject);
                  return true;
              }
        	  if (subject instanceof Boulder)
        	  {
        		  int moveFactor = sbjX - actX;
        		  System.out.print(moveFactor);
        		  switch (moveFactor) {
                  case 1:
                	  moveEntity(sbjX, sbjY, sbjX + moveFactor, sbjY, Direction.RIGHT);
                	  subject =  this.model.getEntity(sbjX,sbjY);
                  case -1:
                	  moveEntity(sbjX, sbjY, sbjX + moveFactor, sbjY, Direction.LEFT);
                	  subject =  this.model.getEntity(sbjX,sbjY);
        		  }	 
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
            	  if (actor.getAttribute(Attribute.lethal) && subject instanceof Player)
            	  {
            		  this.model.setPlayer(null);
               	   	  endGame(EndType.DEAD); 
            	  }
                  // If the actor is heavy (like Boulder) and subject is crushable (like Player)
                  if (subject.getAttribute(Attribute.crushable) && actor.getAttribute(Attribute.heavy))
                  {
                	   this.model.deleteEntity(subject);
                      if (subject instanceof Player)
                      {
                    	   this.model.setPlayer(null);
                    	   endGame(EndType.DEAD);          
                      }
                      return true;
                  }
                  else if (subject instanceof Hole)
                  {
                	  return true;
                  }
                  else
                  {
                	  return false;
                  }
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
                	   view.setDiamondCounter();
                  }
                  if(subject instanceof Exit)
                  {
                	  endGame(EndType.WIN);
                  }
              }
              if (subject.getAttribute(Attribute.lethal))
              {
            	   this.model.deleteEntity(actor);
            	   this.model.setPlayer(null);
            	   endGame(EndType.DEAD);
              }
              if (subject.getAttribute(Attribute.breakable))
              {
            	   this.model.deleteEntity(subject);
                  return true;
              }
              if (subject instanceof Boulder)
        	  {
        		  int moveFactor = sbjX - (int) actor.getPosition().getX();
        		  System.out.print(moveFactor);
        		  switch (moveFactor) {
                  case 1:
                	  moveEntity(sbjX, sbjY, sbjX + moveFactor, sbjY, Direction.RIGHT);
                	  subject =  this.model.getEntity(sbjX,sbjY);
                  case -1:
                	  moveEntity(sbjX, sbjY, sbjX + moveFactor, sbjY, Direction.LEFT);
                	  subject =  this.model.getEntity(sbjX,sbjY);
        		  }	 
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
                    	   endGame(EndType.DEAD);
                      }
                      return true;
                  }
                  else if (subject instanceof Hole)
                  {
                	  return true;
                  }
                  else
                  {
                	  return false;
                  }
                  
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
    	   
           if( !(this.model.getEntity(checkPointX,checkPointY) instanceof Wall) && this.model.getEntity(checkPointX + 1,checkPointY) instanceof Hole && this.model.getEntity(checkPointX + 1,checkPointY + 1) instanceof Hole)
           {
               moveEntity(checkPointX, checkPointY, checkPointX + 1, checkPointY, Direction.RIGHT);
               moveEntity(checkPointX + 1, checkPointY, checkPointX + 1, checkPointY + 1, Direction.DOWN);
           }
           else if( !(this.model.getEntity(checkPointX,checkPointY) instanceof Wall) && this.model.getEntity(checkPointX - 1,checkPointY) instanceof Hole && this.model.getEntity(checkPointX - 1,checkPointY + 1) instanceof Hole)
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
       	if (checkPointX < 1 || checkPointY < 1 || checkPointX > 28 || checkPointY > 17)
       	{
               return;
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