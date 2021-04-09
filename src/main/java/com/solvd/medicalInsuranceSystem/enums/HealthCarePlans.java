package com.solvd.medicalInsuranceSystem.enums;

import com.solvd.medicalInsuranceSystem.models.AbstractHealthCarePlan;
import com.solvd.medicalInsuranceSystem.models.BaseHealCarePlan;
import com.solvd.medicalInsuranceSystem.models.MediumHealCarePlan;
import com.solvd.medicalInsuranceSystem.models.PremiumHealCarePlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum HealthCarePlans {

    BASE("BASE", 4500d),
    MEDIUM("MEDIUM", 7000d),
    PREMIUM("PRO", 10000d);

    private String name;
    private double price;

    HealthCarePlans(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return price;
    }

    public static HealthCarePlans randomCategory() {
        return HealthCarePlans.values()[new Random().nextInt(HealthCarePlans.values().length)];
    }

    public static List<AbstractHealthCarePlan> getHealthCarePlans() {
        List<AbstractHealthCarePlan> healthCarePlans = new ArrayList<>();
        healthCarePlans.add(new BaseHealCarePlan(BASE.getName(), BASE.getPrice(), CategoryCoverage.getBaseCoverage()));
        healthCarePlans.add(new MediumHealCarePlan(MEDIUM.getName(), MEDIUM.getPrice(), CategoryCoverage.getMediumCoverage()));
        healthCarePlans.add(new PremiumHealCarePlan(PREMIUM.getName(), PREMIUM.getPrice(), CategoryCoverage.getPremiumCoverage()));
        return healthCarePlans;
    }
}
