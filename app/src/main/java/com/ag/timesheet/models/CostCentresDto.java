package com.ag.timesheet.models;

import java.util.List;


public class CostCentresDto {

    private List<CostCentre> cost_centres;

    public CostCentresDto() {

    }

    public List<CostCentre> getCost_centres() {
        return cost_centres;
    }

    public void setCost_centres(List<CostCentre> cost_centres) {
        this.cost_centres = cost_centres;
    }
}
