package org.solvd.healthSystem.entity;

import org.solvd.healthSystem.enums.Categories;
import org.solvd.healthSystem.enums.CategoryCoverage;

import java.util.List;

<<<<<<< HEAD:src/main/java/org/solvd/healthSystem/entity/PremiumCategory.java
public class PremiumCategory extends Category {
=======
public class ProCategory extends Category {
>>>>>>> 0932fd5db8f42f9547ece2e7f683f4c4cfa79d1e:src/main/java/org/solvd/healthSystem/entity/ProCategory.java
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
