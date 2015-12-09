package angrybirds.jeu;

import modele.Courbe;
import java.awt.Graphics;
import static angrybirds.Constante.*;
import static angrybirds.jeu.HeartCore.t;
import entites.Collision;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import static ressource.PFAGReader.listePFAG;

/**
 * La classe principale du programme la ou se consentre aussi le visualisateur
 * du jeu, le moteur de collision, le thread principal du jeu et la courbe
 * engage par l'oiseau
 */
public class AnimationJeu extends JPanel implements KeyListener {

    /**
     * Le visualisateur qui gere l'affichage des skins sur le plan
     */
    private Visualisateur visu;

    /**
     * Thread des collisions (gere la partie physique du jeu)
     */
    private Collision stun;

    /**
     * Thread de l'animation (gere les deplacements et l'affichage du jeu au
     * niveau des calculs)
     */
    private HeartCore core;

    /**
     * Boolean de lancement de l'animation
     */
    boolean shoot = false;

    public AnimationJeu() {
        setFocusable(true);
        setDoubleBuffered(true); // Un bel affichage en HD
        addKeyListener(this);
        visu = new Visualisateur(); // Gestionnaire d'affichage
        stun = new Collision(); // Gestionnaire de collision
        core = new HeartCore(5, this); // Gestionnaire d'evenement
    }

    /**
     * Demmarrage de l'animation
     */
    public final void start() {
        bird.setX(gReader.positionOiseau(listePFAG().get(indexPFAGUtilise)).height);
        bird.setY(gReader.positionOiseau(listePFAG().get(indexPFAGUtilise)).width);
        lancement();
        core.start();
    }

    /**
     * Le painteur du jeu, simplifie grace au visu'
     *
     * @param g Le graphics sur le quelle dessiner
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        addFootstepCoord();
        g = visu.drawAllNeed(g);
        g = visu.drawCurve(g, bird.getCourbe());
        g = visu.drawAllHitBox(g);
        stun.run();
    }

    /**
     * Fonction qui ajoute les coordonnes actuel a une liste
     */
    private void addFootstepCoord() {
        if (bird.isMove()) {
            footstepX.add(bird.getX());
            footstepY.add(bird.getY() + bird.getR());
            footstepA.add(bird.getCourbe().angleAenT(t));
        }
    }

    /**
     * Retourne le thread du jeu
     *
     * @return Le thread du jeu
     */
    public Thread getCore() {
        return core;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Direction du lance
     */
    int k = 1;

    int u = 0;

    /**
     * Prend une touche du clavier, si on appuis sur espace, le jeu se lance,
     * les touches directionnelles permettent de regler la courbe
     *
     * @param e L'evenement pris en compte
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("ok");
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            shoot = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (bird.getA() > -1.6) {
                bird.setA(bird.getA() - 0.1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (bird.getA() < 1.6) {
                bird.setA(bird.getA() + 0.1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            k = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            k = -1;
        }
        bird.setCourbe(new Courbe(0, k, bird.getX(), 0.0009, bird.getA(), bird.getY()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void lancement() {
        while (!shoot) {
            repaint();
        }
    }
}
