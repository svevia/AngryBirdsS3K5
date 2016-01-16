package angrybirds.jeu.core;

import static angrybirds.Constante.*;
import static modele.Visualisateur.*;
import java.awt.Graphics;
import java.util.Stack;

public class VisualCore extends Thread {

    Stack<Integer> stack = new Stack<>();

    /**
     * Si la cible doit etre dessine
     */
    public boolean paintCible = false;

    /**
     * L'endroit ou la cible sera dessine
     */
    public int xTarget, yTarget;

    public VisualCore() {
        stack.push(1);
        setName("Romane la photographe");
    }

    /**
     * Une fois lance, le visu ne fera plus qu'afficher sans arret
     */
    @Override
    public void run() {
        while (!stack.empty()) {
            if (stack.pop() == 1) {
                try {
                    stack.push(1);
                    screen.repaint();
                    sleep(FPS60);
                } catch (InterruptedException ex) {
                    System.out.println("I can't see, I can't see, I'm going blind..." + ex.getMessage() + "\n");
                }
            }
        }
//        showMe();
    }

    // A l'époque, on  utilisais une récursivité, désormais on utilise notre propre stack
    
//    /**
//     * Fonction recursive qui affiche toute les 'xx' ms le jeu sur le panel
//     */
//    private void showMe() {
//        try {
//            screen.repaint();
//            sleep(FPS60);
//            showMe(); // The wave can't stop ♪♫♪...
//        } catch (InterruptedException | StackOverflowError ex) {
//            System.out.println("I can't see, I can't see, I'm going blind..." + ex.getMessage() + "\n");
//        }
//    }
    /**
     * Dessine le visuel sur le graphics
     *
     * @param g Le graphics qui recoit
     * @return Le graphics modifie
     */
    public Graphics draw(Graphics g) {
        // Attention les choses se repaint les unes sur les autres
        g = drawFond(g);
        g = drawFootstep(3, (int) vitesse + 3, g);
        g = drawObstacle(g);
        if (bird != null) {
            g = drawCurve(g, bird.getCourbe());
            g = drawOiseau(g);
        }
        g = drawAllHitBox(g); // A décommenter si vous voulez voir l'envers du décors
        g = drawAnimation(g);
        if (paintCible) {
            try {
                g = drawTarget(g, screen.getMousePosition().x, screen.getMousePosition().y, xTarget, yTarget);
            } catch (NullPointerException e) {
            }
        }
        return g;
    }
}
