package Software;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {
    private String extension;
    private String description;

    public MyFileFilter() {
        this.setExtension((String)null);
        this.setDescription((String)null);
    }

    public MyFileFilter(String var1, String var2) {
        this.setExtension(var1);
        this.setDescription(var2);
    }

    public boolean accept(File var1) {
        String var2 = var1.getName();
        return var1.isDirectory() || this.extension == null || var2.toUpperCase().endsWith(this.extension.toUpperCase());
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String var1) {
        if (var1 == null) {
            this.description = new String("All Files(*.*)");
        } else {
            this.description = new String(var1);
        }

    }

    public void setExtension(String var1) {
        if (var1 == null) {
            this.extension = null;
        } else {
            this.extension = (new String(var1)).toLowerCase();
            if (!var1.startsWith(".")) {
                this.extension = "." + this.extension;
            }

        }
    }
}

