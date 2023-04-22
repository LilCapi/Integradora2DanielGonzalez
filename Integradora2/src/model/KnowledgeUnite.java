package model;

import java.util.Calendar;

public class KnowledgeUnite {
    
    private String id;
    private String description;
    private KnowledgeEnum knowledgeType;
    private String name;
    private String employeePosition;
    private String knowledge;
    private boolean knowledgeUniteApproval;
    private Calendar knowledgeApprovalDate;
    private boolean publishKnowledgeUnit;
    private String urlKnowledgeUnit;

    public KnowledgeUnite(String id, String description, int knowledgeType, String name, String employeePosition, String knowledge){

        this.id = id;
        this.description = description;
        this.name = name;
        this.employeePosition = employeePosition;
        this.knowledge = knowledge;
        this.knowledgeUniteApproval = false;
        this.publishKnowledgeUnit = false;
        

        switch (knowledgeType) {
            case 1:
                this.knowledgeType = KnowledgeEnum.TECHNICAL;
                break;

            case 2: 
                this.knowledgeType = KnowledgeEnum.MANAGEMENT;
                break;
            
            case 3:
                this.knowledgeType = KnowledgeEnum.DOMAIN;
                break;

            case 4:
                this.knowledgeType = KnowledgeEnum.EXPERIENCES;
                break;
        
        }


    }

    public String getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public KnowledgeEnum getKnowledgeType(){
        return knowledgeType;
    }
    
    public String getCollaboratorName(){
        return name;
    }

    public String getEmployeePosition(){
        return employeePosition;
    }

    public String getKnowledge(){
        return knowledge;
    }

    public boolean getKnowledgeUniteApproval(){
        return knowledgeUniteApproval;
    }

    public Calendar getKnowledgeApprovalDate(){

        return knowledgeApprovalDate;
    }

    public void setKnowledgeApproval(){
        this.knowledgeUniteApproval = true;
        this.knowledgeApprovalDate = Calendar.getInstance();

    }

    public void setPublishKnowledgeUnit(){
        this.publishKnowledgeUnit = true;
        this.urlKnowledgeUnit = "https://www.GreenSQA.com";

    }

    public String getName() {
        return name;
    }

    public boolean getPublishKnowledgeUnit() {
        return publishKnowledgeUnit;
    }

    public String getUrlKnowledgeUnit() {
        return urlKnowledgeUnit;
    }

}
