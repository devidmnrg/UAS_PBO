package View;

import Controller.Controller;
import Model.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Devid L Manurung
 */
public class MenuLogin {
    Controller control = new Controller();
    JFrame jframe;
    JTextField email;
    JPasswordField passwordField;
    JButton login;
    JButton regisNewUser;
  public MenuLogin() {
        jframe = new JFrame();
        jframe.setTitle("HB Game Store - Login");
        jframe.setSize(300, 200);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);

        //ini email
        JLabel labelEmail = new JLabel("Email : ");
        labelEmail.setBounds(10, 10, 80, 20);
        jframe.add(labelEmail);

        email = new JTextField(20);
        email.setBounds(100, 10, 180, 20);
        jframe.add(email);

        //ini pw
        JLabel labelPw = new JLabel("Password : ");
        labelPw.setBounds(10, 40, 80, 20);
        jframe.add(labelPw);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 40, 180, 20);
        jframe.add(passwordField);

        login = new JButton("Login");
        login.setBounds(35, 65, 80, 20);
        login.setEnabled(true);
        jframe.add(login);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userEmail = email.getText();
                String userPassword = new String(passwordField.getPassword());
                Users loggedInUser = control.getUser(userEmail, userPassword);
                
                if (loggedInUser.getId() != 0) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil!");
                    new MenuGameList(loggedInUser);
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal untuk login. Email atau password salah.");
                }
            }
        });

        

        jframe.setVisible(true);
    }
    public static void main(String[] args) {
        new MenuLogin();
    }
}