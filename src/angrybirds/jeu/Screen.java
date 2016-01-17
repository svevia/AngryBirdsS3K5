package angrybirds.jeu;

import static angrybirds.Constante.*;
import angrybirds.jeu.core.HeartCore;
import angrybirds.jeu.core.HeartMoveBird;
import java.awt.Graphics;
import angrybirds.jeu.core.VisualCore;
import entites.bird.power.Power;
import entites.obstacle.ImpactOrder;
import entites.target.TargetListener;
import javax.swing.JPanel;

/**
 * La classe principale du programme la ou se consentre aussi le visualisateur
 * du jeu, le moteur de collision, le thread principal du jeu et la courbe
 * engage par l'oiseau
 */
public class Screen extends JPanel {

    /**
     * Le visualisateur qui gere l'affichage des skins sur le plan
     */
    public VisualCore visu;

    /**
     * Thread de l'animation (gere les deplacements et l'affichage du jeu au
     * niveau des calculs)
     */
    private HeartCore core;

    public Screen() {
        vitesse = 5;
        setFocusable(true);
        setDoubleBuffered(true); // Un bel affichage en HD !!!
        visu = new VisualCore(); // Gestionnaire d'affichage, plus souvent appellé "le visu"
        visu.setDaemon(true);
        // Le gestionnaire de calcul, le coeur, est remit a plus tard desormais (rf order277)
    }

    /**
     * Demmarrage de l'animation
     */
    public void start() {
        addMouseListener(new TargetListener(visu));
        bird = pigeons.get(essai).type; // A tester
        bird.setX(pigeons.get(essai).x); // A tester
        bird.setY(pigeons.get(essai).y); // A tester
        visu.start(); // L'affichage
    }

    public void restart() {
        addMouseListener(new TargetListener(visu));
        entityHitty = 0;
        ImpactOrder.lastObstacleRebond = null;
        essai++;
        bird = pigeons.get(essai).type;
        bird.setX(pigeons.get(essai).x);
        bird.setY(pigeons.get(essai).y);
        // La staticite fait mal les choses finalement...
        HeartMoveBird.internalTime = 0;
    }

    /**
     * Le painteur du jeu, simplifie grace au visu'
     *
     * @param g Le graphics sur le quelle dessiner
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g = visu.draw(g);
    }

    /**
     * Aucun retrait n'est permis desormais, vous venez de vous lancer dans une
     * grande aventure, enjoy it ! Fly away !
     */
    public void oder227() {
        for (Power p : bird.getPower()) {
            addKeyListener(p);
        }
        core = new HeartCore();
        last = false;
        if (!core.isAlive()) {
            core.start();
        }
    }
}
