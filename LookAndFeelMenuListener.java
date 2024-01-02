package Software;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

class LookAndFeelMenuListener implements ActionListener {
    String classname;
    Component jf;

    LookAndFeelMenuListener(String var1, Component var2) {
        this.jf = var2;
        this.classname = new String(var1);
    }

    public void actionPerformed(ActionEvent var1) {
        try {
            UIManager.setLookAndFeel(this.classname);
            SwingUtilities.updateComponentTreeUI(this.jf);
        } catch (Exception var3) {
            System.out.println(var3);
        }

    }
}
