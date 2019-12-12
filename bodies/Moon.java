package bodies;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Moon extends Orbit implements CoordinatesInterface {

    int angle = ThreadLocalRandom.current().nextInt(1, 10);
    int dist = ThreadLocalRandom.current().nextInt(rad/2, rad/2+1);

    /**
     * moon constructor
     * @param radius    moon radius (will be modified later)
     * @param orbiting  instance of interface object
     * @param ithMoon   number of moon given when created
     */
    public Moon(int radius, CoordinatesInterface orbiting, int ithMoon) {
        super(orbiting, radius);
        this.ith = ithMoon;
        this.rad = radius/(angle + 1);
        this.orbiting = orbiting;
    }

    @Override
    public int getx() {
        return x;
    }

    @Override
    public int gety() {
        return y;
    }

    /**
     * draw moon
     * @param g Graphics object to draw to
     */
    public void draw(Graphics g) {
        x =calculateX(dist);
        y = calculateY(dist);

        g.setColor(color);
        g.fillOval(x - rad/2, y - rad/2, rad, rad);
        super.angle += angle;
    }
}
