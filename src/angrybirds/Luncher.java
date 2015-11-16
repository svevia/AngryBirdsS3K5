package angrybirds;

import javax.swing.JFrame;

/**
 * La fenetre du jeu
 */
public class Luncher extends JFrame {

    /**
     * Le jeu sous panel
     */
    private AnimationOiseau jeu;

    /**
     *
     * @param serieNum
     * @param totalSeries
     * @param c
     */
    public Luncher() {
        jeu = new AnimationOiseau();
        setDefaultCloseOperation(3);
        setResizable(false);
        setContentPane(jeu);
        setSize(Constante.fenetre.getSize());
        setLocationRelativeTo(null);
        setVisible(true);

        setTitle("Angry Birds");
    }
}
