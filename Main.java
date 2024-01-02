package Software;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
class ButtonExample {
    public static void main(String[] args) {
        JFrame f=new JFrame("Mobile Interface");
        JButton b5=new JButton(new ImageIcon("D:\\Java\\3.png"));
        JButton b1=new JButton(new ImageIcon("D:\\Java\\2.png"));
        JButton b2=new JButton(new ImageIcon("D:\\Java\\Cal.png"));
        JButton b3=new JButton(new ImageIcon("D:\\Java\\4.png"));
        JButton b4=new JButton(new ImageIcon("D:\\Java\\5.png"));
        JButton b6=new JButton(new ImageIcon("D:\\Java\\6.png"));
        JButton b7=new JButton(new ImageIcon("D:\\Java\\7.png"));
        JButton b8=new JButton(new ImageIcon("D:\\Java\\8.png"));
        JButton b9=new JButton(new ImageIcon("D:\\Java\\1.png"));
        JButton b11=new JButton(new ImageIcon("D:\\Java\\111.png"));
        JButton b12=new JButton(new ImageIcon("D:\\Java\\12.png"));
        JButton b10=new JButton(new ImageIcon("D:\\Java\\10.png"));
        JButton b13=new JButton(new ImageIcon("D:\\Java\\13.png"));
        JButton b14=new JButton(new ImageIcon("D:\\Java\\14.png"));
        JButton b15=new JButton(new ImageIcon("D:\\Java\\15.png"));
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.main();
            }

        });
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                webinter.main();
            }

        });
        b5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.main();
            }

        });
        b7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                alexa.main();
            }

        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCalculator.main();
            }

        });
        b11.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                albutton.main();
            }

        });
        b10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Notepad.main();
            }

        });
        b13.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarProgram.main();
            }

        });
        b14.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                TextToSpeech.main();
            }

        });
        b15.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Screenshot.main();
            }

        });
        b9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.main();
                }
                catch (Exception m)
                {

                }
            }

        });
        b12.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GameFrame();
                }
                catch (Exception m)
                {
                }
            }

        });
        b8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    URI uri= new URI("https://www.windy.com/VOCB?11.030,75.944,8");

                    java.awt.Desktop.getDesktop().browse(uri);

                } catch (Exception m) {

                }

            }

        });
        b6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    URI uri= new URI("https://open.spotify.com/");

                    java.awt.Desktop.getDesktop().browse(uri);

                } catch (Exception m) {

                }

            }

        });
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    URI uri= new URI("https://onlineradiofm.in/stations/suryan");

                    java.awt.Desktop.getDesktop().browse(uri);

                } catch (Exception m) {

                }

            }

        });
        b7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    URI uri= new URI("https://www.youtube.com/?gl=IN");

                    java.awt.Desktop.getDesktop().browse(uri);

                } catch (Exception m) {

                }

            }

        });

        b1.setBounds(0,0,175,150);
        b2.setBounds(0,150,175,150);
        b3.setBounds(0,300,175,150);
        b4.setBounds(175,0,175,150);
        b5.setBounds(175,150,175,150);
        b6.setBounds(175,300,175,150);
        b7.setBounds(350,0,175,150);
        b8.setBounds(350,150,175,150);
        b9.setBounds(350,300,175,150);
        b10.setBounds(525,0,175,150);
        b12.setBounds(525,150,175,150);
        b11.setBounds(525,300,175,150);
        b13.setBounds(700,0,175,150);
        b14.setBounds(700,150,175,150);
        b15.setBounds(700,300,175,150);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b10);
        f.add(b12);
        f.add(b11);
        f.add(b13);
        f.add(b14);
        f.add(b15);


        f.setSize(875,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}