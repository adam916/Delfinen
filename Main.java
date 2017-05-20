import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
       
       User user1 = new User();
       Scanner input = new Scanner(System.in);
       boolean menuLoop=false;
       while(menuLoop=true){
       System.out.println("type 1 to create a new member");
       System.out.println("type 2 to edit a member");
       System.out.println("type 3 to delete a member");
       System.out.println("type 4 to exit system");

       int choice=input.nextInt();
        
     

        switch (choice) {
            case 1: user1.createMember();
            break;

            case 2: user1.editMember();
            break;

            case 3:  user1.deleteMember();
            break;

            case 4:
            System.out.print("System shutting down..");
            System.exit(0);
            break;

            default:
            break;
         }
      }
   }
}