package view;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.Gender;
import model.UserData;

public class inputUserData {
    
    public UserData inputData() throws ParseException {
        try (Scanner iScanner = new Scanner(System.in )) {
            while (true){
                System.out.println("Введите строку через ПРОБЕЛ (Ф.И.О, дату рождения - dd.mm.yyyy, номер телефона - цифры, пол - f/m ) : ");
                String input = iScanner.nextLine();
                String[] data = input.split(" ");
                if (data.length == 6) {

                    LocalDate dateOfBirth = parseDateOfBirth(data[3]);
                    long phoneNumber = parsePhoneNumber(data[4]);
                    Gender gender = parseGender(data[5]);

                    return new UserData(data[0], data[1], data[2], dateOfBirth, phoneNumber, gender);
                    
                } else System.out.println("Неверный ввод данных, пожалуйста, повторите попытку");
            }
        }

    }

    private LocalDate parseDateOfBirth(String dateOfBirthString) throws ParseException {
        try {
          return LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
          throw new ParseException("Неверный формат даты рождения", 0);
        }
    }

    private long parsePhoneNumber(String phoneNumberString) throws ParseException {
        try {
          return Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
          throw new ParseException("Неверный формат номера телефона", 0);
        }
    }

    private Gender parseGender(String genderString) throws ParseException {
        if (genderString.equalsIgnoreCase("m")) {
          return Gender.m;
        } else if (genderString.equalsIgnoreCase("f")) {
          return Gender.f;
        } else {
          throw new ParseException("Неверный формат", 0);
        }
    }


}
