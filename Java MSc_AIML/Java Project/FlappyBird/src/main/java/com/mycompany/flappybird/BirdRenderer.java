/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flappybird;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author chinm
 */
public class BirdRenderer extends JPanel{
      private static final long serialVersionUID = 1L; // For warning.

    // Recursive, to continue rendering itself, when looped.
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g); // Calls method from parent class (JPanel, which is extended to this class).
        FlappyBird.flappybird.repaint(g);
    }    
    
}