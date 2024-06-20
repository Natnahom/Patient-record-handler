import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        new auth();

    }

}

class mainFunc{
    mainFunc(){
        Frame frame = new Frame();

        ImageIcon image2 = new ImageIcon("C:\\Users\\pc\\IdeaProjects\\Patient record handler\\src\\Images\\patImage2.jpg");
        ImageIcon image3 = new ImageIcon("C:\\Users\\pc\\IdeaProjects\\Patient record handler\\src\\Images\\texImage.png");
        ImageIcon image4 = new ImageIcon("C:\\Users\\pc\\IdeaProjects\\Patient record handler\\src\\Images\\patImage3.jpg");


        JButton button1 = new JButton("Add patient");
        JButton button2 = new JButton("Update patient info");
        JButton button3 = new JButton("Retrieve patients");
        JButton button4 = new JButton("Delete patient info");

        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();

        label.setIcon(image3);
        label2.setIcon(image2);
        label3.setIcon(image4);


        label.setBounds(330,0,1000,150);
        label2.setBounds(370,140,250,250);
        label3.setBounds(670,140,250,250);


        button1.setBounds(420, 400, 200, 50);
        button2.setBounds(420, 470, 200, 50);
        button3.setBounds(670, 400, 200, 50);
        button4.setBounds(670, 470, 200, 50);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        button1.addActionListener(e -> {
            frame.setVisible(false);
            new addPatient();
        });

        button2.addActionListener(e -> {
            frame.setVisible(false);
            new updatePatient();
        });

        button3.addActionListener(e -> {
            frame.setVisible(false);
            new showallPatients();
        });

        button4.addActionListener(e -> {
            frame.setVisible(false);
            new deletePatient();

        });

    }
}