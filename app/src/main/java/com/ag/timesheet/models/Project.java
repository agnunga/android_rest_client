package com.ag.timesheet.models;

public class Project {

    private long id;
    private String project_code;
    private String name;
    private String location;
    private long manager_id;
    private String start_date;
    private String end_date;
    private String other_details;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", project_code='" + project_code + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", manager_id=" + manager_id +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", other_details='" + other_details + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getManager_id() {
        return manager_id;
    }

    public void setManager_id(long manager_id) {
        this.manager_id = manager_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }
}
