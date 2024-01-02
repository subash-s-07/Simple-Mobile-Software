package Software;


import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

 class MyCalculator extends Frame {
    public boolean setClear = true;
    double number;
    double memValue;
    char op;
    String[] digitButtonText = new String[]{"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "+/-", "."};
    String[] operatorButtonText = new String[]{"/", "sqrt", "*", "%", "-", "1/X", "+", "="};
    String[] memoryButtonText = new String[]{"MC", "MR", "MS", "M+"};
    String[] specialButtonText = new String[]{"Backspc", "C", "CE"};
    MyDigitButton[] digitButton;
    MyOperatorButton[] operatorButton;
    //MyMemoryButton[] memoryButton;
    MySpecialButton[] specialButton;
    Label displayLabel;
    Label memLabel;
    final int FRAME_WIDTH;
    final int FRAME_HEIGHT;
    final int HEIGHT;
    final int WIDTH;
    final int H_SPACE;
    final int V_SPACE;
    final int TOPX;
    final int TOPY;

    MyCalculator(String var1) {
        super(var1);
        this.digitButton = new MyDigitButton[this.digitButtonText.length];
        this.operatorButton = new MyOperatorButton[this.operatorButtonText.length];
        //this.memoryButton = new MyMemoryButton[this.memoryButtonText.length];
        this.specialButton = new MySpecialButton[this.specialButtonText.length];
        this.displayLabel = new Label("0", 2);
        this.memLabel = new Label(" ", 2);
        this.FRAME_WIDTH = 325;
        this.FRAME_HEIGHT = 325;
        this.HEIGHT = 30;
        this.WIDTH = 30;
        this.H_SPACE = 10;
        this.V_SPACE = 10;
        this.TOPX = 30;
        this.TOPY = 50;
        int var2 = 30;
        int var3 = 50;
        this.displayLabel.setBounds(var2, var3, 240, 30);
        this.displayLabel.setBackground(Color.BLUE);
        this.displayLabel.setForeground(Color.WHITE);
        this.add(this.displayLabel);
        this.memLabel.setBounds(30, 90, 30, 30);
        this.add(this.memLabel);
        var2 = 30;
        var3 = 130;

        int var4;
        /*for(var4 = 0; var4 < this.memoryButton.length; ++var4) {
            this.memoryButton[var4] = new MyMemoryButton(var2, var3, 30, 30, this.memoryButtonText[var4], this);
            this.memoryButton[var4].setForeground(Color.RED);
            var3 += 40;
        }*/

        var2 = 70;
        byte var9 = 90;

        for(var4 = 0; var4 < this.specialButton.length; ++var4) {
            this.specialButton[var4] = new MySpecialButton(var2, var9, 60, 30, this.specialButtonText[var4], this);
            this.specialButton[var4].setForeground(Color.RED);
            var2 = var2 + 60 + 10;
        }

        byte var10 = 70;
        short var5 = 130;
        var2 = var10;
        var3 = var5;

        int var6;
        for(var6 = 0; var6 < this.digitButton.length; ++var6) {
            this.digitButton[var6] = new MyDigitButton(var2, var3, 30, 30, this.digitButtonText[var6], this);
            this.digitButton[var6].setForeground(Color.BLUE);
            var2 += 40;
            if ((var6 + 1) % 3 == 0) {
                var2 = var10;
                var3 += 40;
            }
        }

        var6 = var10 + 80 + 10;
        var2 = var6;
        var3 = var5;

        for(int var8 = 0; var8 < this.operatorButton.length; ++var8) {
            var2 += 40;
            this.operatorButton[var8] = new MyOperatorButton(var2, var3, 30, 30, this.operatorButtonText[var8], this);
            this.operatorButton[var8].setForeground(Color.RED);
            if ((var8 + 1) % 2 == 0) {
                var2 = var6;
                var3 += 40;
            }
        }

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent var1) {
                System.exit(0);
            }
        });
        this.setLayout((LayoutManager)null);
        this.setSize(325, 325);
        this.setVisible(true);
    }

    static String getFormattedText(double var0) {
        String var2 = "" + var0;
        if (var2.lastIndexOf(".0") > 0) {
            var2 = var2.substring(0, var2.length() - 2);
        }

        return var2;
    }

    public static void main() {
        new MyCalculator("Calculator");
    }
}
