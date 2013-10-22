/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo.algorithm;

import montecarlo.gui.Base;
import montecarlo.gui.Gui;
import java.util.List;
import montecarlo.gui.KeyboardInput;
import static montecarlo.gui.KeyboardInput.A;
import static montecarlo.gui.KeyboardInput.D;
import static montecarlo.gui.KeyboardInput.DOWN;
import static montecarlo.gui.KeyboardInput.LEFT;
import static montecarlo.gui.KeyboardInput.RIGHT;
import static montecarlo.gui.KeyboardInput.S;
import static montecarlo.gui.KeyboardInput.UP;
import static montecarlo.gui.KeyboardInput.W;

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
        for (int i = 0; i != 500; i++) {
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
