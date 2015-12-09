package installateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Installateur extends JFrame implements ActionListener {

    JFileChooser chooser = new JFileChooser();
    private static String OS = System.getProperty("os.name").toLowerCase();

    public Installateur() {
        setTitle("Ou installer Angry Birds");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        add(chooser);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.addActionListener(this);
        chooser.setDoubleBuffered(true);
        chooser.setMultiSelectionEnabled(false);
        
        if (isUnix()) {
            chooser.setCurrentDirectory(new File("$HOME"));
        }
        if (isWindows()) {
            chooser.setCurrentDirectory(new File("$HOME"));
        }
        if (isMac()) {
            chooser.setCurrentDirectory(new File("$HOME"));
        }
        if (isSolaris()) {
            chooser.setCurrentDirectory(new File("$HOME"));
        }

        setSize(500, 500);
    }

    public static void main(String[] args) {
        new Installateur();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CancelSelection")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("ApproveSelection")) {
            System.out.println(chooser.getSelectedFile());
        }
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }

}
