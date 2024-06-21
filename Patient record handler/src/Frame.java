import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Frame(){

        this.setTitle("Patient Record Handler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100,600);
        this.setVisible(true);
        this.setLayout(null);

        ImageIcon image = new ImageIcon("C:\\Users\\pc\\IdeaProjects\\Patient record handler\\src\\Images\\patImage.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x123456));

    }
}
