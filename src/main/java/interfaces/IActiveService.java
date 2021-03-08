package interfaces;

import entity.Patient;

import java.util.List;

public interface IActiveService {
    boolean patientIsActive(String patientName);
    List<Patient> filterByActiveUser();

}
