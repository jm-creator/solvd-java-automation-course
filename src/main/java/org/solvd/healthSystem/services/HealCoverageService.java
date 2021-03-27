package org.solvd.healthSystem.services;

import org.solvd.healthSystem.entity.App;
import org.solvd.healthSystem.enums.CategoryCoverage;
import org.solvd.healthSystem.entity.Patient;
import org.solvd.healthSystem.exceptions.PatientNotFoundException;
import org.solvd.healthSystem.interfaces.IHealCareCoverage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HealCoverageService implements IHealCareCoverage {
    private static final Logger LOGGER = Logger.getLogger(HealCoverageService.class);
    private final List<Patient> patients = App.getRandomPatients();
    @Override
    public List<String> listHealCareCoverage(String patientName) {
        for (Patient patient : patients) {

            if (patient.getFirstName().equals(patientName)) {
                List<String> list = new ArrayList<>();
                for (CategoryCoverage coverage: patient.getHealCareCategory().getCoverage()) {
                    list.add(coverage.getName());
                }
                return list;
            }
        }
        try {
            throw new PatientNotFoundException();
        } catch (PatientNotFoundException e) {
           LOGGER.error(e.getMessage());
        }
        return null;
    }
}
