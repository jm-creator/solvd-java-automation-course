package enums;

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
    PLASTIC_SURGERY("Plastic surgery", "1");

    private String name;
    private String desc;

    CategoryCoverage(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public static List<CategoryCoverage> getBaseCoverage() {
        List<CategoryCoverage> coverages = new ArrayList<>();
        coverages.add(MATERNAL);
        coverages.add(OPTICAL);
        coverages.add(ORTHODONTICS);
        coverages.add(PSYCHOLOGY);
        coverages.add(KINESIOLOGY);
        return coverages;
    }

    public static List<CategoryCoverage> getMediumCoverage() {
        List<CategoryCoverage> coverages = new ArrayList<>();
        coverages.addAll(getBaseCoverage());
        coverages.add(HOSPITAL_THERAPY);
        coverages.add(EMERGENCIES);
        return coverages;
    }

    public static List<CategoryCoverage> getPremiumCoverage() {
        List<CategoryCoverage> coverages = new ArrayList<>();
        coverages.addAll(getBaseCoverage());
        coverages.addAll(getMediumCoverage());
        coverages.add(DOCTOR_AT_HOME);
        coverages.add(INTERNATIONAL_COVERAGE);
        coverages.add(PLASTIC_SURGERY);
        return coverages;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static CategoryCoverage getRandomCoverage() {
        return CategoryCoverage.values()[new Random().nextInt(CategoryCoverage.values().length)];
    }

}


