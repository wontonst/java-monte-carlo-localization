/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

/**
 *
 * @author RoyZheng
 */
public class Particle {

    Point point;

    public Particle(Point p) {
        this.point = p;
    }

    public Particle(int x, int y) {
        this.point = new Point(x, y);
    }

    public Point getPoint() {
        return this.point;
    }
}
