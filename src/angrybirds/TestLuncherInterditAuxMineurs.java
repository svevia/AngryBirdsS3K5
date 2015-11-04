package angrybirds;

import static angrybirds.Constante.iniz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Un luncher uniquement fait pour le background, ce lucnher rajoute quelques
 * trucs utiles qu'il fait essayer pour comprendre
 */
public class TestLuncherInterditAuxMineurs extends JFrame implements ActionListener {

    /**
     * Ici tu rentre ta courbe
     */
    private double a = 0.0009, b = -0.6, c = 450;

    /**
     * Le jeu sous son magnifique panel double bufferise, pimpe et tout
     */
    private AnimationOiseau jeu = new AnimationOiseau(a, b, c);
    //private AnimationOiseau jeu = new AnimationOiseau(0, 0, 450);

    private JDialog control = new JDialog();

    /**
     * Le jolie panel des admin flambant neuf
     */
    private JPanel adminPanel = new JPanel();

    /**
     * Et ses boutons
     */
    private JButton pause = new JButton("Pause");

    /**
     * Boolean pour savoir si le jeu est en pause
     */
    private boolean waiting = false;

    {
        setSize(Constante.fenetre.getSize());
        setDefaultCloseOperation(3);
        setContentPane(jeu);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        pause.addActionListener(this);
        adminPanel.add(pause);

        control.setVisible(true);
        control.setDefaultCloseOperation(2);
        control.setContentPane(adminPanel);
        control.setVisible(true);
        control.setLocationRelativeTo(null);
        control.setResizable(true);
        control.setSize(200, 200);
    }

    /**
     *
     */
    public TestLuncherInterditAuxMineurs() {
        jeu.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (waiting) {
            jeu.getCore().run();
            pause.setText("Pause");
            waiting = false;
        } else {
            jeu.getCore().stop();
            pause.setText("Play");
            waiting = true;
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        iniz();
        new TestLuncherInterditAuxMineurs();
    }

}
