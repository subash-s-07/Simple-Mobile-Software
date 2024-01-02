package Software;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

class Notepad implements ActionListener, MenuConstants {
    JFrame f;
    JTextArea ta;
    JLabel statusBar;
    private String fileName = "Untitled";
    private boolean saved = true;
    String applicationName = "Javapad";
    String searchString;
    String replaceString;
    int lastSearchIndex;
    FileOperation fileHandler;
    FontChooser fontDialog = null;
    FindDialog findReplaceDialog = null;
    JColorChooser bcolorChooser = null;
    JColorChooser fcolorChooser = null;
    JDialog backgroundDialog = null;
    JDialog foregroundDialog = null;
    JMenuItem cutItem;
    JMenuItem copyItem;
    JMenuItem deleteItem;
    JMenuItem findItem;
    JMenuItem findNextItem;
    JMenuItem replaceItem;
    JMenuItem gotoItem;
    JMenuItem selectAllItem;

    Notepad() {
        this.f = new JFrame(this.fileName + " - " + this.applicationName);
        this.ta = new JTextArea(30, 60);
        this.statusBar = new JLabel("||       Ln 1, Col 1  ", 4);
        this.f.add(new JScrollPane(this.ta), "Center");
        this.f.add(this.statusBar, "South");
        this.f.add(new JLabel("  "), "East");
        this.f.add(new JLabel("  "), "West");
        this.createMenuBar(this.f);
        this.f.pack();
        this.f.setLocation(100, 50);
        this.f.setVisible(true);
        this.f.setLocation(150, 50);
        this.f.setDefaultCloseOperation(0);
        this.fileHandler = new FileOperation(this);
        this.ta.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent var1) {
                int var2 = 0;
                int var3 = 0;
                boolean var4 = false;

                try {
                    int var7 = Notepad.this.ta.getCaretPosition();
                    var2 = Notepad.this.ta.getLineOfOffset(var7);
                    var3 = var7 - Notepad.this.ta.getLineStartOffset(var2);
                } catch (Exception var6) {
                }

                if (Notepad.this.ta.getText().length() == 0) {
                    var2 = 0;
                    var3 = 0;
                }

                Notepad.this.statusBar.setText("||       Ln " + (var2 + 1) + ", Col " + (var3 + 1));
            }
        });
        DocumentListener var1 = new DocumentListener() {
            public void changedUpdate(DocumentEvent var1) {
                Notepad.this.fileHandler.saved = false;
            }

            public void removeUpdate(DocumentEvent var1) {
                Notepad.this.fileHandler.saved = false;
            }

            public void insertUpdate(DocumentEvent var1) {
                Notepad.this.fileHandler.saved = false;
            }
        };
        this.ta.getDocument().addDocumentListener(var1);
        WindowAdapter var2 = new WindowAdapter() {
            public void windowClosing(WindowEvent var1) {
                if (Notepad.this.fileHandler.confirmSave()) {
                    System.exit(0);
                }

            }
        };
        this.f.addWindowListener(var2);
    }

    void goTo() {
        boolean var1 = false;

        try {
            int var4 = this.ta.getLineOfOffset(this.ta.getCaretPosition()) + 1;
            String var2 = JOptionPane.showInputDialog(this.f, "Enter Line Number:", "" + var4);
            if (var2 == null) {
                return;
            }

            var4 = Integer.parseInt(var2);
            this.ta.setCaretPosition(this.ta.getLineStartOffset(var4 - 1));
        } catch (Exception var3) {
        }

    }

    public void actionPerformed(ActionEvent var1) {
        String var2 = var1.getActionCommand();
        if (var2.equals("New")) {
            this.fileHandler.newFile();
        } else if (var2.equals("Open...")) {
            this.fileHandler.openFile();
        } else if (var2.equals("Save")) {
            this.fileHandler.saveThisFile();
        } else if (var2.equals("Save As...")) {
            this.fileHandler.saveAsFile();
        } else if (var2.equals("Exit")) {
            if (this.fileHandler.confirmSave()) {
                System.exit(0);
            }
        } else if (var2.equals("Print")) {
            JOptionPane.showMessageDialog(this.f, "Get ur printer repaired first! It seems u dont have one!", "Bad Printer", 1);
        } else if (var2.equals("Cut")) {
            this.ta.cut();
        } else if (var2.equals("Copy")) {
            this.ta.copy();
        } else if (var2.equals("Paste")) {
            this.ta.paste();
        } else if (var2.equals("Delete")) {
            this.ta.replaceSelection("");
        } else if (var2.equals("Find...")) {
            if (this.ta.getText().length() == 0) {
                return;
            }

            if (this.findReplaceDialog == null) {
                this.findReplaceDialog = new FindDialog(this.ta);
            }

            this.findReplaceDialog.showDialog(this.f, true);
        } else if (var2.equals("Find Next")) {
            if (this.ta.getText().length() == 0) {
                return;
            }

            if (this.findReplaceDialog == null) {
                this.statusBar.setText("Nothing to search for, use Find option of Edit Menu first !!!!");
            } else {
                this.findReplaceDialog.findNextWithSelection();
            }
        } else if (var2.equals("Replace")) {
            if (this.ta.getText().length() == 0) {
                return;
            }

            if (this.findReplaceDialog == null) {
                this.findReplaceDialog = new FindDialog(this.ta);
            }

            this.findReplaceDialog.showDialog(this.f, false);
        } else if (var2.equals("Go To...")) {
            if (this.ta.getText().length() == 0) {
                return;
            }

            this.goTo();
        } else if (var2.equals("Select All")) {
            this.ta.selectAll();
        } else if (var2.equals("Time/Date")) {
            this.ta.insert((new Date()).toString(), this.ta.getSelectionStart());
        } else {
            JCheckBoxMenuItem var3;
            if (var2.equals("Word Wrap")) {
                var3 = (JCheckBoxMenuItem)var1.getSource();
                this.ta.setLineWrap(var3.isSelected());
            } else if (var2.equals("Font...")) {
                if (this.fontDialog == null) {
                    this.fontDialog = new FontChooser(this.ta.getFont());
                }

                if (this.fontDialog.showDialog(this.f, "Choose a font")) {
                    this.ta.setFont(this.fontDialog.createFont());
                }
            } else if (var2.equals("Set Text color...")) {
                this.showForegroundColorDialog();
            } else if (var2.equals("Set Pad color...")) {
                this.showBackgroundColorDialog();
            } else if (var2.equals("Status Bar")) {
                var3 = (JCheckBoxMenuItem)var1.getSource();
                this.statusBar.setVisible(var3.isSelected());
            } else if (var2.equals("About Javapad")) {
                JOptionPane.showMessageDialog(this.f, "<html><big>Your Javapad</big><hr><hr><p align=right>Prepared by a Ducatian!<hr><p align=left>I Used jdk1.5 to compile the source code.<br><br><strong>Thanx 4 using Javapad</strong><br>Ur Comments as well as bug reports r very welcome at<p align=center><hr><em><big>radialgoal@gmail.com</big></em><hr><html>", "Dedicated 2 u!", 1);
            } else {
                this.statusBar.setText("This " + var2 + " command is yet to be implemented");
            }
        }

    }

    void showBackgroundColorDialog() {
        if (this.bcolorChooser == null) {
            this.bcolorChooser = new JColorChooser();
        }

        if (this.backgroundDialog == null) {
            this.backgroundDialog = JColorChooser.createDialog(this.f, "Set Pad color...", false, this.bcolorChooser, new ActionListener() {
                public void actionPerformed(ActionEvent var1) {
                    Notepad.this.ta.setBackground(Notepad.this.bcolorChooser.getColor());
                }
            }, (ActionListener)null);
        }

        this.backgroundDialog.setVisible(true);
    }

    void showForegroundColorDialog() {
        if (this.fcolorChooser == null) {
            this.fcolorChooser = new JColorChooser();
        }

        if (this.foregroundDialog == null) {
            this.foregroundDialog = JColorChooser.createDialog(this.f, "Set Text color...", false, this.fcolorChooser, new ActionListener() {
                public void actionPerformed(ActionEvent var1) {
                    Notepad.this.ta.setForeground(Notepad.this.fcolorChooser.getColor());
                }
            }, (ActionListener)null);
        }

        this.foregroundDialog.setVisible(true);
    }

    JMenuItem createMenuItem(String var1, int var2, JMenu var3, ActionListener var4) {
        JMenuItem var5 = new JMenuItem(var1, var2);
        var5.addActionListener(var4);
        var3.add(var5);
        return var5;
    }

    JMenuItem createMenuItem(String var1, int var2, JMenu var3, int var4, ActionListener var5) {
        JMenuItem var6 = new JMenuItem(var1, var2);
        var6.addActionListener(var5);
        var6.setAccelerator(KeyStroke.getKeyStroke(var4, 2));
        var3.add(var6);
        return var6;
    }

    JCheckBoxMenuItem createCheckBoxMenuItem(String var1, int var2, JMenu var3, ActionListener var4) {
        JCheckBoxMenuItem var5 = new JCheckBoxMenuItem(var1);
        var5.setMnemonic(var2);
        var5.addActionListener(var4);
        var5.setSelected(false);
        var3.add(var5);
        return var5;
    }

    JMenu createMenu(String var1, int var2, JMenuBar var3) {
        JMenu var4 = new JMenu(var1);
        var4.setMnemonic(var2);
        var3.add(var4);
        return var4;
    }

    void createMenuBar(JFrame var1) {
        JMenuBar var2 = new JMenuBar();
        JMenu var4 = this.createMenu("File", 70, var2);
        JMenu var5 = this.createMenu("Edit", 69, var2);
        JMenu var6 = this.createMenu("Format", 79, var2);
        JMenu var7 = this.createMenu("View", 86, var2);
        JMenu var8 = this.createMenu("Help", 72, var2);
        this.createMenuItem("New", 78, var4, 78, this);
        this.createMenuItem("Open...", 79, var4, 79, this);
        this.createMenuItem("Save", 83, var4, 83, this);
        this.createMenuItem("Save As...", 65, var4, this);
        var4.addSeparator();
        JMenuItem var3 = this.createMenuItem("Page Setup...", 85, var4, this);
        var3.setEnabled(false);
        this.createMenuItem("Print", 80, var4, 80, this);
        var4.addSeparator();
        this.createMenuItem("Exit", 88, var4, this);
        var3 = this.createMenuItem("Undo", 85, var5, 90, this);
        var3.setEnabled(false);
        var5.addSeparator();
        this.cutItem = this.createMenuItem("Cut", 84, var5, 88, this);
        this.copyItem = this.createMenuItem("Copy", 67, var5, 67, this);
        this.createMenuItem("Paste", 80, var5, 86, this);
        this.deleteItem = this.createMenuItem("Delete", 76, var5, this);
        this.deleteItem.setAccelerator(KeyStroke.getKeyStroke(127, 0));
        var5.addSeparator();
        this.findItem = this.createMenuItem("Find...", 70, var5, 70, this);
        this.findNextItem = this.createMenuItem("Find Next", 78, var5, this);
        this.findNextItem.setAccelerator(KeyStroke.getKeyStroke(114, 0));
        this.replaceItem = this.createMenuItem("Replace", 82, var5, 72, this);
        this.gotoItem = this.createMenuItem("Go To...", 71, var5, 71, this);
        var5.addSeparator();
        this.selectAllItem = this.createMenuItem("Select All", 65, var5, 65, this);
        this.createMenuItem("Time/Date", 68, var5, this).setAccelerator(KeyStroke.getKeyStroke(116, 0));
        this.createCheckBoxMenuItem("Word Wrap", 87, var6, this);
        this.createMenuItem("Font...", 70, var6, this);
        var6.addSeparator();
        this.createMenuItem("Set Text color...", 84, var6, this);
        this.createMenuItem("Set Pad color...", 80, var6, this);
        this.createCheckBoxMenuItem("Status Bar", 83, var7, this).setSelected(true);
        LookAndFeelMenu.createLookAndFeelMenuItem(var7, this.f);
        var3 = this.createMenuItem("Help Topic", 72, var8, this);
        var3.setEnabled(false);
        var8.addSeparator();
        this.createMenuItem("About Javapad", 65, var8, this);
        MenuListener var9 = new MenuListener() {
            public void menuSelected(MenuEvent var1) {
                if (Notepad.this.ta.getText().length() == 0) {
                    Notepad.this.findItem.setEnabled(false);
                    Notepad.this.findNextItem.setEnabled(false);
                    Notepad.this.replaceItem.setEnabled(false);
                    Notepad.this.selectAllItem.setEnabled(false);
                    Notepad.this.gotoItem.setEnabled(false);
                } else {
                    Notepad.this.findItem.setEnabled(true);
                    Notepad.this.findNextItem.setEnabled(true);
                    Notepad.this.replaceItem.setEnabled(true);
                    Notepad.this.selectAllItem.setEnabled(true);
                    Notepad.this.gotoItem.setEnabled(true);
                }

                if (Notepad.this.ta.getSelectionStart() == Notepad.this.ta.getSelectionEnd()) {
                    Notepad.this.cutItem.setEnabled(false);
                    Notepad.this.copyItem.setEnabled(false);
                    Notepad.this.deleteItem.setEnabled(false);
                } else {
                    Notepad.this.cutItem.setEnabled(true);
                    Notepad.this.copyItem.setEnabled(true);
                    Notepad.this.deleteItem.setEnabled(true);
                }

            }

            public void menuDeselected(MenuEvent var1) {
            }

            public void menuCanceled(MenuEvent var1) {
            }
        };
        var5.addMenuListener(var9);
        var1.setJMenuBar(var2);
    }

    public static void main() {
        new Notepad();
    }
}
