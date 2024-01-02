package Software;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

// Java program to play an Audio
// file using Clip Object
import java.io.File;
import java.io.IOException;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class ASimpleAudioPlayer
{

    // to store current position
    Long currentFrame;
    Clip clip;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;
    static String filePath;

    // constructor to initialize streams and clip
    public ASimpleAudioPlayer()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        System.out.println("In");
        filePath = "D:\\1.wav";
        // create AudioInputStream object
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);

        try
        {
            //filePath = "Your path for the file";
            ASimpleAudioPlayer audioPlayer =
                    new ASimpleAudioPlayer();

            audioPlayer.play();

        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }



    // Work as the user enters his choice


    // Method to play the audio
    public void play()
    {
        //start the clip
        clip.start();

        status = "play";
    }



    // Method to reset audio stream
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}

class alrm{
    String getInput;

    alrm(String l)

    {
        getInput = l;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        String d = dtf.format(localTime);
        System.out.println(d);

        LocalTime time1
                = LocalTime.parse(dtf.format(localTime));
        LocalTime time2
                = LocalTime.parse(getInput);

        // apply compareTo()
        int value = time1.compareTo(time2);

        // print LocalDateTime
        if (value > 0) {
            System.out.println("Alarm CAnt be set");
        }
        else if (value == 0) {
            System.out.println("Alarm ringin");
        }
        else {

            System.out.println("Process");
            try {
                String time11 = String.valueOf(time2);
                String time22 = String.valueOf(time1);

                // Creating a SimpleDateFormat object
                // to parse time in the format HH:MM:SS
                SimpleDateFormat simpleDateFormat
                        = new SimpleDateFormat("HH:mm:ss");

                // Parsing the Time Period
                Date date1 = simpleDateFormat.parse(time11);
                Date date2 = simpleDateFormat.parse(time22);

                // Calculating the difference in milliseconds
                long differenceInMilliSeconds
                        = Math.abs(date2.getTime() - date1.getTime());

                // Calculating the difference in Hours
                long differenceInHours
                        = (differenceInMilliSeconds / (60 * 60 * 1000))
                        % 24;

                // Calculating the difference in Minutes
                long differenceInMinutes
                        = (differenceInMilliSeconds / (60 * 1000)) % 60;

                // Calculating the difference in Seconds
                long differenceInSeconds
                        = (differenceInMilliSeconds / 1000) % 60;

                // Printing the answer
                System.out.println(
                        "Difference is " + differenceInHours + " hours "
                                + differenceInMinutes + " minutes "
                                + differenceInSeconds + " Seconds. ");
                int minss = (int) (differenceInHours * 3600 + differenceInMinutes * 60 + differenceInSeconds);
                System.out.println(minss);
                //minss = minss*1000;
                Thread.sleep(minss);
                //playsong
                ASimpleAudioPlayer ff = new ASimpleAudioPlayer();

            }catch (Exception t)
            {
                t.printStackTrace();
            }
        }
    }
    public static void main() {

        alrm b = new alrm("14:40:37");

    }
}