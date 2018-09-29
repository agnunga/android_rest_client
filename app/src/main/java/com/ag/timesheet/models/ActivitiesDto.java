package com.ag.timesheet.models;

import java.util.ArrayList;
import java.util.List;


public class ActivitiesDto {

    private List<Activity> activities;

    public ActivitiesDto() {

    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
