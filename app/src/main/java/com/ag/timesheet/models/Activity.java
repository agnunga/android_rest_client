package com.ag.timesheet.models;

import java.io.Serializable;

public class Activity implements Serializable {

    private long id;
    private String code;
    private long project_id;
    private String start_date;
    private String end_date;
    private String other_details;

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", project_id=" + project_id +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
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
