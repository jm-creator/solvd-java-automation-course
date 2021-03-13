package services;

import entity.App;
import entity.Patient;
import exceptions.PatientNotFoundException;
import interfaces.IActiveService;

import java.util.ArrayList;
import java.util.List;

public class ActiveService implements IActiveService {

    private final List<Patient> patients = App.getRandomPatients();


    @Override
    public boolean patientIsActive(String patientName) throws PatientNotFoundException {
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
