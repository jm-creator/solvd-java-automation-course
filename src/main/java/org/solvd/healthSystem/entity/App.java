package org.solvd.healthSystem.entity;
<<<<<<< HEAD:src/main/java/org/solvd/healthSystem/entity/App.java

=======
>>>>>>> 0932fd5db8f42f9547ece2e7f683f4c4cfa79d1e:src/main/java/entity/App.java
import org.solvd.healthSystem.enums.Categories;
import org.solvd.healthSystem.enums.CategoryCoverage;
import org.solvd.healthSystem.interfaces.IActive;
import org.solvd.healthSystem.interfaces.IActivePatients;
import org.solvd.healthSystem.interfaces.ICoverage;
import org.solvd.healthSystem.interfaces.IHealCareCoverage;
import org.solvd.healthSystem.services.ActivePatientsService;
import org.solvd.healthSystem.services.ActiveService;
import org.solvd.healthSystem.services.CoverageService;
import org.solvd.healthSystem.services.HealCoverageService;
<<<<<<< HEAD:src/main/java/org/solvd/healthSystem/entity/App.java

import org.apache.log4j.Logger;
=======
import org.apache.log4j.Logger;

>>>>>>> 0932fd5db8f42f9547ece2e7f683f4c4cfa79d1e:src/main/java/entity/App.java
import java.util.ArrayList;
import java.util.List;

public class App {

   private static final Logger LOGGER = Logger.getLogger(Patient.class);
   private ICoverage iCoverageService;
   private IActive iActiveService;
   private IActivePatients iActivePatients;
   private IHealCareCoverage iHealCareCoverage;



    private final static List<Patient> randomPatients = generateRandomPatients();

    public App() {
        this.iActiveService = new ActiveService();
        this.iCoverageService = new CoverageService();
        this.iActivePatients = new ActivePatientsService();
        this.iHealCareCoverage = new HealCoverageService();
    }

    public static List<Patient> generateRandomPatients() {
      LOGGER.debug("Initializing Patients List...");

        List<Patient> randomPatients = new ArrayList<>();
        for(int i = 0; i <= 10; i++) {

            Categories category = Categories.randomCategory();

            switch (category.getName()) {
                case "BASE":
                    BaseCategory baseCategory;
                    baseCategory = new BaseCategory(category.getName(), category.getPrice(), CategoryCoverage.getBaseCoverage());
                    randomPatients.add(new Patient(baseCategory));
                case "MEDIUM":
                    MediumCategory mediumCategory;
                    mediumCategory = new MediumCategory(category.getName(), category.getPrice(), CategoryCoverage.getMediumCoverage());
                    randomPatients.add(new Patient(mediumCategory));
                case "PRO":
                    PremiumCategory proCategory;
                    proCategory = new PremiumCategory(category.getName(), category.getPrice(), CategoryCoverage.getPremiumCoverage());
                    randomPatients.add(new Patient(proCategory));
            }
        }
        return randomPatients;
    }

    public Patient getPatient() {
        Patient patient = getPatientList().get(0);
        return patient;
    }

    public static List<Patient> getRandomPatients() {
        return randomPatients;
    }

    public List<Patient> getPatientList() {
        return randomPatients;
    }

    public ICoverage getICoverageService() {
        return iCoverageService;
    }

    public IActive getIActiveService() {
        return this.iActiveService;
    }

    public IActivePatients getIActivePatients() {
        return iActivePatients;
    }

    public IHealCareCoverage getIHealCareCoverage() {
        return iHealCareCoverage;
    }



}
