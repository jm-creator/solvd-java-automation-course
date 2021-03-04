package entity;

import com.github.javafaker.Cat;
import enums.CategoryCoverage;
import org.apache.log4j.Logger;

import java.util.List;

public class Category {
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

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<CategoryCoverage> getCoverage() {
        return coverage;
    }

    public void setCoverage(List<CategoryCoverage> coverage) {
        this.coverage = coverage;
    }
}
