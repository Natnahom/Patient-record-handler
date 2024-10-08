package com.phr.functions;

import com.phr.database.DatabaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.*;
import java.util.Objects;


public class showallPatients extends JFrame {
    public showallPatients() {
        com.phr.functions.Frame frame5 = new Frame();

        JLabel header1 = new JLabel("Search patients or retrieve all patients information (if you don't enter these options, it's going to retrieve all patients)");
        header1.setBounds(50, 50, 1000, 50);

        header1.setFont(new Font("", Font.PLAIN, 17));
        header1.setForeground(new Color(0xFFFFFF));

        JLabel searchLabel = new JLabel("Search here: ");
        searchLabel.setFont(new Font("", Font.PLAIN, 15));
        searchLabel.setForeground(new Color(0xFFFFFF));
        searchLabel.setBounds(120, 100, 200, 30);

        JLabel FnameLabel = new JLabel("Firstname: ");
        FnameLabel.setFont(new Font("", Font.PLAIN, 15));
        FnameLabel.setForeground(new Color(0xFFFFFF));
        FnameLabel.setBounds(110, 150, 200, 30);
        JTextField searchFField = new JTextField();
        searchFField.setBounds(190, 150, 200, 30);

        JLabel LnameLabel = new JLabel("Lastname: ");
        LnameLabel.setFont(new Font("", Font.PLAIN, 15));
        LnameLabel.setForeground(new Color(0xFFFFFF));
        LnameLabel.setBounds(110, 200, 200, 30);
        JTextField searchLField = new JTextField();
        searchLField.setBounds(190, 200, 200, 30);

        JButton Show = new JButton("Show");
        Show.setBounds(520, 600, 100, 25);

        JButton Reset = new JButton("Reset");
        Reset.setBounds(650, 600, 100, 25);

        Show.addActionListener(e -> {
            String firstName = searchFField.getText().trim();
            String lastName = searchLField.getText().trim();
//            System.out.println(firstName + " " + lastName);
            if (!(Objects.equals(firstName, "")) || !(Objects.equals(lastName, ""))) {
                try {
                    Connection conn = DatabaseConnection.getConnection();

                    // Check if the patient exists
                    PreparedStatement checkStmt = conn.prepareStatement("SELECT id FROM patients WHERE Firstname = ? AND Lastname = ?");
                    checkStmt.setString(1, firstName);
                    checkStmt.setString(2, lastName);
                    ResultSet rs = checkStmt.executeQuery();

                    if (rs.next()) {
                        int patientId = rs.getInt("id");

                        // Prepare the SQL select statements
                        PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM patients WHERE id = ?");
                        PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM medical_conditions WHERE id = ?");
                        PreparedStatement stmt3 = conn.prepareStatement("SELECT * FROM medications_and_payments WHERE id = ?");
                        PreparedStatement stmt4 = conn.prepareStatement("SELECT * FROM tests WHERE id = ?");

                        stmt1.setInt(1, patientId);
                        stmt2.setInt(1, patientId);
                        stmt3.setInt(1, patientId);
                        stmt4.setInt(1, patientId);

                        // Execute the select statements and store the results in separate ResultSets
                        ResultSet rs1 = stmt1.executeQuery();
                        ResultSet rs2 = stmt2.executeQuery();
                        ResultSet rs3 = stmt3.executeQuery();
                        ResultSet rs4 = stmt4.executeQuery();

                        // Create a new JTable and populate it with the data
                        final Object[][][] data = {new Object[1][37]};
                        if (rs1.next() && rs2.next() && rs3.next() && rs4.next()) {
                            data[0][0][0] = rs1.getInt("id");
                            data[0][0][1] = rs1.getString("Firstname");
                            data[0][0][2] = rs1.getString("Lastname");
                            data[0][0][3] = rs1.getString("DateOfBirth");
                            data[0][0][4] = rs1.getString("Gender");
                            data[0][0][5] = rs1.getString("phoneNo");
                            data[0][0][6] = rs1.getString("address");
                            data[0][0][7] = rs1.getString("email");
                            data[0][0][8] = rs1.getString("EmergencyContact");
                            data[0][0][9] = rs2.getString("PastMedicalCondition");
                            data[0][0][10] = rs2.getString("SurgicalHistory");
                            data[0][0][11] = rs2.getString("Allergies");
                            data[0][0][12] = rs2.getString("CurrentMedications");
                            data[0][0][13] = rs2.getString("FamilyMedicalHistory");
                            data[0][0][14] = rs4.getString("BloodPressure");
                            data[0][0][15] = rs4.getString("Temperature");
                            data[0][0][16] = rs4.getString("HeartRate");
                            data[0][0][17] = rs4.getString("RespiratoryRate");
                            data[0][0][18] = rs4.getString("height");
                            data[0][0][19] = rs4.getString("weight");
                            data[0][0][20] = rs4.getString("PhysicalExamination");
                            data[0][0][21] = rs4.getString("LabTest");
                            data[0][0][22] = rs4.getString("MRI");
                            data[0][0][23] = rs4.getString("X_Ray");
                            data[0][0][24] = rs3.getString("PrescribedMedication");
                            data[0][0][25] = rs3.getString("Dosage");
                            data[0][0][26] = rs3.getString("frequency_and_instructions");
                            data[0][0][27] = rs3.getString("OrderedDiagnosticTests");
                            data[0][0][28] = rs3.getString("ReferralsToSpecialists");
                            data[0][0][29] = rs3.getString("ImmunizationRecords");
                            data[0][0][30] = rs3.getString("Schedule");
                            data[0][0][31] = rs3.getString("InsuranceInfo");
                            data[0][0][32] = rs3.getString("PaymentHistory");
                            data[0][0][33] = rs3.getString("Date");
                            data[0][0][34] = getResultSetData(rs2);
                            data[0][0][35] = getResultSetData(rs3);
                            data[0][0][36] = getResultSetData(rs4);
                        }

                        String[] columns = {"ID", "First Name", "Last Name", "Date of Birth", "Gender", "Phone No.", "Address", "Email", "Emergency Contact", "Past Medical Condition", "Surgical History", "Allergies", "Current Medications", "Family Medical History", "Blood Pressure", "Temperature", "Heart Rate", "Respiratory Rate", "Height", "Weight", "Physical Examination", "Lab Test", "MRI", "X-Ray", "Prescribed Medication", "Dosage", "Frequency and Instructions", "Ordered Diagnostic Tests", "Referrals to Specialists", "Immunization Records", "Schedule", "Insurance Info", "Payment History", "Date"};
                        JTable table = new JTable(data[0], columns);
                        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Disable auto-resize
                        table.setRowHeight(50); // Increase row height

                        // Set the width for all columns
                        TableColumnModel columnModel = table.getColumnModel();
                        for (int i = 0; i < columnModel.getColumnCount(); i++) {
                            columnModel.getColumn(i).setPreferredWidth(200); // Set the preferred width to 150 pixels
                        }
                        // Create a JScrollPane and add the table to it
                        JScrollPane scrollPane = new JScrollPane(table);
                        scrollPane.setPreferredSize(new Dimension(1200, 600)); // Set the size of the scrollpane

                        // Display the table in a JFrame
                        JFrame frameMini = new JFrame("Patient Information");
                        frameMini.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        ImageIcon image = new ImageIcon("C:\\Users\\pc\\Desktop\\Class 8\\Object oriented programming\\Patient record handling project\\Images\\patImage.png");
                        frameMini.setIconImage(image.getImage());

                        JButton addBtnFM = new JButton("Add");
                        JButton editBtnFM = new JButton("Edit");
                        JButton deleteBtnFM = new JButton("Delete");

//                        addBtnFM.setBounds(30,30,50,30);
//                        editBtnFM.setBounds(90,30,50,30);
//                        deleteBtnFM.setBounds(150,30,50,30);

                        addBtnFM.addActionListener(e2 -> {
                            new addPatient();
                        });

                        frameMini.add(new JScrollPane(table));
                        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        buttonPanel.add(addBtnFM);
                        buttonPanel.add(editBtnFM);
                        buttonPanel.add(deleteBtnFM);

                        // Add action listener to the Edit button
                        editBtnFM.addActionListener( e3 -> {
                            new updatePatient();
                        });

                        // Add action listener to the Delete button
                        deleteBtnFM.addActionListener(e3 -> {
                            int selectedRow = table.getSelectedRow(); // Get the selected row
                            if (selectedRow != -1) { // Check if a row is selected
                                int patId = (int) table.getValueAt(selectedRow, 0); // Assuming ID is in the first column

                                // Confirm deletion
                                int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this patient?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                                if (confirmation == JOptionPane.YES_OPTION) {
                                    try {
//                                        Connection conn = com.phr.database.DatabaseConnection.getConnection();

                                        // Prepare delete statement
                                        PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM patients WHERE id = ?");
                                        deleteStmt.setInt(1, patId);
                                        deleteStmt.executeUpdate();

                                        // Remove the selected row from the table
                                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);

                                        // Optionally, refresh the table data if needed
                                        // refreshTableData(); // Implement this method if you want to reload data

                                        JOptionPane.showMessageDialog(null, "Patient deleted successfully.");

                                        conn.close();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Error deleting patient: " + ex.getMessage());
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Please select a patient to delete.");
                            }
                        });
                        // Add the components to the frame
                        frameMini.getContentPane().add(buttonPanel, BorderLayout.NORTH);
                        frameMini.pack();
                        frameMini.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Patient not found.");
                    }

//                    conn.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error displaying patient information: " + e2.getMessage());
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Error displaying patient information: " + e2.getMessage());
                }
            } else{
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
                    tableModel.addColumn("Date");

                    // Create the JTable
                    JTable table = new JTable(tableModel);
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Disable auto-resize
                    table.setRowHeight(50); // Increase row height

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

                    // Create the frame and set the icon
                    JFrame frameMini2 = new JFrame("Patient Records");
                    frameMini2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frameMini2.setIconImage(new ImageIcon("C:\\Users\\pc\\IdeaProjects\\Patient record handler\\src\\Images\\patImage.png").getImage());
                    frameMini2.getContentPane().add(scrollPane, "Center");
                    JButton addBtnFM = new JButton("Add");
                    JButton editBtnFM = new JButton("Edit");
                    JButton deleteBtnFM = new JButton("Delete");

//                    addBtnFM.setBounds(30,30,50,30);
//                    editBtnFM.setBounds(90,30,50,30);
//                    deleteBtnFM.setBounds(150,30,50,30);

                    addBtnFM.addActionListener(e2 -> {
                        new addPatient();
                    });

                    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    buttonPanel.add(addBtnFM);
                    buttonPanel.add(editBtnFM);
                    buttonPanel.add(deleteBtnFM);

                    editBtnFM.addActionListener( e3 -> {
                        new updatePatient();
                    });

                    deleteBtnFM.addActionListener(e2 -> {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) {
                            try {
//                                Connection conn = com.phr.database.DatabaseConnection.getConnection();
                                Statement statement2 = conn.createStatement();

                                // Get the patient ID from the selected row
                                int patientId = (int) tableModel.getValueAt(selectedRow, 0);

                                // Execute the DELETE query
                                int rowsDeleted = statement2.executeUpdate("DELETE FROM patients WHERE id = " + patientId);

                                if (rowsDeleted > 0) {
                                    // Remove the corresponding row from the table model
                                    tableModel.removeRow(selectedRow);
                                    JOptionPane.showMessageDialog(frameMini2, "Patient record deleted successfully.");
                                } else {
                                    JOptionPane.showMessageDialog(frameMini2, "Failed to delete patient record.", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                                statement2.close();
//                                conn.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(frameMini2, "Error deleting patient record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(frameMini2, "Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    });
                    // Add the components to the frame
                    frameMini2.getContentPane().add(buttonPanel, BorderLayout.NORTH);

                    frameMini2.add(new JScrollPane(table));
//                    frameMini2.add(addBtnFM);
//                    frameMini2.add(editBtnFM);
//                    frameMini2.add(deleteBtnFM);
                    frameMini2.add(new JScrollPane(table));
                    frameMini2.pack();
                    // Add the table to the frame
                    getContentPane().add(scrollPane, "Center");
                    frameMini2.setVisible(true);

                    // Close the resources
                    statement.close();
//                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            });

        Reset.addActionListener(e -> {
//            frame5.setVisible(false);
//            frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            new mainFunc();
            searchFField.setText("");
            searchLField.setText("");
        });

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
            String Date = medicationAndPaymentsResultSet.getString("Date");

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
                    tableModel.setValueAt(Date, i, 33);
                    break;
                }
            }
        }
        medicationAndPaymentsResultSet.close();
    }

    private static String getResultSetData(ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        while (rs.next()) {
            sb.append(rs.getString(1)).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
    }

}