package interfaces;
import entity.Patient;
import java.util.List;

public interface IActivePatients {
    List<Patient> filterByActiveUser();
}
