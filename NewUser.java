package Software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUser{
    private JPanel panel1;
    private JFormattedTextField PASSWORDFormattedTextField;
    private JFormattedTextField MOBILENUMBERFormattedTextField;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;


    public NewUser() {
        button1.setIcon(new ImageIcon("engine.png"));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String k = passwordField1.getText();
                System.out.println(k);
            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("New");
        f.setContentPane(new NewUser().panel1);
        f.setSize(500,500);
        f.setVisible(true);
    }
}
