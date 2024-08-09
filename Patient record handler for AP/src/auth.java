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
//        JButton addUser = new JButton("Add user");
        JButton submit1 = new JButton("Submit");
        JButton reset1 = new JButton("Reset");

        label.setBounds(510, 320, 250, 10);
        changePass.setBounds(10, 10, 200, 15);
//        addUser.setBounds(1000, 10, 200, 15);
        passwordF.setBounds(500, 350, 250, 30);
        submit1.setBounds(460, 400, 130, 30);
        reset1.setBounds(660, 400, 130, 30);

        frame.add(label);
        frame.add(passwordF);
        frame.add(changePass);
//        frame.add(addUser);
        frame.add(submit1);
        frame.add(reset1);

        changePass.addActionListener(e -> {
            //closes the current frame and changePassword frame
            frame.setVisible(false);
            changePassword();
        });
//        addUser.addActionListener(e -> {
//            //closes the current frame and changePassword frame
//            frame.setVisible(false);
//            addUser();
//        });
        submit1.addActionListener(e -> {
            //checks if it's empty
            String password = passwordF.getText();
            if (!(password.isEmpty())) {
                //stores the entered password to a variable
                try {
                    PreparedStatement stmt1 = conn.prepareStatement("SELECT pass FROM auth");
                    ResultSet rs1 = stmt1.executeQuery();
                    if (rs1.next() && Objects.equals(password, rs1.getString("pass"))) {
                        frame.setVisible(false);
//                        new mainFunc();
                        new showallPatients();
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
                        JOptionPane.showMessageDialog(frame2, "Invalid Password", "Error", JOptionPane.ERROR_MESSAGE);
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

    // for adding employees information and password
//    private static void addUser() {
//        Frame frame3 = new Frame();
//        Connection conn = DatabaseConnection.getConnection();
//
//        JLabel label1 = new JLabel();
//        JLabel label2 = new JLabel();
//        JLabel label3 = new JLabel();
//
//        JButton back = new JButton("Back");
//        label1.setText("EMPLOYEE NAME: ");
//        label2.setText("PASSWORD: ");
//        label3.setText("ADMIN PASSWORD: ");
//        label1.setForeground(Color.WHITE);
//        label2.setForeground(Color.WHITE);
//        label3.setForeground(Color.WHITE);
//        JTextField name = new JTextField();
//        JPasswordField password = new JPasswordField();
//        JPasswordField adminPass = new JPasswordField();
//
////        JButton changePass = new JButton("Change Password");
//        JButton submit2 = new JButton("Add");
//        JButton reset2 = new JButton("Reset");
//        JButton delete = new JButton("Delete");
//
//        back.setBounds(10, 10, 80, 15);
//        label1.setBounds(385, 200, 250, 10);
//        label2.setBounds(385, 250, 250, 10);
//        label3.setBounds(360, 300, 250, 10);
//        name.setBounds(500, 195, 200, 30);
//        password.setBounds(500, 245, 200, 30);
//        adminPass.setBounds(500, 295, 200, 30);
//        submit2.setBounds(420, 400, 130, 30);
//        reset2.setBounds(620, 400, 130, 30);
//        delete.setBounds(820, 400, 130, 30);
//
//        frame3.add(back);
//        frame3.add(label1);
//        frame3.add(label2);
//        frame3.add(label3);
//        frame3.add(name);
//        frame3.add(password);
//        frame3.add(adminPass);
//        frame3.add(submit2);
//        frame3.add(reset2);
//        frame3.add(delete);
//
//        submit2.addActionListener(e -> {
//            if (!(name.getText().isEmpty()) && !(password.getText().isEmpty()) && !(adminPass.getText().isEmpty())) {
//                String password1 = name.getText();
//                String password2 = password.getText();
//                String password3 = adminPass.getText();
//                try {
//                    PreparedStatement stmt1 = conn.prepareStatement("SELECT pass FROM auth");
//                    ResultSet rs1 = stmt1.executeQuery();
//                    if (rs1.next() && Objects.equals(password1, rs1.getString("pass"))) {
////                        frame2.setVisible(false);
////                        new mainFunc();
//                        if (Objects.equals(password2, password3)) {
//                            try {
//                                PreparedStatement preparedStmt = conn.prepareStatement("UPDATE auth SET pass = ? WHERE id = 1");
//                                preparedStmt.setString(1, password2);
//                                preparedStmt.executeUpdate();
//                                JOptionPane.showMessageDialog(frame3, "Password changed successfully, If you want to change again go back and click on change password again");
//                            } catch (SQLException ex) {
//                                throw new RuntimeException(ex);
//                            }
//                            conn.close();
//                        }
//                        else{
//                            JOptionPane.showMessageDialog(frame3, "Passwords do not match");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(frame3, "Invalid Password");
//                    }
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
//            } else {
//                JOptionPane.showMessageDialog(frame3, "Please enter a password!");
//            }
//        });
//
//        reset2.addActionListener(e -> {
//            name.setText("");
//            password.setText("");
//            adminPass.setText("");
//        });
//
//        back.addActionListener(e -> {
//            frame3.setVisible(false);
//            new auth();
//        });
//    }
}
