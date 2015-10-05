package angrybirds;

import java.awt.Graphics;
import javax.swing.JFrame;
import static angrybirds.Constante.*;
import obstacle.Collision;

/**
 * La class principale du programme
 */
public class AnimationOiseau extends JFrame {

    /**
     * Le visualisateur
     */
    private Visualisateur visu;

    /**
     * Gestionnaire de collision
     */
    private Collision stun;

    /**
     * Thread de l'animation
     */
    private Thread core;

    /**
     * Position du pigeon en x
     */
    private int x;

    /**
     * Position du pigeon en y
     */
    private int y;

    /**
     * L'angle de l'oiseau
     */
    private double a;

    /**
     * Courbe qu'aura le pigeon, qui prendra ses parametres dans le constructeur
     */
    private Courbe courbe;

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
    }

    /**
     * Initializer, initialisant la class
     */
    {
        setTitle("Angry Fly Test : " + angrybirds.AngryBirds.p.i);
        setResizable(false);
        setSize(fenetre);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        visu = new Visualisateur(); // Gestionnaire d'affichage
        stun = new Collision(); // Gestionnaire de collision
        core = new Thread(new HeartCore(40, 7)); // Gestionnaire d'evenement
    }

    /**
     * Demmarrage de l'animation
     */
    public final void start() {
        core.start();
    }

    /**
     * Arrete le thread du jeu et relance un nouveau jeu
     */
    void arret() {
        core.stop();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Probleme de sommeil\n" + ex.getMessage());
        }
        AngryBirds.p.run();
    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        y = (int) courbe.getYenX(x);
        a = courbe.angleNext(x);
        addFootstepCoord();
        g = visu.drawFond(g);
        g = visu.drawFootstep(false, 5, g);
        g = visu.drawOiseau(x, y, a, g);
        g = visu.drawObstacle(g);
    }
    
    /**
     * Fonction qui ajoute les coordonnes actuel a une liste
     */
    private void addFootstepCoord() {
        footstepX.add(x);
        footstepY.add(y + bird.getR());
        footstepA.add(courbe.getCoefficientDirecteur(x));
    }

    /**
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Incremente x de i
     *
     * @param i L'incrementeur
     */
    public void incrementeX(int i) {
        this.x += i;
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
