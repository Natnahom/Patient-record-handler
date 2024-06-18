import javax.swing.*;
import java.awt.*;

public class updatePatient {
    updatePatient(){
        Frame frame3 = new Frame();

        JLabel Fname = new JLabel("1.First Name ");
        JLabel Lname = new JLabel("2.Last Name ");
        JLabel DateOfBirth = new JLabel("3.Date of Birth ");
        Fname.setBounds(50, 10, 100, 30);
        Lname.setBounds(50, 30, 100, 30);
        DateOfBirth.setBounds(50, 50, 100, 30);

        JLabel gender = new JLabel("4.Gender ");
        gender.setBounds(450, 10, 100, 30);
        
        JLabel phone = new JLabel("5.Phone Number ");
        phone.setBounds(450, 30, 100, 30);
        
        JLabel address = new JLabel("6.Address ");
        address.setBounds(450, 50, 100, 30);
        
        JLabel email = new JLabel("7.Email ");
        email.setBounds(50, 70, 100, 30);
        
        JLabel EmergencyContact = new JLabel("8.Emergency Contact ");
        EmergencyContact.setBounds(50, 90, 150, 30);
        
        JLabel PastMedicalCondition = new JLabel("9.Past medical condition ");
        PastMedicalCondition.setBounds(50, 110, 150, 30);
        
        JLabel SurgicalHistory = new JLabel("10.Surgical history ");
        SurgicalHistory.setBounds(50, 130, 150, 30);
        
        JLabel Allergies = new JLabel("11.Allergies ");
        Allergies.setBounds(50, 150, 100, 30);
        
        JLabel CurrentMedications = new JLabel("12.Current medications ");
        CurrentMedications.setBounds(50, 170, 150, 30);
        
        JLabel FamilyMedicalHistory = new JLabel("13.Family medical history ");
        FamilyMedicalHistory.setBounds(50, 190, 150, 30);
        
        JLabel BloodPressure = new JLabel("14.Blood pressure ");
        BloodPressure.setBounds(50, 210, 150, 30);
        
        JLabel Temperature = new JLabel("15.Average temperature ");
        Temperature.setBounds(850, 10, 150, 30);
        
        JLabel HeartRate = new JLabel("16.Heart rate ");
        HeartRate.setBounds(450, 70, 150, 30);
        
        JLabel RespiratoryRate = new JLabel("17.Respiratory rate ");
        RespiratoryRate.setBounds(450, 90, 150, 30);
        
        JLabel height = new JLabel("18.Height ");
        height.setBounds(450, 110, 100, 30);
        
        JLabel weight = new JLabel("19.Weight ");
        weight.setBounds(450, 130, 100, 30);
        
        JLabel PhysicalExamination = new JLabel("20.Physical examination ");
        PhysicalExamination.setBounds(450, 150, 150, 30);
        
        JLabel LabTest = new JLabel("21.Lab test ");
        LabTest.setBounds(450, 170, 100, 30);
        
        JLabel MRI = new JLabel("22.MRI ");
        MRI.setBounds(450, 190, 100, 30);
        
        JLabel X_RAY = new JLabel("23.X-RAY ");
        X_RAY.setBounds(450, 210, 100, 30);
        
        JLabel PrescribedMedication = new JLabel("24.Prescribed medication ");
        PrescribedMedication.setBounds(850, 30, 170, 30);
        
        JLabel Dosage = new JLabel("25.Dosage ");
        Dosage.setBounds(850, 50, 100, 30);
        
        JLabel frequency_and_instructions = new JLabel("26.Frequency and instructions ");
        frequency_and_instructions.setBounds(850, 70, 200, 30);
        
        JLabel OrderedDiagnosticTests = new JLabel("27.Ordered diagnostic tests ");
        OrderedDiagnosticTests.setBounds(850,90, 200, 30);
        
        JLabel ReferralsToSpecialists = new JLabel("28.Referrals to specialists ");
        ReferralsToSpecialists.setBounds(850, 110, 200, 30);
        
        JLabel ImmunizationRecords = new JLabel("29.Immunization records ");
        ImmunizationRecords.setBounds(850, 130, 200, 30);
        
        JLabel Schedule = new JLabel("30.Schedule ");
        Schedule.setBounds(850, 150, 100, 30);
        
        JLabel InsuranceInfo = new JLabel("31.Insurance information ");
        InsuranceInfo.setBounds(850, 170, 150, 30);
        
        JLabel PaymentHistory = new JLabel("32.Payment history ");
        PaymentHistory.setBounds(850, 190, 150, 30);

        JLabel header1 = new JLabel("Enter the patient's name, then the number that you wish to change from the above choices");
        JLabel header2 = new JLabel("and the information that you wish to insert as an updated version.");

        header1.setBounds(50, 250, 1000, 50);
        header2.setBounds(50, 270, 1000, 50);

        header1.setFont(new Font("",Font.PLAIN, 17));
        header1.setForeground(new Color(0xFFFFFF));

        header2.setFont(new Font("",Font.PLAIN, 17));
        header2.setForeground(new Color(0xFFFFFF));

        JLabel Firstname = new JLabel("First Name ");
        JTextField FField = new JTextField();
        Firstname.setForeground(new Color(0xFFFFFF));

        JLabel Lastname = new JLabel("Last Name ");
        JTextField LField = new JTextField();
        Lastname.setForeground(new Color(0xFFFFFF));

        JLabel choice = new JLabel("Number of choice ");
        JTextField choiceF = new JTextField();
        choice.setForeground(new Color(0xFFFFFF));

        JLabel info = new JLabel("Information to be inserted ");
        JTextField infoF = new JTextField();
        info.setForeground(new Color(0xFFFFFF));

        Firstname.setBounds(50, 350, 100, 30);
        FField.setBounds(205, 350, 200, 30);
        Lastname.setBounds(50, 400, 100, 30);
        LField.setBounds(205, 400, 200, 30);
        choice.setBounds(50, 450, 130, 30);
        choiceF.setBounds(205, 450, 200, 30);
        info.setBounds(50, 500, 200, 30);
        infoF.setBounds(205, 500, 200, 30);

        JButton Submit = new JButton("Submit");
        JButton Reset = new JButton("Cancel");
        Submit.setBounds(450, 600, 100, 25);
        Reset.setBounds(600, 600, 100, 25);

        Submit.addActionListener(e -> 
            System.out.println("Patient updated successfully")
        );


        Reset.addActionListener(e -> 
            frame3.setVisible(false)
        );
        Reset.addActionListener(e -> 
            new mainFunc()
        );

frame3.add(Fname);
Fname.setForeground(Color.WHITE);

frame3.add(Lname);
Lname.setForeground(Color.WHITE);

frame3.add(DateOfBirth);
DateOfBirth.setForeground(Color.WHITE);

frame3.add(gender);
gender.setForeground(Color.WHITE);

frame3.add(phone);
phone.setForeground(Color.WHITE);

frame3.add(address);
address.setForeground(Color.WHITE);

frame3.add(email);
email.setForeground(Color.WHITE);

frame3.add(EmergencyContact);
EmergencyContact.setForeground(Color.WHITE);

frame3.add(PastMedicalCondition);
PastMedicalCondition.setForeground(Color.WHITE);

frame3.add(SurgicalHistory);
SurgicalHistory.setForeground(Color.WHITE);

frame3.add(Allergies);
Allergies.setForeground(Color.WHITE);

frame3.add(CurrentMedications);
CurrentMedications.setForeground(Color.WHITE);

frame3.add(FamilyMedicalHistory);
FamilyMedicalHistory.setForeground(Color.WHITE);

frame3.add(BloodPressure);
BloodPressure.setForeground(Color.WHITE);

frame3.add(Temperature);
Temperature.setForeground(Color.WHITE);

frame3.add(HeartRate);
HeartRate.setForeground(Color.WHITE);

frame3.add(RespiratoryRate);
RespiratoryRate.setForeground(Color.WHITE);

frame3.add(height);
height.setForeground(Color.WHITE);

frame3.add(weight);
weight.setForeground(Color.WHITE);

frame3.add(PhysicalExamination);
PhysicalExamination.setForeground(Color.WHITE);

frame3.add(LabTest);
LabTest.setForeground(Color.WHITE);

frame3.add(MRI);
MRI.setForeground(Color.WHITE);

frame3.add(X_RAY);
X_RAY.setForeground(Color.WHITE);

frame3.add(PrescribedMedication);
PrescribedMedication.setForeground(Color.WHITE);

frame3.add(Dosage);
Dosage.setForeground(Color.WHITE);

frame3.add(frequency_and_instructions);
frequency_and_instructions.setForeground(Color.WHITE);

frame3.add(OrderedDiagnosticTests);
OrderedDiagnosticTests.setForeground(Color.WHITE);

frame3.add(ReferralsToSpecialists);
ReferralsToSpecialists.setForeground(Color.WHITE);

frame3.add(ImmunizationRecords);
ImmunizationRecords.setForeground(Color.WHITE);

frame3.add(Schedule);
Schedule.setForeground(Color.WHITE);

frame3.add(InsuranceInfo);
InsuranceInfo.setForeground(Color.WHITE);

frame3.add(PaymentHistory);
PaymentHistory.setForeground(Color.WHITE);

frame3.add(header1);
frame3.add(header2);

frame3.add(Firstname);
frame3.add(FField);

frame3.add(Lastname);
frame3.add(LField);

frame3.add(choice);
frame3.add(choiceF);

frame3.add(info);
frame3.add(infoF);


        frame3.add(Submit);
        frame3.add(Reset);

    }
    
}
