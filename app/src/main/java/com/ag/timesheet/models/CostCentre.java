package com.ag.timesheet.models;

import java.io.Serializable;
import java.util.Date;

public class CostCentre implements Serializable {

    private long id;
    private String name;
    private String description;
    private String order_details;
    private long owner_id;
    private Date date_created;
    private Date date_modified;

    @Override
    public String toString() {
        return "CostCentre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", order_details='" + order_details + '\'' +
                ", owner_id=" + owner_id +
                ", date_created=" + date_created +
                ", date_modified=" + date_modified +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrder_details() {
        return order_details;
    }

    public void setOrder_details(String order_details) {
        this.order_details = order_details;
    }

    public long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }
}
