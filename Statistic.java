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

    

    public Statistic(int resultTime, String disciplin, int swimplacement, String contest){
        this.resultTime=resultTime;
        this.disciplin=disciplin;
        this.swimPlacement=swimPlacement;
        this.contest=contest;
    }

    public Statistic(){

    }

    public void createStatistic(){
        Scanner input = new Scanner(System.in);
       
        try{
           
            File f = new File("Members.txt");

            f.createNewFile();

            Scanner scan = new Scanner(f);
            ArrayList<User> members = new ArrayList<User>();
 
            while(scan.hasNextLine())
            {
                members.add(new User(scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.nextBoolean(), scan.nextBoolean(), scan.next()));   
            }

            for(int i = 0; i < members.size(); i++)
            {
                System.out.println(i + " " + members.get(i).getCompetitionswimmer()==true);
            }
             
            System.out.print ("Hvilket medlem vil du tilføje svømmetider på? ");
            int number = input.nextInt();

            System.out.print("Tast svømmekonkurrencens navn ");
            String statistic = input.next();
            members.get(number).statistic(statistic);

            // System.out.print("Tast svømmedisciplin ");
            // String disciplin = input.next();
            // members.get(number).setDisciplin(disciplin);
            
            // System.out.print("Tast svømmerens placering ");
            // int swimPlacement = input.nextInt();
            // members.get(number).setSwimPlacement(swimPlacement);

            // System.out.print("Tast svømmerens tid ");
            // int resultTime = input.next();
            // members.get(number).setResultTime(resultTime);

            // Gemmer oplysningerne i Members.text
            PrintStream file = new PrintStream(f);
            for(int i = 0; i < members.size(); i++)
            {
                 file.print(members.get(i).getFirstname() + " " + members.get(i).getLastname() + " " + members.get(i).getAge() + " " + members.get(i).getEmail() +
                     " " + members.get(i).getPhone() + " " + members.get(i).getActivemembership() + " " + members.get(i).statistic );
                if(i != members.size() -1)
                {
                    file.println();
                }
            }
       
            } catch(Exception e)
            {
                System.out.println(e);
            }
      
    }

// + " " + members.get(i).getAdmin() + " " + members.get(i).getContestName() + " " + members.get(i).getDisciplin() + " " + members.get(i).getSwimPlacement() + " " + members.get(i).getResultTime()


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