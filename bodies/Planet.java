package bodies;

import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Planet extends Orbit implements CoordinatesInterface {

    int speed = ThreadLocalRandom.current().nextInt(1, 10);
    int dist = ThreadLocalRandom.current().nextInt(40, 60);
    int numberOfMoons = ThreadLocalRandom.current().nextInt(0, 4);
    List<Moon> moons = new ArrayList<>();

    /**
     * planet constructor
     * @param radius    platen radius (will be modified later)
     * @param orbiting  instance of interface object
     * @param ithPlanet planet number given when created
     */
    public Planet(int radius, CoordinatesInterface orbiting, int ithPlanet) {
        super(orbiting, radius);
        this.rad = radius / (speed + 1);
        this.orbiting = orbiting;
        this.ith = ithPlanet;
        x = orbiting.getx();
        y = orbiting.gety();
        if (speed < 8) {
            for (int i = 0; i < numberOfMoons; i++) {
                moons.add(new Moon(rad, this, i + 1));
            }
        }
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
     * draw planet
     * @param g Graphics object to draw to
     */
    public void draw(Graphics g) {
        //super.ith = ith;
        x =calculateX(dist);
        y = calculateY(dist);

        g.setColor(color);
        g.fillOval(x - rad/2, y - rad/2, rad, rad);
        super.angle += speed;
        if (speed < 8) {
            for (Moon moon : moons) {
                moon.draw(g);
            }
        }
     }
}
