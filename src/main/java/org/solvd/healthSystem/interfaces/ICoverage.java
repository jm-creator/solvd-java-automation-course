package org.solvd.healthSystem.interfaces;

import java.util.List;

public interface ICoverage {
    boolean patientHasCoverage(String patientFirstName,  String coverageName);
    List<String> listHealCareCoverage(String patientName);
}
