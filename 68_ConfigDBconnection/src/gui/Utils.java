package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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
            System.err.println("Unable to load image: " + path);
        }

        ImageIcon icon = new ImageIcon(url);
        return icon;
    }

    public static Font createFont(String path) {
        /*Use Class loader to get Java classes,
        * we're using same technology to load
        * images*/
        URL url = System.class.getResource(path);

        if(url == null){
            System.err.println("Unable to load font: " + path);
        }
        Font font = null;
            try {
                font = Font.createFont(Font.TRUETYPE_FONT, url.openStream());
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }

        if (font == null) {
            return new Font("Serif", Font.PLAIN, 20);
        }

        return font;
    }
}
