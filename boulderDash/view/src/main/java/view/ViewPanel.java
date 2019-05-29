package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * <h1>View Class</h1>
 * The View of the game.
 * <p>
 * This class is the object that is used to quit the game.
 * <p>
 * 
* @author joana
* @version 9.2
* @since 0.9.0
*/

class ViewPanel extends JPanel implements Observer {

    /** The view frame. */
    private ViewFrame viewFrame;
    /** The Constant serialVersionUID. */
    private static final long    serialVersionUID    = -998294702363713521L;

    /**
     * Instantiates a new view panel.
     *
     * @param viewFrame
     *          the view frame
     */
    public ViewPanel(final ViewFrame viewFrame) {
        this.setViewFrame(viewFrame);
        //viewFrame.getModel().getObservable().addObserver(this);
    }

    /**
     * Gets the view frame.
     *
     * @return the view frame
     */
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }

    /**
     * Sets the view frame.
     *
     * @param viewFrame
     *          the new view frame
     */
    private void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(final Graphics graphics) {
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        graphics.drawString("Vous avez une chance de gagner !", 10, 20);
    }
}
