package skin;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * L'enumeration qui contient tout les skins d'empreinte et les fonctions associeb
 */
enum Footstep {

    NONE(),
    ROUGE(Color.red),
    NOIR(Color.black),
    ARCENCIEL(Color.magenta, Color.blue, Color.cyan, Color.green, Color.yellow, Color.ORANGE, Color.red),
    GAY(Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta),
    ROSE(Color.pink),
    RAZER(Color.black, new Color(2, 255, 4), Color.black),
    NEERLANDE(Color.red, Color.red, Color.white, Color.white, Color.blue, Color.blue),
    USA(Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red, Color.white, Color.red);

    private Color[] c;

    Footstep(Color... c) {
        this.c = c;
    }

    public Color[] getC() {
        return c;
    }

    public Graphics drawFootstep(ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Double> a, int tailSize, Graphics g) {
        int[] xP = new int[4], yP = new int[4];
        int i = (x.size() - tailSize < 0)?0:x.size() - tailSize;
        for (i = i; i < x.size(); i++) {
            for (int j = 0; j < c.length; j++) {
                g.setColor(c[j]);
                xP[0] = x.get(i);
                xP[1] = x.get(i) + 3;
                xP[2] = x.get(i) + 3;
                xP[3] = x.get(i);
                yP[0] = y.get(i) + j * 3;
                yP[1] = (int) (y.get(i) + a.get(i)) + j * 3;
                yP[2] = (int) (y.get(i) + a.get(i)) + 3 + j * 3;
                yP[3] = y.get(i) + 3 + j * 3;
                g.fillPolygon(xP, yP, 4);
            }
        }
        return g;
    }
}
