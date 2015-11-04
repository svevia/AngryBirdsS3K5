package angrybirds;

import javax.swing.JFrame;

/**
 * La fenetre du jeu
 */
public class GameFrame extends JFrame {

    /**
     * Le jeu sous panel
     */
    private AnimationOiseau jeu;

    {
        setSize(Constante.fenetre.getSize());
        setDefaultCloseOperation(3);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     *
     * @param serieNum
     * @param totalSeries
     * @param c
     */
    public GameFrame(int serieNum, int totalSeries, Courbe c) {
        jeu = new AnimationOiseau(c);
        setContentPane(jeu);
        setTitle("Angry Birds - Essai n° : " + serieNum + "/" + totalSeries);
        jeu.start();
    }
}
