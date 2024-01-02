package Software;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

class FileFilterDemo extends JFrame {
    JLabel myLabel = new JLabel("No file is choosed yet");
    JButton myButton = new JButton("Choose file");
    JFileChooser chooser;

    FileFilterDemo() {
        super("File Filter Demo");
        ActionListener var1 = new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                if (FileFilterDemo.this.chooser == null) {
                    FileFilterDemo.this.chooser = new JFileChooser();
                }

                FileFilterDemo.this.chooser.addChoosableFileFilter(new MyFileFilter(".java", "Java Source Files(*.java)"));
                FileFilterDemo.this.chooser.addChoosableFileFilter(new MyFileFilter(".txt", "Text Files(*.txt)"));
                if (FileFilterDemo.this.chooser.showDialog(FileFilterDemo.this, "Select this") == 0) {
                    FileFilterDemo.this.myLabel.setText(FileFilterDemo.this.chooser.getSelectedFile().getPath());
                }

            }
        };
        this.myButton.addActionListener(var1);
        this.add(this.myLabel, "Center");
        this.add(this.myButton, "South");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(3);
    }

    public static void main(String[] var0) {
        FileFilterDemo var1 = new FileFilterDemo();
        var1.setVisible(true);
    }
}
