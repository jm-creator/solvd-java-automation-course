package org.solvd.healthSystem;

import org.solvd.healthSystem.entity.App;
import org.solvd.healthSystem.enums.CategoryCoverage;
import org.solvd.healthSystem.entity.Patient;
import org.apache.log4j.Logger;
import org.solvd.healthSystem.exceptions.InvalidCoverageException;
import org.solvd.healthSystem.exceptions.PatientNotActiveException;
import org.solvd.healthSystem.exceptions.PatientNotFoundException;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);
    static private final App app = new App();
    static private final Patient patient = app.getPatient();
    static private final String name = patient.getFirstName();
    static private final String lastName = patient.getLastName();
    static private final String coverage = CategoryCoverage.getRandomCoverage().getName();

    public static void main(String[] args) {

        try {
            app.getIActiveService().patientIsActive(name);
        } catch (PatientNotActiveException e) {
            e.printStackTrace();
        }

        try {
            if (!app.getIActiveService().patientIsActive(name)) {
                LOGGER.info("patient " + name+" "+lastName+ " is NOT active!");

            } else LOGGER.info("patient " + name +" "+lastName+ " is active");
        } catch (PatientNotActiveException e) {
            e.printStackTrace();
        }

        LOGGER.info("Printing coverage " + coverage + " for patient " + name +" "+lastName + " ...");


        try {
            if (app.getICoverageService().patientHasCoverage(name, coverage)) {
                LOGGER.info("Patient " + name +" "+lastName + " has coverage for " + coverage);}

            else{   LOGGER.info("Patient " + name+" "+lastName + " doesn't have coverage for " + coverage);}
        } catch (PatientNotFoundException | InvalidCoverageException e) {
            e.printStackTrace();
        }


        LOGGER.info("Current patient coverage : " + app.getIHealCareCoverage().listHealCareCoverage(name));
//        LOGGER.info("\n Patients : \n" + app.getPatientList());
       LOGGER.info("\n Active patients : \n" + app.getIActivePatients().filterByActiveUser());

    }
}
