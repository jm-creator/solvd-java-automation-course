package entity;

import interfaces.IActiveService;
import interfaces.ICoverageService;
import enums.Categories;
import enums.CategoryCoverage;
import org.apache.log4j.Logger;
import services.ActiveService;
import services.CoverageService;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final Logger LOGGER = Logger.getLogger(Patient.class);
    ICoverageService iCoverageService;
    IActiveService iActiveService;



    private final static List<Patient> randomPatients = generateRandomPatients();

    public App() {
        this.iActiveService = new ActiveService();
        this.iCoverageService = new CoverageService();
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
                    ProCategory proCategory;
                    proCategory = new ProCategory(category.getName(), category.getPrice(), CategoryCoverage.getPremiumCoverage());
                    randomPatients.add(new Patient(proCategory));
            }
        }
        return randomPatients;
    }

    public static List<Patient> getRandomPatients() {
        return randomPatients;
    }

    public List<Patient> getPatientList() {
        return randomPatients;
    }

    public ICoverageService getICoverageService() {
        return iCoverageService;
    }

    public IActiveService getIActiveService() {
        return this.iActiveService;
    }


}
