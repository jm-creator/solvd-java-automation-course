package entity;

import com.github.javafaker.Faker;
import enums.Categories;
import enums.CategoryCoverage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Patient extends Person{

    private static final Logger LOGGER = Logger.getLogger(Patient.class);

    Faker faker = new Faker();
    private boolean isActive;
    private String lastName;
    private String firstName;
    private Category healCareCategory;
    private int idNumber;


    public Patient(Category healCareCategory) {
        this.lastName = faker.name().lastName();
        this.firstName = faker.name().firstName();
        this.isActive = new Random().nextBoolean();
        this.healCareCategory = healCareCategory;
        this.idNumber = faker.idNumber().hashCode();
    }

    public Patient(String firstName, String lastName, int idNumber) {
        super(firstName, lastName, idNumber);
        this.lastName = faker.name().lastName();
        this.firstName = faker.name().firstName();
        this.isActive = new Random().nextBoolean();
        this.idNumber = faker.idNumber().hashCode();
    }

    @Override
    public String toString() {
        return "Patient " +
                "Name= " + lastName + " " + firstName + "\n"+
                ", isActive= " + isActive+
                ", HealCarePlan= " + healCareCategory +
                 "\n";
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

    public int getIdNumber() {
        return idNumber;
    }
}
