package com.solvd.medicalInsuranceSystem.models;

import java.util.List;


public class PremiumHealCarePlan extends AbstractHealthCarePlan {

    public PremiumHealCarePlan(String name, double price, List<HealthCareCategoryCoverage> categoryCoverage) {
        super(name, price, categoryCoverage);
    }
}
