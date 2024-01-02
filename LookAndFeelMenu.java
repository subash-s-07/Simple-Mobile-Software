package Software;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;

public class LookAndFeelMenu {
    public LookAndFeelMenu() {
    }

    public static void createLookAndFeelMenuItem(JMenu var0, Component var1) {
        UIManager.LookAndFeelInfo[] var2 = UIManager.getInstalledLookAndFeels();
        JRadioButtonMenuItem[] var3 = new JRadioButtonMenuItem[var2.length];
        ButtonGroup var4 = new ButtonGroup();
        JMenu var5 = new JMenu("Change Look and Feel");
        var5.setMnemonic('C');

        for(int var6 = 0; var6 < var2.length; ++var6) {
            var3[var6] = new JRadioButtonMenuItem(var2[var6].getName());
            var3[var6].setMnemonic(var2[var6].getName().charAt(0));
            var5.add(var3[var6]);
            var4.add(var3[var6]);
            var3[var6].addActionListener(new LookAndFeelMenuListener(var2[var6].getClassName(), var1));
        }

        var3[0].setSelected(true);
        var0.add(var5);
    }
}
