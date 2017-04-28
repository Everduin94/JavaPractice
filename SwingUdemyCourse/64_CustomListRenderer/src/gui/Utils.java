package gui;

import javax.swing.*;
import java.net.URL;

/**
 * Created by everduin on 12/8/2016.
 */
public final class Utils {

    private Utils(){
        //Do not instantiate
    }

    public static String getFileExtension(String name) {
        int pointIndex = name.lastIndexOf("."); //Grab last .

        if(pointIndex == -1){ //. doesn't exist
            return null;
        }

        if(pointIndex == name.length()-1){ //File has no extension
            return null;
        }

        return name.substring(pointIndex+1, name.length()); //Just after the . is found
    }


    /*Load images - Need warnings, it's easy to have images not load*/
    public static ImageIcon createIcon(String path){
        /*Use Class loader to get Java classes,
        * we're using same technology to load
        * images*/
        URL url = System.class.getResource(path);

        if(url == null){
            System.err.println("Unable to load image");
        }

        ImageIcon icon = new ImageIcon(url);
        return icon;
    }
}
