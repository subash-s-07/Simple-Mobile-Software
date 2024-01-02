
package Software;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.*;

public class TextToSpeech extends JFrame implements ActionListener {
    JLabel l;
    JTextField tf;
    JButton b;
    TextToSpeech(){
        super("TEXT TO SPEECH :)");
        l=new JLabel("Enter tEXT :");
        l.setBounds(50,70,250,50);;
        tf=new JTextField();
        tf.setBounds(50,150,300,30);

        b=new JButton("");
        b.setBounds(50,250,200,200);
        b.addActionListener(this);


        //setBackground(Color.RED);

        try {
            Image img = ImageIO.read(getClass().getResource("speakers.png"));
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
        try{
            System.setProperty(
                    "freetts.voices",
                    "com.sun.speech.freetts.en.us"
                            + ".cmu_us_kal.KevinVoiceDirectory");

            // Register Engine
            Central.registerEngineCentral(
                    "com.sun.speech.freetts"
                            + ".jsapi.FreeTTSEngineCentral");

            // Create a Synthesizer
            Synthesizer synthesizer
                    = Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US));

            // Allocate synthesizer
            synthesizer.allocate();

            // Resume Synthesizer
            synthesizer.resume();

            // Speaks the given text
            // until the queue is empty.
            synthesizer.speakPlainText(url, null);
            synthesizer.waitEngineState(
                    Synthesizer.QUEUE_EMPTY);

            // Deallocate the Synthesizer.
            synthesizer.deallocate();
            Thread.sleep(Long.parseLong("1000"));
            //synthesizer.speakPlainText("BYE", null);
            setVisible(false);
            System.exit(0);

        } catch (Exception eo) {

            eo.printStackTrace();

        }
    }
    public static void main() {
        new TextToSpeech();
    }
}
