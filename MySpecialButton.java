package Software;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MySpecialButton extends Button implements ActionListener {
    MyCalculator cl;

    MySpecialButton(int var1, int var2, int var3, int var4, String var5, MyCalculator var6) {
        super(var5);
        this.setBounds(var1, var2, var3, var4);
        this.cl = var6;
        this.cl.add(this);
        this.addActionListener(this);
    }

    static String backSpace(String var0) {
        String var1 = "";

        for(int var2 = 0; var2 < var0.length() - 1; ++var2) {
            var1 = var1 + var0.charAt(var2);
        }

        return var1;
    }

    public void actionPerformed(ActionEvent var1) {
        String var2 = ((MySpecialButton)var1.getSource()).getLabel();
        if (var2.equals("Backspc")) {
            String var3 = backSpace(this.cl.displayLabel.getText());
            if (var3.equals("")) {
                this.cl.displayLabel.setText("0");
            } else {
                this.cl.displayLabel.setText(var3);
            }

        } else {
            if (var2.equals("C")) {
                this.cl.number = 0.0;
                this.cl.op = ' ';
                this.cl.memValue = 0.0;
                this.cl.memLabel.setText(" ");
            }

            this.cl.displayLabel.setText("0");
            this.cl.setClear = true;
        }
    }
}
