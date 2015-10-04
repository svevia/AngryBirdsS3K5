package skin;

import java.awt.Color;
import java.awt.Graphics;
import static angrybirds.Constante.*;

/**
 * L'enumeration qui contient tout les skins d'empreinte et les fonctions associeb
 */
public enum Footstep {

    NONE(),
    ROUGE(Color.red),
    NOIR(Color.black),
    ARCENCIEL(Color.magenta, Color.blue, Color.cyan, Color.green, Color.yellow, Color.ORANGE, Color.red),
    GAY(Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta),
    ROSE(Color.pink),
    RAZER(Color.black, new Color(2, 255, 4), Color.black),
    NEERLANDE(Color.red, Color.red, Color.white, Color.white, Color.blue, Color.blue),
    USA(Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red);

    /**
     * La liste des couleurs du skin
     */
    private Color[] c;

    /**
     * Constructeur prenant en parametre une liste de couleurs
     * @param c 
     */
    Footstep(Color... c) {
        this.c = c;
    }

    /**
     * Return un tableau des couleurs d'un skin
     * @return 
     */
    public Color[] getC() {
        return c;
    }

    /**
     * Dessinne une partie des empreintes
     * @param x La liste des points en x
     * @param y La liste des point en y
     * @param a La liste des angles de chaque pas
     * @param part Nombre de pas a dessiner a partir de l'entite
     * @param g Graphique sur le quel il s'applique
     * @return 
     */
    public Graphics drawFootstep(int part, Graphics g) {
        int[] xP = new int[4], yP = new int[4];
        int i = (footstepX.size() - part < 0)?0:footstepX.size() - part;
        for (i = i; i < footstepX.size(); i++) {
            for (int j = 0; j < c.length; j++) {
                g.setColor(c[j]);
                xP[0] = footstepX.get(i);
                xP[1] = footstepX.get(i) + 3;
                xP[2] = footstepX.get(i) + 3;
                xP[3] = footstepX.get(i);
                yP[0] = footstepY.get(i) + j * 3;
                yP[1] = (int) (footstepY.get(i) + footstepA.get(i)) + j * 3;
                yP[2] = (int) (footstepY.get(i) + footstepA.get(i)) + 3 + j * 3;
                yP[3] = footstepY.get(i) + 3 + j * 3;
                g.fillPolygon(xP, yP, 4);
            }
        }
        return g;
    }
    
    /**
     * Dessinne toute les empreintes
     * @param x La liste des points en x
     * @param y La liste des point en y
     * @param a La liste des angles de chaque pas
     * @param g Graphique sur le quel il s'applique
     * @return 
     */
    public Graphics drawAllFootstep(Graphics g) {
        int[] xP = new int[4], yP = new int[4];
        for (int i = 0; i < footstepX.size(); i++) {
            for (int j = 0; j < c.length; j++) {
                g.setColor(c[j]);
                xP[0] = footstepX.get(i);
                xP[1] = footstepX.get(i) + 3;
                xP[2] = footstepX.get(i) + 3;
                xP[3] = footstepX.get(i);
                yP[0] = footstepY.get(i) + j * 3;
                yP[1] = (int) (footstepY.get(i) + footstepA.get(i)) + j * 3;
                yP[2] = (int) (footstepY.get(i) + footstepA.get(i)) + 3 + j * 3;
                yP[3] = footstepY.get(i) + 3 + j * 3;
                g.fillPolygon(xP, yP, 4);
            }
        }
        return g;
    }}
