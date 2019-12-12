package noApplet;


import bodies.Sun;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;


/** Reusable class implementing the animation idiom. */
@SuppressWarnings("serial")
public abstract class AnimationNoApplet extends NoApplet {

    /** Delay in milliseconds between two consecutive frames. */
    protected int delay = 100;

    /** Dimension of the screen for this noapplet. */
    protected Dimension dim;

    /** Refresh display once per <code>delay</code> milliseconds. */
    private Timer timer;

    protected AnimationNoApplet(String[] args) {
    	super(args);
    }

    /** Overridden here to initialize the animation. */
    @Override
    public final void init() {
    	dim = getSize();
    	initAnimation();
    	timer = new Timer(delay, e -> repaint());
    }

    /** Callback to be invoked by the <code>init</code> method
     * to perform a subclass-specific initialization. */
    protected void initAnimation() {
    }

    /** Overridden here to start the animation timer. */
    @Override
    public void start() {
        timer.start();
    }

    /** Overridden here to ttop the timer. */
    @Override
    public void stop() {
        timer.stop();
    }

    public static void main(String[] args) {

        new Sun(new String[] {"width=1000", "height = 1000"}).run();
    }

}

