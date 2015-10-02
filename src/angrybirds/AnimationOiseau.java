package angrybirds;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import static angrybirds.Constante.*;
import java.awt.Color;
import obstacle.Collision;

/**
 * La class principale du programme
 */
public class AnimationOiseau extends JFrame {

    /**
     * Position du pigeon en x
     */
    int x;

    /**
     * Position du pigeon en y
     */
    int y;

    /**
     * Le nombre d'incrementation de x par boucle du thread
     */
    int stepByX = 3;

    /**
     * Thread de l'animation
     */
    Thread fred = new Thread(new avancement(20));

    /**
     * Courbe qu'aura le pigeon, qui prendra ses paramètres dans le constructeur
     */
    Courbe courbe;

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
     * Gestion des collisions
     */
    Collision coll = new Collision();

    /**
     * Constructeur prenant en parametre le point de depart du pigeon et sa
     * courbe
     *
     * @param x point de depart en x
     * @param a ax²
     * @param b + bx
     * @param c + c
     */
    public AnimationOiseau(int x, double a, double b, double c) {
        this.x = x;
        courbe = new Courbe(a, b, c);
        start();
    }

//    public AnimationOiseau() {
//        menuDeDemarrage mdd = new menuDeDemarrage();
//    }
    {
        setTitle("Angry Fly");
        setResizable(false);
        setSize(fenetre);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
    }

    /**
     * Demmarrage de l'animation
     */
    public final void start() {
        Constante.inizObstacle();
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
        footstepY.add(y + bird.getR());
        footstepA.add(courbe.getCoefficientDirecteur(x));
        g.drawImage(fond.getFond(), 0, 0, null);
        g = footstep.drawFootstep(footstepX, footstepY, footstepA, bird.getR() / 2 + 20, g); // Dessine le trace
        g = bird.draw(x, y, courbe.angleNext(x), g); // Dessine le pigeon
        for (int i = 0; i < obstacle.size(); i++) {
            g = obstacle.get(i).drawMe(g);
        }
        // Si la distance de x et y depassent la fenetre
        if (x + bird.getR() * 2 > fenetre.getWidth() || y + bird.getR() * 2 > fenetre.getHeight() - 50) {
            arret();
        }
    }

    /**
     * Arrete le thread du jeu et relance un nouveau jeu
     */
    void arret() {
        fred.stop();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Probleme de sommeil\n" + ex.getMessage());
        }
        AngryBirds.p.run();
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
                int x1 = x - bird.getR(), x2 = x + bird.getR(), y1 = y - bird.getR(), y2 = y + bird.getR();
                // Ce try/catch renferme a peu pres tout le traitement pour que le 
                // repaint se passe sans "encombre"
                try {
                    if (x > 15) {
                        if (y < 15) {
                            repaint(0, 0, 800, y2 + 25);
                            System.out.println(y2);
                        } else {
                            repaint(x1, y1, x2, y2);
                        }
                    } else {
                        x1 = 0;
                        x2 = 800;
                        y1 = 0;
                        y2 = 600;
                        repaint(x1, y1, x2, y2);
                    }
                    Thread.sleep(vitesse);
                } catch (InterruptedException e) {
                    System.out.println("Fred a un soucis :(\n" + e.getMessage());
                }
                int tmp = coll.entityHit();
                if (tmp != 0) {
                    bird.setCorps(Color.BLACK);
                    obstacle.get(tmp).setC(Color.BLACK);
                    repaint();
                    arret();
                }
            }
        }
    }

//    class menuDeDemarrage extends JDialog implements ActionListener {
//
//        private JPanel pMain = new JPanel(new BorderLayout(1, 3)), p1 = new JPanel(), p2 = new JPanel();
//        private JLabel courbeEtA = new JLabel("Courbe : a -> "), B = new JLabel("b ->"), C = new JLabel("c ->"), departEtX = new JLabel(" - Demarre en x ->");
//        private JTextArea aT = new JTextArea("0.002"), bT = new JTextArea("-1.7"), cT = new JTextArea("400"), xT = new JTextArea("0");
//        private JButton start = new JButton("Demarrer"), rez = new JButton("RaZ"), essai = new JButton("Tester");
//
//        {
//            setSize(800, 200);
//            setLocationRelativeTo(null);
//            setDefaultCloseOperation(2);
//            setVisible(true);
//
//            start.addActionListener(this);
//
//            p1.add(courbeEtA);
//            p1.add(aT);
//            p1.add(B);
//            p1.add(bT);
//            p1.add(C);
//            p1.add(cT);
//            pMain.add("North", p1);
//            p2.add(start);
//            p2.add(rez);
//            p2.add(essai);
//            pMain.add("South", p2);
//            add(pMain);
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == start) {
//                x = Integer.parseInt(xT.getText());
//                courbe = new Courbe(Integer.parseInt(aT.getText()), Integer.parseInt(bT.getText()), Integer.parseInt(cT.getText()));
//                start();
//            }
//        }
//    }
}
