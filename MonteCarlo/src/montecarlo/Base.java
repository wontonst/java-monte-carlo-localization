/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author RoyZheng
 */
public class Base extends JFrame implements KeyListener {
    
    Gui gui;
    MonteCarlo algo;
    
    public Base() {
        this.gui = new Gui();
        this.algo = new MonteCarlo(gui.getParticles(), gui.getRobot(), gui.getSensor(),this.gui);
        this.add(gui);
        this.addKeyListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Gui.DIM_X + 20, Gui.DIM_Y + 30);
        this.setVisible(true);
    }
    
    public boolean isValidKey(KeyEvent k) {
        switch (k.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                return true;
            default:
                return false;
        }
    }
    
    public static KeyboardInput keyEventToKeyboardInput(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                return KeyboardInput.UP;
            case KeyEvent.VK_DOWN:
                return KeyboardInput.DOWN;
            case KeyEvent.VK_LEFT:
                return KeyboardInput.LEFT;
            case KeyEvent.VK_RIGHT:
                return KeyboardInput.RIGHT;
            case KeyEvent.VK_W:
                return KeyboardInput.W;
            case KeyEvent.VK_A:
                return KeyboardInput.A;
            case KeyEvent.VK_S:
                return KeyboardInput.S;
            case KeyEvent.VK_D:
                return KeyboardInput.D;
            default:
                return null;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (this.isValidKey(e)) {
            System.out.println("Running MonteCarlo");
            this.algo.runOnce(keyEventToKeyboardInput(e));
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
