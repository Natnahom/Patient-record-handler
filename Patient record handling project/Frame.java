import javax.swing.*;
import java.awt.Color;

public class Frame extends JFrame {
    Frame(){

        this.setTitle("Patient Record Handler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100,600);
        this.setVisible(true);
        this.setLayout(null);

        ImageIcon image = new ImageIcon("C:\\Users\\pc\\Desktop\\Class 8\\Object oriented programming\\Patient record handling project\\Images\\patImage.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x123456));

    }
}
