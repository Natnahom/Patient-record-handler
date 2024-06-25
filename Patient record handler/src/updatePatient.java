
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Objects;

public class updatePatient {
    Connection conn = DatabaseConnection.getConnection();
    updatePatient(){
        Frame frame3 = new Frame();
        frame3.setTitle("Update Patient");

        JLabel Fname = new JLabel("1.First Name ");
        JLabel Lname = new JLabel("2.Last Name ");
        JLabel DateOfBirth = new JLabel("3.Date of Birth ");
        Fname.setBounds(50, 10, 100, 30);
        Lname.setBounds(50, 30, 100, 30);
        DateOfBirth.setBounds(50, 50, 100, 30);

        JLabel gender = new JLabel("4.Gender ");
        gender.setBounds(450, 10, 100, 30);

        JLabel phone = new JLabel("5.Phone Number ");
        phone.setBounds(450, 30, 150, 30);

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
        FamilyMedicalHistory.setBounds(50, 190, 200, 30);

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

        // Add action listener to the Submit button
        Submit.addActionListener(e -> {
            String firstName = FField.getText();
            String lastName = LField.getText();
            int choiceNumber = Integer.parseInt(choiceF.getText());
            String newInfo = infoF.getText();

            // Update the patient information in the database based on the choice number
            switch (choiceNumber) {
                case 1:
                    // Update first name
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updateFirstName(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 2:
                    // Update last name
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updateLastName(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");

                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 3:
                    // Update date of birth
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updateDateOfBirth(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 4:
                    // Update gender
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updateGender(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    break;
                case 5:
                    // Update phone number
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updatephoneNo(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 6:
                    // Update address
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updateAddress(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 7:
                    // Update email
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updateEmail(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 8:
                    // Update emergency contact
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updateEmergencyContact(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 9:
                    // Update past medical condition
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updatePastMedicalCondition(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 10:
                    // Update surgical history
                    try {
                        if(Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        }
                        else {
                            updateSurgicalHistory(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 11:
                    // Update allergies
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateAllergies(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case 12:
                    // Update current medications
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateCurrentMedications(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case 13:
                    // Update family medical history
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateFamilyMedicalHistory(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case 14:
                    // Update blood pressure
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateBloodPressure(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case 15:
                    // Update temperature
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateTemperature(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case 16:
                    // Update heart rate
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateHeartRate(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case 17:
                    // Update respiratory rate
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateRespiratoryRate(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case 18:
                    // Update height
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error",0);
                        } else {
                            updateHeight(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case 19:
                    // Update weight
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateWeight(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case 20:
                    // Update physical examination
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updatePhysicalExamination(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 21:
// Update lab test information
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateLabTest(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 22:
// Update MRI information
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateMRI(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 23:
// Update X-Ray information
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateX_Ray(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 24:
// Update prescribed medication information
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updatePrescribedMedication(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 25:
// Update medication dosage information
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateDosage(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 26:
// Update medication frequency and instructions
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateFrequencyAndInstructions(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 27:
// Update ordered diagnostic tests
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateOrderedDiagnosticTests(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 28:
// Update referrals to specialists
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateReferralsToSpecialists(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 29:
// Update immunization records
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateImmunizationRecords(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 30:
// Update patient schedule
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateSchedule(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 31:
// Update insurance information
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updateInsuranceInfo(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 32:
// Update payment history
                    try {
                        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(newInfo, "")) {
                            JOptionPane.showMessageDialog(Reset, "Invalid data!", "Error", 0);
                        } else {
                            updatePaymentHistory(firstName, lastName, newInfo);
                            JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(Reset, this, "Invalid input!", 0);
                    break;
            }

//            JOptionPane.showMessageDialog(Reset, this, "Patient updated successfully!", 0);

        });


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

    // Helper methods to update the patient information in the database
    private void updateFirstName(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the first name in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE patients SET Firstname = ? WHERE Firstname = ? AND Lastname = ?");
            PreparedStatement preparedStmt2 = conn.prepareStatement("UPDATE medical_conditions SET Firstname = ? WHERE Firstname = ? AND Lastname = ?");
            PreparedStatement preparedStmt3 = conn.prepareStatement("UPDATE tests SET Firstname = ? WHERE Firstname = ? AND Lastname = ?");
            PreparedStatement preparedStmt4 = conn.prepareStatement("UPDATE medications_and_payments SET Firstname = ? WHERE Firstname = ? AND Lastname = ?");

            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);

            preparedStmt2.setString(1, newInfo);
            preparedStmt2.setString(2, firstName);
            preparedStmt2.setString(3, lastName);

            preparedStmt3.setString(1, newInfo);
            preparedStmt3.setString(2, firstName);
            preparedStmt3.setString(3, lastName);

            preparedStmt4.setString(1, newInfo);
            preparedStmt4.setString(2, firstName);
            preparedStmt4.setString(3, lastName);

            preparedStmt.executeUpdate();
            preparedStmt2.executeUpdate();
            preparedStmt3.executeUpdate();
            preparedStmt4.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();
    }

    private void updateLastName(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the last name in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE patients SET Lastname = ? WHERE Firstname = ? AND Lastname = ?");
            PreparedStatement preparedStmt2 = conn.prepareStatement("UPDATE medical_conditions SET Lastname = ? WHERE Firstname = ? AND Lastname = ?");
            PreparedStatement preparedStmt3 = conn.prepareStatement("UPDATE tests SET Lastname = ? WHERE Firstname = ? AND Lastname = ?");
            PreparedStatement preparedStmt4 = conn.prepareStatement("UPDATE medications_and_payments SET Lastname = ? WHERE Firstname = ? AND Lastname = ?");

            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);

            preparedStmt2.setString(1, newInfo);
            preparedStmt2.setString(2, firstName);
            preparedStmt2.setString(3, lastName);

            preparedStmt3.setString(1, newInfo);
            preparedStmt3.setString(2, firstName);
            preparedStmt3.setString(3, lastName);

            preparedStmt4.setString(1, newInfo);
            preparedStmt4.setString(2, firstName);
            preparedStmt4.setString(3, lastName);

            preparedStmt.executeUpdate();
            preparedStmt2.executeUpdate();
            preparedStmt3.executeUpdate();
            preparedStmt4.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();
    }

    private void updateDateOfBirth(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE patients SET DateOfBirth = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateGender(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
//        if(firstName == "" || lastName == "" || newInfo == "") {
//            JButton Reset = null;
//            JOptionPane.showMessageDialog(Reset, this, "Invalid data!", 0);
//        }
//        else {
            try {
                PreparedStatement preparedStmt = conn.prepareStatement("UPDATE patients SET Gender = ? WHERE Firstname = ? AND Lastname = ?");
                preparedStmt.setString(1, newInfo);
                preparedStmt.setString(2, firstName);
                preparedStmt.setString(3, lastName);
                preparedStmt.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
//        }
        conn.close();

    }

    private void updatephoneNo(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE patients SET phoneNo = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateAddress(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE patients SET address = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateEmail(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE patients SET email = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateEmergencyContact(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE patients SET EmergencyContact = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updatePastMedicalCondition(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medical_conditions SET PastMedicalCondition = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateSurgicalHistory(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medical_conditions SET SurgicalHistory = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateAllergies(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medical_conditions SET Allergies = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateCurrentMedications(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medical_conditions SET CurrentMedications = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateFamilyMedicalHistory(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medical_conditions SET FamilyMedicalHistory = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateBloodPressure(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET BloodPressure = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateTemperature(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET Temperature = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateHeartRate(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET HeartRate = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateRespiratoryRate(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET RespiratoryRate = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateHeight(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET height = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateWeight(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET weight = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updatePhysicalExamination(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET PhysicalExamination = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateLabTest(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET LabTest = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateMRI(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET MRI = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateX_Ray(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE tests SET X_Ray = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updatePrescribedMedication(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medications_and_payments SET PrescribedMedication = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateDosage(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medications_and_payments SET Dosage = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateFrequencyAndInstructions(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medications_and_payments SET frequency_and_instructions = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateOrderedDiagnosticTests(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medications_and_payments SET OrderedDiagnosticTests = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateReferralsToSpecialists(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medications_and_payments SET ReferralsToSpecialists = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateImmunizationRecords(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medications_and_payments SET ImmunizationRecords = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateSchedule(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medications_and_payments SET Schedule = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updateInsuranceInfo(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medications_and_payments SET InsuranceInfo = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

    private void updatePaymentHistory(String firstName, String lastName, String newInfo) throws SQLException {
        // Code to update the date of birth in the database
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("UPDATE medications_and_payments SET PaymentHistory = ? WHERE Firstname = ? AND Lastname = ?");
            preparedStmt.setString(1, newInfo);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, lastName);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        conn.close();

    }

// Add helper methods for the remaining choices
    
}
