import entity.App;
import entity.Patient;
import enums.Categories;
import org.apache.log4j.Logger;
import services.ActiveService;
import services.CoverageService;

import java.util.List;

public class main {

    private static final Logger LOGGER = Logger.getLogger(main.class);

    public static void main(String[] args) {

        String name = "Hyatt";
        String area = "Maternal";


        App app = new App();


        LOGGER.info("Printing coverage " + area + " for patient " + name + " ...");

        if (app.getICoverageService().patientHasCoverage(name, area)) {
            LOGGER.info("Patient " + name + " has coverage for " + area);
        } else {
            LOGGER.info("Patient " + name + " doesn't have coverage for " + area);
        }

        LOGGER.info("Printing coverage list for patient " + name);

        LOGGER.info(app.getICoverageService().listHealCareCoverage(name));

        LOGGER.info("List of patients : " + app.getPatientList());


        LOGGER.info("List of ACTIVE patients : " + app.getIActiveService().filterByActiveUser());




    }
}
