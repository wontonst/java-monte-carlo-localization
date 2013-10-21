/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static montecarlo.KeyboardInput.A;
import static montecarlo.KeyboardInput.D;
import static montecarlo.KeyboardInput.DOWN;
import static montecarlo.KeyboardInput.LEFT;
import static montecarlo.KeyboardInput.RIGHT;
import static montecarlo.KeyboardInput.S;
import static montecarlo.KeyboardInput.UP;
import static montecarlo.KeyboardInput.W;

/**
 *
 * @author RoyZheng
 */
public class MonteCarlo {

    private void monteCarlo() {
        //WRITE YOUR CODE TO UPDATE EVERYTHING HERE
        switch (this.last_input) {//handle user input
            case W:
                break;
            case A:
                break;
            case S:
                break;
            case D:
                break;
            case UP:
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
        }
        //update particles

    }
    
    
    private void generateInitialParticles() {
        java.util.Random rand;
        rand = new java.util.Random();
        for (int i = 0; i != 100; i++) {
            this.particles.add(new Particle(rand.nextInt(Gui.DIM_X) + 1, rand.nextInt(Gui.DIM_Y) + 1));
        }
    }
    
    
    
    
    
    
    
    
    
    List<Particle> particles;
    Robot robot;
    Sensor sensor;
    Gui gui;
    KeyboardInput last_input;

    public MonteCarlo(List<Particle> particles, Robot robo, Sensor sense, Gui g) {
        this.particles = particles;
        this.robot = robo;
        this.sensor = sense;
        this.gui = g;
        this.generateInitialParticles();
    }

    public void runOnce(KeyboardInput ki) {
        this.last_input = ki;
        this.monteCarlo();
        this.gui.repaint();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Base b = new Base();


    }
}
