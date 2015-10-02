package angrybirds;

import java.util.Random;

public class Presentation implements Runnable {

    private Random r = new Random();
    private int i, n;

    public Presentation(int nombreSerie) {
        n = nombreSerie;
    }

    @Override
    public void run() {
        if (i < n) {
            try {
                //new AnimationOiseau(0, 0.0005, -0.5, 450 + r.nextInt(50)).setVisible(true);
                new AnimationOiseau(0, 0.0005, -0.5, 450 + r.nextInt(50)).setVisible(true);
            } catch (Exception e) {
                System.out.println("CA MARCHE PAS !!!\n" + e.toString());
            }
            i++;
        }
    }

}
