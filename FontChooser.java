package Software;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FontChooser extends JPanel {
    private Font thisFont;
    private JList jFace;
    private JList jStyle;
    private JList jSize;
    private JDialog dialog;
    private JButton okButton;
    JTextArea tf;
    private boolean ok;

    public FontChooser(Font var1) {
        this.thisFont = var1;
        String[] var2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        this.jFace = new JList(var2);
        this.jFace.setSelectedIndex(0);
        this.jFace.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent var1) {
                FontChooser.this.tf.setFont(FontChooser.this.createFont());
            }
        });
        String[] var3 = new String[]{"Regular", "Italic", "Bold", "Bold Italic"};
        this.jStyle = new JList(var3);
        this.jStyle.setSelectedIndex(0);
        this.jStyle.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent var1) {
                FontChooser.this.tf.setFont(FontChooser.this.createFont());
            }
        });
        String[] var4 = new String[30];

        for(int var5 = 0; var5 < 30; ++var5) {
            var4[var5] = new String(10 + var5 * 2 + "");
        }

        this.jSize = new JList(var4);
        this.jSize.setSelectedIndex(0);
        this.jSize.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent var1) {
                FontChooser.this.tf.setFont(FontChooser.this.createFont());
            }
        });
        JPanel var11 = new JPanel();
        var11.setLayout(new GridLayout(1, 3));
        var11.add(new JLabel("Font", 0));
        var11.add(new JLabel("Font Style", 0));
        var11.add(new JLabel("Size", 0));
        JPanel var6 = new JPanel();
        var6.setLayout(new GridLayout(1, 3));
        var6.add(new JScrollPane(this.jFace));
        var6.add(new JScrollPane(this.jStyle));
        var6.add(new JScrollPane(this.jSize));
        this.okButton = new JButton("OK");
        JButton var7 = new JButton("Cancel");
        this.okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                FontChooser.this.ok = true;
                FontChooser.this.thisFont = FontChooser.this.createFont();
                FontChooser.this.dialog.setVisible(false);
            }
        });
        var7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                FontChooser.this.dialog.setVisible(false);
            }
        });
        JPanel var8 = new JPanel();
        var8.setLayout(new FlowLayout());
        var8.add(this.okButton);
        var8.add(new JLabel("          "));
        var8.add(var7);
        this.tf = new JTextArea(5, 30);
        JPanel var9 = new JPanel();
        var9.add(new JScrollPane(this.tf));
        JPanel var10 = new JPanel();
        var10.setLayout(new GridLayout(2, 1));
        var10.add(var6);
        var10.add(var9);
        this.setLayout(new BorderLayout());
        this.add(var11, "North");
        this.add(var10, "Center");
        this.add(var8, "South");
        this.add(new JLabel("  "), "East");
        this.add(new JLabel("  "), "West");
        this.tf.setFont(this.thisFont);
        this.tf.append("\nA quick brown fox jumps over the lazy dog.");
        this.tf.append("\n0123456789");
        this.tf.append("\n~!@#$%^&*()_+|?><\n");
    }

    public Font createFont() {
        Font var1 = this.thisFont;
        byte var2 = 0;
        int var3 = this.jStyle.getSelectedIndex();
        switch (var3) {
            case 0:
                var2 = 0;
                break;
            case 1:
                var2 = 2;
                break;
            case 2:
                var2 = 1;
                break;
            case 3:
                var2 = 3;
        }

        int var4 = Integer.parseInt((String)this.jSize.getSelectedValue());
        String var5 = (String)this.jFace.getSelectedValue();
        var1 = new Font(var5, var2, var4);
        return var1;
    }

    public boolean showDialog(Component var1, String var2) {
        this.ok = false;
        Frame var3 = null;
        if (var1 instanceof Frame) {
            var3 = (Frame)var1;
        } else {
            var3 = (Frame)SwingUtilities.getAncestorOfClass(Frame.class, var1);
        }

        if (this.dialog == null || this.dialog.getOwner() != var3) {
            this.dialog = new JDialog(var3, true);
            this.dialog.add(this);
            this.dialog.getRootPane().setDefaultButton(this.okButton);
            this.dialog.setSize(400, 325);
        }

        this.dialog.setTitle(var2);
        this.dialog.setVisible(true);
        return this.ok;
    }
}
