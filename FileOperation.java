package Software;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

class FileOperation {
    Notepad npd;
    boolean saved;
    boolean newFileFlag;
    String fileName;
    String applicationTitle = "Javapad";
    File fileRef;
    JFileChooser chooser;

    boolean isSave() {
        return this.saved;
    }

    void setSave(boolean var1) {
        this.saved = var1;
    }

    String getFileName() {
        return new String(this.fileName);
    }

    void setFileName(String var1) {
        this.fileName = new String(var1);
    }

    FileOperation(Notepad var1) {
        this.npd = var1;
        this.saved = true;
        this.newFileFlag = true;
        this.fileName = new String("Untitled");
        this.fileRef = new File(this.fileName);
        this.npd.f.setTitle(this.fileName + " - " + this.applicationTitle);
        this.chooser = new JFileChooser();
        this.chooser.addChoosableFileFilter(new MyFileFilter(".java", "Java Source Files(*.java)"));
        this.chooser.addChoosableFileFilter(new MyFileFilter(".txt", "Text Files(*.txt)"));
        this.chooser.setCurrentDirectory(new File("."));
    }

    boolean saveFile(File var1) {
        FileWriter var2 = null;

        label63: {
            boolean var4;
            try {
                var2 = new FileWriter(var1);
                var2.write(this.npd.ta.getText());
                break label63;
            } catch (IOException var14) {
                this.updateStatus(var1, false);
                var4 = false;
            } finally {
                try {
                    var2.close();
                } catch (IOException var13) {
                }

            }

            return var4;
        }

        this.updateStatus(var1, true);
        return true;
    }

    boolean saveThisFile() {
        return !this.newFileFlag ? this.saveFile(this.fileRef) : this.saveAsFile();
    }

    boolean saveAsFile() {
        File var1 = null;
        this.chooser.setDialogTitle("Save As...");
        this.chooser.setApproveButtonText("Save Now");
        this.chooser.setApproveButtonMnemonic(83);
        this.chooser.setApproveButtonToolTipText("Click me to save!");

        do {
            if (this.chooser.showSaveDialog(this.npd.f) != 0) {
                return false;
            }

            var1 = this.chooser.getSelectedFile();
        } while(var1.exists() && JOptionPane.showConfirmDialog(this.npd.f, "<html>" + var1.getPath() + " already exists.<br>Do you want to replace it?<html>", "Save As", 0) != 0);

        return this.saveFile(var1);
    }

    boolean openFile(File var1) {
        FileInputStream var2 = null;
        BufferedReader var3 = null;

        label85: {
            boolean var5;
            try {
                var2 = new FileInputStream(var1);
                var3 = new BufferedReader(new InputStreamReader(var2));
                String var4 = " ";

                while(true) {
                    if (var4 == null) {
                        break label85;
                    }

                    var4 = var3.readLine();
                    if (var4 == null) {
                        break label85;
                    }

                    this.npd.ta.append(var4 + "\n");
                }
            } catch (IOException var15) {
                this.updateStatus(var1, false);
                var5 = false;
            } finally {
                try {
                    var3.close();
                    var2.close();
                } catch (IOException var14) {
                }

            }

            return var5;
        }

        this.updateStatus(var1, true);
        this.npd.ta.setCaretPosition(0);
        return true;
    }

    void openFile() {
        if (this.confirmSave()) {
            this.chooser.setDialogTitle("Open File...");
            this.chooser.setApproveButtonText("Open this");
            this.chooser.setApproveButtonMnemonic(79);
            this.chooser.setApproveButtonToolTipText("Click me to open the selected file.!");
            File var1 = null;

            while(this.chooser.showOpenDialog(this.npd.f) == 0) {
                var1 = this.chooser.getSelectedFile();
                if (var1.exists()) {
                    this.npd.ta.setText("");
                    if (!this.openFile(var1)) {
                        this.fileName = "Untitled";
                        this.saved = true;
                        this.npd.f.setTitle(this.fileName + " - " + this.applicationTitle);
                    }

                    if (!var1.canWrite()) {
                        this.newFileFlag = true;
                    }

                    return;
                }

                JOptionPane.showMessageDialog(this.npd.f, "<html>" + var1.getName() + "<br>file not found.<br>" + "Please verify the correct file name was given.<html>", "Open", 1);
            }

        }
    }

    void updateStatus(File var1, boolean var2) {
        if (var2) {
            this.saved = true;
            this.fileName = new String(var1.getName());
            if (!var1.canWrite()) {
                this.fileName = this.fileName + "(Read only)";
                this.newFileFlag = true;
            }

            this.fileRef = var1;
            this.npd.f.setTitle(this.fileName + " - " + this.applicationTitle);
            this.npd.statusBar.setText("File : " + var1.getPath() + " saved/opened successfully.");
            this.newFileFlag = false;
        } else {
            this.npd.statusBar.setText("Failed to save/open : " + var1.getPath());
        }

    }

    boolean confirmSave() {
        String var1 = "<html>The text in the " + this.fileName + " file has been changed.<br>" + "Do you want to save the changes?<html>";
        if (!this.saved) {
            int var2 = JOptionPane.showConfirmDialog(this.npd.f, var1, this.applicationTitle, 1);
            if (var2 == 2) {
                return false;
            }

            if (var2 == 0 && !this.saveAsFile()) {
                return false;
            }
        }

        return true;
    }

    void newFile() {
        if (this.confirmSave()) {
            this.npd.ta.setText("");
            this.fileName = new String("Untitled");
            this.fileRef = new File(this.fileName);
            this.saved = true;
            this.newFileFlag = true;
            this.npd.f.setTitle(this.fileName + " - " + this.applicationTitle);
        }
    }
}

