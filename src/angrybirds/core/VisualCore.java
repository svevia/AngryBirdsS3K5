package angrybirds.core;

import static angrybirds.Constante.FPSChose;
import static angrybirds.Constante.bird;
import static angrybirds.Constante.vitesse;
import static angrybirds.Visualisateur.drawCurve;
import static angrybirds.Visualisateur.drawFond;
import static angrybirds.Visualisateur.drawFootstep;
import static angrybirds.Visualisateur.drawObstacle;
import static angrybirds.Visualisateur.drawOiseau;
import static angrybirds.Visualisateur.drawTarget;
import angrybirds.jeu.Screen;
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
    
    /**
     * Le screen de l'animation
     */
    public Screen anim;

    /**
     * Le visu sert a gerer l'affichage sur un screen
     * @param anim  Le screen
     */
    public VisualCore(Screen anim) {
        this.anim = anim;
    }

    /**
     * Une fois lance, le visu ne fera plus qu'afficher sans arret
     */
    @Override
    public void run() {
        showMeNom();
    }

    /**
     * Fonction recursive qui affiche toute les 16 ms le jeu sur le panel
     */
    private void showMeNom() {
        try {
            anim.repaint();
            sleep(FPSChose);
            showMeNom();
        } catch (InterruptedException ex) {
            System.out.println("Oh no ! I'm blind now " + ex.getMessage());
        }
    }

    /**
     * Tout se qui sera actualise sur le screen
     * @param g Le graphics du screen
     * @return Le graphics modifie
     */
    public Graphics draw(Graphics g) {
        g = drawFond(g);
        g = drawFootstep(3, (int) vitesse + 3, g);
        g = drawOiseau(g);
        g = drawObstacle(g);
        g = drawCurve(g, bird.getCourbe());
//        g = drawAllHitBox(g);
        if (paintCible) {
            g = drawTarget(g, anim.getMousePosition().x, anim.getMousePosition().y, xTarget, yTarget);
        }
        return g;
    }

}
