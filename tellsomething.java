package Software;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class tellsomething {
    private JPanel panel1;
    private JButton pressButton;
    private JTextField tellmeSomethingTextField;

    public tellsomething() {

        tellmeSomethingTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if((int)e.getKeyChar() == KeyEvent.VK_ENTER) {
                    System.out.println("Enter");
                    Runtime runtime = Runtime.getRuntime();     //getting Runtime object

                    try
                    {
                        runtime.exec(tellmeSomethingTextField.getText());        //opens new notepad instance
                        // runtime.exec("speechtotxt.py");
                        //OR runtime.exec("notepad");
                    }
                    catch (IOException e2)
                    {
                        e2.printStackTrace();
                    }
                }
                System.out.println(e.getKeyChar());
            }
        });
        pressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime runtime = Runtime.getRuntime();     //getting Runtime object

                try
                {
                    runtime.exec(tellmeSomethingTextField.getText());        //opens new notepad instance
                    // runtime.exec("speechtotxt.py");
                    //OR runtime.exec("notepad");
                }
                catch (IOException e3)
                {
                    e3.printStackTrace();
                }
            }
        });
        tellmeSomethingTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                tellmeSomethingTextField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame f1 = new JFrame("New");
        f1.setContentPane(new tellsomething().panel1);
        f1.setSize(400,200);
        f1.setVisible(true);
    }
}
