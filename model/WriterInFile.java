package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterInFile {
    
    public void writeData(UserData userData) {

        String path = userData.getLastName() + ".txt";
        File file = new File(path);

        try {
            if (file.isFile()) {
                try (FileWriter fw = new FileWriter(path, true)) {
                    fw.append(userData.toString());
                }
                System.out.println("Данные успешно записаны в файл: " + path);
            } else {
                try (FileWriter fw = new FileWriter(path, false)) {
                    fw.append(userData.toString());
                }
                System.out.println("Данные успешно записаны в файл: " + path);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
            
        
    }



}
