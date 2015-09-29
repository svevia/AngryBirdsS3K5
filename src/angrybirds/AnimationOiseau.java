package angrybirds;

import skin.Footstep;
import skin.*;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import skin.RougeGorge;

public class AnimationOiseau extends JFrame {

    /**
     * Position du pigeon en x
     */
    int x, y;

    /**
     * Le nombre d'incrementation de x par boucle du thread
     */
    int stepByX = 3;

    /**
     * Thread de l'animation
     */
    Thread fred = new Thread(new avancement(50));

    /**
     * Courbe qu'aura le pigeon, qui prendra ses paramètres dans le constructeur
     */
    CourbeBeta courbe;

    /**
     * Liste des points de passages du pigeon en x
     */
    ArrayList<Integer> footstepX = new ArrayList<>();

    /**
     * Liste des points de passages du pigeon en y
     */
    ArrayList<Integer> footstepY = new ArrayList<>();

    /**
     * Liste des angles en x fait par le pigeon
     */
    ArrayList<Double> footstepA = new ArrayList<>();

    /**
     * L'oiseau choisi
     */
    Oiseau o = new RougeGorge();

    /**
     * La couleur du trace choisi
     */
    Footstep f = Footstep.ARCENCIEL;

    /**
     * Constructeur prenant en parametre le point de depart du pigeon et sa
     * courbe
     *
     * @param x
     * @param a
     * @param b
     * @param c
     */
    public AnimationOiseau(int x, double a, double b, double c) {
        this.x = x;
        courbe = new CourbeBeta(a, b, c);
        setTitle("Angry Fly");
        setResizable(false);
        setSize(800, 400);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
    }

    /**
     * Demarrage de l'animation
     */
    {
        fred.start();
    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        x += stepByX;
        y = (int) courbe.getYenX(x);
        // Ajout de coordonnees au trace
        footstepX.add(x); 
        footstepY.add(y + o.getR());
        footstepA.add(courbe.getCoefficientDirecteur(x));
        // Si la distance de x est plus grande que 800
        if (x > 800) {
            fred.stop();
        }
        g = f.drawFootstep(footstepX, footstepY, footstepA, g); // Dessine le trace
        g = o.draw(x, y, courbe.angleNext(x), g); // Dessine le pigeon
    }

    /**
     * La classe du thread de l'animation
     */
    class avancement implements Runnable {

        /**
         * En milliseconde, le temps entre 2 pas (ou deux battements d'ailes)
         */
        int vitesse;

        /**
         *
         * @param vitesse
         */
        public avancement(int vitesse) {
            this.vitesse = vitesse;
        }

        /**
         * Le run avance le x, repaint et attends un peu
         */
        @Override
        public void run() {
            while (true) {
                try {
                    repaint();
                    Thread.sleep(vitesse);
                } catch (InterruptedException ex) {
                    System.out.println("Fred a un soucis :( ");
                }
            }
        }
    }
}
