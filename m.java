package Software;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.rmi.server.ExportException;

public class m {
    private JPanel panel1;
    private JButton a1Button;
    private JButton a2Button;
    private JButton PAUSEButton;
    private JButton STOPButton;
    private JButton RESUMEButton;
    private JButton PREVIOUSButton;
    private JSlider slider1;
    String [] music = new String[10];
    Software.SimpleAudioPlayer m;
    int i;
    public m() {
        music[0] = "D:\\4.wav";
        music[1] = "D:\\2.wav";
        music[2] = "D:\\3.wav";
        music[3] = "D:\\1.wav";
        music[4] = "D:\\5.wav";
        i=0;
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Software.SimpleAudioPlayer s = new SimpleAudioPlayer(music[i]);
                    m=s;
                }
                catch (Exception r)
                {

                }
            }

        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    i++;
                    m.stop();
                    Software.SimpleAudioPlayer s = new SimpleAudioPlayer(music[i]);
                    m=s;
                }
                catch (Exception r)
                {

                }
            }
        });
        PAUSEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    m.stop();
                }
                catch (Exception m)
                {

                }
            }
        });
        RESUMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    m.resumeAudio();
                }
                catch (Exception r)
                {

                }
            }
        });
        PREVIOUSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    i--;
                    m.stop();
                    Software.SimpleAudioPlayer s = new SimpleAudioPlayer(music[i]);
                    m=s;
                }
                catch (Exception r)
                {

                }
            }
        });
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //System.out.println(("Value : " + ((JSlider)e.getSource()).getValue()));
                //System.out.println(slider1.getValue());
                try {
                    slider1.setMinimum(0);
                    slider1.setMaximum(237238276);
                    System.out.println((long)slider1.getValue());
                    m.jump((long)slider1.getValue());

                }
                catch (Exception b)
                {
                    System.out.println(b);
                }
            }
        });
    }

    public static void main() {
        JFrame f1 = new JFrame("New");
        f1.setContentPane(new m().panel1);
        f1.setSize(500,500);
        f1.setVisible(true);
    }
}
