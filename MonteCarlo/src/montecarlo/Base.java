/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import javax.swing.JFrame;

/**
 *
 * @author RoyZheng
 */
public class Base extends JFrame {

    Gui gui;
    MonteCarlo algo;

    public Base() {
        this.algo = new MonteCarlo();
        
        
        this.gui = new Gui();
        this.add(gui);
        
    }
}
