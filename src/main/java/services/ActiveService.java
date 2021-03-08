package services;

import entity.App;
import entity.Patient;
import interfaces.IActiveService;

import java.util.ArrayList;
import java.util.List;

public class ActiveService implements IActiveService {

    private List<Patient> patients = Patient.getRandomPatients();


    @Override
    public boolean patientIsActive(String patientName) {
        for (Patient patient: patients) {
            if (patient.isActive())
                return true;
        }
        return false;
    }

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
