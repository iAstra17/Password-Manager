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
    private static String filePath ="data"+File.separator+"passwords.dat";

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
    public static Password generateRandomPassword(String platform, int length, int typeOfLetters, int containsDigits, int containsSymbols){
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
        return new Password(platform, 1, length, typeOfLetters, containsDigits, containsSymbols, pwd);
    };

    public static boolean platformAlreadyExist(String platform){
        for(Password password : passwords){
            if(password.getPlatform().equalsIgnoreCase(platform)){
                return true;
            }
        }
        return false;
    }

    public static Password generatePassword(){
        String platform = "";
        int length = 0;
        int typeOfLetters = -1;
        int containsDigits = -1;
        int containsSymbols = -1;

        try {
            System.out.print("insert the name of the platform which your password will be associated with: ");
            platform = sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("Error");
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
                System.out.println("Error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }

        if(platformAlreadyExist(platform)){
            System.out.println("there is a password already associated for this platform! ");
            return null;
        }

        try {
            System.out.print("insert the length of the password (the minimum length allowed is 4): ");
            length = sc.nextInt();
            sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("Error");
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
                System.out.println("Error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }

        try{
            System.out.print("""
                Do you want to use :
                0 - only lowercase letters
                1 - only uppercase letters
                2 - both
                choice :""");
            typeOfLetters = sc.nextInt();
            sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("Error");
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
                System.out.println("Error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }

        try {
            System.out.print("""
                Do you want to use digits :
                0 - no
                1 - yes
                choice :""");
            containsDigits = sc.nextInt();
            sc.nextLine();
            System.out.println();
            } catch (InputMismatchException e){
                System.out.println("invalid input");
                //e.printStackTrace();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("Error");
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
                System.out.println("Error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }

        try {
            System.out.print("""
                Do you want to use symbols :
                0 - no
                1 - yes
                choice :""");
            containsSymbols = sc.nextInt();
            sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("Error");
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
                System.out.println("Error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }
    
        return generateRandomPassword(platform, length, typeOfLetters, containsDigits, containsSymbols);
    }

    public static int getContainsSymbols(String pwd){
        int containsSymbols = 0;
        int i = -1;
        while(i < pwd.length()){
            i++;
            int ascii = (int)pwd.charAt(i);
            if (!(ascii > 96 && ascii < 123) && !(ascii > 64 && ascii < 91) && !(ascii > 47 && ascii < 58)){
                return 1;
            }
        }
        return containsSymbols;
    }

    public static int getContainsDigits(String pwd){
        int containsDigits = 0;
        int i = -1;
        while(i < pwd.length()){
            i++;
            int ascii = (int)pwd.charAt(i);
            if (ascii > 47 && ascii < 58){
                return 1;
            }
        }
        return containsDigits;
    }

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

    public static void editPassword(){}

    public static void removePasswordFromFile(){}

    public static void saveNewPassword(){
        String platform = "";
        String pwd = "";

        try {
            System.out.print("insert the name of the platform which your password will be associated with: ");
            platform = sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("Error");
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
                System.out.println("Error");
                //e.printStackTrace();
                sc.nextLine();
            }
        }

        if(platformAlreadyExist(platform)){
            System.out.println("there is a password already associated for this platform! ");
            return;
        }

        try {
            System.out.print("insert the password to save (must be at least 4 characters long and must not contains a space): ");
            pwd = sc.nextLine();
            System.out.println();
        } catch (InputMismatchException e){
            System.out.println("invalid input");
            //e.printStackTrace();
            sc.nextLine();
        } catch (Exception e){
            System.out.println("Error");
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
                    System.out.println("Error");
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
                    System.out.println("Error");
                    //e.printStackTrace();
                    sc.nextLine();
                }
            }
        }
        int typeOfLetters = getTypeOfLetters(pwd);
        int containsDigits = getContainsDigits(pwd);
        int containsSymbols = getContainsSymbols(pwd);
        Password password = new Password(platform, 0, pwd.length(), typeOfLetters, containsDigits, containsSymbols, pwd);
        passwords.add(password);
        fillFileFromList();
        System.out.println("Successfully added password to file");
    };

    public static void generateNewPasswordWithoutSave(){
        Password password = generatePassword();
        System.out.println("password generated successfully");
        System.out.println();
        System.out.println("your password is : "+ password.getPassword());
        System.out.println();
    };

    public static void generateNewPasswordAndSave(){
        Password password = generatePassword();
        if (password == null) return;
        System.out.println("password generated successfully");
        System.out.println();
        System.out.println("your password is : "+ password.getPassword());
        System.out.println();
        passwords.add(password);
        fillFileFromList();
        File file = new File(filePath);
        if (file.length()!=0){
            System.out.println("Successfully added password to file");
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
            System.out.println();
            System.out.println(passwords);
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
        } while(choice != 5);
        
        sc.close();
    }
}