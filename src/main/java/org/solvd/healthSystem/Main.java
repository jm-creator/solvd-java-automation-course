package org.solvd.healthSystem;


import org.solvd.healthSystem.exceptions.IncorrectPermissionsException;
import org.solvd.healthSystem.exceptions.InvalidCoverageException;
import org.solvd.healthSystem.exceptions.PartnerInsufficientIncomeException;
import org.solvd.healthSystem.models.*;
import org.apache.log4j.Logger;
import org.solvd.healthSystem.utils.DataGenerator;

import static org.solvd.healthSystem.enums.Permissions.*;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);
    static private final App app = new App();

    public static void main(String[] args) {
        Partner existentPartner = app.getRandomPartner();
        Partner nonExistentPartner = new Partner("Juan Manuel", "Rovira", 31238, true, false, 80000d);
        AbstractHealthCarePlan healthCarePlan = app.getRandomHealthCarePlan();
        HealthCareCategoryCoverage healthCareCategoryCoverage = DataGenerator.getRandomHealthCareCategoryCoverage();

        app.addPermissions(app.getEmployees(), e -> {
                if (e instanceof HumanResourcesEmployee) {
                    e.getPermissions().add(CREATE_PARTNER);
                    e.getPermissions().add(GET_PARTNER);
                } else if (e instanceof HumanResourcesManager) {
                    e.getPermissions().add(CREATE_PARTNER);
                    e.getPermissions().add(DELETE_PARTNER);
                    e.getPermissions().add(MODIFY_PARTNER);
                    e.getPermissions().add(GET_PARTNER);
                }
            }
        );

        // add nonExistentPartner
        LOGGER.info("Trying to add Partner: " + nonExistentPartner);
        LOGGER.info("Health care plan: " + healthCarePlan.toString());
        try {
            app.addPartner(app.getEmployee(), nonExistentPartner, healthCarePlan);
        } catch (IncorrectPermissionsException | PartnerInsufficientIncomeException e) {
           LOGGER.info(e.getMessage());
        }

        // delete existentPartner
        LOGGER.info("Trying to delete a Partner");
        try {
            app.deletePartner(app.getEmployee(), existentPartner);
        } catch (IncorrectPermissionsException e) {
            LOGGER.info(e.getMessage());
        }

        boolean hasCoverage = false;
        try {
            hasCoverage = app.partnerHasCoverage(
                      (p, c) -> p.getHealCareCategory().getCoverages().contains(c),
                      existentPartner,
                      healthCareCategoryCoverage);
        } catch (InvalidCoverageException e) {
            LOGGER.info(e.getMessage());
        }
      if (hasCoverage) {
          LOGGER.info("Partner " + existentPartner + "has coverage for " + healthCareCategoryCoverage);
      } else LOGGER.info("Partner " + existentPartner + "doesn't coverage for " + healthCareCategoryCoverage);

    }
}
