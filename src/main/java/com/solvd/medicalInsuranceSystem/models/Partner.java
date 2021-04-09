package com.solvd.medicalInsuranceSystem.models;

import org.apache.log4j.Logger;

public class Partner extends Person {
    
    private static final Logger LOGGER = Logger.getLogger(Partner.class);
    private boolean isActive;
    private AbstractHealthCarePlan healCareCategory;
    private boolean familiarGroup;
    private double income;


    public Partner(String firstName, String lastName, int idNumber, boolean isActive, boolean familiarGroup, double income) {
        super(firstName, lastName, idNumber);
        this.isActive = isActive;
        this.familiarGroup = familiarGroup;
        this.income = income;
    }

    public Partner(String firstName, String lastName, int idNumber, boolean isActive, AbstractHealthCarePlan healCareCategory, boolean familiarGroup, double income) {
        super(firstName, lastName, idNumber);
        this.isActive = isActive;
        this.healCareCategory = healCareCategory;
        this.familiarGroup = familiarGroup;
        this.income = income;
    }


    @Override
    public String toString() {
        return "Partner " +
                "Name = " + super.getLastName() + " " + super.getFirstName() + "\n"+
                "Income = " + income +
                ", isActive = " + isActive +
                ", HealCarePlan = " + healCareCategory +
                 "\n";
    }

    public boolean isFamiliarGroup() {
        return familiarGroup;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public AbstractHealthCarePlan getHealCareCategory() {
        return healCareCategory;
    }

    public void setHealCareCategory(AbstractHealthCarePlan healCareCategory) {
        this.healCareCategory = healCareCategory;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
