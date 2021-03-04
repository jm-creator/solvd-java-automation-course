package interfaces;

import java.util.List;

public interface ICoverageService {
    boolean patientHasCoverage(String patientName, String coverageName);
    List<String> listHealCareCoverage(String patientName);
}
