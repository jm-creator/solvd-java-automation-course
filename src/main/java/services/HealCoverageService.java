package services;

import entity.App;
import entity.Patient;
import enums.CategoryCoverage;
import interfaces.IHealCareCoverage;

import java.util.ArrayList;
import java.util.List;

public class HealCoverageService implements IHealCareCoverage {
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
        return null;
    }
}
