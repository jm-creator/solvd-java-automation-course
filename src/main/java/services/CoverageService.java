package services;

import entity.App;
import entity.Patient;
import enums.CategoryCoverage;
import exceptions.InvalidCoverageException;
import interfaces.ICoverage;

import java.util.ArrayList;
import java.util.List;

public class CoverageService implements ICoverage {


    private final List<Patient> patients = App.getRandomPatients();


    @Override
    public boolean patientHasCoverage(String patientFirstName, String coverageName) {
        List <String> list = listHealCareCoverage(patientFirstName);
        for(String coverage : list) {
            if(coverage.equals(coverageName)){
                return true;
            }
        }
        return  false;
    }

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
        return null;
    }


}
