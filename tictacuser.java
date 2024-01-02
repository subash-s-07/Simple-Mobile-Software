package Software;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Software.TicTacToeGameinSwing;

public class tictacuser {
    private JPanel panel1;
    private JButton playButton;
    private JTextField textField1;
    private JTextField textField2;

    tictacuser()
    {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new TicTacToeGameinSwing(textField1.getText(),textField2.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame f1 = new JFrame("New");
        f1.setContentPane(new tictacuser().panel1);
        f1.setSize(400,200);
        f1.setVisible(true);
    }
}
