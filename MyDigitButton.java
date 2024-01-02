package Software;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyDigitButton extends Button implements ActionListener {
    MyCalculator cl;

    MyDigitButton(int var1, int var2, int var3, int var4, String var5, MyCalculator var6) {
        super(var5);
        this.setBounds(var1, var2, var3, var4);
        this.cl = var6;
        this.cl.add(this);
        this.addActionListener(this);
    }

    static boolean isInString(String var0, char var1) {
        for(int var2 = 0; var2 < var0.length(); ++var2) {
            if (var0.charAt(var2) == var1) {
                return true;
            }
        }

        return false;
    }

    public void actionPerformed(ActionEvent var1) {
        String var2 = ((MyDigitButton)var1.getSource()).getLabel();
        if (var2.equals(".")) {
            if (this.cl.setClear) {
                this.cl.displayLabel.setText("0.");
                this.cl.setClear = false;
            } else if (!isInString(this.cl.displayLabel.getText(), '.')) {
                this.cl.displayLabel.setText(this.cl.displayLabel.getText() + ".");
            }

        } else {
            boolean var3 = false;

            int var6;
            try {
                var6 = Integer.parseInt(var2);
            } catch (NumberFormatException var5) {
                return;
            }

            if (var6 != 0 || !this.cl.displayLabel.getText().equals("0")) {
                if (this.cl.setClear) {
                    this.cl.displayLabel.setText("" + var6);
                    this.cl.setClear = false;
                } else {
                    this.cl.displayLabel.setText(this.cl.displayLabel.getText() + var6);
                }

            }
        }
    }
}
