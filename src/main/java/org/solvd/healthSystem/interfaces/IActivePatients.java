package org.solvd.healthSystem.interfaces;
import org.solvd.healthSystem.entity.Patient;

import java.util.List;

public interface IActivePatients {
    List<Patient> filterByActiveUser();
}
