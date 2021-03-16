package services;

import entity.App;
import entity.Patient;
import interfaces.IActivePatients;

import java.util.ArrayList;
import java.util.List;

public class ActivePatientsService implements IActivePatients {
    private final List<Patient> patients = App.getRandomPatients();
    @Override
    public List<Patient> filterByActiveUser() {
        List<Patient> patientList = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.isActive()) {
                patientList.add(patient);
            }
        }
        return patientList;
    }
}
