package main;

import contract.ControllerOrder;
import contract.IModel;
import controller.ControllerGame;
//import controller.Controller;
//import model.GameHandler;
//import model.Model;
//import model.Model;
import view.View;

/**
 * 
 * <h1>The Class Main.</h1>
 *
 * <p>
 * This class is used to call each function to our game.
 * <p>
 * 
 * @author joana
 * 
 * @version 9.2
 * @since 0.9.0
 */

public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
       // final Model model = new Model();
        final View view = new View();
        //final ControllerGame controllerGame = new ControllerGame(view, model);
        //view.setController(controller);

        //controllerGame.control();
        //controller.orderPerform(ControllerOrder.English);
    }
}