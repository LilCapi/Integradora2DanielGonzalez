package ui;

import java.util.Scanner;
import model.Controller;


public class Executable {

    private Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

    public static void main(String[] args) {
        Executable exe = new Executable();
        exe.menu();
    }
    
    public void menu(){
        
        

        boolean flage = false;

        while (!flage) {

            System.out.println("\n Choose an option \n 1: Create a project \n 2: End project stage \n 3: Register Knowledge unit \n 4: Approve capsules \n 5: Publish capsules \n 6: Quantity of each type of KnowledgeUnit \n 7: Show a list of the knowledge registered by each stage type \n 8: inform the user of the project with the most knowledge units registers \n 9: Consult if a collaborator has registered knowledge units in any project \n 10: Entera keyword to search up in the knowledge units that where approved and published  \n 11: Exit");
        int option = reader.nextInt();

             switch (option) {
            case 1:

                registerProject();
                
                break;
            
            case 2:

                endProjectStage();

                break;

            case 3:

                registerKnowledgeUnite();

                break;
            
            case 4: 

                approveKnowledgeUnite();

                break;

            case 5:

                publishKnowledgeUnit();

                break;

            case 6:

                System.out.println(controller.quantityKnowledgeUniteType());

                break;

            case 7:

                knowledgeByKnowledgeUniteType();
                
                break;

            case 8:

                System.out.println(controller.projectMostKnowledgeUnits());

                break;

            case 9:

                collaboratorKnowledgeUnitsInProject();

                break;

            case 10:

                hashtags();    

                break;

            case 11:

                System.out.println("You have successfully exit the program");    

                System.exit(0);

            default:

                System.out.println("Please enter a number within the range");
                break;

            }   
        }
        
    }

    /**
     * Description: Here the user register his project.
     */

    public void registerProject(){

        reader.nextLine();

        System.out.println("Here you will create your project");

        //Proyect name

        System.out.println("Enter the name of the project: ");
        String projectName = reader.nextLine();

        //Client name

        System.out.println("Enter the name of the client: ");
        String clientName = reader.nextLine();

        // Initiation date

        System.out.println("Enter the date that the project will begin");
        
        System.out.println("Enter your day of intiation:");
        int initialDay = reader.nextInt();

        System.out.println("Enter your month of initiation:");
        int initialMonth = reader.nextInt();

        System.out.println("Enter your year of initiation:");
        int initialYear = reader.nextInt();

        //Finalization date

        System.out.println("Enter your date of finalization");

        System.out.println("Enter your day of finalizaton:");
        int finalDay = reader.nextInt();

        System.out.println("Enter your month of finalizaton:");
        int finalMonth = reader.nextInt();

        System.out.println("Enter your year of finalizaton:");
        int finalYear = reader.nextInt();

        //Budget

        System.out.println("Enter your budget:");
        double budget = reader.nextDouble();

        //Manager info

        reader.nextLine();

        System.out.println("Enter the name of the manager:");
        String managerName = reader.nextLine();

        System.out.println("Enter the cell phone number of the manager:");
        String managerPhone = reader.nextLine();

        int[] monthStages = new int[6];

        for (int i = 0; i < monthStages.length; i++) {
            System.out.println("Enter how many months will this stage #"+(i+1)+" will take." );
            int monthOption = reader.nextInt();
            monthStages[i] = monthOption;
        }

        if (controller.registerProject(projectName, clientName, controller.createCalendar(initialDay, initialMonth, initialYear), controller.createCalendar(finalDay, finalMonth, finalYear), budget, managerName, managerPhone,monthStages)==true){
            System.out.println("Your project was created successfully");
        }
        else{
            System.out.println("Memory full, con nott register another project");
        }

    }

    /**
     * Description: here the user registers his knowledge units.
     */

    public void registerKnowledgeUnite(){

        System.out.println(" Here you will register your knowledge unit.");

        System.out.println("This are the projects that you have created:");

        //Project

        System.out.println(controller.getPorjectInfo());

        System.out.println("Enter the position of the project that you want to acces:");
        int projectPosition = reader.nextInt();
        projectPosition -=1;

        //Stage

        System.out.println(controller.getProjects()[projectPosition].getStageInfo());

        System.out.println("Enter the position of the stage that you want to acces");
        int stagePosition = reader.nextInt();
        stagePosition -=1;

        reader.nextLine();

        //Stage info

        System.out.println("Please enter the capsulse id:");
        String id = reader.nextLine();

        System.out.println("Enter a description of the situation that you want to register:");
        String description = reader.nextLine();

        System.out.println("Enter which type do you desire to create \n 1: TECHNICAL \n 2: MANAGEMENT \n 3: DOMAIN \n 4: EXPERIENCES");
        int type = reader.nextInt();

        reader.nextLine();

        System.out.println("Enter the name of the collaborator who's filling this information:");
        String name = reader.nextLine();

        System.out.println("Enter the position of the collaborator who's filling this information:");
        String employeePosition = reader.nextLine();

        System.out.println("Enter what you learned or the knowledge that you acquired:");
        String knowledge = reader.nextLine();

        controller.registerKnowledgeUnite(id, description, type, name, employeePosition, knowledge, projectPosition, stagePosition);


}

    /**
     * Description: Here the user can end a stage and strat the next one.
     */

    public void endProjectStage(){

        //Project position

        System.out.println(controller.getPorjectInfo());

        System.out.println("Enter the position of the project that you want to acces:");
        int projectPosition = reader.nextInt();
        projectPosition -=1;

        //Stage

        System.out.println(controller.getProjects()[projectPosition].getStageInfo());

        System.out.println("Enter the position of the stage that you want to acces");
        int stagePosition = reader.nextInt();
        stagePosition -=1;

        controller.endProjectStage(projectPosition, stagePosition);

    }

    /**
     * Description: Here the user will aprove a knowledge unit
     */

    public void approveKnowledgeUnite(){
        //Project position

        System.out.println(controller.getPorjectInfo());

        System.out.println("Enter the position of the project that you want to acces:");
        int projectPosition = reader.nextInt();
        projectPosition -=1;

        //Stage

        System.out.println(controller.getProjects()[projectPosition].getStageInfo());

        System.out.println("Enter the position of the stage that you want to acces");
        int stagePosition = reader.nextInt();
        stagePosition -=1;

        System.out.println(controller.getProjects()[projectPosition].getStages()[stagePosition].getKnowledgeUnitesinfo());

        System.out.println("Enter the position of the knowledge unite that you want to approve:");
        int knowledgeUnitePosition = reader.nextInt();
        knowledgeUnitePosition -=1;

        controller.getProjects()[projectPosition].getStages()[stagePosition].getKnowledgeUnites()[knowledgeUnitePosition].setKnowledgeApproval();

        if (controller.getProjects()[projectPosition].getStages()[stagePosition].getKnowledgeUnites()[knowledgeUnitePosition].getKnowledgeUniteApproval()==true){
            System.out.println("The knowledge unit was successfully aproved");
        }
        else {
            System.out.println("There was a proble aproving your knowledge unit");
        }
    }

    /**
     * Description: Here the user enter a collaborator.
     */

    public void collaboratorKnowledgeUnitsInProject(){

        reader.nextLine();

        System.out.println("Enter the name of the collaborator:");
        String collaboratorName = reader.nextLine();

        System.out.println(controller.collaboratorKnowledgeUnitsInProject(collaboratorName));
    }

    /**
     * Description: Here the user enter a type of stage that it will use to get all of the knowledge that their is of that type of stage in all of the projects.
     */

    public void knowledgeByKnowledgeUniteType(){

        if(controller.getProjects()[0]!=null){
            
            System.out.println(controller.getProjects()[0].getStageInfo());

            System.out.println("Enter the number of which type of stage do you want to search");
            int stageType = reader.nextInt();

            System.out.println(controller.knowledgeByKnowledgeUniteType(stageType));

        }

        else{
            System.out.println("Make sure you hava created previously a proyect");
        }

    }

    /**
     * Description: Here the user will publish the knowledge units that where periously approved.
     */

    public void publishKnowledgeUnit(){

        //Project position

        System.out.println(controller.getPorjectInfo());

        System.out.println("Enter the position of the project that you want to acces:");
        int projectPosition = reader.nextInt();
        projectPosition -=1;

        //Stage

        System.out.println(controller.getProjects()[projectPosition].getStageInfo());

        System.out.println("Enter the position of the stage that you want to acces");
        int stagePosition = reader.nextInt();
        stagePosition -=1;

        System.out.println(controller.getProjects()[projectPosition].getStages()[stagePosition].getKnowledgeUnitesinfo());

        System.out.println("Enter the position of the knowledge unite that you want to approve:");
        int knowledgeUnitePosition = reader.nextInt();
        knowledgeUnitePosition -=1;

        if(controller.getProjects()[projectPosition].getStages()[stagePosition].getKnowledgeUnites()[knowledgeUnitePosition].getKnowledgeUniteApproval()==true){

                controller.getProjects()[projectPosition].getStages()[stagePosition].getKnowledgeUnites()[knowledgeUnitePosition].setPublishKnowledgeUnit();

            if ( controller.getProjects()[projectPosition].getStages()[stagePosition].getKnowledgeUnites()[knowledgeUnitePosition].getPublishKnowledgeUnit() == true){

                System.out.println("The knowledge unit was succssefully published");
            }}

    }

    /**
     * Description: Here the user will enter a keyword and the program will locate that keyword on the knowledge and will bring back all of them.
     */

    public void hashtags(){

        reader.nextLine();

        System.out.println("Enter the keyword you want to search:");
        String query = reader.nextLine();

        System.out.println(controller.hashtags(query));
    }

}
