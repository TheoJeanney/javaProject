package boulderDashGame.controller;

import java.awt.Point;

import boulderDashGame.contract.ControllerOrder;
import boulderDashGame.contract.Direction;
import boulderDashGame.contract.IView;
import boulderDashGame.entity.Entity;
import boulderDashGame.model.GameHandler;

public interface IController {


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
	void orderPerform(Direction controllerOrder);

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
	void moveEntity(int oldX, int oldY, int newX, int newY, Direction moveDir);

	/**
	 * <h1>moveEntity Method</h1>
	 * moves Entity objects in level grid-array, using entity pointer and destination coordinates
	 *
	 * @param movingEntity pointer to the entity
	 * @param newX the entities destination X position
	 * @param newY the entities destination Y position
	 * @param moveDir the Direction the entity want to move
	 */
	void moveEntity(Entity movingEntity, int newX, int newY, Direction moveDir);
	
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
	boolean handleInteraction(int actX, int actY, int sbjX, int sbjY);
	
	/**
     * <h1>handleInteraction Method</h1>
     * handles interaction between two entity objects, uses actors X and Y coordinates to determine what happens
     *
     * @param actor the entity object
     * @param sbjX the subject current X position
     * @param sbjY the subject current Y position
     * @return weather of not an object can move through another object
     */
	boolean handleInteraction(Entity actor, int sbjX, int sbjY);

	/**
     * <h1>handleRolling Method</h1>
     * handles a rollable object rolling check and movement
     *
     * @param checkPointX the affected objects current X coordinate
     * @param checkPointY the affected objects current Y coordinate
     */
     public void handleRolling(int checkPointX, int checkPointY);
	 
     /**
     * <h1>handleCascade Method</h1>
     * handles individual points that are sent by startCascade()
     *
     * @param checkPoint the affected objects current position
     */
     public void handleCascade(Point checkPoint);
     
     /**
     * <h1>start Cascade Method</h1>
     * starts interaction around the actors X and Y coordinates to determine what happens
     *
     * @param actX the actors current X position
     * @param actY the actors current Y position
     * @param moveDir the actors move direction
     */
     public void startCascade(int actX, int actY, Direction moveDir);
     
     /**
     * <h1>handleCascade Method</h1>
     * handles interaction around the actors entity object to determine what happens
     *
     * @param actor the actors entity object
     * @param moveDir the actors move direction
     */
     public void startCascade(Entity actor, Direction moveDir);

}