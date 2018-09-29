package com.ag.timesheet.models;

import java.util.ArrayList;



public class UsersDto {

    private ArrayList<User> users;

    public UsersDto() {

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
