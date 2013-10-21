/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

/**
 *
 * @author RoyZheng
 */
public class Robot {

    Point point;

    public Robot(int x, int y) {
        this.point = new Point(x, y);
    }
    public Point getPoint(){
        return this.point;
    }
}
