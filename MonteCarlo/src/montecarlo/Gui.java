/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Make sure you run setParticles, setRobotPosition, and setRobot, and
 * setSensorAnims before you use.
 *
 * @author RoyZheng
 */
public class Gui extends JPanel {

    public static int SENSOR_WIDTH = 2;
    public static int PARTICLE_WIDTH = 1;
    public static int ROBOT_WIDTH = 3;
    public static int DIM_X = 800;
    public static int DIM_Y = 800;
    List<Particle> particles;//list of particles to draw
    Robot robot;//robot to draw
    Sensor sensor;//sensor animations to draw (sensor = a line going from robot to wall)

    public Gui() {
        this.particles = new ArrayList<Particle>();
        this.robot = new Robot(DIM_X / 2, DIM_Y / 2);
        this.sensor = new Sensor(this.robot);
        this.setSize(DIM_X, DIM_Y);
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
        this.drawSensor(g2d);
    }

    private void drawParticle(Point p, Graphics2D g) {
        g.drawOval(p.x(), p.y(), PARTICLE_WIDTH, PARTICLE_WIDTH);
    }

    private void drawSensor(Graphics2D g) {
        SensorEnum dir = this.sensor.getFireDirection();
        if (dir != null) {
            switch (dir) {
                case NORTH:
                    g.drawRect(this.robot.getPoint().x(), 0, SENSOR_WIDTH, this.robot.getPoint().y());
                    break;
                case SOUTH:
                    g.drawRect(this.robot.getPoint().x(), this.robot.getPoint().y(), SENSOR_WIDTH, DIM_Y - this.robot.getPoint().y());
                    break;
                case EAST:
                    g.drawRect(this.robot.getPoint().x(), this.robot.getPoint().y(), DIM_X - this.robot.getPoint().x(), SENSOR_WIDTH);
                    break;
                case WEST:
                    g.drawRect(0, this.robot.getPoint().y(), this.robot.getPoint().x(), SENSOR_WIDTH);
                    break;
            }
        }
    }

    private void drawRobot(Graphics2D g) {
        g.drawOval(this.robot.getPoint().x(), this.robot.getPoint().y(), ROBOT_WIDTH, ROBOT_WIDTH);
    }

    public List<Particle> getParticles() {
        return this.particles;
    }

    public Robot getRobot() {
        return this.robot;
    }

    public Sensor getSensor() {
        return this.sensor;
    }
}
