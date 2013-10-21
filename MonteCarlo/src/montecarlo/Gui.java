/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JPanel;

/**
 * Make sure you run setParticles, setRobotPosition, and setRobot, and
 * setSensorAnims before you use.
 *
 * @author RoyZheng
 */
public class Gui extends JPanel {
    
    public static int PARTICLE_WIDTH = 1;
    public static int ROBOT_WIDTH = 3;
    public static int DIM_X = 800;
    public static int DIM_Y = 800;
    List<Particle> particles;//list of particles to draw
    Robot robot;//robot to draw
    List<Sensor> sensor_animations;//list of sensor animations to draw (sensor = a line going from robot to wall)

    public void setParticles(List<Particle> p) {
        this.particles = p;
    }
    
    public void setRobot(Robot p) {
        this.robot = p;
    }
    
    public void setSensorAnims(List<Sensor> p) {
        this.sensor_animations = p;
    }
    
    public void getValues(){
        
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, DIM_X, DIM_Y);
        
        g2d.setColor(Color.BLACK);
        for (Particle p : this.particles) {
            this.drawParticle(p.getPoint(), g2d);
        }
        g2d.setColor(Color.RED);
        this.drawRobot(g2d);
        g2d.setColor(Color.BLUE);
        for (Sensor sa : this.sensor_animations) {
            this.drawSensorAnimation(sa, g2d);
        }
    }
    
    private void drawParticle(Point p, Graphics2D g) {
        g.drawOval(p.x(), p.y(), PARTICLE_WIDTH, PARTICLE_WIDTH);
    }
    
    private void drawSensorAnimation(Sensor sa, Graphics2D g) {
    }

    private void drawRobot(Graphics2D g) {
        g.drawOval(this.robot.x(), this.robot.y(), ROBOT_WIDTH, ROBOT_WIDTH);
    }
}
