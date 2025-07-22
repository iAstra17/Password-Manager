package app;

import model.Password;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Password> passwords = new ArrayList<>();
    private static final String filePath ="data"+File.separator+"passwords.dat";

    //this method is used to get and check the containsSymbols modifier from user inputs
    public static int getCheckedContainsSymbolsFromUserInputs(String message, int containsSymbols){
        try {
            System.out.print(message);
            containsSymbols = sc.nextInt();
            sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("error");
            //e.printStackTrace();
            sc.nextLine();
        }
        while (containsSymbols < 0 || containsSymbols > 1){
            try {
                System.out.print("insert a correct choice: ");
                containsSymbols = sc.nextInt();
                sc.nextLine();
                System.out.println();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                //e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }
        return containsSymbols;
    }

    //this method is used to get and check the containsDigits modifier from user inputs
    public static int getCheckedContainsDigitsFromUserInputs(String message, int containsDigits){
        try {
            System.out.print(message);
            containsDigits = sc.nextInt();
            sc.nextLine();
            System.out.println();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                //e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("error");
                //e.printStackTrace();
                sc.nextLine();
            }
        while (containsDigits < 0 || containsDigits > 1){
            try {
                System.out.print("insert a correct choice: ");
                containsDigits = sc.nextInt();
                sc.nextLine();
                System.out.println();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                //e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }
        return containsDigits;
    }

    //this method is used to get and check the typeOfLetters modifier from user inputs
    public static int getCheckedTypeOfLettersFromUserInputs(String message, int typeOfLetters){
        try{
            System.out.print(message);
            typeOfLetters = sc.nextInt();
            sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("error");
            //e.printStackTrace();
            sc.nextLine();
        }
        while (typeOfLetters < 0 || typeOfLetters > 2){
            try {
                System.out.print("insert a correct choice: ");
                typeOfLetters = sc.nextInt();
                sc.nextLine();
                System.out.println();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                //e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }
        return typeOfLetters;
    }

    //this method is used to get and check the length from user inputs
    public static int getCheckedLengthFromUserInputs(String message, int length){
        try {
            System.out.print(message);
            length = sc.nextInt();
            sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("error");
            //e.printStackTrace();
            sc.nextLine();
        }
        while(length < 4){
            try {
                System.out.print("insert a correct length of the password: ");
                length = sc.nextInt();
                sc.nextLine();
                System.out.println();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                //e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }
        return length;
    }

    //this method is used to get and check the platform from user inputs
    public static String getCheckedPlatformFromUserInputs(String message, String platform){
        try {
            System.out.print(message);
            platform = sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("error");
            //e.printStackTrace();
            sc.nextLine();
        }
        while(platform.equals("") || platform.equals(" ")){
            try {
                System.out.print("insert a correct name of the platform: ");
                platform = sc.nextLine();
                System.out.println();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                //e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }
        return platform;
    }

    //this method is used to get and check the password from user inputs
    public static String getCheckedPasswordFromUserInputs(String message, String pwd){
        try {
            System.out.print(message);
            pwd = sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("error");
            //e.printStackTrace();
            sc.nextLine();
        }
        while(pwd.indexOf(" ")!=-1 || pwd.length() < 4){
            if (pwd.indexOf(" ")!=-1){
                try {
                    System.out.print("insert a correct password without spaces: ");
                    pwd = sc.nextLine();
                    System.out.println();
                } catch (InputMismatchException e){
                    System.out.println("invalid input");
                    //e.printStackTrace();
                    sc.nextLine();
                } catch (Exception e){
                    System.out.println("error");
                    //e.printStackTrace();
                    sc.nextLine();
                }
            }else {
                try {
                    System.out.print("insert a password that is at least 4 characters long: ");
                    pwd = sc.nextLine();
                    System.out.println();
                } catch (InputMismatchException e){
                    System.out.println("invalid input");
                    //e.printStackTrace();
                    sc.nextLine();
                } catch (Exception e){
                    System.out.println("error");
                    //e.printStackTrace();
                    sc.nextLine();
                }
            }
        }
        return pwd;
    }

    //this method is used to clear all the content of the file
    public static void clearFile(){
        try (FileOutputStream _ = new FileOutputStream(filePath)){}
        catch (IOException e){
            System.out.println("error clearing file");
            // e.printStackTrace();
        }
    }

    //this method is used to print all the content of the file
    public static void printFileContent(){
        File file = new File(filePath);
        if (file.length()==0){
            System.out.println("there are no passwords saved at the current time!");
            System.out.println();
            return;
        }
        passwords.clear();
        loadListFromFile();
        for (Password password: passwords){
            System.out.println(password);
        }
        System.out.println();
    }

    //this method is used to load the list with passwords from the file
    @SuppressWarnings("unchecked")
    public static void loadListFromFile(){
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))){
            passwords = (ArrayList<Password>)ois.readObject();
        } catch(ClassNotFoundException e){
            System.out.println("error casting file");
            //e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("error file not found");
            //e.printStackTrace();
        } catch (IOException e){
            System.out.println("error loading list from file");
            //e.printStackTrace();
        }
    }

    //this method is used to fill the file with passwords contained inside the list
    public static void fillFileFromList(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)))){
            oos.writeObject(passwords);
        } catch (FileNotFoundException e) {
            System.out.println("error file not found");
            //e.printStackTrace();
        } catch(IOException e){
            System.out.println("error filling file");
            // e.printStackTrace();
        }
    }

    //this method is used to generate a password from a string that contains all the accepted characters
    public static String generatePasswordFromString(int length, String s){
        String pwd = "";
        Random rnd = new Random();
        for (int i = 0; i<length; i++){
            pwd += s.charAt(rnd.nextInt(s.length()));
        }
        return pwd;
    }

    //this method is used to generate a password randomized based on given parameters
    public static String generateRandomPassword(int length, int typeOfLetters, int containsDigits, int containsSymbols){
        String pwd = "";
        switch (typeOfLetters){
            case 0:
                if (containsDigits == 0 && containsSymbols == 0){
                    pwd = generatePasswordFromString(length, "abcdefghijklmnopqrstuvwxyz");
                }
                else if(containsDigits == 1 && containsSymbols == 0){
                    pwd = generatePasswordFromString(length, "abcdefghijklmnopqrstuvwxyz0123456789");
                }
                else if(containsDigits == 0 && containsSymbols == 1){
                    pwd = generatePasswordFromString(length, "abcdefghijklmnopqrstuvwxyz!@#$%^&*()-_=+[]{}:;,.?/");
                }
                else{
                    pwd = generatePasswordFromString(length, "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}:;,.?/");
                }
                break;
            case 1:
                if (containsDigits == 0 && containsSymbols == 0){
                    pwd = generatePasswordFromString(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                }
                else if(containsDigits == 1 && containsSymbols == 0){
                    pwd = generatePasswordFromString(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
                }
                else if(containsDigits == 0 && containsSymbols == 1){
                    pwd = generatePasswordFromString(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-_=+[]{}:;,.?/");
                }
                else{
                    pwd = generatePasswordFromString(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}:;,.?/");
                }
                break;
            case 2:
                if (containsDigits == 0 && containsSymbols == 0){
                    pwd = generatePasswordFromString(length, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
                }
                else if(containsDigits == 1 && containsSymbols == 0){
                    pwd = generatePasswordFromString(length, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
                }
                else if(containsDigits == 0 && containsSymbols == 1){
                    pwd = generatePasswordFromString(length, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-_=+[]{}:;,.?/");
                }
                else{
                    pwd = generatePasswordFromString(length, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}:;,.?/");
                }
                break;
        }
        return pwd;
    };

    //this method is used to get an ArrayList of passwords associated to a given platform
    public static ArrayList<Password> getPlatformPasswords(String platform){
        ArrayList<Password> pwds = new ArrayList<>(); 
        for(Password password : passwords){
            if(password.getPlatform().equalsIgnoreCase(platform)){
                pwds.add(password);
            }
        }
        return pwds;
    }

    //this method is used to get the index of a password from a given identifier
    public static int getPasswordIndexFromId(int id){
        int i = -1;
        for(Password password : passwords){
            i++;
            if (password.getId() == id){
                return i;
            }
        }
        return i;
    }

    //this method is used to get the index of a password from a given platform and user inputs
    public static int getPasswordIndexFromPlatform(String platform, String message){
        ArrayList<Password> pwds = getPlatformPasswords(platform);
        if(pwds.isEmpty()){
            System.out.println("there is no such platform !");
            System.out.println();
            return -1;
        }
        int passwordIndex;
        if(pwds.size()==1){
            passwordIndex = getPasswordIndexFromId(pwds.get(0).getId());
        } else {
            System.out.println("There is more than one platform with this name!");
            System.out.println("which password do you want to "+message);
            int i = -1;
            int choice = -1;
            for(Password pwd : pwds){
                i++;
                System.out.println(i+" - "+pwd.getPassword());
            }
            System.out.print("choice :");
            try{
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                // e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("error");
                // e.printStackTrace();
                sc.nextLine();
            }
            while (choice < 0 || choice > i){
                try{
                    System.out.print("insert a correct choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e){
                    System.out.println("invalid input");
                    // e.printStackTrace();
                    sc.nextLine();
                } catch (Exception e){
                    System.out.println("error");
                    // e.printStackTrace();
                    sc.nextLine();
                }
            }
            passwordIndex = getPasswordIndexFromId(pwds.get(choice).getId());
        }
        return passwordIndex;
    }
    //this method is used to get the containsSymbols modifier for an inserted password by user inputs
    public static int getContainsSymbols(String pwd){
        int containsSymbols = 0;
        int i = 0;
        while(i < pwd.length()){
            int ascii = (int)pwd.charAt(i);
            if (!(ascii > 96 && ascii < 123) && !(ascii > 64 && ascii < 91) && !(ascii > 47 && ascii < 58)){
                return 1;
            }
            i++;
        }
        return containsSymbols;
    }

    //this method is used to get the containsDigits modifier for an inserted password by user inputs
    public static int getContainsDigits(String pwd){
        int containsDigits = 0;
        int i = 0;
        while(i < pwd.length()){
            int ascii = (int)pwd.charAt(i);
            if (ascii > 47 && ascii < 58){
                return 1;
            }
            i++;
        }
        return containsDigits;
    }

    //this method is used to get the typeOfLetters modifier for an inserted password by user inputs
    public static int getTypeOfLetters(String pwd){
        int typeOfLetters = -1;
        boolean test1 = false;
        boolean test2 = false;

        for(int i = 0; i < pwd.length(); i++){
            int ascii = (int) pwd.charAt(i);
            if(!test1 && ascii > 96 && ascii < 123){
                typeOfLetters+=1;
                test1 = true;
            } else if (!test2 && ascii > 64 && ascii < 91){
                typeOfLetters+=2;
                test2 = true;
            }
            if(test1 && test2){
                return typeOfLetters;
            }
        }
        if(typeOfLetters == -1) return 0;
        return typeOfLetters;
    }

    //this method is used to check if the user wants to add a password for a platform that already has a password
    public static boolean checkToAddPasswordForExistingPlatform(String platform){
            System.out.println("there is a password already associated for this platform! ");
            int choice = 0;
            try{
                System.out.println("do you want to create an other one");
                System.out.print("""
                            0 - no
                            1 - yes
                            choice : """);
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                // e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("error");
                // e.printStackTrace();
                sc.nextLine();
            }
            while(choice < 0 || choice > 1){
                try{
                    System.out.print("insert a correct choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e){
                    System.out.println("invalid input");
                    // e.printStackTrace();
                    sc.nextLine();
                } catch (Exception e){
                    System.out.println("error");
                    // e.printStackTrace();
                    sc.nextLine();
                }
            }
            if (choice == 0) return false;
            return true;
        }

    public static void editPassword(){
        String platform = "";
        String message = "insert the name of the platform to edit it's password: ";
        platform = getCheckedPlatformFromUserInputs(message, platform);
        message = "edit";
        int passwordIndex = getPasswordIndexFromPlatform(platform, message);
        if (passwordIndex == -1)return;
        String pwd = "";
        message = "insert the new password (must be at least 4 characters long and must not contains a space): ";
        pwd = getCheckedPasswordFromUserInputs(message, pwd);
        passwords.get(passwordIndex).setPassword(pwd);
        fillFileFromList();
        System.out.println("successfully edited the password");
        System.out.println();
    }

    public static void removePasswordFromFile(){
        String platform = "";
        String message = "insert the name of the platform to delete with it's password: ";
        platform = getCheckedPlatformFromUserInputs(message, platform);
        message = "remove";
        int passwordIndex = getPasswordIndexFromPlatform(platform, message);
        if (passwordIndex == -1)return;
        int respond = -1;
        try {
            System.out.println("Are you sure you want to remove the password : "+ passwords.get(passwordIndex).getPassword() + " of the platform : "+ platform);
            System.out.print("""
                    0 - no
                    1 - yes
                    choice : """);
            respond = sc.nextInt();
            sc.nextLine();
            if(respond == 0)return;
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            // e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("error");
            // e.printStackTrace();
            sc.nextLine();
        }
        while (respond < 0 || respond > 1){
            try {
                System.out.print("insert a correct choice: ");
                respond = sc.nextInt();
                sc.nextLine();
                if(respond == 0)return;
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                // e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("error");
                // e.printStackTrace();
                sc.nextLine();
            }
        }
        passwords.remove(passwordIndex);
        if(!passwords.isEmpty()){
            fillFileFromList();
        } else {
            clearFile();
        }
        System.out.println("successfully removed the password");
        System.out.println();
    }

    public static void saveNewPassword(){
        String platform = "";
        String message = "insert the name of a platform to save with your password: ";
        platform = getCheckedPlatformFromUserInputs(message, platform);
        if(!getPlatformPasswords(platform).isEmpty()) if(!checkToAddPasswordForExistingPlatform(platform)) return;
        String pwd = "";
        message = "insert the password to save (must be at least 4 characters long and must not contains a space): ";
        pwd = getCheckedPasswordFromUserInputs(message, pwd);
        int typeOfLetters = getTypeOfLetters(pwd);
        int containsDigits = getContainsDigits(pwd);
        int containsSymbols = getContainsSymbols(pwd);
        Password password = new Password(platform, 0, pwd.length(), typeOfLetters, containsDigits, containsSymbols, pwd);
        passwords.add(password);
        fillFileFromList();
        System.out.println("Successfully added password to file");
    };

    public static void generateNewPasswordWithoutSave(){
        int length = 0;
        String message = "insert the length of the password (the minimum length allowed is 4): ";
        length = getCheckedLengthFromUserInputs(message, length);
        int typeOfLetters = -1;
        message = """
                Do you want to use :
                0 - only lowercase letters
                1 - only uppercase letters
                2 - both
                choice : """;
        typeOfLetters = getCheckedTypeOfLettersFromUserInputs(message, typeOfLetters);
        int containsDigits = -1;
        message = """
                Do you want to use digits :
                0 - no
                1 - yes
                choice : """;
        containsDigits = getCheckedContainsDigitsFromUserInputs(message, containsDigits);
        int containsSymbols = -1;
        message = """
                Do you want to use symbols :
                0 - no
                1 - yes
                choice : """;
        containsSymbols = getCheckedContainsSymbolsFromUserInputs(message, containsSymbols);
        
        String pwd = generateRandomPassword(length, typeOfLetters, containsDigits, containsSymbols);
        System.out.println("password generated successfully");
        System.out.println();
        System.out.println("your password is : "+ pwd);
        System.out.println();
    };

    public static void generateNewPasswordAndSave(){
        String platform = "";
        String message = "insert the name of a platform to associate with your password: ";
        platform = getCheckedPlatformFromUserInputs(message, platform);
        if(!getPlatformPasswords(platform).isEmpty()) if(!checkToAddPasswordForExistingPlatform(platform)) return;
        int length = 0;
        message = "insert the length of the password (the minimum length allowed is 4): ";
        length = getCheckedLengthFromUserInputs(message, length);
        int typeOfLetters = -1;
        message = """
                Do you want to use :
                0 - only lowercase letters
                1 - only uppercase letters
                2 - both
                choice : """;
        typeOfLetters = getCheckedTypeOfLettersFromUserInputs(message, typeOfLetters);
        int containsDigits = -1;
        message = """
                Do you want to use digits :
                0 - no
                1 - yes
                choice : """;
        containsDigits = getCheckedContainsDigitsFromUserInputs(message, containsDigits);
        int containsSymbols = -1;
        message = """
                Do you want to use symbols :
                0 - no
                1 - yes
                choice : """;
        containsSymbols = getCheckedContainsSymbolsFromUserInputs(message, containsSymbols);
        String pwd;
        int respond = -1;
        do {
            pwd = generateRandomPassword(length, typeOfLetters, containsDigits, containsSymbols);
            System.out.println("password generated successfully");
            System.out.println();
            System.out.println("your password is : "+ pwd);
            System.out.println();
            try {
                System.out.print("""
                    do you want to change the password
                    0 - no
                    1 - yes
                    choice :""");
                respond = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                // e.printStackTrace();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("error");
                // e.printStackTrace();
                sc.nextLine();
            }
            while (respond < 0 || respond > 1){
                try {
                    System.out.print("insert a correct choice: ");
                    respond = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e){
                    System.out.println("invalid input");
                    // e.printStackTrace();
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("error");
                    // e.printStackTrace();
                    sc.nextLine();
                }
            }
        } while (respond == 1);
        Password password = new Password(platform, 1, length, typeOfLetters, containsDigits, containsSymbols, pwd);
        passwords.add(password);
        fillFileFromList();
        File file = new File(filePath);
        if (file.length()!=0){
            System.out.println("Successfully saved the password");
            System.out.println();
        }
        file = null;
    };
    
    public static void main(String[] args){
        // System.out.println(System.getProperty("user.dir"));
        File file = new File(filePath);
        if(file.length()>0){
            loadListFromFile();
        }
        file = null;

        int choice = 0;
        do{
            // System.out.println();
            // System.out.println(passwords);
            System.out.println();
            System.out.println("""
                ==========================================
                         *** Password Manager ***
                ==========================================

                    1 - Generate new password and save
                    2 - Generate new password
                    3 - Save new password
                    4 - Edit password
                    5 - Remove password
                    6 - Show all passwords
                    7 - Exit

                ==========================================""");

            try {
                
                System.out.print("What is your choice : ");
                choice = sc.nextInt();
                sc.nextLine();
                System.out.println();
                if (choice < 1 || choice > 7){
                    System.out.println("specify a number of choice from the list !!");
                    System.out.println();
                } else if (choice == 1){
                    generateNewPasswordAndSave();
                } else if (choice == 2){
                    generateNewPasswordWithoutSave();
                } else if (choice == 3){
                    saveNewPassword();
                } else if (choice == 4){
                    editPassword();
                } else if (choice == 5){
                    removePasswordFromFile();
                } else if (choice == 6){
                    printFileContent();
                } else {
                    System.out.println("Program is Stopping ...");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input (specify the number of the choice)");
            } catch (Exception e){
                System.out.println("Error");
                //e.printStackTrace();
            }
        } while(choice != 7);
        
        sc.close();
    }
}