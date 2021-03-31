package org.solvd.healthSystem.entity;

import org.solvd.healthSystem.enums.CategoryCoverage;
import org.apache.log4j.Logger;

import java.util.List;

public abstract class Category {
    private static final Logger LOGGER = Logger.getLogger(Category.class);

    private String name;
    private float price;
    private List<CategoryCoverage> coverage;

    public Category(String name, Float price, List<CategoryCoverage> categoryCoverage) {
        //LOGGER.info("Initializing Heal Care Category");
        this.name = name;
        this.price = price;
        this.coverage = categoryCoverage;
    }

    @Override
    public String toString() {
        return "{" + name + " " + price + " " + coverage.toString() +'}';
    }

    public String getName() {
        return name;
    }

    public List<CategoryCoverage> getCoverage() {
        return coverage;
    }

}
