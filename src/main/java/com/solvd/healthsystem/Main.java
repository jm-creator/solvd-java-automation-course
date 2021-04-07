package com.solvd.healthsystem;


import com.solvd.healthsystem.enums.Permissions;
import com.solvd.healthsystem.exceptions.InvalidCoverageException;
import com.solvd.healthsystem.exceptions.PartnerInsufficientIncomeException;
import com.solvd.healthsystem.models.*;
import com.solvd.healthsystem.utils.DataGenerator;
import com.solvd.healthsystem.exceptions.IncorrectPermissionsException;
import org.apache.log4j.Logger;

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
                    e.getPermissions().add(Permissions.CREATE_PARTNER);
                    e.getPermissions().add(Permissions.GET_PARTNER);
                } else if (e instanceof HumanResourcesManager) {
                    e.getPermissions().add(Permissions.CREATE_PARTNER);
                    e.getPermissions().add(Permissions.DELETE_PARTNER);
                    e.getPermissions().add(Permissions.MODIFY_PARTNER);
                    e.getPermissions().add(Permissions.GET_PARTNER);
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
