import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.*;
import java.util.Objects;

public class showallPatients extends JFrame {
    showallPatients(){
        Frame frame5 = new Frame();

        JLabel header1 = new JLabel("Search patients or retrieve all patients information (if you don't enter these options, it's going to retrieve all patients)");
        header1.setBounds(50, 50, 1000, 50);

        header1.setFont(new Font("",Font.PLAIN, 17));
        header1.setForeground(new Color(0xFFFFFF));

        JLabel searchLabel = new JLabel("Search here: ");
        searchLabel.setFont(new Font("",Font.PLAIN, 15));
        searchLabel.setForeground(new Color(0xFFFFFF));
        searchLabel.setBounds(120, 100, 200, 30);

        JLabel FnameLabel = new JLabel("Firstname: ");
        FnameLabel.setFont(new Font("",Font.PLAIN, 15));
        FnameLabel.setForeground(new Color(0xFFFFFF));
        FnameLabel.setBounds(110, 150, 200, 30);
        JTextField searchFField = new JTextField();
        searchFField.setBounds(190, 150, 200, 30);

        JLabel LnameLabel = new JLabel("Lastname: ");
        LnameLabel.setFont(new Font("",Font.PLAIN, 15));
        LnameLabel.setForeground(new Color(0xFFFFFF));
        LnameLabel.setBounds(110, 200, 200, 30);
        JTextField searchLField = new JTextField();
        searchLField.setBounds(190, 200, 200, 30);

        String firstName = searchFField.getText();
        String lastName = searchLField.getText();

        JButton Show = new JButton("Show All");
        Show.setBounds(520, 600, 100, 25);

        JButton Reset = new JButton("Cancel");
        Reset.setBounds(650, 600, 100, 25);

        Show.addActionListener(e -> {
            if (Objects.equals(firstName, "") || Objects.equals(lastName, "")) {
                try {
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
//                JTable table = new JTable(tableModel);
//                JScrollPane scrollPane = new JScrollPane(table);
                    // Create the JTable
                    JTable table = new JTable(tableModel);
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Disable auto-resize
                    table.setRowHeight(50); // Increase row height
//                table.setMinimumSize(new Dimension(600, 70));
// Set the width for all columns
                    TableColumnModel columnModel = table.getColumnModel();
                    for (int i = 0; i < columnModel.getColumnCount(); i++) {
                        columnModel.getColumn(i).setPreferredWidth(200); // Set the preferred width to 150 pixels
                    }
                    // Create a JScrollPane and add the table to it
                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setPreferredSize(new Dimension(1200, 600)); // Set the size of the scrollpane

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
            }
            else{
//                try {
//                    Connection conn = DatabaseConnection.getConnection();
//                    Statement statement = conn.createStatement();
//
//                    // Create the table model
//                    DefaultTableModel tableModel = new DefaultTableModel();
//                    tableModel.addColumn("ID");
//                    tableModel.addColumn("Firstname");
//                    tableModel.addColumn("Lastname");
//                    tableModel.addColumn("Date of Birth");
//                    tableModel.addColumn("Gender");
//                    tableModel.addColumn("Phone Number");
//                    tableModel.addColumn("Address");
//                    tableModel.addColumn("Email");
//                    tableModel.addColumn("Emergency Contact");
//                    tableModel.addColumn("Past Medical Condition");
//                    tableModel.addColumn("Surgical History");
//                    tableModel.addColumn("Allergies");
//                    tableModel.addColumn("Current Medications");
//                    tableModel.addColumn("Family Medical History");
//                    tableModel.addColumn("Blood Pressure");
//                    tableModel.addColumn("Temperature");
//                    tableModel.addColumn("Heart Rate");
//                    tableModel.addColumn("Respiratory Rate");
//                    tableModel.addColumn("Height");
//                    tableModel.addColumn("Weight");
//                    tableModel.addColumn("Physical Examination");
//                    tableModel.addColumn("Lab Test");
//                    tableModel.addColumn("MRI");
//                    tableModel.addColumn("X-Ray");
//                    tableModel.addColumn("Prescribed Medication");
//                    tableModel.addColumn("Dosage");
//                    tableModel.addColumn("Frequency and Instructions");
//                    tableModel.addColumn("Ordered Diagnostic Tests");
//                    tableModel.addColumn("Referrals to Specialists");
//                    tableModel.addColumn("Immunization Records");
//                    tableModel.addColumn("Schedule");
//                    tableModel.addColumn("Insurance Info");
//                    tableModel.addColumn("Payment History");
//
//                    // Create the JTable
////                JTable table = new JTable(tableModel);
////                JScrollPane scrollPane = new JScrollPane(table);
//                    // Create the JTable
//                    JTable table = new JTable(tableModel);
//                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Disable auto-resize
//                    table.setRowHeight(50); // Increase row height
////                table.setMinimumSize(new Dimension(600, 70));
//// Set the width for all columns
//                    TableColumnModel columnModel = table.getColumnModel();
//                    for (int i = 0; i < columnModel.getColumnCount(); i++) {
//                        columnModel.getColumn(i).setPreferredWidth(200); // Set the preferred width to 150 pixels
//                    }
//                    // Create a JScrollPane and add the table to it
//                    JScrollPane scrollPane = new JScrollPane(table);
//                    scrollPane.setPreferredSize(new Dimension(1200, 600)); // Set the size of the scrollpane
//
//                    String query = "SELECT * FROM patients WHERE Firstname = ? AND Lastname = ?";
//                    PreparedStatement preparedStatement = conn.prepareStatement(query);
//                    preparedStatement.setString(1, firstName);
//                    preparedStatement.setString(2, lastName);
//                    ResultSet patientsResultSet = preparedStatement.executeQuery();
//                    // Fetch data from patients table
////                    ResultSet patientsResultSet = statement.executeQuery("SELECT * FROM patients WHERE Firstname = firstname AND Lastname = lastname");
//                    while (patientsResultSet.next()) {
//                        Object[] rowData = {
//                                patientsResultSet.getInt("id"),
//                                patientsResultSet.getString("Firstname"),
//                                patientsResultSet.getString("Lastname"),
//                                patientsResultSet.getString("DateOfBirth"),
//                                patientsResultSet.getString("Gender"),
//                                patientsResultSet.getString("phoneNo"),
//                                patientsResultSet.getString("address"),
//                                patientsResultSet.getString("email"),
//                                patientsResultSet.getString("EmergencyContact"),
//                                "", // Past Medical Condition
//                                "", // Surgical History
//                                "", // Allergies
//                                "", // Current Medications
//                                "", // Family Medical History
//                                "", // Blood Pressure
//                                "", // Temperature
//                                "", // Heart Rate
//                                "", // Respiratory Rate
//                                "", // Height
//                                "", // Weight
//                                "", // Physical Examination
//                                "", // Lab Test
//                                "", // MRI
//                                "", // X-Ray
//                                "", // Prescribed Medication
//                                "", // Dosage
//                                "", // Frequency and Instructions
//                                "", // Ordered Diagnostic Tests
//                                "", // Referrals to Specialists
//                                "", // Immunization Records
//                                "", // Schedule
//                                "", // Insurance Info
//                                "" // Payment History
//                        };
//                        tableModel.addRow(rowData);
//                    }
//                    patientsResultSet.close();
//
//                    // Fetch data from other tables and update the JTable
//                    updateTableWithMedicalConditions(statement, tableModel);
//                    updateTableWithMedicationAndPayments(statement, tableModel);
//                    updateTableWithTests(statement, tableModel);
//
//                    // Add the table to the frame
//                    getContentPane().add(scrollPane, "Center");
//                    setVisible(true);
//
//                    // Close the resources
//                    statement.close();
//                    conn.close();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
            }
        });

        Reset.addActionListener(e -> 
            frame5.setVisible(false)
        );
        Reset.addActionListener(e -> 
            new mainFunc()
        );

        frame5.add(header1);
        frame5.add(searchLabel);
        frame5.add(FnameLabel);
        frame5.add(searchFField);
        frame5.add(LnameLabel);
        frame5.add(searchLField);
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


