import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Statistic implements Comparator<Statistic>{
    private String date;
    private int userId;
    private int resultTime;
    private String disciplin;
    private int swimPlacement;
    private String contest;

    ArrayList<Statistic> stats = new ArrayList<Statistic>();

    public Statistic(String date, int userId, String contest, String disciplin, int swimPlacement, int resultTime){
        this.date=date;
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
                stats.add(new Statistic(scan1.next(), scan1.nextInt(), scan1.next(), scan1.next(), scan1.nextInt(), scan1.nextInt()));
            }

            for(int i = 0; i < members.size(); i++)
            {
                if( members.get(i).getCompetitionswimmer()==true){
                    System.out.println("Id: " + members.get(i).getUserId() + " " + members.get(i).getFirstname() + " " + members.get(i).getLastname());   
                }
            }
             
            System.out.print("Tast id på det medlem du vil tilføje statistik på ");
            int number = input.nextInt();

            System.out.print("Tast dato for konkurrencen (format 25/05/2017) ");
            String date = input.next();

            System.out.print("Tast konkurrencens navn ");
            String contest = input.next();

            System.out.print("Tast svømmedisciplin ");
            String disciplin = input.next();
            
            System.out.print("Tast svømmerens placering ");
            int swimPlacement = input.nextInt();

            System.out.print("Tast svømmerens tid ");
            int resultTime = input.nextInt();

            stats.add(new Statistic(date, number, contest, disciplin, swimPlacement, resultTime));

            PrintStream file = new PrintStream(g);
            for(int i = 0; i < stats.size(); i++)
            {
                file.print(stats.get(i).getUserId() + " " + stats.get(i).getDate() + " " + stats.get(i).getContestName() + " " + stats.get(i).getDisciplin() + " " + stats.get(i).getSwimPlacement() + " " + stats.get(i).getResultTime());
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
                stats.add(new Statistic(scan1.next(), scan1.nextInt(), scan1.next(), scan1.next(), scan1.nextInt(), scan1.nextInt()));
            }

		    System.out.print("Tast hvilken disciplin du vil have en top5 over ");
            System.out.println("som fx. bryst, crawl, butterfly, ryg ect..");
            
            
            String answer = input.nextLine();
            System.out.println("Du har valgt at få en top 5 over følgende svømmedisciplin: " + answer);
                // Count makes sure we only get the results of the disciplin ones
                int count=1;
                for(int i = 0; i < stats.size(); i++)
                {
                        if(stats.get(i).getDisciplin().equalsIgnoreCase(answer)&&count==1)
                        {  
                            count++;
                            // Beneath sorts (through the comparator method) the fastest time (resultTime) 
                            Collections.sort(stats, new Statistic());
                            
                                    // Count2 limits to 5 showings
                                    int count2=0;
                                    for(Statistic s:stats)
                                    {
                                        // Limit the chosen disciplin to show the first 5
                                        if(answer.equalsIgnoreCase(s.getDisciplin())&&count2<5)
                                        {   
                                             count2++;
                                            System.out.println("Id: " + s.getUserId() + " - Tid: " + s.getResultTime() + " - Disciplin: " + s.getDisciplin() + " - Dato: " + s.getDate());   
                                                        
                                        }
                                    }
                        }   
                }
            // Count resets so you can do another search   
            count=1;
        }catch(Exception e)
            {
                System.out.println(e);
            }

    }
    
    // Used to sort out the arraylist to show lowest resultTime value first
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
                stats.add(new Statistic(scan1.next(), scan1.nextInt(), scan1.next(), scan1.next(), scan1.nextInt(), scan1.nextInt()));
            }     

            // Loops through swimmer to sort off the non-comp-swimmer
            System.out.println("Vælg en svømmer at se resultater fra");
            for(int i=0; i<members.size(); i++)
            {
                if(members.get(i).getCompetitionswimmer()==true)
                {
                    System.out.println(" Id: " + members.get(i).getUserId() + " " + members.get(i).getFirstname() + " " + members.get(i).getLastname());
                }
            }
            int choiceSwimmer = input.nextInt();

            // Prints the name of chosen swimmer             
            for(int j = 0; j<members.size(); j++)
            {
                if(choiceSwimmer==members.get(j).getUserId())
                {
                    System.out.println("Du har valgt " + members.get(j).getFirstname() + " " + members.get(j).getLastname()+ "'s resultater: ");
                }
            }
            
            for(int k=0; k<stats.size(); k++)
            {
                stats.get(k);
                if(stats.get(k).getUserId()==choiceSwimmer)
                {
                System.out.println("Dato: " + stats.get(k).getDate() + " - Konkurrence: " + stats.get(k).getContestName() + " - Disciplin: " + stats.get(k).getDisciplin() + " - Placering: " + stats.get(k).getSwimPlacement() + " - Tid: " + stats.get(k).getResultTime());
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

    public void setDate(String date) {
        this.date=date;
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

    public String getDate(){
        return date;
    }

    @Override
    public String toString(){
        return date + contest + swimPlacement + disciplin + userId + resultTime;
    }


}