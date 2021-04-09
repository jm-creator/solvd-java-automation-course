package com.solvd.medicalInsuranceSystem.models;

import java.util.List;

public class MediumHealCarePlan extends AbstractHealthCarePlan {

    public MediumHealCarePlan(String name, double price, List<HealthCareCategoryCoverage> categoryCoverage) {
        super(name, price, categoryCoverage);
    }

}
