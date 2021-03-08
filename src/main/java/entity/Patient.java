package entity;

import com.github.javafaker.Faker;
import enums.Categories;
import enums.CategoryCoverage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Patient {

    private static final Logger LOGGER = Logger.getLogger(Patient.class);

    Faker faker = new Faker();
    private boolean isActive;
    private String lastName;
    private String firstName;
    private Category healCareCategory;

    private final static List<Patient> randomPatients = generateRandomPatients();


    public Patient(Category healCareCategory) {
        this.lastName = faker.name().lastName();
        this.firstName = faker.name().firstName();
        this.isActive = new Random().nextBoolean();
        this.healCareCategory = healCareCategory;
    }

    public Patient(String name, Category healCareCategory) {
        this.firstName = name;
        this.healCareCategory = healCareCategory;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "name=" + lastName + " " + firstName +
                ", healCarePlan=" + healCareCategory +
                ", isActive=" + isActive;
    }

    public static List<Patient> generateRandomPatients() {

        List<Patient> randomPatients = new ArrayList<>();
        for(int i = 0; i <= 10; i++) {

            Categories category = Categories.randomCategory();

            switch (category.getName()) {
                case "BASE":
                    randomPatients.add(new Patient(
                            new Category(Categories.BASE.getName(),
                                    Categories.BASE.getPrice(),
                                    CategoryCoverage.getBaseCoverage())));
                case "MEDIUM":
                    randomPatients.add(new Patient(
                            new Category(Categories.MEDIUM.getName(),
                                    Categories.MEDIUM.getPrice(),
                                    CategoryCoverage.getMediumCoverage())));
                case "PRO":
                    randomPatients.add(new Patient(
                            new Category(Categories.PRO.getName(),
                                    Categories.PRO.getPrice(),
                                    CategoryCoverage.getPremiumCoverage())));
            }
        }
        return randomPatients;
    }

    public static List<Patient> getRandomPatients() {
        return randomPatients;
    }

    public boolean hasCoverage(String coverageName) {
        LOGGER.info("Checking for coverage of " + coverageName + " for the patient " + this.firstName);
        for (CategoryCoverage categoryCoverage: healCareCategory.getCoverage()) {
            return coverageName.equals(categoryCoverage.getName());
        }

        return false;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Category getHealCareCategory() {
        return healCareCategory;
    }

    public void setHealCareCategory(Category healCareCategory) {
        this.healCareCategory = healCareCategory;
    }

}
