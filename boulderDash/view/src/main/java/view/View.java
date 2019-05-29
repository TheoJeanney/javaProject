package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * <h1>The Class View.</h1>
 *
 * The View and it's function.
 * <p>
 * This class is used to call each function to make our game windows.
 * <p>
 * 
 * @author joana
 * 
 * @version 9.2
 * @since 0.9.0
 */

public final class View implements IView, Runnable {

    /** The frame. */
    private final ViewFrame viewFrame;

    /**
     * Instantiates a new view.
     *
     * @param model
     * 
     */
    public View() {
        this.viewFrame = new ViewFrame();
        SwingUtilities.invokeLater(this);
    }

    /**
     * Key code to controller order.
     *
     * @param keyCode
     * 
     * @return the controller order
     */
   /* protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_G:
                return ControllerOrder.English;
            case KeyEvent.VK_F:
                return ControllerOrder.Francais;
            case KeyEvent.VK_D:
                return ControllerOrder.Deutsch;
            case KeyEvent.VK_I:
                return ControllerOrder.Indonesia;
            default:
                return ControllerOrder.English;
        }
    }*/

    /*
     * (non-Javadoc)
     *
     * @see contract.IView#printMessage(java.lang.String)
     */
    public void printMessage(final String message) {
        this.viewFrame.printMessage(message);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    public void run() {
        this.viewFrame.setVisible(true);
    }

    /**
     * Sets the controller.
     *
     * @param controller
     *          the new controller
     */
  /*  public void setController(final IController controller) {
        this.viewFrame.setController(controller);
    }*/
}