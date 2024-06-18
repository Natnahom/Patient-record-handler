import javax.swing.*;
import java.awt.*;

public class deletePatient {
    deletePatient(){

        Frame frame4 = new Frame();

        JLabel header1 = new JLabel("Enter the patient's first name and last name then click delete");

        header1.setBounds(50, 150, 1000, 50);

        header1.setFont(new Font("",Font.PLAIN, 17));
        header1.setForeground(new Color(0xFFFFFF));

        JLabel Firstname = new JLabel("First Name ");
        JTextField FField = new JTextField();
        Firstname.setForeground(new Color(0xFFFFFF));

        JLabel Lastname = new JLabel("Last Name ");
        JTextField LField = new JTextField();
        Lastname.setForeground(new Color(0xFFFFFF));


        Firstname.setBounds(50, 250, 100, 30);
        FField.setBounds(205, 250, 200, 30);
        Lastname.setBounds(50, 350, 100, 30);
        LField.setBounds(205, 350, 200, 30);

        JButton Submit = new JButton("Delete");
        JButton Reset = new JButton("Cancel");
        Submit.setBounds(450, 500, 100, 25);
        Reset.setBounds(600, 500, 100, 25);

        Submit.addActionListener(e -> 
            System.out.println("Patient deleted successfully")
        );


        Reset.addActionListener(e -> 
            frame4.setVisible(false)
        );
        Reset.addActionListener(e -> 
            new mainFunc()
        );

frame4.add(header1);

frame4.add(Firstname);
frame4.add(FField);

frame4.add(Lastname);
frame4.add(LField);

        frame4.add(Submit);
        frame4.add(Reset);
    }
}
