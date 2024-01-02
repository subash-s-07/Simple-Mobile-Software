package Software;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyOperatorButton extends Button implements ActionListener {
    MyCalculator cl;

    MyOperatorButton(int var1, int var2, int var3, int var4, String var5, MyCalculator var6) {
        super(var5);
        this.setBounds(var1, var2, var3, var4);
        this.cl = var6;
        this.cl.add(this);
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent var1) {
        String var2 = ((MyOperatorButton)var1.getSource()).getLabel();
        this.cl.setClear = true;
        double var3 = Double.parseDouble(this.cl.displayLabel.getText());
        double var5;
        if (var2.equals("1/x")) {
            try {
                var5 = 1.0 / var3;
                this.cl.displayLabel.setText(MyCalculator.getFormattedText(var5));
            } catch (ArithmeticException var7) {
                this.cl.displayLabel.setText("Divide by 0.");
            }

        } else if (var2.equals("sqrt")) {
            try {
                var5 = Math.sqrt(var3);
                this.cl.displayLabel.setText(MyCalculator.getFormattedText(var5));
            } catch (ArithmeticException var8) {
                this.cl.displayLabel.setText("Divide by 0.");
            }

        } else if (!var2.equals("=")) {
            this.cl.number = var3;
            this.cl.op = var2.charAt(0);
        } else {
            switch (this.cl.op) {
                case '%':
                    try {
                        var3 = this.cl.number % var3;
                    } catch (ArithmeticException var10) {
                        this.cl.displayLabel.setText("Divide by 0.");
                        return;
                    }
                case '&':
                case '\'':
                case '(':
                case ')':
                case ',':
                case '.':
                default:
                    break;
                case '*':
                    var3 *= this.cl.number;
                    break;
                case '+':
                    var3 += this.cl.number;
                    break;
                case '-':
                    var3 = this.cl.number - var3;
                    break;
                case '/':
                    try {
                        var3 = this.cl.number / var3;
                    } catch (ArithmeticException var9) {
                        this.cl.displayLabel.setText("Divide by 0.");
                        return;
                    }
            }

            this.cl.displayLabel.setText(MyCalculator.getFormattedText(var3));
        }
    }
}
