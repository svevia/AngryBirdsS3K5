/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication32;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author lefevrew
 */
public class AnimationOiseau extends JFrame {

    int x, y;
    Thread fred = new Thread(new avancement(30));

    /**
     * Constructeur prenant en parametre le point de depart du pigeon
     *
     * @param x
     * @param y
     */
    public AnimationOiseau(int x, int y) {
        this.x = x;
        this.y = y;
        setVisible(true);
        setSize(800, 400);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
    }

    {
        fred.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g = oiseau(x, y, g, 0, 0);
        if (x > 400) {
            fred.stop();
        }
    }

    /**
     * Le thread de l'animation
     */
    class avancement implements Runnable {

        int vitesse;
        
        public avancement(int vitesse) {
            this.vitesse = vitesse;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    x += 2;
                    repaint();
                    Thread.sleep(vitesse);
                } catch (InterruptedException ex) {
                    System.out.println("sa ne marche pas");
                }
            }
        }
    }

    Graphics oiseau(int posX, int posY, Graphics g, int directionX, int directionY) {
        int[] polyX = {posX + 20, posX + 20, posX + 30};
        int[] polyY = {posY + 4, posY + 16, posY + 16 - 4 / 2};
        g.setColor(Color.red);
        g.fillOval(posX, posY, 20, 20);
        g.setColor(Color.black);
        g.fillPolygon(polyX, polyY, 3);
        g.fillOval(posX + 15, posY + 5, 2, 2);
        return g;
    }
}
