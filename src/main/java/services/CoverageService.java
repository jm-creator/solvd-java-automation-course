package services;

import entity.App;
import entity.Patient;
import enums.CategoryCoverage;
import interfaces.ICoverageService;

import java.util.ArrayList;
import java.util.List;

public class CoverageService implements ICoverageService {

    App app = new App();

    private List<Patient> patients = app.getPatients();

    public List<Patient> getPatients() {
        return this.patients;
    }

    @Override
    public boolean patientHasCoverage(String patientName, String coverageName) {
        for (Patient patient: patients) {
            if (patient.getFirstName().equals(patientName) && patient.hasCoverage(coverageName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> listHealCareCoverage(String patientName) {
        for (Patient patient: patients) {
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
