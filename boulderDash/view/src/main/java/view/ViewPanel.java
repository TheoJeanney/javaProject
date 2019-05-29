package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
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
    private JLabel text;
    
    public ViewPanel() {
        super();
        this.setViewFrame(viewFrame);
        this.propText();

    }
    
    private void propText() {
        // TODO Auto-generated method stub
        text = new JLabel();
        this.text.setText("Tu joues, tu perds ! ");
        this.add(text);
    }

    private void setViewFrame(ViewFrame viewFrame) {
        // TODO Auto-generated method stub
        this.viewFrame = viewFrame;
    }

    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }
    
    @Override
    protected void paintComponent(final Graphics graphics) {
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        //graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 10, 20);
    }
    
}