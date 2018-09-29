package com.ag.timesheet.models;

import java.io.Serializable;
import java.util.Date;

public class TImeSheet implements Serializable {

    private long id;
    private String employee_id;
    private Date date;
    private String time_from;
    private String time_to;
    private String comments;
    private long activity_id;
    private Date date_submitted;

    @Override
    public String toString() {
        return "TImeSheet{" +
                "id=" + id +
                ", employee_id='" + employee_id + '\'' +
                ", date=" + date +
                ", time_from='" + time_from + '\'' +
                ", time_to='" + time_to + '\'' +
                ", comments='" + comments + '\'' +
                ", activity_id=" + activity_id +
                ", date_submitted=" + date_submitted +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime_from() {
        return time_from;
    }

    public void setTime_from(String time_from) {
        this.time_from = time_from;
    }

    public String getTime_to() {
        return time_to;
    }

    public void setTime_to(String time_to) {
        this.time_to = time_to;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public long getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(long activity_id) {
        this.activity_id = activity_id;
    }

    public Date getDate_submitted() {
        return date_submitted;
    }

    public void setDate_submitted(Date date_submitted) {
        this.date_submitted = date_submitted;
    }
}
