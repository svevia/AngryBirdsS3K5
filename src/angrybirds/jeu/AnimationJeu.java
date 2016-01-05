package angrybirds.jeu;

import angrybirds.Constante;
import static angrybirds.Constante.*;
import angrybirds.core.HeartCore;
import java.awt.Graphics;
import angrybirds.core.VisualCore;
import entites.target.TargetListener;
import javax.swing.JPanel;
import static modele.PFAGReader.listePFAG;

/**
 * La classe principale du programme la ou se consentre aussi le visualisateur
 * du jeu, le moteur de collision, le thread principal du jeu et la courbe
 * engage par l'oiseau
 */
public class AnimationJeu extends JPanel {

    /**
     * Le visualisateur qui gere l'affichage des skins sur le plan
     */
    private VisualCore visu;

    /**
     * Thread de l'animation (gere les deplacements et l'affichage du jeu au
     * niveau des calculs)
     */
    private HeartCore core;

    /**
     * Boolean de lancement du jeu, le jeu est separe en deux phase, la phase de
     * lancement, et la phase de jeu.
     */
    private boolean shoot = false;

    public AnimationJeu() {
        Constante.vitesse = 5;
        setFocusable(true);
        setDoubleBuffered(true); // Un bel affichage en HD !!!
        visu = new VisualCore(); // Gestionnaire d'affichage, plus souvent appellé "le visu"
        core = new HeartCore(); // Gestionnaire d'evenement, le coeur
        addMouseListener(new TargetListener(visu));
        // Ces trois potes enssemble gèrent le jeu
    }

    /**
     * Demmarrage de l'animation
     */
    public final void start() {
        bird.setX(gReader.positionOiseau(listePFAG().get(indexPFAGUtilise)).height);
        bird.setY(gReader.positionOiseau(listePFAG().get(indexPFAGUtilise)).width);
        lancement();
        // Demarre la bête
        core.start(); // Les calculs
        visu.start(); // Et l'affichage
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
     * Garde le jeu dans un etat de zombie tant que l'ordre 227 n'est pas
     * execute
     */
    private void lancement() {
        while (!shoot) {
            repaint();
        }
    }

    /**
     * Aucun retrait n'est permis desormais, vous venez de vous lancer dans une
     * grande aventure, enjoy it !
     */
    public void oder227() {
        shoot = true;
        bird.getPower().stream().forEach((p) -> {
            addKeyListener(p);
        });
    }
}
