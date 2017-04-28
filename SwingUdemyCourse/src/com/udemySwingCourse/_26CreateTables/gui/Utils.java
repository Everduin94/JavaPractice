package com.udemySwingCourse._26CreateTables.gui;

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
}
