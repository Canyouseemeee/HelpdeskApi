package com.example.helpdesk;

public class Issues {

    private int Issuesid;
    private int Trackerid;
    private int Priorityid;
    private int Statusid;
    private int Departmentid;
    private String Users;
    private String Subject;
    private String Description;
    private String Date_In;
    private String Image;
    private String created_at;
    private String updated_at;

    public int getIssuesid() {
        return Issuesid;
    }

    public int getTrackerid() {
        return Trackerid;
    }

    public int getPriorityid() {
        return Priorityid;
    }

    public int getStatusid() {
        return Statusid;
    }

    public int getDepartmentid() {
        return Departmentid;
    }

    public String getUsers() {
        return Users;
    }

    public String getSubject() {
        return Subject;
    }

    public String getDescription() {
        return Description;
    }

    public String getDate_In() {
        return Date_In;
    }

    public String getImage() {
        return Image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
