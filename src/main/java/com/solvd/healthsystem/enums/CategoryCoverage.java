package com.solvd.healthsystem.enums;

import com.solvd.healthsystem.models.HealthCareCategoryCoverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum CategoryCoverage {
    //BASE
    MATERNAL("Maternal", "Material plan"),
    OPTICAL("Optical", "Optical plan"),
    ORTHODONTICS("Orthodontics", "Orthodontics plan"),
    PSYCHOLOGY("Psychology", "Psychology plan"),
    KINESIOLOGY("Kinesiology", "Kinesiology plan"),
    //MEDIUM
    HOSPITAL_THERAPY("Full hospital therapy", "Therapy"),
    EMERGENCIES("Emergencies and Urgencies", "24hs Urgencies"),
    //PRO
    DOCTOR_AT_HOME("Doctor at home", "24hs Doctor at Home"),
    INTERNATIONAL_COVERAGE("International coverage", "Full International"),
    PLASTIC_SURGERY("Plastic surgery", "1 surgery a year");

    private String name;
    private String desc;

    CategoryCoverage(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public static List<HealthCareCategoryCoverage> getBaseCoverage() {
        List<HealthCareCategoryCoverage> coverages = new ArrayList<>();
        coverages.add(new HealthCareCategoryCoverage(MATERNAL.getName(), MATERNAL.getDesc()));
        coverages.add(new HealthCareCategoryCoverage(OPTICAL.getName(), OPTICAL.getDesc()));
        coverages.add(new HealthCareCategoryCoverage(ORTHODONTICS.getName(), ORTHODONTICS.getDesc()));
        coverages.add(new HealthCareCategoryCoverage(PSYCHOLOGY.getName(), PSYCHOLOGY.getDesc()));
        coverages.add(new HealthCareCategoryCoverage(KINESIOLOGY.getName(), KINESIOLOGY.getDesc()));
        return coverages;
    }

    public static List<HealthCareCategoryCoverage> getMediumCoverage() {
        List<HealthCareCategoryCoverage> coverages = new ArrayList<>(getBaseCoverage());
        coverages.add(new HealthCareCategoryCoverage(HOSPITAL_THERAPY.getName(), HOSPITAL_THERAPY.getDesc()));
        coverages.add(new HealthCareCategoryCoverage(EMERGENCIES.getName(), EMERGENCIES.getDesc()));
        return coverages;
    }

    public static List<HealthCareCategoryCoverage> getPremiumCoverage() {
        List<HealthCareCategoryCoverage> coverages = new ArrayList<>(getMediumCoverage());
        coverages.add(new HealthCareCategoryCoverage(DOCTOR_AT_HOME.getName(), DOCTOR_AT_HOME.getDesc()));
        coverages.add(new HealthCareCategoryCoverage(INTERNATIONAL_COVERAGE.getName(), INTERNATIONAL_COVERAGE.getDesc()));
        coverages.add(new HealthCareCategoryCoverage(PLASTIC_SURGERY.getName(), PLASTIC_SURGERY.getDesc()));
        return coverages;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return desc;
    }


    public static HealthCareCategoryCoverage getRandomCoverage() {
        CategoryCoverage cc = CategoryCoverage.values()[new Random().nextInt(CategoryCoverage.values().length)];
        return new HealthCareCategoryCoverage(cc.getName(), cc.getDesc());
    }

}


