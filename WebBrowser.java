package Software;
//open browser
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
public class WebBrowser extends JFrame implements ActionListener{
    JLabel l;
    JTextField tf;
    JButton b;
    WebBrowser(){
        super("BROWSER :)");
        l=new JLabel("Enter Website U want to go for:");
        l.setBounds(50,70,250,50);;
        tf=new JTextField();
        tf.setBounds(50,150,300,30);

        b=new JButton("");
        b.setBounds(50,250,400,200);
        b.addActionListener(this);


        //setBackground(Color.RED);

        try {
            Image img = ImageIO.read(getClass().getResource("searchicon.png"));
            b.setIcon(new ImageIcon(img));
        }
        catch (Exception e)
        {
            System.out.println("No search");
        }

        add(l);
        add(tf);
        add(b);

        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String url = tf.getText();
        try {

            URI uri = new URI(url);

            java.awt.Desktop.getDesktop().browse(uri);
            System.out.println("Web page opened in browser");

        } catch (Exception eo) {

            eo.printStackTrace();

        }
    }
    public static void main(String[] args) {
        new WebBrowser();
    }
}