package com.solvd.medicalInsuranceSystem.models;

import java.util.List;

public class BaseHealCarePlan extends AbstractHealthCarePlan {

    public BaseHealCarePlan(String name, double price, List<HealthCareCategoryCoverage> categoryCoverages) {
        super(name, price, categoryCoverages);
    }

}
