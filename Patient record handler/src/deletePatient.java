import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deletePatient extends Component {
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

        Submit.addActionListener(e -> {
            String firstName = FField.getText().trim();
            String lastName = LField.getText().trim();
            deletePatientFunc(firstName, lastName);
//            System.out.println("Patient deleted successfully");

        });


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

    private void deletePatientFunc(String firstName, String lastName) {

//        if (firstName.isEmpty() || lastName.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter both first and last name.");
//            return;
//        }

        try {
            // Connect to the database
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            Connection conn = DatabaseConnection.getConnection();

            conn.setAutoCommit(false);

            // Prepare the SQL delete statements
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM patients WHERE Firstname = ? AND Lastname = ?");
            PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM medical_conditions WHERE id = (SELECT id FROM patients WHERE Firstname = ? AND Lastname = ?)");
            PreparedStatement stmt3 = conn.prepareStatement("DELETE FROM medications_and_payments WHERE id = (SELECT id FROM patients WHERE Firstname = ? AND Lastname = ?)");
            PreparedStatement stmt4 = conn.prepareStatement("DELETE FROM tests WHERE id = (SELECT id FROM patients WHERE Firstname = ? AND Lastname = ?)");

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt2.setString(1, firstName);
            stmt2.setString(2, lastName);
            stmt3.setString(1, firstName);
            stmt3.setString(2, lastName);
            stmt4.setString(1, firstName);
            stmt4.setString(2, lastName);

            // Execute the delete statement
            int rowsDeleted = stmt.executeUpdate();
            int rowsDeleted2 = stmt2.executeUpdate();
            int rowsDeleted3 = stmt3.executeUpdate();
            int rowsDeleted4 = stmt4.executeUpdate();

            if (rowsDeleted > 0 && rowsDeleted2 > 0 && rowsDeleted3 > 0 && rowsDeleted4 > 0) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Patient deleted successfully!");
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Patient not found.");
            }

            // Close the connection
            conn.close();
        }
        catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting patient: " + e.getMessage());
        }
        finally {
//            throw new RuntimeException(e);
            JOptionPane.showMessageDialog(null, "Error deleting patient: ");
        }
    }
}

