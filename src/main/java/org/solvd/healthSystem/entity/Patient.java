package org.solvd.healthSystem.entity;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;

import java.util.Random;

public class Patient extends Person {

    private static final Logger LOGGER = Logger.getLogger(Patient.class);
    private boolean isActive;
    private Category healCareCategory;
<<<<<<< HEAD:src/main/java/org/solvd/healthSystem/entity/Patient.java
    private Faker faker = new Faker();
=======
    private int idNumber;

    
>>>>>>> 0932fd5db8f42f9547ece2e7f683f4c4cfa79d1e:src/main/java/entity/Patient.java

    public Patient(Category healCareCategory) {
        super.setLastName(faker.name().lastName());
        super.setFirstName(faker.name().firstName());
        super.setIdNumber(faker.idNumber().hashCode());
        this.isActive = new Random().nextBoolean();
        this.healCareCategory = healCareCategory;
    }

    public Patient(String firstName, String lastName, int idNumber) {
        super(firstName, lastName, idNumber);
        this.isActive = new Random().nextBoolean();
    }

    @Override
    public String toString() {
        return "Patient " +
                "Name= " + super.getLastName() + " " + super.getFirstName() + "\n"+
                ", isActive= " + isActive +
                ", HealCarePlan= " + healCareCategory +
                 "\n";
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Category getHealCareCategory() {
        return healCareCategory;
    }

    public void setHealCareCategory(Category healCareCategory) {
        this.healCareCategory = healCareCategory;
    }

}
