import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class showallPatients extends JFrame {
    showallPatients(){
        Frame frame5 = new Frame();

        JLabel header1 = new JLabel("Showing all patients informations");

        header1.setBounds(50, 150, 1000, 50);

        header1.setFont(new Font("",Font.PLAIN, 17));
        header1.setForeground(new Color(0xFFFFFF));

        JButton Show = new JButton("Show");
        Show.setBounds(520, 600, 100, 25);

        JButton Reset = new JButton("Cancel");
        Reset.setBounds(650, 600, 100, 25);

        Show.addActionListener(e -> {
            try {
//                Connection conn = DatabaseConnection.getConnection();
////                PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO patients (Firstname, Lastname, DateOfBirth, Gender, phoneNo, address, email, EmergencyContact, PastMedicalCondition, SurgicalHistory, Allergies, CurrentMedications, FamilyMedicalHistory, BloodPressure, Temperature, HeartRate, RespiratoryRate, height, weight, PhysicalExamination, LabTest, MRI, X_Ray, PrescribedMedication, Dosage, frequency_and_instructions, OrderedDiagnosticTests, ReferralsToSpecialists, ImmunizationRecords, Schedule, InsuranceInfo, PaymentHistory) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//                Statement statement = conn.createStatement();
//
//                // Create the table model
//                DefaultTableModel tableModel = new DefaultTableModel();
//                tableModel.addColumn("ID");
//                tableModel.addColumn("Firstname");
//                tableModel.addColumn("Lastname");
//                tableModel.addColumn("Gender");
//                tableModel.addColumn("Phone Number");
//                tableModel.addColumn("Medical Condition");
//                tableModel.addColumn("Medication");
//                tableModel.addColumn("Payment");
//                tableModel.addColumn("Test");
//
//// Create the JTable
//                JTable table = new JTable(tableModel);
//                JScrollPane scrollPane = new JScrollPane(table);
////                    Connection conn = DatabaseConnection.getConnection();
////                    Statement statement = conn.createStatement();
//
//                    // Fetch data from patients table
//                    ResultSet patientsResultSet = statement.executeQuery("SELECT id, Firstname, Lastname, DateOfBirth, Gender, phoneNo, address, email, EmergencyContact, Date FROM patients");
//                    while (patientsResultSet.next()) {
//                        int id = patientsResultSet.getInt("ID");
//                        String Firstname = patientsResultSet.getString("Firstname");
//                        String Lastname = patientsResultSet.getString("Lastname");
//                        String Gender = patientsResultSet.getString("Gender");
//                        String PhoneNumber = patientsResultSet.getString("phoneNo");
//                        tableModel.addRow(new Object[] { id, Firstname, Lastname, Gender, PhoneNumber, "", "", "", "" });
//                    }
//                    patientsResultSet.close();
//
//                    // Fetch data from medical_conditions table
//                    ResultSet medicalConditionsResultSet = statement.executeQuery("SELECT id, Firstname, Lastname, PastMedicalCondition, SurgicalHistory, Allergies, CurrentMedications, FamilyMedicalHistory, Date FROM medical_conditions");
//                    while (medicalConditionsResultSet.next()) {
//                        int patientId = medicalConditionsResultSet.getInt("ID");
//                        String Firstname = medicalConditionsResultSet.getString("Firstname");
//                        String Lastname = medicalConditionsResultSet.getString("Lastname");
//                        String PastMedicalCondition = medicalConditionsResultSet.getString("PastMedicalCondition");
//                        for (int i = 0; i < tableModel.getRowCount(); i++) {
//                            int id = (int) tableModel.getValueAt(i, 0);
//                            if (id == patientId) {
//                                tableModel.setValueAt(PastMedicalCondition, i, 5);
//                                break;
//                            }
//                        }
//                    }
//                    medicalConditionsResultSet.close();
//
//                    // Fetch data from medication_and_payments table
//                    ResultSet medicationAndPaymentsResultSet = statement.executeQuery("SELECT id, Firstname, Lastname, PrescribedMedication, Dosage, frequency_and_instructions, OrderedDiagnosticTests, ReferralsToSpecialists, ImmunizationRecords, Schedule, InsuranceInfo, PaymentHistory, Date FROM medications_and_payments");
//                    while (medicationAndPaymentsResultSet.next()) {
//                        int patientId = medicationAndPaymentsResultSet.getInt("ID");
//                        int medicationId = medicationAndPaymentsResultSet.getInt("Firstname");
//                        String Payment = medicationAndPaymentsResultSet.getString("Lastname");
//                        ResultSet medicationResultSet = statement.executeQuery("SELECT medication FROM medication WHERE id = " + medicationId);
//                        if (medicationResultSet.next()) {
//                            String Medication = medicationResultSet.getString("medication");
//                            for (int i = 0; i < tableModel.getRowCount(); i++) {
//                                int id = (int) tableModel.getValueAt(i, 0);
//                                if (id == patientId) {
//                                    tableModel.setValueAt(Medication, i, 6);
//                                    tableModel.setValueAt(Payment, i, 7);
//                                    break;
//                                }
//                            }
//                        }
//                        medicationResultSet.close();
//                    }
//                    medicationAndPaymentsResultSet.close();
//
//                    // Fetch data from tests table
//                    ResultSet testsResultSet = statement.executeQuery("SELECT id, Firstname, Lastname, BloodPressure, Temprature, HeartRate, RespiratoryRate, height, weight, PhysicalExamination, LabTest, MRI, X_Ray, Date FROM tests");
//                    while (testsResultSet.next()) {
//                        int patientId = testsResultSet.getInt("patient_id");
//                        String Test = testsResultSet.getString("test_name");
//                        for (int i = 0; i < tableModel.getRowCount(); i++) {
//                            int id = (int) tableModel.getValueAt(i, 0);
//                            if (id == patientId) {
//                                tableModel.setValueAt(Test, i, 8);
//                                break;
//                            }
//                        }
//                    }
//                    testsResultSet.close();
//
//                    // Add the table to the frame
//                    getContentPane().add(scrollPane, "Center");
//                    setVisible(true);
//
//                    // Close the resources
//                    statement.close();
//                    conn.close();
                Connection conn = DatabaseConnection.getConnection();
                Statement statement = conn.createStatement();

                // Create the table model
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.addColumn("ID");
                tableModel.addColumn("Firstname");
                tableModel.addColumn("Lastname");
                tableModel.addColumn("Date of Birth");
                tableModel.addColumn("Gender");
                tableModel.addColumn("Phone Number");
                tableModel.addColumn("Address");
                tableModel.addColumn("Email");
                tableModel.addColumn("Emergency Contact");
                tableModel.addColumn("Past Medical Condition");
                tableModel.addColumn("Surgical History");
                tableModel.addColumn("Allergies");
                tableModel.addColumn("Current Medications");
                tableModel.addColumn("Family Medical History");
                tableModel.addColumn("Blood Pressure");
                tableModel.addColumn("Temperature");
                tableModel.addColumn("Heart Rate");
                tableModel.addColumn("Respiratory Rate");
                tableModel.addColumn("Height");
                tableModel.addColumn("Weight");
                tableModel.addColumn("Physical Examination");
                tableModel.addColumn("Lab Test");
                tableModel.addColumn("MRI");
                tableModel.addColumn("X-Ray");
                tableModel.addColumn("Prescribed Medication");
                tableModel.addColumn("Dosage");
                tableModel.addColumn("Frequency and Instructions");
                tableModel.addColumn("Ordered Diagnostic Tests");
                tableModel.addColumn("Referrals to Specialists");
                tableModel.addColumn("Immunization Records");
                tableModel.addColumn("Schedule");
                tableModel.addColumn("Insurance Info");
                tableModel.addColumn("Payment History");

                // Create the JTable
                JTable table = new JTable(tableModel);
                JScrollPane scrollPane = new JScrollPane(table);

                // Fetch data from patients table
                ResultSet patientsResultSet = statement.executeQuery("SELECT * FROM patients");
                while (patientsResultSet.next()) {
                    Object[] rowData = {
                            patientsResultSet.getInt("id"),
                            patientsResultSet.getString("Firstname"),
                            patientsResultSet.getString("Lastname"),
                            patientsResultSet.getString("DateOfBirth"),
                            patientsResultSet.getString("Gender"),
                            patientsResultSet.getString("phoneNo"),
                            patientsResultSet.getString("address"),
                            patientsResultSet.getString("email"),
                            patientsResultSet.getString("EmergencyContact"),
                            "", // Past Medical Condition
                            "", // Surgical History
                            "", // Allergies
                            "", // Current Medications
                            "", // Family Medical History
                            "", // Blood Pressure
                            "", // Temperature
                            "", // Heart Rate
                            "", // Respiratory Rate
                            "", // Height
                            "", // Weight
                            "", // Physical Examination
                            "", // Lab Test
                            "", // MRI
                            "", // X-Ray
                            "", // Prescribed Medication
                            "", // Dosage
                            "", // Frequency and Instructions
                            "", // Ordered Diagnostic Tests
                            "", // Referrals to Specialists
                            "", // Immunization Records
                            "", // Schedule
                            "", // Insurance Info
                            "" // Payment History
                    };
                    tableModel.addRow(rowData);
                }
                patientsResultSet.close();

                // Fetch data from other tables and update the JTable
                updateTableWithMedicalConditions(statement, tableModel);
                updateTableWithMedicationAndPayments(statement, tableModel);
                updateTableWithTests(statement, tableModel);

                // Add the table to the frame
                getContentPane().add(scrollPane, "Center");
                setVisible(true);

                // Close the resources
                statement.close();
                conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        });

        Reset.addActionListener(e -> 
            frame5.setVisible(false)
        );
        Reset.addActionListener(e -> 
            new mainFunc()
        );

        frame5.add(header1);
        frame5.add(Show);
        frame5.add(Reset);
    }

    private static void updateTableWithMedicalConditions(Statement statement, DefaultTableModel tableModel) throws SQLException {
        ResultSet medicalConditionsResultSet = statement.executeQuery("SELECT * FROM medical_conditions");
        while (medicalConditionsResultSet.next()) {
            int id = medicalConditionsResultSet.getInt("Id");
            String pastMedicalCondition = medicalConditionsResultSet.getString("PastMedicalCondition");
            String surgicalHistory = medicalConditionsResultSet.getString("SurgicalHistory");
            String allergies = medicalConditionsResultSet.getString("Allergies");
            String currentMedications = medicalConditionsResultSet.getString("CurrentMedications");
            String familyMedicalHistory = medicalConditionsResultSet.getString("FamilyMedicalHistory");

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                int id1 = (int) tableModel.getValueAt(i, 0);
                if (id1 == id) {
                    tableModel.setValueAt(pastMedicalCondition, i, 9);
                    tableModel.setValueAt(surgicalHistory, i, 10);
                    tableModel.setValueAt(allergies, i, 11);
                    tableModel.setValueAt(currentMedications, i, 12);
                    tableModel.setValueAt(familyMedicalHistory, i, 13);
                    break;
                }
            }
        }
        medicalConditionsResultSet.close();
    }

    private static void updateTableWithTests(Statement statement, DefaultTableModel tableModel) throws SQLException {
        ResultSet testsResultSet = statement.executeQuery("SELECT * FROM tests");
        while (testsResultSet.next()) {
            int id = testsResultSet.getInt("Id");
            String BloodPressure = testsResultSet.getString("BloodPressure");
            String Temperature = testsResultSet.getString("Temperature");
            String HeartRate = testsResultSet.getString("HeartRate");
            String RespiratoryRate = testsResultSet.getString("RespiratoryRate");
            String height = testsResultSet.getString("Height");
            String weight = testsResultSet.getString("Weight");
            String PhysicalExamination = testsResultSet.getString("PhysicalExamination");
            String LabTest = testsResultSet.getString("LabTest");
            String MRI = testsResultSet.getString("MRI");
            String X_Ray = testsResultSet.getString("X_Ray");

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                int id1 = (int) tableModel.getValueAt(i, 0);
                if (id1 == id) {
                    tableModel.setValueAt(BloodPressure, i, 14);
                    tableModel.setValueAt(Temperature, i, 15);
                    tableModel.setValueAt(HeartRate, i, 16);
                    tableModel.setValueAt(RespiratoryRate, i, 17);
                    tableModel.setValueAt(height, i, 18);
                    tableModel.setValueAt(weight, i, 19);
                    tableModel.setValueAt(PhysicalExamination, i, 20);
                    tableModel.setValueAt(LabTest, i, 21);
                    tableModel.setValueAt(MRI, i, 22);
                    tableModel.setValueAt(X_Ray, i, 23);
                    break;
                }
            }
        }
        testsResultSet.close();
    }

    private static void updateTableWithMedicationAndPayments(Statement statement, DefaultTableModel tableModel) throws SQLException {
        ResultSet medicationAndPaymentsResultSet = statement.executeQuery("SELECT * FROM medications_and_payments");
        while (medicationAndPaymentsResultSet.next()) {
            int id = medicationAndPaymentsResultSet.getInt("Id");
            String prescribedMedication = medicationAndPaymentsResultSet.getString("PrescribedMedication");
            String dosage = medicationAndPaymentsResultSet.getString("Dosage");
            String frequencyAndInstructions = medicationAndPaymentsResultSet.getString("frequency_and_instructions");
            String orderedDiagnosticTests = medicationAndPaymentsResultSet.getString("OrderedDiagnosticTests");
            String referralsToSpecialists = medicationAndPaymentsResultSet.getString("ReferralsToSpecialists");
            String immunizationRecords = medicationAndPaymentsResultSet.getString("ImmunizationRecords");
            String schedule = medicationAndPaymentsResultSet.getString("Schedule");
            String insuranceInfo = medicationAndPaymentsResultSet.getString("InsuranceInfo");
            String paymentHistory = medicationAndPaymentsResultSet.getString("PaymentHistory");

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                int id1 = (int) tableModel.getValueAt(i, 0);
                if (id1 == id) {
                    tableModel.setValueAt(prescribedMedication, i, 24);
                    tableModel.setValueAt(dosage, i, 25);
                    tableModel.setValueAt(frequencyAndInstructions, i, 26);
                    tableModel.setValueAt(orderedDiagnosticTests, i, 27);
                    tableModel.setValueAt(referralsToSpecialists, i, 28);
                    tableModel.setValueAt(immunizationRecords, i, 29);
                    tableModel.setValueAt(schedule, i, 30);
                    tableModel.setValueAt(insuranceInfo, i, 31);
                    tableModel.setValueAt(paymentHistory, i, 32);
                    break;
                }
            }
        }
        medicationAndPaymentsResultSet.close();
    }
}


