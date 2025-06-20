import java.util.Scanner;
import java.util.InputMismatchException;;
public class App {

    public static void generateNewPassword(){};

    public static void generateNewPasswordAndSave(){};

    public static void saveNewPassword(){};
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        do{
            System.out.println("""
                ======================================
                       *** Password Manager ***
                ======================================

                  1 - Generate new password and save
                  2 - Generate new password
                  3 - Save new password
                  4 - Exit

                ======================================
            """);

            try {
                
                System.out.print("What is your choice : ");
                choice = sc.nextInt();
                System.out.println();
                if (choice < 1 || choice > 4){
                    System.out.println("Please specify a number of choice from the list !!");
                    System.out.println();
                } else if (choice == 1){
                    generateNewPasswordAndSave();
                } else if (choice == 2){
                    generateNewPassword();
                } else if (choice == 3){
                    saveNewPassword();
                } else {
                    System.out.println("Program is Stopping ...");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input (please specify the number of the choice)");
            }
        } while(choice != 4);
        
        sc.close();
    }
}
