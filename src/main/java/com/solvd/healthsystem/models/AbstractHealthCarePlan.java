package com.solvd.healthsystem.models;

import org.apache.log4j.Logger;

import java.util.List;

public abstract class AbstractHealthCarePlan {
    private static final Logger LOGGER = Logger.getLogger(AbstractHealthCarePlan.class);

    private String name;
    private double price;
    private List<HealthCareCategoryCoverage> coverages;

    public AbstractHealthCarePlan(String name, double price, List<HealthCareCategoryCoverage> categoryCoverage) {
        //LOGGER.info("Initializing Heal Care Category");
        this.name = name;
        this.coverages = categoryCoverage;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + name + " " + price + " " + coverages.toString() +'}';
    }

    public String getName() {
        return name;
    }

    public List<HealthCareCategoryCoverage> getCoverages() {
        return coverages;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public HealthCareCategoryCoverage getRandomCategoryCoverage() {
        return coverages.get(0);
    }
}
