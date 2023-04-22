package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

    private Project[] projects;

	public Controller() {

		projects = new Project[10];

        int[] months = {1,2,3,4,5,6};

        projects[0] = new Project("Project1", "david", Calendar.getInstance(),Calendar.getInstance(), 10000000, "Juan", "123546578765", months);
    
        registerKnowledgeUnite("1234657876", "descripcon de la primera capsula", 2, "parra", "manager", "#Trabajo final# el importante que se hagan bien los trabajos finales...", 0, 0);
        
        registerKnowledgeUnite("9876543", "descripcon de la segunda capsula", 1, "daniel", "ceo", "#integradora# el importante que se hagan bien la integradora...", 0, 1);
	}

    /**
     * Description: The purpose of this method is to resive the day, the month, and the year and it puts it together in a calendar format.
     * @param day is an int and the day that the user wants to enter into a calendar format.
     * @param month is an int and the month that the user wants to enter into a calendar format.
     * @param year is an int and the year that the user wants to enter into a calendar format.
     * @return calendar is type Calendar and is the final date in tha calendar format.
     */

    public Calendar createCalendar(int day, int month, int year){

        Calendar calendar = new GregorianCalendar(day,month,year);

        return calendar;
    }

    /**
     * Description: This method registers a project that can be accesed later on in the program.
     * @param projectName is a string and it's the name of the project.
     * @param clientName is a string and it's the name of the client.
     * @param initalDate is a Calendar type and it's the date of initiation of the project.
     * @param finalDateis is a Calendar type and it's the date of finalization of the project.
     * @param budget is a double and it's the budget that user will destin to the project.
     * @param managerName is a string and it's the name of the manager of the project.
     * @param managerPhone is a string and it's the phone of the manager of the project.
     * @param monthStages is an arry of int and it's the duration of the months of each stage of a project.
     * @return true or false, if it's true then it means that the project was saved successfully, however if it's false the it meanst that there is no more to save the project.
     */
    
    public boolean registerProject(String projectName, String clientName, Calendar initalDate,Calendar finalDate, double budget, String managerName, String managerPhone, int[] monthStages ){

        Project newProject = new Project(projectName, clientName, initalDate, finalDate, budget, managerName, managerPhone, monthStages); 

        for (int i = 0; i < projects.length; i++) {
			
			if (projects[i]==null){
				projects[i] = newProject;
				return true;
			}
		}

        return false;
    }

    /**
     * Description: In this methos the user registers the information of the knowledge unit.
     * @param id is a string and it's the unic identificatior of each knowledge unit.
     * @param description is a string and it's where the user enter a description the knowledge unit.
     * @param knowledgeType is and int and it's the type of the knowledge unit.
     * @param name is a string and it's the name of the collaborator that it's registering the knowledge unit.
     * @param employeePosition is a string  and it's the position of the collaborator.
     * @param knowledge is a string and it's where the collaborators store their knowledge of the project and what they have learned about the project.
     * @param projectPosition is an int and it's the position where the project is store in the array.
     * @param stagePosition  is an int and it's the stage where the project is store in the arry.
     * @return true or false, if it's true then it means that the stage was saved successfully, however if it's false the it meanst that there is no more to save the stage.
     */

    public boolean registerKnowledgeUnite(String id, String description, int knowledgeType, String name, String employeePosition, String knowledge, int projectPosition, int stagePosition){

        KnowledgeUnite newKnowledgeUnit = new KnowledgeUnite(id, description, knowledgeType, name, employeePosition, knowledge);

        for (int i = 0; i < 49; i++) {
            if (projects[projectPosition].getStages()[stagePosition].getKnowledgeUnites()[i] == null){
                projects[projectPosition].getStages()[stagePosition].getKnowledgeUnites()[i] = newKnowledgeUnit;
                return true;
            }
        }

        return false;
    }

    /**
     * Description: Here the stage that was active is inactivated and the next stage is activated.
     * @param projectPosition is an int and it's the position where the project is store in the array.
     * @param stagePosition is an int and it's the stage where the project is store in the arry.
     * @return msg is a string concatenation telling the user if the the stage ended successfully or not.
     */

    public String endProjectStage(int projectPosition, int stagePosition){

        String msg = "";

        if(projects[projectPosition].getStages()[stagePosition].getStageActivity() == true){

            projects[projectPosition].getStages()[stagePosition].setStageInactive();

            projects[projectPosition].getStages()[stagePosition].setRealFinalDate();

            projects[projectPosition].getStages()[stagePosition+1].setStageActive();

            projects[projectPosition].getStages()[stagePosition+1].setRealInitialDate();

            return msg+="You have successfully ended this project stage";

        }
        else{
            return msg+="This stage is already inactive";
        }

    }

    /**
     * Description: Here the user get the information of how many knowledge units their are of each type of knowledge unit.
     * @return msg is a string concatenation showing the user how many knowledge units their are of each type of knowledge unit.
     */

    public String quantityKnowledgeUniteType(){
        String msg = "";

        int countTechnical = 0;
        int countManagment = 0;
        int countDomain = 0;
        int countExperiences = 0;

    
        for (int i = 0; i < projects.length; i++) {
            
            if (projects[i]!=null){

                for (int j = 0; j < projects[i].getStages().length; j++) {
                    
                    for (int k = 0; k < projects[i].getStages()[j].getKnowledgeUnites().length; k++) {
                        
                        if (projects[i].getStages()[j].getKnowledgeUnites()[k]!=null){

                            if (projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledgeType() == KnowledgeEnum.TECHNICAL){

                                countTechnical +=1;
                            }

                            else if(projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledgeType() == KnowledgeEnum.MANAGEMENT){

                                countManagment +=1;
                            }

                            else if (projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledgeType() == KnowledgeEnum.DOMAIN){

                                countDomain +=1;
                            }

                            else if(projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledgeType() == KnowledgeEnum.EXPERIENCES){

                                countExperiences +=1;
                            } 


                        }
                    }
                }
            }

        }
        
        msg += " You have "+countTechnical+" technical knowlege units \n You have "+countManagment+" management knowledge units \n you have "+countDomain+" domain knowledge units \n You have "+countExperiences+" experiences knowledge units";

        return msg;
    }
    
    /**
     * Description: Here the useri is shown is a string concatenation showing the user
     * @return  msg is a string concatenation showing the user is a string concatenation showing the user
     */

    public String projectMostKnowledgeUnits(){

        String msg = "";

        int max = 0;
        int sum = 0;
        int maxProject=0;

         for (int i = 0; i < projects.length; i++) {

            if (projects[i]!=null){

                for (int j = 0; j < projects[i].getStages().length; j++) {
                    
                    for (int k = 0; k < projects[i].getStages()[j].getKnowledgeUnites().length; k++){

                        if(projects[i].getStages()[j].getKnowledgeUnites()[k]!=null){

                            sum +=1;

                            
                        }

                    }

                }

            }


            if (sum > max){
                max = sum;
                maxProject = i;

            }

         }
        
         msg = "Project #"+(maxProject+1)+" has "+max+" knowleg units, making it the project with the most knowledge units.";

        return msg;

    }

    /**
     * Description: This method shows the user if the collaborator that they are searching has created a knowledge unit in any project.
     * @param collaboratorName is a string and it's the name of the collaborator that they are searching for.
     * @return msg is a string concatenation showing the user if the collaborator that they are searching has created a knowledge unit in any project.
     */

    public String collaboratorKnowledgeUnitsInProject(String collaboratorName){
        
        String msg = "";

        for (int i = 0; i < projects.length; i++) {
            
            if (projects[i]!=null){

                for (int j = 0; j < projects[i].getStages().length; j++) {
                    
                    for (int k = 0; k < projects[i].getStages()[j].getKnowledgeUnites().length; k++) {
                        
                        if (projects[i].getStages()[j].getKnowledgeUnites()[k]!=null){

                            if(projects[i].getStages()[j].getKnowledgeUnites()[k].getCollaboratorName().equals(collaboratorName)){
                                return msg+= "This collaborator has created a knowledge unit";
                            }

                        }
                    }
                }
            }

        }

        return msg+="This collaborator has not created a knowledge unit";
    }

    /**
     * Description: Here the user is shown all the knowledge stored in all the projects in a certein stage type.
     * @param stageType is an int and it's the stage type that the user enters.
     * @return msg is a string concatenation showing the user all the knowledge stored in all the projects in a certein stage type.
     */

    public String knowledgeByKnowledgeUniteType(int stageType){

        String msg = "";

        for (int i = 0; i < projects.length; i++) {
            
            if (projects[i]!=null){

                for (int j = 0; j < projects[i].getStages().length; j++) {
                    
                    for (int k = 0; k < projects[i].getStages()[j].getKnowledgeUnites().length; k++) {
                        
                        if (projects[i].getStages()[j].getKnowledgeUnites()[k]!=null){

                            if (stageType == 1){

                                if(projects[i].getStages()[j].getStageType().equals(StageEnum.START)){
                                    msg += projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledge()+"\n";
                                }

                            }

                            else if (stageType == 2){

                                if(projects[i].getStages()[j].getStageType().equals(StageEnum.ANALISIS)){
                                    msg += projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledge()+"\n";
                                }

                           }

                            else if (stageType == 3){

                                if(projects[i].getStages()[j].getStageType().equals(StageEnum.DESIGN)){
                                    msg += projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledge()+"\n";
                                }

                             

                            }

                            else if (stageType == 4){

                                if(projects[i].getStages()[j].getStageType().equals(StageEnum.EXECUTION)){
                                    msg += projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledge()+"\n";
                                }

                              


                            }

                            else if (stageType == 5){

                                if(projects[i].getStages()[j].getStageType().equals(StageEnum.CLOSING)){
                                    msg += projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledge()+"\n";
                                }

                             


                            }

                            else if (stageType == 6){

                                if(projects[i].getStages()[j].getStageType().equals(StageEnum.FOLLOW_UP_AND_PROJECT_CONTROL)){
                                    msg += projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledge()+"\n";
                                }


                            }

                          
                        }
                    }
                }
            }

        }

        if (msg.equals("")){
            
                msg +="There is no knowledge units registered in this type of stage";
        
        }

        return msg;
    }

    /**
     * Description: Here the user types in a keyword and then it's searched in all of the knowledge units and when is matches with a word withing a knowledge it shows it back to the user.
     * @param query is a string and it's the keyword that the user enters.
     * @return msg is a string concatenation showing the user the knowledge that matched with the keyword.
     */

    public String hashtags(String query){

        String msg = "";

        for (int i = 0; i < projects.length; i++) {
            
            if (projects[i]!=null){

                for (int j = 0; j < projects[i].getStages().length; j++) {
                    
                    for (int k = 0; k < projects[i].getStages()[j].getKnowledgeUnites().length; k++) {
                        
                        if (projects[i].getStages()[j].getKnowledgeUnites()[k]!=null){

                            if(projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledgeUniteApproval()==true && projects[i].getStages()[j].getKnowledgeUnites()[k].getPublishKnowledgeUnit()==true){

                                if(projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledge().contains(query)){

                                    msg += projects[i].getStages()[j].getKnowledgeUnites()[k].getKnowledge();

                                }
                            }

                        }
                    }
                }
            }

        }

        return msg;
    }

    public Project[] getProjects(){
        return projects;
    }

    public Project getProject(int position){
        return projects[position];
    }

    public String getPorjectInfo(){

        String msg = "";

        for (int i = 0; i < projects.length; i++) {

            if(projects[i]!=null){
                msg += (i+1)+". "+ projects[i].getPorjectName()+"\n";
            }
        }

        return msg;
    }

    public int getProjectsNumber(){

        int countProjects = 0;

        for (int i = 0; i < projects.length; i++) {
            
            if(projects[i]!=null){

                countProjects +=1;

            }
        }

        return countProjects;
    }

    
}
