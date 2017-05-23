import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.lang.Iterable;


public class Statistic implements Comparator<Statistic>{
    private int userId;
    private int resultTime;
    private String disciplin;
    private int swimPlacement;
    private String contest;

    ArrayList<Statistic> fastestTime = new ArrayList<Statistic>();
    ArrayList<Statistic> stats = new ArrayList<Statistic>();

    public Statistic(ArrayList<Statistic> stats) {         
    this.stats = stats;    
    }  

    public Statistic(int userId, String contest,  String disciplin, int swimPlacement, int resultTime){
        this.userId=userId;
        this.contest=contest;
        this.disciplin=disciplin;
        this.swimPlacement=swimPlacement;
        this.resultTime=resultTime;
    }

    public Statistic(){

    }
  
    public void createStatistic(){
        Scanner input = new Scanner(System.in);
       
        try{
           
            File f = new File("Members.txt");
            File g = new File("Stats.txt");

            g.createNewFile();
            f.createNewFile();
        
            Scanner scan = new Scanner(f);
            Scanner scan1 = new Scanner(g);

            ArrayList<Statistic> stats = new ArrayList<Statistic>();
            ArrayList<User> members = new ArrayList<User>();
            
            while(scan.hasNextLine())
            {
                members.add(new User(scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.nextBoolean(), scan.nextBoolean()));   
            }
            while(scan1.hasNextLine())
            {
                stats.add(new Statistic(scan1.nextInt(),scan1.next(), scan1.next(), scan1.nextInt(), scan1.nextInt()));
            }

            for(int i = 0; i < members.size(); i++)
            {
                if( members.get(i).getCompetitionswimmer()==true){
                    System.out.println("Id: " + members.get(i).getUserId() + " " + members.get(i).getFirstname() + " " + members.get(i).getLastname());   
                }
            }
             
            System.out.print ("Tast id på det medlem du vil tilføje statistik på ");
            int number = input.nextInt();

            System.out.print("Tast svømmekonkurrencens navn ");
            String contest = input.next();

            System.out.print("Tast svømmedisciplin ");
            String disciplin = input.next();
            
            System.out.print("Tast svømmerens placering ");
            int swimPlacement = input.nextInt();

            System.out.print("Tast svømmerens tid ");
            int resultTime = input.nextInt();

            stats.add(new Statistic(number, contest, disciplin, swimPlacement, resultTime));

            PrintStream file = new PrintStream(g);
            for(int i = 0; i < stats.size(); i++)
            {
                file.print(stats.get(i).getUserId() + " " + stats.get(i).getContestName() + " " + stats.get(i).getDisciplin() + " " + stats.get(i).getSwimPlacement() + " " + stats.get(i).getResultTime());
                if(i != stats.size() -1)
                {
                    file.println();
                }
            }
            } catch(Exception e)
            {
                System.out.println(e);
            }
    
    }

    public void printTop5(){
        
        Scanner input = new Scanner(System.in);
        
        try{

            File g = new File("Stats.txt");

            g.createNewFile();
 
            Scanner scan1 = new Scanner(g);
            ArrayList<Statistic> stats = new ArrayList<Statistic>();

            while(scan1.hasNextLine())
            {
                stats.add(new Statistic(scan1.nextInt(),scan1.next(), scan1.next(), scan1.nextInt(), scan1.nextInt()));
            }

		    System.out.print("Tast hvilken disciplin du vil have en top5 over ");
            String answer = input.nextLine();
            System.out.println("Du har valgt at få en top 5 over følgende svømmedisciplin: " + answer);

            for(int i = 0; i < stats.size(); i++)
            {
                if(stats.get(i).toString().contains(answer))
                {  
                    // System.out.println(stats.get(i).getResultTime()); // Printer alle indenfor f.eks. crawl eller bryst - dog ikke sorteret efter hurtigste tid.
                    // Nedenfor sorterer (via comparator metoden) efter hurtigste tid, men printer alle linier hvergang den finder "answer" >:/
                    Collections.sort(stats, new Statistic());
                    System.out.println("Printer hele liste for hver gang den finder 'answer'");
                    for(Statistic s:stats){
                        System.out.println("Id: " + s.getUserId() + " - Tid: " + s.getResultTime() + " - Printer desværre alle discipliner: " + s.getDisciplin());
                        
                    }
                }
            }

        }catch(Exception e)
            {
                System.out.println(e);
            }

    }
    
    // Bruges til at sortere arraylisten, så hurtigste tid (resultTime) kommer først
    @Override
    public int compare(Statistic stat1, Statistic stat2) {          
        if(stat1.getResultTime() < stat2.getResultTime()) {
            return -1;
        }else{
            return 1;
        }
    }  

    public void printIndividualResult(){
        Scanner input = new Scanner(System.in);
        try{
           
            File f = new File("Members.txt");
            File g = new File("Stats.txt");

            g.createNewFile();
            f.createNewFile();
        
            Scanner scan = new Scanner(f);
            Scanner scan1 = new Scanner(g);

            ArrayList<Statistic> stats = new ArrayList<Statistic>();
            ArrayList<User> members = new ArrayList<User>();
            
            while(scan.hasNextLine())
            {
                members.add(new User(scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.nextBoolean(), scan.nextBoolean()));   
            }
            while(scan1.hasNextLine())
            {
                stats.add(new Statistic(scan1.nextInt(),scan1.next(), scan1.next(), scan1.nextInt(), scan1.nextInt()));
            }     


            System.out.println("Vælg en svømmer at se resultater fra");
            for(int i=0; i<members.size(); i++)
            {
                System.out.println(" Id: " + members.get(i).getUserId() + " " + members.get(i).getFirstname() + " " + members.get(i).getLastname());
                
            }
            int choiceSwimmer = input.nextInt();
            for(int j=0; j<stats.size(); j++)
            {
                stats.get(j);
                if(stats.get(j).getUserId()==choiceSwimmer)
                {
                //System.out.println(stats.get(i))
                System.out.println("Konkurrence: " + stats.get(j).getContestName() + " - Disciplin: " + stats.get(j).getDisciplin() + " - Placering: " + stats.get(j).getSwimPlacement() + " - Tid: " + stats.get(j).getResultTime());
                }
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public void setResultTime(int resultTime){
        this.resultTime=resultTime;
    }

    public void setDisciplin(String disciplin){
        this.disciplin=disciplin;
    }

    public void setSwimPlacement(int swimPlacement){
        this.swimPlacement=swimPlacement;
    }

    public void setContestName(String contest){
        this.contest=contest;
    }


     
    public int getResultTime(){
        return resultTime;
    }

    public String getDisciplin(){
        return disciplin;
    }

    public int getSwimPlacement(){
        return swimPlacement;
    }

    public String getContestName(){
        return contest;
    }
    

    public int getUserId(){
        return userId;
    }

    @Override
    public String toString(){
        return contest + swimPlacement + disciplin + userId + resultTime;
    }


}