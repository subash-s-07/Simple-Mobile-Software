package Software;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class FindDialog extends JPanel implements ActionListener {
    JTextArea jta;
    public int lastIndex;
    JLabel replaceLabel;
    private TextField findWhat;
    private JTextField replaceWith;
    private JCheckBox matchCase;
    JRadioButton up;
    JRadioButton down;
    JButton findNextButton;
    JButton replaceButton;
    JButton replaceAllButton;
    JButton cancelButton;
    JPanel direction;
    JPanel buttonPanel;
    JPanel findButtonPanel;
    JPanel replaceButtonPanel;
    CardLayout card;
    private boolean ok;
    private JDialog dialog;

    public FindDialog(JTextArea var1) {
        this.jta = var1;
        this.findWhat = new TextField(20);
        this.replaceWith = new JTextField(20);
        this.matchCase = new JCheckBox("Match case");
        this.up = new JRadioButton("Up");
        this.down = new JRadioButton("Down");
        this.down.setSelected(true);
        ButtonGroup var2 = new ButtonGroup();
        var2.add(this.up);
        var2.add(this.down);
        this.direction = new JPanel();
        Border var3 = BorderFactory.createEtchedBorder();
        TitledBorder var4 = BorderFactory.createTitledBorder(var3, "Direction");
        this.direction.setBorder(var4);
        this.direction.setLayout(new GridLayout(1, 2));
        this.direction.add(this.up);
        this.direction.add(this.down);
        JPanel var5 = new JPanel();
        var5.setLayout(new GridLayout(1, 2));
        var5.add(this.matchCase);
        var5.add(this.direction);
        this.findNextButton = new JButton("Find Next");
        this.replaceButton = new JButton("Replace");
        this.replaceAllButton = new JButton("Replace All");
        this.cancelButton = new JButton("Cancel");
        this.replaceButtonPanel = new JPanel();
        this.replaceButtonPanel.setLayout(new GridLayout(4, 1));
        this.replaceButtonPanel.add(this.findNextButton);
        this.replaceButtonPanel.add(this.replaceButton);
        this.replaceButtonPanel.add(this.replaceAllButton);
        this.replaceButtonPanel.add(this.cancelButton);
        JPanel var6 = new JPanel();
        var6.setLayout(new GridLayout(3, 2));
        var6.add(new JLabel("Find what "));
        var6.add(this.findWhat);
        var6.add(this.replaceLabel = new JLabel("Replace With "));
        var6.add(this.replaceWith);
        var6.add(new JLabel(" "));
        var6.add(new JLabel(" "));
        this.setLayout(new BorderLayout());
        this.add(new JLabel("       "), "North");
        this.add(var6, "Center");
        this.add(this.replaceButtonPanel, "East");
        this.add(var5, "South");
        this.setSize(200, 200);
        this.findNextButton.addActionListener(this);
        this.replaceButton.addActionListener(this);
        this.replaceAllButton.addActionListener(this);
        this.cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                FindDialog.this.dialog.setVisible(false);
            }
        });
        this.findWhat.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent var1) {
                FindDialog.this.enableDisableButtons();
            }
        });
        this.findWhat.addTextListener(new TextListener() {
            public void textValueChanged(TextEvent var1) {
                FindDialog.this.enableDisableButtons();
            }
        });
    }

    void enableDisableButtons() {
        if (this.findWhat.getText().length() == 0) {
            this.findNextButton.setEnabled(false);
            this.replaceButton.setEnabled(false);
            this.replaceAllButton.setEnabled(false);
        } else {
            this.findNextButton.setEnabled(true);
            this.replaceButton.setEnabled(true);
            this.replaceAllButton.setEnabled(true);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.findNextButton) {
            this.findNextWithSelection();
        } else if (var1.getSource() == this.replaceButton) {
            this.replaceNext();
        } else if (var1.getSource() == this.replaceAllButton) {
            JOptionPane.showMessageDialog((Component)null, "Total replacements made= " + this.replaceAllNext());
        }

    }

    int findNext() {
        String var1 = this.jta.getText();
        String var2 = this.findWhat.getText();
        this.lastIndex = this.jta.getCaretPosition();
        int var3 = this.jta.getSelectionStart();
        int var4 = this.jta.getSelectionEnd();
        if (this.up.isSelected()) {
            if (var3 != var4) {
                this.lastIndex = var4 - var2.length() - 1;
            }

            if (!this.matchCase.isSelected()) {
                this.lastIndex = var1.toUpperCase().lastIndexOf(var2.toUpperCase(), this.lastIndex);
            } else {
                this.lastIndex = var1.lastIndexOf(var2, this.lastIndex);
            }
        } else {
            if (var3 != var4) {
                this.lastIndex = var3 + 1;
            }

            if (!this.matchCase.isSelected()) {
                this.lastIndex = var1.toUpperCase().indexOf(var2.toUpperCase(), this.lastIndex);
            } else {
                this.lastIndex = var1.indexOf(var2, this.lastIndex);
            }
        }

        return this.lastIndex;
    }

    public void findNextWithSelection() {
        int var1 = this.findNext();
        if (var1 != -1) {
            this.jta.setSelectionStart(var1);
            this.jta.setSelectionEnd(var1 + this.findWhat.getText().length());
        } else {
            JOptionPane.showMessageDialog(this, "Cannot find \"" + this.findWhat.getText() + "\"", "Find", 1);
        }

    }

    void replaceNext() {
        if (this.jta.getSelectionStart() == this.jta.getSelectionEnd()) {
            this.findNextWithSelection();
        } else {
            String var1 = this.findWhat.getText();
            String var2 = this.jta.getSelectedText();
            if (this.matchCase.isSelected() && var2.equals(var1) || !this.matchCase.isSelected() && var2.equalsIgnoreCase(var1)) {
                this.jta.replaceSelection(this.replaceWith.getText());
            }

            this.findNextWithSelection();
        }
    }

    int replaceAllNext() {
        if (this.up.isSelected()) {
            this.jta.setCaretPosition(this.jta.getText().length() - 1);
        } else {
            this.jta.setCaretPosition(0);
        }

        boolean var1 = false;
        int var2 = 0;

        int var3;
        do {
            var3 = this.findNext();
            if (var3 == -1) {
                break;
            }

            ++var2;
            this.jta.replaceRange(this.replaceWith.getText(), var3, var3 + this.findWhat.getText().length());
        } while(var3 != -1);

        return var2;
    }

    public boolean showDialog(Component var1, boolean var2) {
        Frame var3 = null;
        if (var1 instanceof Frame) {
            var3 = (Frame)var1;
        } else {
            var3 = (Frame)SwingUtilities.getAncestorOfClass(Frame.class, var1);
        }

        if (this.dialog == null || this.dialog.getOwner() != var3) {
            this.dialog = new JDialog(var3, false);
            this.dialog.add(this);
            this.dialog.getRootPane().setDefaultButton(this.findNextButton);
        }

        if (this.findWhat.getText().length() == 0) {
            this.findNextButton.setEnabled(false);
        } else {
            this.findNextButton.setEnabled(true);
        }

        this.replaceButton.setVisible(false);
        this.replaceAllButton.setVisible(false);
        this.replaceWith.setVisible(false);
        this.replaceLabel.setVisible(false);
        if (var2) {
            this.dialog.setSize(460, 180);
            this.dialog.setTitle("Find");
        } else {
            this.replaceButton.setVisible(true);
            this.replaceAllButton.setVisible(true);
            this.replaceWith.setVisible(true);
            this.replaceLabel.setVisible(true);
            this.dialog.setSize(450, 200);
            this.dialog.setTitle("Replace");
        }

        this.dialog.setVisible(true);
        return this.ok;
    }
}
