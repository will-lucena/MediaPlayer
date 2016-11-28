package App;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChooser
{

    public String escolherArquivo(String title)
    {
        String str = "";
        JFileChooser chooser = new JFileChooser();
        File file = new File("C:\\Users\\William\\workspace\\");
        chooser.setCurrentDirectory(file);
        chooser.setDialogTitle(title);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            str = chooser.getSelectedFile().getAbsolutePath();
        }
        return str;
    }

    public String escolherDiretorio(String title)
    {
        String str = "";
        JFileChooser chooser = new JFileChooser();
        File file = new File("C:\\Users\\William\\workspace\\");
        chooser.setCurrentDirectory(file);
        chooser.setDialogTitle(title);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath());
            str = chooser.getSelectedFile().getAbsolutePath();
        }
        return str;
    }
}
