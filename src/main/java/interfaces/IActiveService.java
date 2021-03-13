package interfaces;

import entity.Patient;
import exceptions.PatientNotFoundException;

import java.util.List;

public interface IActiveService {
    boolean patientIsActive(String patientName) throws PatientNotFoundException;
    List<Patient> filterByActiveUser();
}
