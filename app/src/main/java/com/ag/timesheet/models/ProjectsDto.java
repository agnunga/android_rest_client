package com.ag.timesheet.models;

import java.util.List;


public class ProjectsDto {

    private List<Project> projects;

    public ProjectsDto() {

    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
