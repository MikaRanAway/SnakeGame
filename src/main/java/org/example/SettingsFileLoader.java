package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONTokener;

public class SettingsFileLoader {
    private final static String filePath = "settings.json";


    public static void loadSettings(){
        getFileContent();
    }

    private static String getFileContent(){
        ClassLoader classLoader = SettingsFileLoader.class.getClassLoader();
        String fullFilePath = classLoader.getResource("settings.json").getPath();

        File file = new File(fullFilePath);
        FileReader fileReader;

        try{
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e){
            System.out.println("Could not find the settings file");
            return null;
        }


        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONArray array = new JSONArray(jsonTokener);

        System.out.println(array);

        return "TMP";
    }
}
