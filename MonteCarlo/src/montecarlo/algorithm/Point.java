/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo.algorithm;

/**
 *
 * @author RoyZheng
 */
public class Point {

    protected int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
}