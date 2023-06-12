package model;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    
    public void writeData(UserData userData) {

        String path = userData.getLastName() + ".txt";
        
        try(FileWriter fw = new FileWriter(path, true)) {
            fw.append(userData.toString());
            fw.append("\n");
            System.out.println("Данные успешно записаны в файл: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
