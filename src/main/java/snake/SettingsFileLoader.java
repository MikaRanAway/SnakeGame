package snake.src.main.java.snake;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import json

public class SettingsFileLoader {
    private final static String filePath = "settings.json";

    public static void loadSettings(){

    }

    private static String getFileContent(){
        File file = new File(filePath);
        FileReader fileReader;

        try{
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e){
            return null;
        }

        //JSONArray array;
        //JSONObject jsonObject;
        return "TMP";
    }
}
