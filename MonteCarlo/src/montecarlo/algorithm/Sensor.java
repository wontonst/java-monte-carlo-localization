/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo.algorithm;

import montecarlo.gui.Gui;
import static montecarlo.gui.Gui.ROBOT_WIDTH;

/**
 *
 * @author RoyZheng
 */
public class Sensor {

    SensorEnum firing_direction = null;
    Robot robot;

    public Sensor(Robot r) {
        this.robot = r;
        //  this.firing_direction = SensorEnum.WEST;
    }

    public int fireNorth() {
        this.firing_direction = SensorEnum.NORTH;
        return robot.getPoint().y() + Gui.ROBOT_WIDTH / 2;
    }

    public int fireSouth() {
        this.firing_direction = SensorEnum.SOUTH;
        return Gui.DIM_Y - robot.getPoint().y() - Gui.ROBOT_WIDTH / 2;
    }

    public int fireEast() {
        this.firing_direction = SensorEnum.EAST;
        return Gui.DIM_X - robot.getPoint().x() + Gui.ROBOT_WIDTH / 2;
    }

    public int fireWest() {
        this.firing_direction = SensorEnum.WEST;
        return robot.getPoint().x() - Gui.ROBOT_WIDTH / 2;
    }

    public void stopFire() {
        this.firing_direction = null;
    }

    public SensorEnum getFireDirection() {
        return this.firing_direction;
    }
}
