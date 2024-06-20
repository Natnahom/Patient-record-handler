import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Objects;

public class auth {
    auth(){
        Frame frame = new Frame();
        Connection conn = DatabaseConnection.getConnection();

        JLabel label = new JLabel();
        label.setText("ENTER ADMINISTRATOR PASSWORD: ");
        label.setForeground(Color.WHITE);
        JPasswordField passwordF = new JPasswordField();

        JButton changePass = new JButton("Change Password");
        JButton submit1 = new JButton("Submit");
        JButton reset1 = new JButton("Reset");

        label.setBounds(470, 320, 250, 10);
        changePass.setBounds(10, 10, 200, 15);
        passwordF.setBounds(460, 350, 250, 30);
        submit1.setBounds(420, 400, 130, 30);
        reset1.setBounds(620, 400, 130, 30);

        frame.add(label);
        frame.add(passwordF);
        frame.add(changePass);
        frame.add(submit1);
        frame.add(reset1);

        changePass.addActionListener(e -> {
            frame.setVisible(false);
            changePassword();
        });
        submit1.addActionListener(e -> {
            if (!(passwordF.getText().isEmpty())) {
                String password = passwordF.getText();
                try {
                    PreparedStatement stmt1 = conn.prepareStatement("SELECT pass FROM auth");
                    ResultSet rs1 = stmt1.executeQuery();
                    if (rs1.next() && Objects.equals(password, rs1.getString("pass"))) {
                        frame.setVisible(false);
                        new mainFunc();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid Password");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a password!");
            }
        });
        reset1.addActionListener(e -> {
            passwordF.setText("");
        });
    }

    private static void changePassword() {
        Frame frame2 = new Frame();
        Connection conn = DatabaseConnection.getConnection();

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();

        JButton back = new JButton("Back");
        label1.setText("OLD PASSWORD: ");
        label2.setText("NEW PASSWORD: ");
        label3.setText("CONFIRM PASSWORD: ");
        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        JPasswordField passwordO = new JPasswordField();
        JPasswordField passwordN = new JPasswordField();
        JPasswordField passwordC = new JPasswordField();

//        JButton changePass = new JButton("Change Password");
        JButton submit2 = new JButton("Submit");
        JButton reset2 = new JButton("Reset");

        back.setBounds(10, 10, 80, 15);
        label1.setBounds(385, 200, 250, 10);
        label2.setBounds(385, 250, 250, 10);
        label3.setBounds(360, 300, 250, 10);
        passwordO.setBounds(500, 195, 200, 30);
        passwordN.setBounds(500, 245, 200, 30);
        passwordC.setBounds(500, 295, 200, 30);
        submit2.setBounds(420, 400, 130, 30);
        reset2.setBounds(620, 400, 130, 30);

        frame2.add(back);
        frame2.add(label1);
        frame2.add(label2);
        frame2.add(label3);
        frame2.add(passwordO);
        frame2.add(passwordN);
        frame2.add(passwordC);
        frame2.add(submit2);
        frame2.add(reset2);

        submit2.addActionListener(e -> {
            if (!(passwordO.getText().isEmpty()) && !(passwordN.getText().isEmpty()) && !(passwordC.getText().isEmpty())) {
                String password1 = passwordO.getText();
                String password2 = passwordN.getText();
                String password3 = passwordC.getText();
                try {
                    PreparedStatement stmt1 = conn.prepareStatement("SELECT pass FROM auth");
                    ResultSet rs1 = stmt1.executeQuery();
                    if (rs1.next() && Objects.equals(password1, rs1.getString("pass"))) {
//                        frame2.setVisible(false);
//                        new mainFunc();
                        if (Objects.equals(password2, password3)) {
                            try {
                                PreparedStatement preparedStmt = conn.prepareStatement("UPDATE auth SET pass = ? WHERE id = 1");
                                preparedStmt.setString(1, password2);
                                preparedStmt.executeUpdate();
                                JOptionPane.showMessageDialog(frame2, "Password changed successfully, If you want to change again go back and click on change password again");
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                            conn.close();
                        }
                        else{
                            JOptionPane.showMessageDialog(frame2, "Passwords do not match");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame2, "Invalid Password");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(frame2, "Please enter a password!");
            }
        });

        reset2.addActionListener(e -> {
            passwordO.setText("");
            passwordN.setText("");
            passwordC.setText("");
        });

        back.addActionListener(e -> {
            frame2.setVisible(false);
            new auth();
        });
    }
}
