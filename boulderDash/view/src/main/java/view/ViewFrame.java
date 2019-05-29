package view;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import contract.IController;
import contract.IModel;

/**
 * <h1>The Class ViewFrame.</h1>
 *
 * The frame and it's function.
 * <p>
 * This class is used to do the windows of our game.
 * <p>
 * 
 * @author joana
 * 
 * @version 9.2
 * @since 0.9.0
 */
 public class ViewFrame extends JFrame implements KeyListener {

    /** The model. */
    private IModel model;

    /** The controller. */
    private IController controller;
    /** The Constant serialVersionUID. */
    private static final long    serialVersionUID    = -697358409737458175L;

    ViewPanel pan;
    
    /**
     * Instantiates a new view frame.
     *
     * @param model
     *          the model
     * @throws HeadlessException
     *           the headless exception
     */
    public ViewFrame() throws HeadlessException {
        super();
        this.buildViewFrame();
    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    @SuppressWarnings("unused")
    private IController getController() {
        return this.controller;
    }

    /**
     * Sets the controller.
     *
     * @param controller
     *          the new controller
     */
    protected void setController(final IController controller) {
        this.controller = controller;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    protected IModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *          the new model
     */
    private void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Builds the view frame.
     *
     * @param model
     * 
     */
    private void buildViewFrame() {
        //this.setModel(model);
        /*close the frame with the cross*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*title of the frame (Bold and Italic)*/
        this.setTitle("Boulder Dash");
        /*not resizable*/
        this.setResizable(false);
        this.addKeyListener(this);
        /*content of the Frame with ViewPanel*/
        this.pan = new ViewPanel();
        this.setContentPane(pan);
        /*Dimensions of the frame*/
        this.setSize(400+ this.getInsets().left + this.getInsets().right, 290 + this.getInsets().top + this.getInsets().bottom);
        /*Window should be placed where we want*/
        this.setLocationRelativeTo(null);
    }

    /**
     * Prints the message.
     *
     * @param message
     * 
     */
    public void printMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}