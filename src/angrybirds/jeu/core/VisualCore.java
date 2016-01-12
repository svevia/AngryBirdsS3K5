package angrybirds.jeu.core;

import static angrybirds.Constante.*;
import static angrybirds.jeu.Visualisateur.*;
import java.awt.Graphics;

public class VisualCore extends Thread {

    /**
     * Si la cible doit etre dessine
     */
    public boolean paintCible = false;

    /**
     * L'endroit ou la cible sera dessine
     */
    public int xTarget, yTarget;

    public VisualCore() {
        setName("Romane la photographe");
    }

    /**
     * Une fois lance, le visu ne fera plus qu'afficher sans arret
     */
    @Override
    public void run() {
        showMe();
    }

    /**
     * Fonction recursive qui affiche toute les 'xx' ms le jeu sur le panel
     */
    private void showMe() {
        try {
            screen.repaint();
            sleep(FPS60);
            showMe(); // The wave can't stop ♪♫♪...
        } catch (InterruptedException | StackOverflowError ex) {
            System.out.println("I can't see, I can't see, I'm going blind..." + ex.getMessage() + "\n");
        }
    }

    /**
     * Dessine le visuel sur le graphics
     *
     * @param g Le graphics qui recoit
     * @return Le graphics modifie
     */
    public Graphics draw(Graphics g) {
        g = drawFond(g);
        g = drawFootstep(3, (int) vitesse + 3, g);
        if (bird != null) {
            g = drawOiseau(g);
            g = drawCurve(g, bird.getCourbe());
        }
        g = drawObstacle(g);
        g = drawAnimation(g);
        g = drawAllHitBox(g); // A décommenter si vous voulez voir l'envers du décors
        if (paintCible) {
            try {
                g = drawTarget(g, screen.getMousePosition().x, screen.getMousePosition().y, xTarget, yTarget);
            } catch (NullPointerException e) {
            }
        }
        return g;
    }
}
