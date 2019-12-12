package bodies;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.awt.Color.*;

public abstract class Orbit {

    protected int angle;
    protected  int x,y;
    protected int rad;
    protected int ith; //ith planet from the sun
    protected CoordinatesInterface orbiting;
    protected Color color = randColor();

    /**
     * Orbit constructor
     * @param orbiting  object being orbited
     * @param rad   radius of this instance
     */
    public Orbit(CoordinatesInterface orbiting, int rad) {
        this .rad = rad;
        this.orbiting = orbiting;
    }

    /**
     * calculate new x (code given on test)
     * @param distance  modifed distance wanted
     * @return  new x coordinate
     */
    public int calculateX(int distance) {
        int center = orbiting.getx();
        distance *= ith*2;
        return (int) (center + (distance) * Math.cos(Math.toRadians(angle)));
    }

    /**
     * calculate new y (code given on test)
     * @param distance  modified distance wanted
     * @return  new y coordinate
     */
    public int calculateY(int distance) {
        int center = orbiting.gety();
        distance  *=  ith*2;
        return (int) (center + (distance) * Math.sin(Math.toRadians(angle)));
    }

    /**
     * abstract class usod by moon and planet
     * this works best as an abstract class and not concrete class
     * we have more control over different colors and sizes
     * @param g Graphics object to draw on
     */
    abstract  void draw(Graphics g);

    /**
     * select a random color in array of colors
     * @return  random color
     */
    public Color randColor() {
        Color[] colors = {RED,BLUE, GRAY, ORANGE, MAGENTA, GREEN, WHITE};
        return colors[ThreadLocalRandom.current().nextInt(colors.length)];
    }
}
