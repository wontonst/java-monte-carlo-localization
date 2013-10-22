/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo.algorithm;

import java.util.ArrayList;
import montecarlo.gui.Base;
import montecarlo.gui.Gui;
import java.util.List;
import java.util.Random;
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
                this.sensor.stopFire();
                robot.point.y -= 20;
                moveParticles(0, -20);
                moveEstimate();
                break;
            case A:
                this.sensor.stopFire();
                robot.point.x -= 20;
                moveParticles(-20, 0);
                moveEstimate();
                break;
            case S:
                this.sensor.stopFire();
                this.robot.point.y += 20;
                moveParticles(0, 20);
                moveEstimate();
                break;
            case D:
                this.sensor.stopFire();
                this.robot.point.x += 20;
                moveParticles(20, 0);
                moveEstimate();
                break;
            case UP:
                this.sensor.stopFire();
                this.sensor.fireNorth();
                comparePointsY(calculateStandardDeviationY(robot.point.y), robot.point.y);
                moveEstimate();
                break;
            case DOWN:
                this.sensor.stopFire();
                this.sensor.fireSouth();
                comparePointsY(calculateStandardDeviationY(robot.point.y), robot.point.y);
                moveEstimate();
                break;
            case LEFT:
                this.sensor.stopFire();
                this.sensor.fireWest();
                comparePointsX(calculateStandardDeviationX(robot.point.x), robot.point.x);
                moveEstimate();
                break;
            case RIGHT:
                this.sensor.stopFire();
                this.sensor.fireEast();
                comparePointsX(calculateStandardDeviationX(robot.point.x), robot.point.x);
                moveEstimate();
                break;
        }
        //update particles

    }

    private void generateInitialParticles() {
        java.util.Random rand;
        rand = new java.util.Random();
        for (int i = 0; i != 1000; i++) {
            this.particles.add(new Particle(rand.nextInt(Gui.DIM_X) + 1, rand.nextInt(Gui.DIM_Y) + 1));
        }
    }

    public double calculateStandardDeviationX(int sense) {
        double temp = 0;
        for (int i = 0; i < particles.size(); i++) {
            temp += Math.pow(Math.abs(particles.get(i).point.x - sense), 2);
        }

        temp = temp / particles.size() - 1;
        temp = Math.sqrt(temp) / 4;

        return temp;
    }

    public double calculateStandardDeviationY(int sense) {
        double temp = 0;
        for (int i = 0; i < particles.size(); i++) {
            temp += Math.pow(Math.abs(particles.get(i).point.y - sense), 2);
        }

        temp = temp / particles.size() - 1;
        temp = Math.sqrt(temp) / 4;

        return temp;
    }

    public void comparePointsX(double sd, int sense) {
        for (int i = 0; i < particles.size(); i++) {
            if (particles.get(i).point.x > sense + sd || particles.get(i).point.x < sense - sd) {
                particles.get(i).point.x = sense + 4 * (MonteCarlo.randomDouble((int) -sd, (int) sd));
            }
        }
    }

    public void comparePointsY(double sd, int sense) {
        for (int i = 0; i < particles.size(); i++) {
            if (particles.get(i).point.y > sense + sd || particles.get(i).point.y < sense - sd) {
                particles.get(i).point.y = sense + 4 * (MonteCarlo.randomDouble((int) -sd, (int) sd));
            }
        }
    }
    
    public void moveEstimate()
    {
        int tempX =0;
        int tempY =0;
        
        for (int i =0; i<particles.size(); i++)
        {
            tempX+= particles.get(i).point.x;
            tempY+= particles.get(i).point.y;
        }
        
        tempX = tempX/particles.size();
        tempY = tempY/particles.size();
        
        this.gui.setEstimatePosition(tempX, tempY);
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

    public static int randomDouble(int min, int max) {
        Random rand = new Random();

        return (int) (min + (max - min) * rand.nextDouble());
    }
public static int OFFSET = 20;
    public void moveParticles(int xDiff, int yDiff) {
        for (int i = 0; i < particles.size(); i++) {
            int angle = randomDouble(0,360);
            double radians = angle*Math.PI/180;
            int magnitude = randomDouble(-1*OFFSET, OFFSET);
            
            particles.get(i).point.x += xDiff + Math.cos(radians)*magnitude;
            particles.get(i).point.y += yDiff + Math.sin(radians)*magnitude;
        }
        int rm = 0;
        for (int i = 0; i < particles.size(); i++) {
            if (particles.get(i).point.x >= Gui.DIM_X || particles.get(i).point.x <= 0 || particles.get(i).point.y >= Gui.DIM_Y || particles.get(i).point.y <= 0) {
                //particles.get(i).point.x = randomDouble(20,Gui.DIM_X);
                particles.remove(i);
                i--;
                rm++;
            }

        }
        List<Particle> np = new ArrayList<Particle>();
        while (rm > 0) {
            for (int i = 0; i != particles.size(); i++) {
                if (rm <= 0) {
                    break;
                }
                np.add(new Particle(particles.get(i).point.x, particles.get(i).point.y));
                rm--;
            }
        }
        this.particles.addAll(np);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Base b = new Base();


    }
}
