package org.solvd.healthSystem.entity;

import org.solvd.healthSystem.enums.Categories;
import org.solvd.healthSystem.enums.CategoryCoverage;

import java.util.List;

public class PremiumCategory extends Category {
    private final Float price;
    private final String name;
    private final List<CategoryCoverage> proCategory;

    public PremiumCategory(String name, Float price, List<CategoryCoverage> categoryCoverage) {
        super(name, price, categoryCoverage);
        this.name = Categories.PRO.getName();
        this.price = Categories.PRO.getPrice();
        this.proCategory = CategoryCoverage.getPremiumCoverage();
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    public List<CategoryCoverage> getProCategory() {
        return proCategory;
    }

}
