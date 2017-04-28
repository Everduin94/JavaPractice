package gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by everduin on 12/8/2016.
 */
public class PersonFileFilter extends FileFilter{

    @Override
    public boolean accept(File f) {

        if (f.isDirectory()){ //This is so you can see directories
            return true;
        }

        String name = f.getName();
        String extension = Utils.getFileExtension(name);

        if (extension == null){
            return false;
        }

        if(extension.equals("per")){
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Person database files {*.per}"; //.per is arbitrary
    }
}
