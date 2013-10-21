/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import java.util.List;

/**
 *
 * @author RoyZheng
 */
public class MonteCarlo {

    List<Particle> particles;
    Robot robot;
    Sensor sensor;
    Gui g;

    public List<Particle> getParticles() {
        return this.particles;
    }

    public Robot getRobot() {
        return this.robot;
    }

    public Sensor getSensor() {
        return this.sensor;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
