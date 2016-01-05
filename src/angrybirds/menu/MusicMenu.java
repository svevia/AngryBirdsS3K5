package angrybirds.menu;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class MusicMenu extends Thread {

    AudioInputStream audioInputStream = null;
    SourceDataLine line;
    boolean begin = false;

    public void run() {
        File fichier = new File("Ressource/ressource/ambianceMenu.wav");
        try {
            audioInputStream = AudioSystem.getAudioInputStream(fichier);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();
            byte bytes[] = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) {
                line.write(bytes, 0, bytesRead);
            }
        } catch (IOException io) {
            System.out.println("Fichier non trouvable");
        } catch (LineUnavailableException ex) {
            System.out.println("Erreur de lecture");
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("Mauvaise extension du fichier");
        }
    }
}
