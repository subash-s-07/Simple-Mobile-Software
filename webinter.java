package Software;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class webinter {
    private JButton GOOGLE;
    private JButton YAHOOButton;
    private JButton BINGButton;
    private JPanel panel1;
    private JTextArea ENTERWEBSITETextArea;
    private JTextField textField1;
    private JButton SEARCHButton;

    public webinter() {
        GOOGLE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //google
                String url = "www.google.com";
                try {

                    URI uri = new URI(url);

                    java.awt.Desktop.getDesktop().browse(uri);
                    System.out.println("Web page opened in browser");

                } catch (Exception eo) {

                    eo.printStackTrace();

                }
            }
        });
        YAHOOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //yahoo
                String url = "www.yahoo.com";
                try {

                    URI uri = new URI(url);

                    java.awt.Desktop.getDesktop().browse(uri);
                    System.out.println("Web page opened in browser");

                } catch (Exception eo) {

                    eo.printStackTrace();

                }
            }
            }
        );
        BINGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "www.bing.com";
                try {

                    URI uri = new URI(url);

                    java.awt.Desktop.getDesktop().browse(uri);
                    System.out.println("Web page opened in browser");

                } catch (Exception eo) {

                    eo.printStackTrace();

                }
            }
        });
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //search
                String url = textField1.getText();
                try {

                    URI uri = new URI(url);

                    java.awt.Desktop.getDesktop().browse(uri);
                    System.out.println("Web page opened in browser");

                } catch (Exception eo) {

                    eo.printStackTrace();

                }
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = textField1.getText();
                try {

                    URI uri = new URI(url);

                    java.awt.Desktop.getDesktop().browse(uri);
                    System.out.println("Web page opened in browser");

                } catch (Exception eo) {

                    eo.printStackTrace();

                }
            }
        });
    }

        public static void main() {
            JFrame f1 = new JFrame("New");
            f1.setContentPane(new webinter().panel1);
            f1.setSize(500,500);
            f1.setVisible(true);
        }
    }



