package model;

import java.util.Calendar;

public class Stage {
    private Calendar planedInitialDate;
    private Calendar planedFinalDate;
    private Calendar realInitialDate;
    private Calendar realFinalDate;
    private boolean stageActivity;
    private StageEnum stageType; 
    private KnowledgeUnite[] knowledgeUnites;

    public Stage(Calendar planedInitialDate, Calendar planedFinalDate, StageEnum stageType, boolean stageActivity){
        this.planedInitialDate = planedInitialDate;
        this.planedFinalDate = planedFinalDate;
        this.realInitialDate = null;
        this.realFinalDate = null;
        this.stageType = stageType;
        this.stageActivity = stageActivity;
        knowledgeUnites = new KnowledgeUnite[50];
    }

    public Calendar getPlanedInitialDate(){
        return planedInitialDate;
    }

    public Calendar getPlanedFinalDate(){
        return planedFinalDate;
    }

    public Calendar getRealInitialDate(){
        return realInitialDate;
    }

    public Calendar getRealFianalDate(){
        return realFinalDate;
    }

    public boolean getStageActivity(){
        return stageActivity;
    }

    public StageEnum getStageType(){
        return stageType;
    }

    public KnowledgeUnite[] getKnowledgeUnites() {
        return knowledgeUnites;
    }

    public String getKnowledgeUnitesinfo(){
        
        String msg = "";

        for (int i = 0; i < knowledgeUnites.length; i++) {
            if(knowledgeUnites[i]!=null){
            msg += (i+1)+". "+ knowledgeUnites[i].getKnowledgeType();
            }
        }

        return msg;
    }
    
    public void setStageInactive(){
        stageActivity=false;
    }

    public void setStageActive(){
        stageActivity=true;
    }

    public void setRealFinalDate(){
        this.realFinalDate = Calendar.getInstance();
    }

    public void setRealInitialDate(){
        this.realInitialDate = Calendar.getInstance();
    }

  
}
