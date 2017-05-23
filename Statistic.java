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

    

    public Statistic(int userId, String contest,  String disciplin, int swimplacement, int resultTime){
        this.userId=userId;
        this.resultTime=resultTime;
        this.disciplin=disciplin;
        this.swimPlacement=swimPlacement;
        this.contest=contest;
    }

    public Statistic(){

    }

    


  
    public void createStatistic(){
      

    }

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
    

    public int getUserId(){
        return userId;
    }

    public String toString(){
        return contest + disciplin + swimPlacement + resultTime;
    }


}