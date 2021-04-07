package org.solvd.healthSystem.utils;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.solvd.healthSystem.models.*;
import org.solvd.healthSystem.enums.HealthCarePlans;
import org.solvd.healthSystem.enums.CategoryCoverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.solvd.healthSystem.enums.HealthCarePlans.*;

public class DataGenerator {
    private static final Logger LOGGER = Logger.getLogger(DataGenerator.class);
    private static final Faker faker = new Faker();

    public static HealthCareCategoryCoverage getRandomHealthCareCategoryCoverage() {
        return CategoryCoverage.getRandomCoverage();
    }

    public static List<Partner> loadPatientsList() {
        LOGGER.debug("Initializing Patients List...");
        List<Partner> randomPartners = new ArrayList<>();
        BaseHealCarePlan baseCategory;
        MediumHealCarePlan mediumCategory;
        PremiumHealCarePlan premiumCategory;
        String lastName;
        String firstName;
        boolean isActive;
        boolean familyGroup;
        int idNumber;
        double income;

        for (int i = 0; i <= 10; i++) {
            HealthCarePlans category = HealthCarePlans.randomCategory();
            lastName = faker.name().lastName();
            firstName = faker.name().firstName();
            isActive = new Random().nextBoolean();
            idNumber = faker.idNumber().hashCode();
            familyGroup = new Random().nextBoolean();
            baseCategory = new BaseHealCarePlan(category.getName(), BASE.getPrice(), CategoryCoverage.getBaseCoverage());
            mediumCategory = new MediumHealCarePlan(category.getName(), MEDIUM.getPrice(), CategoryCoverage.getMediumCoverage());
            premiumCategory = new PremiumHealCarePlan(category.getName(), PREMIUM.getPrice(), CategoryCoverage.getPremiumCoverage());

            switch (category.getName()) {
                case "BASE":
                    randomPartners.add(new Partner(firstName,
                            lastName,
                            idNumber,
                            isActive,
                            baseCategory,
                            familyGroup,
                            income = faker.number().randomDouble(2, 15000, 100000)));
                case "MEDIUM":
                    randomPartners.add(new Partner(firstName,
                            lastName,
                            idNumber,
                            isActive,
                            mediumCategory,
                            familyGroup,
                            income = faker.number().randomDouble(2, 21000, 100000)));
                case "PRO":
                    randomPartners.add(new Partner(firstName,
                            lastName,
                            idNumber,
                            isActive,
                            premiumCategory,
                            familyGroup,
                            income = faker.number().randomDouble(2, 30000, 100000)));
            }
        }
        return randomPartners;
    }

    public static List<BaseEmployee> loadEmployees() {
        List<BaseEmployee> employees = new ArrayList<>();
        employees.add(new HumanResourcesEmployee(faker.name().firstName(),
                faker.name().lastName(),
                faker.idNumber().hashCode(),
                faker.idNumber().hashCode()));
        employees.add(new HumanResourcesEmployee(faker.name().firstName(),
                faker.name().lastName(),
                faker.idNumber().hashCode(),
                faker.idNumber().hashCode()));
        employees.add(new HumanResourcesManager(faker.name().firstName(),
                faker.name().lastName(),
                faker.idNumber().hashCode(),
                faker.idNumber().hashCode()));
        employees.add(new HumanResourcesManager(faker.name().firstName(),
                faker.name().lastName(),
                faker.idNumber().hashCode(),
                faker.idNumber().hashCode()));
        return employees;
    }

    public static List<AbstractHealthCarePlan> loadHealthCarePlans() {
        return HealthCarePlans.getHealthCarePlans();
    }
}
