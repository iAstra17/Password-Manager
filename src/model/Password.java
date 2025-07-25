package model;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Password implements Serializable{
    private static int counter = readLastId(); // this field represents a counter to use when creating an identifier for the password
    private final int id = ++counter; //this field represents the identifier of the password
    private String platform; //this field represents the platform which the password is associated to
    private int autoGenerated; // 0 = no , 1 = yes
    private int length; // this field contains the length of the password
    private int typeOfLetters; // 0 = lowercase only, 1 = uppercase only, 2 = both
    private int containsDigits; // 0 = no , 1 = yes
    private int containsSymbols; // 0 = no , 1 = yes
    private String password; // this field represents the password itself

    //password constructor
    public Password(String platform, int autoGenerated, int length, int typeOfLetters, int containsDigits, int containsSymbols, String password){
        this.platform = platform;
        this.autoGenerated = autoGenerated;
        this.length = length;
        this.typeOfLetters = typeOfLetters;
        this.containsDigits = containsDigits;
        this.containsSymbols = containsSymbols;
        this.password = password;
        saveLastId(counter);
        System.out.println(this.id);
    }

    public static int readLastId(){
        File file = new File("data"+File.separator+"lastId.dat");
        if(!file.exists() || file.length() == 0) return 0;
        file = null;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("data"+File.separator+"lastId.dat")))) {
            return dis.readInt();
        } catch (FileNotFoundException e){
            System.out.println("error file not found");
            // e.printStackTrace();
        } catch (IOException e) {
            System.out.println("error");
            // e.printStackTrace();
        }
        return 0;
    }

    public static void saveLastId(int id){
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data"+File.separator+"lastId.dat")))){
            dos.writeInt(id);
        } catch (IOException e){
            System.out.println("error");
            // e.printStackTrace();
        }
    }

    //id field getter
    public int getId(){
        return id;
    }

    //platform field getter and setter
    public String getPlatform(){
        return this.platform;
    }
    public void setPlatform(String platform){
        this.platform = platform;
    }

    //autoGenerated field getter and setter
    public int getAutoGenerated(){
        return this.autoGenerated;
    }
    public void setAutoGenerated(int autoGenerated){
        this.autoGenerated = autoGenerated;
    }
    
    //length field getter and setter
    public int getLength(){
        return this.length;
    }
    public void setLength(int length){
        this.length = length;
    }
    
    //typeOfLetters field getter and setter
    public int getTypeOfLetters(){
        return this.typeOfLetters;
    }
    public void setTypeOfLetters(int typeOfLetters){
        this.typeOfLetters = typeOfLetters;
    }
    
    //containsDigits field getter and setter
    public int getContainsDigits(){
        return this.containsDigits;
    }
    public void setContainsDigits(int containsDigits){
        this.containsDigits = containsDigits;
    }
    
    //containsSymbols field getter and setter
    public int getContainsSymbols(){
        return this.containsSymbols;
    }
    public void setContainsSymbols(int containsSymbols){
        this.containsSymbols = containsSymbols;
    }
    
    //password field getter and setter
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return "Platform : "+ this.platform +", Password : "+ this.password + ", length : "+ this.length;
    }
}
