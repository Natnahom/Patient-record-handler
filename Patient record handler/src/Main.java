//import java.util.InputMismatchException;
//import java.util.Scanner;

//import java.awt.*;
import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


//        addToClasspath();
        new mainFunc();

        // Connection connection = DatabaseConnection.getConnection();

        // frame.pack();
        // Border border = BorderFactory.createLineBorder(Color.GRAY, 3);

        // frame.setLayout(new GridLayout(2, 2, 10, 10));
        // label.setHorizontalTextPosition(JLabel.CENTER);
        // label.setVerticalTextPosition(JLabel.TOP);
        // label.setForeground(new Color(0xFFFFFF));
        // label.setFont(new Font("Algerian",Font.PLAIN, 35));

        // label.setIconTextGap(50);
        // label.setVerticalAlignment(JLabel.TOP);
        // label.setHorizontalAlignment(JLabel.CENTER);
        // label.setBorder(border);

        // Scanner scanner = new Scanner(System.in);

        // System.out.println("********** PATIENT RECORDS HANDLING **********");

        // System.out.println();
        // System.out.println("1. Add patient\n2. Update patient info\n3.Show all patients info\n4. Delete patient");
        // System.out.print("Enter your choice(any other key to exit): ");

        // int choice;
        // try {
        //     choice = scanner.nextInt();
        // } catch (InputMismatchException e) {
        //     System.out.println("Invalid input. Please enter a valid integer.");
        //     scanner.nextLine(); // Clear the input buffer
        //     return; // Exit the program
        // }

        // if (choice == 1){
        //     scanner.nextLine();
        //     System.out.print("First name: ");
        //     String Firstname = scanner.nextLine();
        //     System.out.print("Last name: ");
        //     String Lastname = scanner.nextLine();
        //     System.out.print("Date of birth: ");
        //     String DateOfBirth = scanner.nextLine();
        //     System.out.print("Gender(Male/Female): ");
        //     String Gender = scanner.nextLine();
        //     System.out.print("Phone Number: ");
        //     String phone = scanner.nextLine();
        //     System.out.print("Address: ");
        //     String address = scanner.nextLine();
        //     System.out.print("Email: ");
        //     String email = scanner.nextLine();
        //     System.out.print("Emergency Contact: ");
        //     String EmergencyContact = scanner.nextLine();

        //     patient p1 = new patient(Firstname, Lastname, DateOfBirth, Gender, phone, address, email, EmergencyContact);

        //     System.out.print("Past medical condition: ");
        //     String PastMedicalCondition = scanner.nextLine();
        //     System.out.print("Surgical history: ");
        //     String SurgicalHistory = scanner.nextLine();
        //     System.out.print("Allergies: ");
        //     String Allergies = scanner.nextLine();
        //     System.out.print("Current medications: ");
        //     String CurrentMedications = scanner.nextLine();
        //     System.out.print("Family medical history: ");
        //     String FamilyMedicalHistory = scanner.nextLine();

        //     p1.GetCondition(PastMedicalCondition, SurgicalHistory, Allergies, CurrentMedications, FamilyMedicalHistory);

        //     System.out.print("Blood pressure: ");
        //     float BloodPressure = scanner.nextFloat();
        //     System.out.print("Temperature: ");
        //     float Temperature = scanner.nextFloat();
        //     System.out.print("Heart rate: ");
        //     float HeartRate = scanner.nextFloat();
        //     System.out.print("Respiratory rate: ");
        //     int RespiratoryRate = scanner.nextInt();
        //     System.out.print("Height: ");
        //     float height = scanner.nextFloat();
        //     System.out.print("Weight: ");
        //     float weight = scanner.nextFloat();
        //     scanner.nextLine();
        //     System.out.print("Physical examination: ");
        //     String PhysicalExamination = scanner.nextLine();

        //     p1.GetVitalSigns(BloodPressure, Temperature, HeartRate, RespiratoryRate, height, weight, PhysicalExamination);

        //     System.out.print("Lab test: ");
        //     String LabTest = scanner.nextLine();
        //     System.out.print("MRI: ");
        //     String MRI = scanner.nextLine();
        //     System.out.print("X-Ray: ");
        //     String X_RAY = scanner.nextLine();

        //     p1.GetDiagnostics(LabTest, MRI, X_RAY);

        //     System.out.print("Prescribed medication: ");
        //     String PrescribedMedication = scanner.nextLine();
        //     System.out.print("Dosage: ");
        //     String Dosage = scanner.nextLine();
        //     System.out.print("Frequency and Instructions: ");
        //     String frequency_and_instructions = scanner.nextLine();
        //     System.out.print("Ordered diagnostic tests: ");
        //     String OrderedDiagnosticTests = scanner.nextLine();
        //     System.out.print("Referrals to specialists: ");
        //     String ReferralsToSpecialists = scanner.nextLine();
        //     System.out.print("Immunization records: ");
        //     String ImmunizationRecords = scanner.nextLine();

        //     p1.GetTreatments(PrescribedMedication, Dosage, frequency_and_instructions, OrderedDiagnosticTests, ReferralsToSpecialists, ImmunizationRecords);

        //     System.out.print("Schedule: ");
        //     String Schedule = scanner.nextLine();
        //     System.out.print("Insurance information: ");
        //     String InsuranceInfo = scanner.nextLine();
        //     System.out.print("Payment history: ");
        //     String PaymentHistory = scanner.nextLine();

        //     p1.GetBillings(Schedule, InsuranceInfo, PaymentHistory);

        //     p1.PrintInfo();


        // }
        // else if (choice == 2){
        //     System.out.println("You chose to update");
        // }
        // else if (choice == 3){
        //     System.out.println("You chose to show");
        // }
        // else if (choice == 4){
        //     System.out.println("You chose to delete");
        // }
        // else{
        //     System.out.println("You chose nothing");
        // }

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

//        button1.addActionListener(e ->
//        );

        button2.addActionListener(e -> {
            frame.setVisible(false);
            new updatePatient();
        });

//        button2.addActionListener(e ->
//        );

        button3.addActionListener(e -> {
            frame.setVisible(false);
            new showallPatients();
        });

//        button3.addActionListener(e ->
//        );

        button4.addActionListener(e -> {
            frame.setVisible(false);
            new deletePatient();

        });

//        button4.addActionListener(e ->
//        );
    }
}