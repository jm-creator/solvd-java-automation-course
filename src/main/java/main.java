import entity.App;
import entity.BaseCategory;
import entity.Category;
import entity.Patient;
import enums.Categories;
import enums.CategoryCoverage;
import exceptions.CategoryNotFoundException;
import exceptions.InvalidCoverageException;
import exceptions.PatientNotFoundException;
import org.apache.log4j.Logger;
import services.ActiveService;
import services.CoverageService;

import java.util.List;

public class main {

    private static final Logger LOGGER = Logger.getLogger(main.class);

    public static void main(String[] args) {

        App app = new App();
        Patient patient = app.getPatientList().get(0);
        String name = patient.getFirstName();
        String lastName = patient.getLastName();
        String coverage = CategoryCoverage.getRandomCoverage().getName();

        try {
            if (!app.getIActiveService().patientIsActive(name)) {
                LOGGER.info("patient " + name+" "+lastName+ " is NOT active!");
            } else LOGGER.info("patient " + name +" "+lastName+ " is active");
        } catch (PatientNotFoundException e) {
            e.printStackTrace();
        }
        LOGGER.info("Printing coverage " + coverage + " for patient " + name +" "+lastName + " ...");

        try {
            if (app.getICoverageService().patientHasCoverage(name, coverage))
                LOGGER.info("Patient " + name +" "+lastName + " has coverage for " + coverage);
            else
                LOGGER.info("Patient " + name+" "+lastName + " doesn't have coverage for " + coverage);
        } catch (InvalidCoverageException e) {
            e.printStackTrace();
        }

        LOGGER.info(app.getIHealCareCoverage().listHealCareCoverage(name));
        LOGGER.info("\n Patients : \n" + app.getPatientList());
        LOGGER.info("\n Active patients : \n" + app.getIActivePatients().filterByActiveUser());


    }
}
