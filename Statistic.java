import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Statistic{
    private int userId;
    private int resultTime;
    private String disciplin;
    private int swimPlacement;
    private String contest;

    

    public Statistic(int userId, int resultTime, String disciplin, int swimplacement, String contest){
        this.userId=userId;
        this.resultTime=resultTime;
        this.disciplin=disciplin;
        this.swimPlacement=swimPlacement;
        this.contest=contest;
    }

    public Statistic(){

    }



  /*
    public void createStatistic(){
        try{
          
                Scanner input = new Scanner(System.in);
                File g = new File("Stats.txt");
                g.createNewFile();

                Scanner scan = new Scanner(g);
                ArrayList<Statistic> stats = new ArrayList<Statistic>();
                
                while(scan.hasNextLine())
                {
                    stats.add(new Statistic(scan.nextInt(), scan.nextInt(), scan.next(), scan.nextInt(), scan.next()));   
                }




                
                PrintStream file2 = new PrintStream(g);
                for(int i = 0; i < stats.size(); i++)
                {
                    file2.print(stats.get(i).getFirstname() + " " + members.get(i).getLastname());
                    if(i != stats.size() -1)
                    {
                        file2.println();
                    }
                }
                
            




        }catch(Exception e)
        {
            System.out.println(e);
        }
    
    }
*/

    public void printTop5(){

    }

    public void printIndividualResult(){
        
    }

    public void setResultTime(int resultTime){
        this.resultTime=resultTime;
    }

    public void setDisciplin(String disciplin){
        this.disciplin=disciplin;
    }

    public void setSwimPlacement(int swimplacement){
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
    

    public String toString(){
        return contest + disciplin + swimPlacement + resultTime;
    }


}