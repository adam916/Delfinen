import java.util.*;
public class Statistics{
    private int resultTime;
    private int userId;
    private String disciplin;
    private int swimplacement;
    private String contest;



    public void printTop5(){


    }

    public void printIndividualResult(){
        
    }

    public void setSwimTime(int resultTime){
        this.resultTime=resultTime;
    }

    public void setDisciplin(String disciplin){
        this.disciplin=disciplin;
    }

    public void setSwimPlacement(int swimplacement){
        this.swimplacement=swimplacement;
    }

    public void setContestName(String contest){
        this.contest=contest;
    }

    public int getSwimTime(){
        return resultTime;
    }

    public String getDisciplin(){
        return disciplin;
    }

    public int getSwimPlacement(){
        return swimplacement;
    }

    public String getContestName(){
        return contest;
    }
    
}