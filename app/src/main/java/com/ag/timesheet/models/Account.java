package com.ag.timesheet.models;

import java.io.Serializable;

public class Account implements Serializable {

    private long id;
    private String title;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private long role_id;
    private String status;


    public Account(long id, String title, String first_name, String last_name, String email, String password, long role_id, String status) {
        this.id = id;
        this.title = title;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
        this.status = status;
    }

    @Override
    public String toString() {

        return "Account{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                ", status='" + status + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
