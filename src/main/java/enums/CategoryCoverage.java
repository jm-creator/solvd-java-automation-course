package enums;

import java.util.ArrayList;
import java.util.List;

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
    DOCTOR_AT_HOME("Doctor at home", "24 hs Doctor at Home"),
    INTERNATIONAL_COVERAGE("International coverage", "Full International"),
    PLASTIC_SURGERY("Plastic surgery", "1");

    private String name;
    private String desc;

    CategoryCoverage(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return this.name;
    }

    public static List<CategoryCoverage> getBaseCoverage() {
        List<CategoryCoverage> aux = new ArrayList<>();
        aux.add(MATERNAL);
        aux.add(OPTICAL);
        aux.add(ORTHODONTICS);
        aux.add(PSYCHOLOGY);
        aux.add(KINESIOLOGY);
        return aux;
    }

    public static List<CategoryCoverage> getMediumCoverage() {
    List<CategoryCoverage> aux = new ArrayList<>();
        aux.addAll(getBaseCoverage());
        aux.add(HOSPITAL_THERAPY);
        aux.add(EMERGENCIES);
    return aux;
    }

    public static List<CategoryCoverage> getPremiumCoverage() {
        List<CategoryCoverage> aux = new ArrayList<>();
        aux.addAll(getBaseCoverage());
        aux.addAll(getMediumCoverage());
        aux.add(DOCTOR_AT_HOME);
        aux.add(INTERNATIONAL_COVERAGE);
        aux.add(PLASTIC_SURGERY);
        return aux;
    }
}


