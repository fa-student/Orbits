package bodies;

import noApplet.AnimationNoApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

/**
 * Sun class draws a sun, and creates instances of planets
 */
public class Sun extends AnimationNoApplet implements CoordinatesInterface {
    protected Dimension dim;
    private Timer timer;
    private Image image;
    private Graphics offscreen;
    private int x = getSize().width/2;
    private int y;
    private int radius = 40;
    private int ith;
    private Color color = Color.YELLOW;
    List<Planet> planets = new ArrayList<>();
    CoordinatesInterface sun = this;

    /**
     * default Sun constructor
     * @param args
     */
    public Sun(String[] args) {
        super(args);
    }

    /**
     * get x coordinate
     * @return  x coordinate
     */
    @Override
    public int getx() {
        return x;
    }

    /**
     * get y coordinate
     * @return  y coordinate
     */
    @Override
    public int gety() {
        return y;
    }

    /**
     * Override initAnimation from super class to set parameters for orbiting properties
     */
    @Override
    public void initAnimation() {
        dim = getSize();
        x = dim.width / 2;
        y = dim.height / 2;
        timer = new Timer(60, e -> repaint());
        for (int i = 0; i < 5; i++) {
            planets.add(new Planet(radius, sun, i + 1));
            //planets.get(i).setIth(i+5);
        }
    }
    @Override
    public void paint(Graphics g) {
        update(g);
    }

    /**
     * This code is taken from the in class banner code
     * implements double buffering
     * @param g graphics object to draw
     */
        @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(dim.width, dim.height);
            offscreen = image.getGraphics();
        }
        super.paint(offscreen);
        g.drawImage(image, 0, 0, this);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(color);
        g.fillOval(x -radius,y -radius,radius,radius);
        for (int i = 0; i < 5; i++) {
            planets.get(i).draw(g);
        }
    }
}
