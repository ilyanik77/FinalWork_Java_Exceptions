package controller;

import java.text.ParseException;

import model.WriterInFile;
import view.inputUserData;

public class Controller {
    
    public void run() throws ParseException {

        view.inputUserData inputUserData = new inputUserData();
        
        WriterInFile writerInFile = new WriterInFile();
        writerInFile.writeData(inputUserData.inputData());

        
    }

}
