package Software;
import java.io.IOException;
import java.util.*;
public class alexa {
    public static void main()
    {
        Runtime runtime = Runtime.getRuntime();     //getting Runtime object

        try
        {
            runtime.exec("speechtotxt.py");        //opens new notepad instance
           // runtime.exec("speechtotxt.py");
            //OR runtime.exec("notepad");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
