package interfaces;
import exceptions.InvalidCoverageException;
import java.util.List;

public interface ICoverage {
    boolean patientHasCoverage(String patientFirstName,  String coverageName) throws InvalidCoverageException;
    List<String> listHealCareCoverage(String patientName);
}
