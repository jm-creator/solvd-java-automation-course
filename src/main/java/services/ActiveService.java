package services;

import entity.App;
import entity.Patient;
import interfaces.IActiveService;

import java.util.List;

public class ActiveService implements IActiveService {

    App app = new App();
    private List<Patient> patients = app.getPatients();
    private List<Patient> activePatients;

    @Override
    public boolean patientIsActive(String patientName) {
        return false;
    }

    @Override
    public List<Patient> filterByActiveUser() {
        return null;
    }
}
