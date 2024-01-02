package Software;

public class PY {
    public static void main(String[] args) {
        String cmd = "D:\\python\\";
        String py = "main";
        String run = "python " + cmd + py + ".py";
        System.out.println(run);
        //Runtime.getRuntime().exec(run);
try {
    Process p = Runtime.getRuntime().exec("Notepad.exe");
}
catch (Exception e)
{
    System.out.println(e);
}
    }
}
