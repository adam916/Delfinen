import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
       
       User user1 = new User();
       Statistic stats = new Statistic();


       Scanner inputMenu = new Scanner(System.in);
       boolean menuLoop;
       while(menuLoop=true){
            System.out.println("-------------------------------------------------------------");   
            System.out.println("Tast 1 for at oprette et nyt medlem ");
            System.out.println("Tast 2 for at ændret oplysningerne for eksisterende medlem ");
            System.out.println("Tast 3 for at slette et medlem ");
            System.out.println("Tast 4 for at tilføj statistic");
            System.out.println("Tast 5 for at se top 5 over en specifik disciplin");
            System.out.println("Tast 6 for at se individuelle resultater");
            System.out.println("Tast 7 for at logge af systemet ");
        

            int choice=inputMenu.nextInt();
            if(choice>7||choice<0){
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
                            stats.createStatistic();
                    break;

                    case 5:
                            stats.printTop5();
                    break;

                    case  6:
                            stats.printIndividualResult();
                    break;

                    case  7:
                        System.out.print("Du logges nu ud af systemet..");
                        System.exit(0);
                    break;

                    default:
                    break;
                }
            }
        }
    }
}