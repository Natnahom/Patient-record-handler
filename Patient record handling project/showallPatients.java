import javax.swing.*;
import java.awt.*;

public class showallPatients {
    showallPatients(){
        Frame frame5 = new Frame();

        JLabel header1 = new JLabel("Showing all patients informations");

        header1.setBounds(50, 150, 1000, 50);

        header1.setFont(new Font("",Font.PLAIN, 17));
        header1.setForeground(new Color(0xFFFFFF));

        JButton Reset = new JButton("Cancel");
        Reset.setBounds(600, 600, 100, 25);

        Reset.addActionListener(e -> 
            frame5.setVisible(false)
        );
        Reset.addActionListener(e -> 
            new mainFunc()
        );

        frame5.add(header1);

        frame5.add(Reset);
    }
}
