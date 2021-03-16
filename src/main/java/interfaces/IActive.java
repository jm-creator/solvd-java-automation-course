package interfaces;
import exceptions.PatientNotFoundException;

public interface IActive {
    boolean patientIsActive(String patientName) throws PatientNotFoundException;

}
