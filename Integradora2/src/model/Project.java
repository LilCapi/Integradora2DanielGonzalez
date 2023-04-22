package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Project {

    private String projectName;
    private String clientName;
    private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
    private String managerName;
    private String managerPhone;
    private Stage[] stages;

    private DateFormat formatter;

    public Project(String projectName, String clientName, Calendar initialDate, Calendar finalDate, double budget, String managerName, String managerPhone, int[] monthStages){

        this.formatter = new SimpleDateFormat("dd/M/yy");

        this.projectName = projectName;
        this.clientName = clientName;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.budget = budget;
        this.managerName = managerName;
        this.managerPhone = managerPhone;
        
        stages = new Stage[6];

        sixStage(monthStages);

    }

    /**
     * Description: Here the six stages are created and planned dates are placed where they belong.
     * @param monthStages is an array of int and it's an array of the month that each stage will last.
     */

    public void sixStage(int[] monthStages){

        Calendar initialPlannedDate0 = initialDate;
        Calendar finalPlannedDate0 = initialDate;
        finalPlannedDate0.add(Calendar.MONTH, monthStages[0]);

        stages[0] = new Stage(initialPlannedDate0, finalPlannedDate0, StageEnum.START, true);
        stages[0].setRealInitialDate();

        Calendar finalPlannedDate1 = finalPlannedDate0;
        finalPlannedDate1.add(Calendar.MONTH, monthStages[1]);
        
        stages[1] = new Stage(finalPlannedDate0, finalPlannedDate1, StageEnum.ANALISIS, false);

        Calendar finalPlannedDate2 = finalPlannedDate1;
        finalPlannedDate2.add(Calendar.MONTH, monthStages[2]);
        
        stages[2] = new Stage(finalPlannedDate1, finalPlannedDate2, StageEnum.DESIGN, false);

        Calendar finalPlannedDate3 = finalPlannedDate2;
        finalPlannedDate3.add(Calendar.MONTH, monthStages[3]);
        
        stages[3] = new Stage(finalPlannedDate2, finalPlannedDate3, StageEnum.EXECUTION , false);

        Calendar finalPlannedDate4 = finalPlannedDate3;
        finalPlannedDate4.add(Calendar.MONTH, monthStages[4]);
        
        stages[4] = new Stage(finalPlannedDate3, finalPlannedDate4, StageEnum.CLOSING, false);

        Calendar finalPlannedDate5 = finalPlannedDate4;
        finalPlannedDate5.add(Calendar.MONTH, monthStages[5]);
        
        stages[5] = new Stage(finalPlannedDate4, finalPlannedDate5, StageEnum.FOLLOW_UP_AND_PROJECT_CONTROL, false);

        }
        
    public String getPorjectName(){
        return projectName;
    }

    public String getClientName(){
        return clientName;
    }

    public Calendar getInitialDate(){
        return initialDate;
    }
    
    public String getInitialDateFormated() throws ParseException{
		return formatter.format(this.initialDate.getTime());
	}

    public Calendar getFinalDate(){
        return finalDate;
    }

    public String getFinalDateFormated() throws ParseException{
		return formatter.format(this.finalDate.getTime());
	}	

    public double getBudget(){
        return budget;
    }

    public String getManagerName(){
        return managerName;
    }

    public String getManagerPhone(){
        return managerPhone;
    }

    public Stage[] getStages() {
        return stages;
    }

    public String getStageInfo(){
        
        String msg = "";

        for (int i = 0; i < stages.length; i++) {
            
            msg += (i+1)+". "+ stages[i].getStageType()+"\n";
            
        }
        
        return msg;
    }

    

}
