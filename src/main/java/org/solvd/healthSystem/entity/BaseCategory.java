package org.solvd.healthSystem.entity;

import org.solvd.healthSystem.enums.Categories;
import org.solvd.healthSystem.enums.CategoryCoverage;

import java.util.List;

public class BaseCategory extends Category {
    private final float price;
    private String name;
    private List<CategoryCoverage> baseCategory;

    public BaseCategory(String name, Float price, List<CategoryCoverage> baseCategory) {
        super(name, price, baseCategory);
        this.name = Categories.BASE.getName();
        this.price = Categories.BASE.getPrice();
        this.baseCategory = CategoryCoverage.getBaseCoverage();
    }


    public List<CategoryCoverage> getBaseCategory() {
        return baseCategory;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
