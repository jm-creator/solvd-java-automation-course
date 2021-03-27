package org.solvd.healthSystem.entity;

import org.solvd.healthSystem.enums.Categories;
import org.solvd.healthSystem.enums.CategoryCoverage;

import java.util.List;

public class MediumCategory extends Category {
    private final float price;
    private String name;
    private List<CategoryCoverage> mediumCategory;

    public MediumCategory(String name, Float price, List<CategoryCoverage> categoryCoverage) {
        super(name, price, categoryCoverage);
        this.name = Categories.MEDIUM.getName();
        this.price = Categories.MEDIUM.getPrice();
        this.mediumCategory = CategoryCoverage.getMediumCoverage();
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    public List<CategoryCoverage> getMediumCategory() {
        return mediumCategory;
    }

}
