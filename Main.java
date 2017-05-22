import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
       
       User user1 = new User();


       Scanner inputMenu = new Scanner(System.in);
       boolean menuLoop;
       while(menuLoop=true){
        System.out.println("Tast 1 for at oprette et nyt medlem ");
        System.out.println("Tast 2 for at ændret oplysningerne for eksisterende medlem ");
        System.out.println("Tast 3 for at slette et medlem ");
        System.out.println("Tast 4 for at logge af systemet ");
        System.out.println("Tast 5 for at tilføj statistic");

        int choice=inputMenu.nextInt();
        if(choice>5||choice<0){
            System.out.println("forkert valg");
        }else{
            switch (choice) {
                case 1: user1.createMember();
                break;

                case 2: user1.editMember();
                break;

                case 3:  user1.deleteMember();
                break;

                case 4:
                System.out.print("Du logges nu ud af systemet..");
                System.exit(0);
                break;


                case  5:
                    user1.createStatistic();
                break;

                default:
                break;
            }
        }
      }
   }
}