package org.solvd.healthSystem.services;

import org.solvd.healthSystem.entity.App;
import org.solvd.healthSystem.enums.CategoryCoverage;
import org.solvd.healthSystem.entity.Patient;
import org.solvd.healthSystem.exceptions.InvalidCoverageException;
import org.solvd.healthSystem.exceptions.PatientNotFoundException;
import org.solvd.healthSystem.interfaces.ICoverage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CoverageService implements ICoverage {

    private final static Logger LOGGER = Logger.getLogger(CoverageService.class);
    private final List<Patient> patients = App.getRandomPatients();


    @Override
    public boolean patientHasCoverage(String patientFirstName, String coverageName) throws PatientNotFoundException, InvalidCoverageException {
        List <String> patientCoverage = listHealCareCoverage(patientFirstName);

        if (patientCoverage.contains(coverageName))
            return true;
        else
            throw new InvalidCoverageException();
    }

    @Override
    public List<String> listHealCareCoverage(String patientName) throws PatientNotFoundException {
        for (Patient patient : patients) {
            if (patient.getFirstName().equals(patientName)) {
                List<String> list = new ArrayList<>();
                for (CategoryCoverage coverage: patient.getHealCareCategory().getCoverage()) {
                    list.add(coverage.getName());
                }
                return list;
            }
        }
        throw new PatientNotFoundException();
    }


}
