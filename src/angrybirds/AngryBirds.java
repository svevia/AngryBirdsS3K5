package angrybirds;

public class AngryBirds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {new AnimationOiseau(0, 0.001, -1, 350).setVisible(true);} catch (Exception e){System.out.println("CA MARCHE PAS !!!");}

    }

}
