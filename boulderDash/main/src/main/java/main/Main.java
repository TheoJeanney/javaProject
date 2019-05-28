
package main;

import java.net.ContentHandler;

import contract.ControllerOrder;
import contract.IModel;
import controller.ControllerGame;
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
 
public class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @param model 
     */
    public static void main(final String[] args, IModel model) {
      //  final Model model = new Model();
        View view = new View(model);
        //ContentHandler controller = new ContentHandler(view, model);
        //view.setController(controller);

       //controller.control();
       // controller.orderPerform(ControllerOrder.English);
    }
}
