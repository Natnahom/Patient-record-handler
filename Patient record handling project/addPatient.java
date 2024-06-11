import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.sql.Statement;


public class addPatient {

    addPatient(){

        Frame frame2 = new Frame();

        JLabel header = new JLabel();
        header.setText("Enter every information asked(if the question doesn't ");
        header.setBounds(890, 540,520, 100);
        JLabel header2 = new JLabel();
        header2.setText("apply to them, enter NULL or 0)");
        header2.setBounds(890, 555,520, 100);
        // header.setVerticalTextPosition(JLabel.TOP);
        // header.setFont(new Font("Times new roman",Font.PLAIN, 20));

        JLabel Fname = new JLabel("First Name ");
        JTextField FField = new JTextField();
        JLabel Lname = new JLabel("Last Name ");
        JTextField LField = new JTextField();
        JLabel DateOfBirth = new JLabel("Date of Birth ");
        JTextField DBField = new JTextField();
        Fname.setBounds(50, 50, 100, 30);
        FField.setBounds(200, 50, 200, 30);
        Lname.setBounds(50, 100, 100, 30);
        LField.setBounds(200, 100, 200, 30);
        DateOfBirth.setBounds(50, 150, 100, 30);
        DBField.setBounds(200, 150, 200, 30);


        JLabel gender = new JLabel("Gender ");
        gender.setBounds(450, 50, 100, 30);
        JTextField genderF = new JTextField();
        genderF.setBounds(600, 50, 200, 30);
        
        JLabel phone = new JLabel("Phone Number ");
        phone.setBounds(450, 100, 100, 30);
        JTextField phoneF = new JTextField();
        phoneF.setBounds(600, 100, 200, 30);
        
        JLabel address = new JLabel("Address ");
        address.setBounds(450, 150, 100, 30);
        JTextField addressF = new JTextField();
        addressF.setBounds(600, 150, 200, 30);
        
        JLabel email = new JLabel("Email ");
        email.setBounds(50, 200, 100, 30);
        JTextField emailF = new JTextField();
        emailF.setBounds(200, 200, 200, 30);
        
        JLabel EmergencyContact = new JLabel("Emergency Contact ");
        EmergencyContact.setBounds(50, 250, 150, 30);
        JTextField EmergencyContactF = new JTextField();
        EmergencyContactF.setBounds(200, 250, 200, 30);
        
        JLabel PastMedicalCondition = new JLabel("Past medical condition ");
        PastMedicalCondition.setBounds(50, 300, 150, 30);
        JTextField PastMedicalConditionF = new JTextField();
        PastMedicalConditionF.setBounds(200, 300, 200, 30);
        
        JLabel SurgicalHistory = new JLabel("Surgical history ");
        SurgicalHistory.setBounds(50, 350, 150, 30);
        JTextField SurgicalHistoryF = new JTextField();
        SurgicalHistoryF.setBounds(200, 350, 200, 30);
        
        JLabel Allergies = new JLabel("Allergies ");
        Allergies.setBounds(50, 400, 100, 30);
        JTextField AllergiesF = new JTextField();
        AllergiesF.setBounds(200, 400, 200, 30);
        
        JLabel CurrentMedications = new JLabel("Current medications ");
        CurrentMedications.setBounds(50, 450, 150, 30);
        JTextField CurrentMedicationsF = new JTextField();
        CurrentMedicationsF.setBounds(200, 450, 200, 30);
        
        JLabel FamilyMedicalHistory = new JLabel("Family medical history ");
        FamilyMedicalHistory.setBounds(50, 500, 150, 30);
        JTextField FamilyMedicalHistoryF = new JTextField();
        FamilyMedicalHistoryF.setBounds(200, 500, 200, 30);
        
        JLabel BloodPressure = new JLabel("Blood pressure ");
        BloodPressure.setBounds(50, 550, 150, 30);
        JTextField BloodPressureF = new JTextField();
        BloodPressureF.setBounds(200, 550, 200, 30);
        
        JLabel Temperature = new JLabel("Average temperature ");
        Temperature.setBounds(850, 50, 150, 30);
        JTextField TemperatureF = new JTextField();
        TemperatureF.setBounds(1050, 50, 200, 30);
        
        JLabel HeartRate = new JLabel("Heart rate ");
        HeartRate.setBounds(450, 200, 150, 30);
        JTextField HeartRateF = new JTextField();
        HeartRateF.setBounds(600, 200, 200, 30);
        
        JLabel RespiratoryRate = new JLabel("Respiratory rate ");
        RespiratoryRate.setBounds(450, 250, 150, 30);
        JTextField RespiratoryRateF = new JTextField();
        RespiratoryRateF.setBounds(600, 250, 200, 30);
        
        JLabel height = new JLabel("Height ");
        height.setBounds(450, 300, 100, 30);
        JTextField heightF = new JTextField();
        heightF.setBounds(600, 300, 200, 30);
        
        JLabel weight = new JLabel("Weight ");
        weight.setBounds(450, 350, 100, 30);
        JTextField weightF = new JTextField();
        weightF.setBounds(600, 350, 200, 30);
        
        JLabel PhysicalExamination = new JLabel("Physical examination ");
        PhysicalExamination.setBounds(450, 400, 150, 30);
        JTextField PhysicalExaminationF = new JTextField();
        PhysicalExaminationF.setBounds(600, 400, 200, 30);
        
        JLabel LabTest = new JLabel("Lab test ");
        LabTest.setBounds(450, 450, 100, 30);
        JTextField LabTestF = new JTextField();
        LabTestF.setBounds(600, 450, 200, 30);
        
        JLabel MRI = new JLabel("MRI ");
        MRI.setBounds(450, 500, 100, 30);
        JTextField MRI_F = new JTextField();
        MRI_F.setBounds(600, 500, 200, 30);
        
        JLabel X_RAY = new JLabel("X-RAY ");
        X_RAY.setBounds(450, 550, 100, 30);
        JTextField X_RAY_F = new JTextField();
        X_RAY_F.setBounds(600, 550, 200, 30);
        
        JLabel PrescribedMedication = new JLabel("Prescribed medication ");
        PrescribedMedication.setBounds(850, 100, 150, 30);
        JTextField PrescribedMedicationF = new JTextField();
        PrescribedMedicationF.setBounds(1050, 100, 200, 30);
        
        JLabel Dosage = new JLabel("Dosage ");
        Dosage.setBounds(850, 150, 100, 30);
        JTextField DosageF = new JTextField();
        DosageF.setBounds(1050, 150, 200, 30);
        
        JLabel frequency_and_instructions = new JLabel("Frequency and instructions ");
        frequency_and_instructions.setBounds(850, 200, 200, 30);
        JTextField frequency_and_instructionsF = new JTextField();
        frequency_and_instructionsF.setBounds(1050, 200, 200, 30);
        
        JLabel OrderedDiagnosticTests = new JLabel("Ordered diagnostic tests ");
        OrderedDiagnosticTests.setBounds(850, 250, 200, 30);
        JTextField OrderedDiagnosticTestsF = new JTextField();
        OrderedDiagnosticTestsF.setBounds(1050, 250, 200, 30);
        
        JLabel ReferralsToSpecialists = new JLabel("Referrals to specialists ");
        ReferralsToSpecialists.setBounds(850, 300, 200, 30);
        JTextField ReferralsToSpecialistsF = new JTextField();
        ReferralsToSpecialistsF.setBounds(1050, 300, 200, 30);
        
        JLabel ImmunizationRecords = new JLabel("Immunization records ");
        ImmunizationRecords.setBounds(850, 350, 200, 30);
        JTextField ImmunizationRecordsF = new JTextField();
        ImmunizationRecordsF.setBounds(1050, 350, 200, 30);
        
        JLabel Schedule = new JLabel("Schedule ");
        Schedule.setBounds(850, 400, 100, 30);
        JTextField ScheduleF = new JTextField();
        ScheduleF.setBounds(1050, 400, 200, 30);
        
        JLabel InsuranceInfo = new JLabel("Insurance information ");
        InsuranceInfo.setBounds(850, 450, 150, 30);
        JTextField InsuranceInfoF = new JTextField();
        InsuranceInfoF.setBounds(1050, 450, 200, 30);
        
        JLabel PaymentHistory = new JLabel("Payment history ");
        PaymentHistory.setBounds(850, 500, 150, 30);
        JTextField PaymentHistoryF = new JTextField();
        PaymentHistoryF.setBounds(1050, 500, 200, 30);

        JButton Submit = new JButton("Submit");
        JButton Reset = new JButton("Cancel");
        Submit.setBounds(450, 600, 100, 25);
        Reset.setBounds(600, 600, 100, 25);

        Submit.addActionListener(e -> {
            try {
                // Get the values from the text fields
                String firstName = FField.getText();
                String lastName = LField.getText();
                String dateOfBirth = DBField.getText();
                String gender1 = genderF.getText();
                String phone1 = phoneF.getText();
                String address1 = addressF.getText();
                String email1 = emailF.getText();
                String emergencyContact = EmergencyContactF.getText();
                String pastMedicalCondition = PastMedicalConditionF.getText();
                String surgicalHistory = SurgicalHistoryF.getText();
                String allergies = AllergiesF.getText();
                String currentMedications = CurrentMedicationsF.getText();
                String familyMedicalHistory = FamilyMedicalHistoryF.getText();
                String bloodPressure = BloodPressureF.getText();
                String temperature = TemperatureF.getText();
                String heartRate = HeartRateF.getText();
                String respiratoryRate = RespiratoryRateF.getText();
                String height1 = heightF.getText();
                String weight1 = weightF.getText();
                // patient p = new patient(firstName, lastName,dateOfBirth,gender1,phone1,address1,email1,emergencyContact);
                // String BMI = p.calcBMI(height1, weight1);
                String physicalExamination = PhysicalExaminationF.getText();
                String labTest = LabTestF.getText();
                String mri = MRI_F.getText();
                String xRay = X_RAY_F.getText();
                String prescribedMedication = PrescribedMedicationF.getText();
                String dosage = DosageF.getText();
                String frequencyAndInstructions = frequency_and_instructionsF.getText();
                String orderedDiagnosticTests = OrderedDiagnosticTestsF.getText();
                String referralsToSpecialists = ReferralsToSpecialistsF.getText();
                String immunizationRecords = ImmunizationRecordsF.getText();
                String schedule = ScheduleF.getText();
                String insuranceInfo = InsuranceInfoF.getText();
                String paymentHistory = PaymentHistoryF.getText();

                // Connect to the database
                // Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/patientsdb", "root", "12211219");
                // Connection connection = DatabaseConnection.getConnection();
                
                Statement stmt = conn.createStatement();

                // Insert the patient information into the database
                String sql = "INSERT INTO patients (Firstname, Lastname, DateOfBirth, Gender, phoneNo, address, email, EmergencyContact, PastMedicalCondition, SurgicalHistory, Allergies, CurrentMedications, FamilyMedicalHistory, BloodPressure, Temperature, HeartRate, RespiratoryRate, height, weight, PhysicalExamination, LabTest, MRI, X-Ray, PrescribedMedication, Dosage, frequency_and_instructions, OrderedDiagnosticTests, ReferralsToSpecialists, ImmunizationRecords, Schedule, InsuranceInfo, PaymentHistory) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, firstName);
                preparedStmt.setString(2, lastName);
                preparedStmt.setString(3, dateOfBirth);
                preparedStmt.setString(4, gender1);
                preparedStmt.setString(5, phone1);
                preparedStmt.setString(6, address1);
                preparedStmt.setString(7, email1);
                preparedStmt.setString(8, emergencyContact);
                preparedStmt.setString(9, pastMedicalCondition);
                preparedStmt.setString(10, surgicalHistory);
                preparedStmt.setString(11, allergies);
                preparedStmt.setString(12, currentMedications);
                preparedStmt.setString(13, familyMedicalHistory);
                preparedStmt.setString(14, bloodPressure);
                preparedStmt.setString(15, temperature);
                preparedStmt.setString(16, heartRate);
                preparedStmt.setString(17, respiratoryRate);
                preparedStmt.setString(18, height1);
                preparedStmt.setString(19, weight1);
                // preparedStmt.setString(19, BMI);
                preparedStmt.setString(20, physicalExamination);
                preparedStmt.setString(21, labTest);
                preparedStmt.setString(22, mri);
                preparedStmt.setString(23, xRay);
                preparedStmt.setString(24, prescribedMedication);
                preparedStmt.setString(25, dosage);
                preparedStmt.setString(26, frequencyAndInstructions);
                preparedStmt.setString(27, orderedDiagnosticTests);
                preparedStmt.setString(28, referralsToSpecialists);
                preparedStmt.setString(29, immunizationRecords);
                preparedStmt.setString(30, schedule);
                preparedStmt.setString(31, insuranceInfo);
                preparedStmt.setString(32, paymentHistory);
                preparedStmt.executeUpdate();

                // Close the connection
                conn.close();

                // Display a success message
                JOptionPane.showMessageDialog(Reset, this, "Patient added successfully!", 0);
            } catch (SQLException ex) {
                // Display an error message
                JOptionPane.showMessageDialog(Reset, this, "Error: " + ex.getMessage(), 0);
            }
        });

        // saveButton.setOnAction(event -> {
        //     // Get the values from the input fields
        //     String firstName = firstNameField.getText();
        //     String lastName = lastNameField.getText();
        //     String dateOfBirth = dobField.getText();
        //     // ... (get values for other fields)
        
        //     // Create a new patient object and populate it
        //     Patient patient = new Patient(firstName, lastName, dateOfBirth, /* other parameters */);
        //     patient.GetCondition(/* condition-related parameters */);
        //     patient.GetVitalSigns(/* vital signs parameters */);
        //     // ... (set other patient data)
        
        //     // Save the patient information to the database
        //     savePatientToDatabase(patient);
        // });


        Reset.addActionListener(e -> 
            frame2.setVisible(false)
        );
        Reset.addActionListener(e -> 
            new mainFunc()
        );

        frame2.add(header);
        header.setForeground(Color.WHITE);
        frame2.add(header2);
        header2.setForeground(Color.WHITE);

frame2.add(Fname);
Fname.setForeground(Color.WHITE);
frame2.add(FField);

frame2.add(Lname);
Lname.setForeground(Color.WHITE);

frame2.add(DateOfBirth);
DateOfBirth.setForeground(Color.WHITE);

frame2.add(gender);
gender.setForeground(Color.WHITE);

frame2.add(phone);
phone.setForeground(Color.WHITE);

frame2.add(address);
address.setForeground(Color.WHITE);

frame2.add(email);
email.setForeground(Color.WHITE);

frame2.add(EmergencyContact);
EmergencyContact.setForeground(Color.WHITE);

frame2.add(PastMedicalCondition);
PastMedicalCondition.setForeground(Color.WHITE);

frame2.add(SurgicalHistory);
SurgicalHistory.setForeground(Color.WHITE);

frame2.add(Allergies);
Allergies.setForeground(Color.WHITE);

frame2.add(CurrentMedications);
CurrentMedications.setForeground(Color.WHITE);

frame2.add(FamilyMedicalHistory);
FamilyMedicalHistory.setForeground(Color.WHITE);

frame2.add(BloodPressure);
BloodPressure.setForeground(Color.WHITE);

frame2.add(Temperature);
Temperature.setForeground(Color.WHITE);

frame2.add(HeartRate);
HeartRate.setForeground(Color.WHITE);

frame2.add(RespiratoryRate);
RespiratoryRate.setForeground(Color.WHITE);

frame2.add(height);
height.setForeground(Color.WHITE);

frame2.add(weight);
weight.setForeground(Color.WHITE);

frame2.add(PhysicalExamination);
PhysicalExamination.setForeground(Color.WHITE);

frame2.add(LabTest);
LabTest.setForeground(Color.WHITE);

frame2.add(MRI);
MRI.setForeground(Color.WHITE);

frame2.add(X_RAY);
X_RAY.setForeground(Color.WHITE);

frame2.add(PrescribedMedication);
PrescribedMedication.setForeground(Color.WHITE);

frame2.add(Dosage);
Dosage.setForeground(Color.WHITE);

frame2.add(frequency_and_instructions);
frequency_and_instructions.setForeground(Color.WHITE);

frame2.add(OrderedDiagnosticTests);
OrderedDiagnosticTests.setForeground(Color.WHITE);

frame2.add(ReferralsToSpecialists);
ReferralsToSpecialists.setForeground(Color.WHITE);

frame2.add(ImmunizationRecords);
ImmunizationRecords.setForeground(Color.WHITE);

frame2.add(Schedule);
Schedule.setForeground(Color.WHITE);

frame2.add(InsuranceInfo);
InsuranceInfo.setForeground(Color.WHITE);

frame2.add(PaymentHistory);
PaymentHistory.setForeground(Color.WHITE);

frame2.add(FField);
frame2.add(LField);
frame2.add(DBField);
frame2.add(genderF);
frame2.add(phoneF);
frame2.add(addressF);
frame2.add(emailF);
frame2.add(EmergencyContactF);
frame2.add(PastMedicalConditionF);
frame2.add(SurgicalHistoryF);
frame2.add(AllergiesF);
frame2.add(CurrentMedicationsF);
frame2.add(FamilyMedicalHistoryF);
frame2.add(BloodPressureF);
frame2.add(TemperatureF);
frame2.add(HeartRateF);
frame2.add(RespiratoryRateF);
frame2.add(heightF);
frame2.add(weightF);
frame2.add(PhysicalExaminationF);
frame2.add(LabTestF);
frame2.add(MRI_F);
frame2.add(X_RAY_F);
frame2.add(PrescribedMedicationF);
frame2.add(DosageF);
frame2.add(frequency_and_instructionsF);
frame2.add(OrderedDiagnosticTestsF);
frame2.add(ReferralsToSpecialistsF);
frame2.add(ImmunizationRecordsF);
frame2.add(ScheduleF);
frame2.add(InsuranceInfoF);
frame2.add(PaymentHistoryF);


        frame2.add(Submit);
        frame2.add(Reset);

    }

    // private void savePatientToDatabase(patient patient) {
    //     try {
    //         // Establish a database connection
    //         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientdb", "username", "password");
    
    //         // Prepare a SQL statement to insert the patient data
    //         PreparedStatement statement = connection.prepareStatement(
    //             "INSERT INTO patients (firstname, lastname, dateofbirth, /* other columns */) VALUES (?, ?, ?, /* other values */)"
    //         );
    //         statement.setString(1, patient.getText());
    //         statement.setString(2, patient.getLastname());
    //         statement.setString(3, patient.getDateOfBirth());
    //         // ... (set other parameters)
    
    //         // Execute the SQL statement to insert the patient data
    //         statement.executeUpdate();
    
    //         // Close the database connect
    //         connection.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
}
